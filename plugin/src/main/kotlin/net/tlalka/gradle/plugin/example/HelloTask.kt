package net.tlalka.gradle.plugin.example

import kotlinx.html.body
import kotlinx.html.h1
import kotlinx.html.h4
import kotlinx.html.html
import kotlinx.html.stream.appendHTML
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction
import java.io.File
import kotlin.LazyThreadSafetyMode.NONE

open class HelloTask : DefaultTask() {

    @Input
    lateinit var variantName: String

    @OutputFile
    lateinit var outputFile: File

    private val config: HelloExtension by lazy(NONE) {
        project.extensions.findByName(HelloExtension.CONFIG_NAME) as HelloExtension
    }

    @TaskAction
    fun startTask() {
        println("Plugin message: ${config.message}")
        println("Variant: $variantName")

        outputFile.writeText(
            text = StringBuilder().appendHTML()
                .html {
                    body {
                        h1 { +"Html Report" }
                        h4 { +"Variant: $variantName" }
                    }
                }
                .toString()
        )
    }

    companion object {

        const val TASK_NAME = "hello"
    }
}
