plugins {

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



}


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
}



openApiGenerate {
    generatorName.set("java")
    inputSpec.set("$rootDir/specs/product.yaml")
    outputDir.set("$rootDir/generated")
//    outputDir.set("$buildDir/generated")
    apiPackage.set("org.openapi.example.api")
    invokerPackage.set("org.openapi.example.invoker")
    modelPackage.set("org.openapi.example.model")
    configOptions.put("dateLibrary", "java8")
}









