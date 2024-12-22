plugins {
    id("java")
    id("org.springframework.boot") version "3.4.1"
    id("io.spring.dependency-management") version "1.1.7"
}
java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}


//group and id are defined in the root project
//group = "xyz.optimized"
//version = "1.0-SNAPSHOT"

//repositories {
//    mavenCentral()
//}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("io.projectreactor:reactor-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")


}

tasks.test {
    useJUnitPlatform()
}