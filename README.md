# Gradle Plugin Example
Example of Gradle Plugin written in Kotlin

### Sample usage

1. Compile plugin to maven local repository:
```
./gradlew install
```

2. Add maven local to your project settings (`settings.gradle`):
```groovy
pluginManagement {
    repositories {
        mavenLocal()
        gradlePluginPortal()
    }
}
```

3. Add plugin to module build script:
```groovy
plugins {
    id("hello-gradle-plugin") varsion "1.0.0"
}
```

4. Run sample plugin for `debug` variant:
```
./gradlew helloDebug
```
