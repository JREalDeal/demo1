# Instruction

1. Goto build.gradle.kts and add the following code:
2. execute the following command:
```./gradlew  openApiGenerate``` or ```./gradlew  buildGen```
3. Then execute the following command:
```./gradlew build```
4. To clean and delete the generated code, simply execute
```./gradlew clean```
5. Alternatively, you can use the following command to generate the code and build the project:
```./gradlew clean buildGen build```

# Note
Now the subproject model is redundant, as the subproject generated is taking care of the model generation. 
