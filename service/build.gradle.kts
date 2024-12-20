//plugins {
//    id("java")
//}

//group and id are defined in the root project
//group = "xyz.optimized"
//version = "1.0-SNAPSHOT"

//repositories {
//    mavenCentral()
//}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}