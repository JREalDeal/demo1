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


project(":service") {
    dependencies {
        "implementation"(project(":generated"))
    }
    tasks.named("compileJava") {
        mustRunAfter(project(":").tasks.named("openApiGenerate"))
        mustRunAfter(project(":generated").tasks.named("compileJava"))
    }
}


// Download Spec: Define the name of the downloaded file and the URL to download from
val downloadedFile = "iaka.yaml"
val yamlUrl =
    "https://raw.githubusercontent.com/JREalDeal/demo1/refs/heads/main/specs/DoughFlowApi.yaml" // Replace with the actual URL

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


// OpenAPI Generator: Generate Java code from the downloaded YAML file
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


tasks.register("buildGen") {
    dependsOn("openApiGenerate")
    doFirst() {
        println("Executing buildGen task")
    }
    doLast() {
        println("Finished executing buildGen task")
    }
}


tasks.named("clean") {
    dependsOn("deleteGenerated")
}


// Delete the generated and downloaded directories
tasks.register("deleteGenerated", Delete::class) {
    delete("$rootDir/generated")
    delete("$rootDir/downloaded")
}



tasks.named("openApiGenerate") {
    dependsOn("downloadSpec")
}









