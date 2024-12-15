# OpenAPI Generator Gradle Plugin
This is a demo project to show how to use the OpenAPI Generator Gradle Plugin to generate code from an OpenAPI spec file.
The specification file is downloaded from the internet and the code is generated from it.

## Instruction
* Goto build.gradle.kts Execute 2 commands:
    1. ```./gradlew clean downloadSpec buildGen ``` to download the spec file and generate the POJOs.
    2. ```./gradlew build``` main build command.


## Steps breakdown
3. ```./gradlew downloadSpec``` to download the spec file from the internet.
4. ```./gradlew  openApiGenerate``` or ```./gradlew  buildGen```generates the code from the spec `.yaml` file.



# Note
Now the subproject model is redundant if all the pojos are int he openapi spec file, as the subproject generated is taking care of the model generation.
We can use model only if we want to generate some additional pojos or modify the existing ones.

