package net.tlalka.gradle.plugin.example

import org.gradle.api.DefaultTask
import org.gradle.api.file.FileCollection
import org.gradle.api.tasks.TaskAction
import kotlin.LazyThreadSafetyMode.NONE
import kotlin.properties.Delegates

open class HelloTask : DefaultTask() {

    private var variantName: String by Delegates.notNull()
    private var fileCollection: FileCollection by Delegates.notNull()

    private val config: HelloExtension by lazy(NONE) {
        project.extensions.findByName(HelloExtension.CONFIG_NAME) as HelloExtension
    }

    @TaskAction
    fun startTask() {
        println("Plugin message: ${config.message}")
        println("Variant: $variantName")

        fileCollection
            .filter { it != null && it.isFile }
            .map { it.absolutePath }
            .forEachIndexed { index, name: String ->
                println("Lib $index: $name")
            }
    }

    internal fun setVariantName(variantName: String) {
        this.variantName = variantName
    }

    internal fun setArtifactCollection(fileCollection: FileCollection) {
        this.fileCollection = fileCollection
    }

    companion object {

        const val TASK_NAME = "hello"
    }
}
