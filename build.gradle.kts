import java.net.URI

plugins {
    id("java")
    id("org.openapi.generator") version "7.10.0"
}

allprojects {
    repositories {
        mavenCentral()
    }
}

subprojects {
    apply(plugin = "java")
    group = "xyz.optimized"
    version = "1.0.5-SNAPSHOT"
}


val downloadedFile = "iaka.yaml"
val yamlUrl = "https://raw.githubusercontent.com/JREalDeal/demo1/refs/heads/main/specs/DoughFlowApi.yaml" // Replace with the actual URL

tasks.register("downloadSpec") {
    group = "utility"
    description = "Downloads a YAML file from a specified URL and saves it in the rootFolder/downloaded directory"

    val outputDir = layout.projectDirectory.dir("downloaded")
    val outputFile = outputDir.file(downloadedFile)

    doLast {
        // Ensure the output directory exists
        val outputDirectory = outputDir.asFile
        if (!outputDirectory.exists()) {
            outputDirectory.mkdirs()
        }

        // Download the file
        val uri = URI.create(yamlUrl)
        val connection = uri.toURL().openConnection()
        connection.getInputStream().use { input ->
            outputFile.asFile.outputStream().use { output ->
                input.copyTo(output)
            }
        }

        println("Downloaded YAML file to: ${outputFile.asFile.absolutePath}")
    }
}


openApiGenerate {
    generatorName.set("java")
    inputSpec.set("$rootDir/downloaded/iaka.yaml")
    outputDir.set("$rootDir/generated")
//    outputDir.set("$buildDir/generated")
    apiPackage.set("org.openapi.example.api")
    invokerPackage.set("org.openapi.example.invoker")
    modelPackage.set("org.openapi.example.model")
    configOptions.put("dateLibrary", "java8")
}



project(":generated") {
    tasks.named("compileJava") {
        dependsOn(project(":").tasks.named("buildGen"))
    }
}



tasks.named("clean") {
    dependsOn("deleteGenerated")
}



tasks.register("deleteGenerated", Delete::class) {
    delete("$rootDir/generated")
    delete("$rootDir/downloaded")
}

tasks.register("buildGen") {
    dependsOn("openApiGenerate")
    doFirst() {
        println("Executing buildGen")
    }
}

tasks.named("openApiGenerate") {
    dependsOn("downloadSpec")
}

project(":service") {
    dependencies {
        "implementation"(project(":generated"))
    }
    tasks.named("compileJava") {
        mustRunAfter(project(":").tasks.named("openApiGenerate"))
        mustRunAfter(project(":generated").tasks.named("compileJava"))
    }
}







