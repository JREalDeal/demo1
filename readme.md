# OpenAPI Generator Gradle Plugin
This is a demo project to show how to use the OpenAPI Generator Gradle Plugin to generate code from an OpenAPI spec file.

## Instruction
1. Goto build.gradle.kts
2. ```./gradlew clean downloadSpecAPI buildGen build``` main build command.

## Steps breakdown
3. ```./gradlew downloadSpecAPI``` to download the spec file from the internet.
4. ```./gradlew  openApiGenerate``` or ```./gradlew  buildGen```generates the code from the spec `.yaml` file.



# Note
Now the subproject model is redundant, as the subproject generated is taking care of the model generation. 
