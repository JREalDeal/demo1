plugins {
    id("java")
    id("org.openapi.generator") version "7.10.0"
}
repositories {
    mavenCentral()
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

    tasks.named("build") {
        dependsOn(project(":").tasks.named("buildGen"))
//        dependsOn("openApiGenerate")
    }

}



project(":generated") {
    tasks.named("compileJava") {
        dependsOn(project(":").tasks.named("buildGen"))
//        dependsOn(project(":").tasks.named("openApiGenerate"))
//        dependsOn(":openApiGenerate") // Ensure openApiGenerate runs before compileJava

        doFirst {
            // Add the generated source directory to the compile task's sources
            val openApiOutputDir = file("$rootDir/generated/src/main/java")
//            source(openApiOutputDir)
            println("Added OpenAPI-generated sources to compileJava task")
        }

        doFirst {
            println("Compiling with OpenAPI-generated sources")
        }
    }

}



tasks.named("clean") {
    dependsOn("deleteGenerated")
}



//tasks.named("compileJava") {
//    mustRunAfter(project(":").tasks.named("openApiGenerate"))
//}

//tasks.named(":service:compileJava") {
//    mustRunAfter(":openApiGenerate")
//}


tasks.register("deleteGenerated", Delete::class) {
    delete("$rootDir/generated")
}

tasks.register("buildGen") {
    dependsOn("openApiGenerate")
    doFirst() {
        println("Executing buildGen")
    }
}

project(":service") {
    dependencies {
        "implementation"(project(":generated"))
    }

    tasks.named("compileJava") {
        mustRunAfter(project(":").tasks.named("buildGen"))
        mustRunAfter(project(":generated").tasks.named("compileJava"))
    }
}




openApiGenerate {
    generatorName.set("java")
    inputSpec.set("$rootDir/specs/DoughFlowApi.yaml")
    outputDir.set("$rootDir/generated")
//    outputDir.set("$buildDir/generated")
    apiPackage.set("org.openapi.example.api")
    invokerPackage.set("org.openapi.example.invoker")
    modelPackage.set("org.openapi.example.model")
    configOptions.put("dateLibrary", "java8")
}

//tasks.named("build") {
//    dependsOn("buildGen")
//    doFirst() {
//        println("Executing build from Main")
//        openApiGenerate
//    }
//}










