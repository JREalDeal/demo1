# OpenAPI Generator Gradle Plugin
This is a demo project to show how to use the OpenAPI Generator Gradle Plugin to generate code from an OpenAPI spec file.
The specification file is downloaded from the internet and the code is generated from it.

## Instruction
* Goto build.gradle.kts Execute 2 commands:
    1. ```./gradlew clean downloadSpec buildGen ``` to download the spec file and generate the POJOs.
    2. ```./gradlew build``` main build command.
  Note: Combining the commands will not work as the downloadSpec task is not executed before the buildGen task. Working on it.


## Steps breakdown
3. ```./gradlew downloadSpec``` to download the spec file from the internet.
4. ```./gradlew  openApiGenerate``` or ```./gradlew  buildGen```generates the code from the spec `.yaml` file.



# Note
Now the subproject model is redundant if all the pojos are int he openapi spec file, as the subproject generated is taking care of the model generation.
We can use model only if we want to generate some additional pojos or modify the existing ones.


# TODO:
1. Not sure if it is a good idea, but we could externalize variables in build.gradle.kts using project `gradle.properties`.
```
springBootVersion=3.1.4
group=com.example
version=1.0-SNAPSHOT
```
Then we can access these variables in the build.gradle.kts file as:
```
val springBootVersion: String by extra

plugins {
    id("org.springframework.boot") version springBootVersion
}

group = extra["group"] as String
version = extra["version"] as String
```
The downside is that we have an extra file and the syntax is not as straightforward.
```

