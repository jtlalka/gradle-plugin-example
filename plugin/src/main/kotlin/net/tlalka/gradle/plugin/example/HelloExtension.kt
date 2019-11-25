package net.tlalka.gradle.plugin.example

open class HelloExtension {

    /**
     * Sample message.
     */
    var message: String = "Hello Gradle Plugin!"

    companion object {

        internal const val CONFIG_NAME = "helloConfig"
    }
}