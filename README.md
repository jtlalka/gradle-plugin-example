# Gradle Plugin Example
Example of Gradle Plugin written in Kotlin

### Sample usage

1. Compile plugin to maven local repository:
```
./gradlew install
```

2. Add maven local to your project build script repository:
```groovy
buildscript {
    repositories {
        mavenLocal()
    }
}
```

3. Apply plugin:
```groovy
plugins {
    id("hello-gradle-plugin")
}

//optional legacy way:
apply plugin: 'hello-gradle-plugin'
```

4. Run sample plugin for `debug` variant:
```
./gradlew helloDebug
```
