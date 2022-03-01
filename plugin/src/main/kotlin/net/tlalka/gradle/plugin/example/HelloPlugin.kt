package net.tlalka.gradle.plugin.example

import net.tlalka.gradle.plugin.example.HelloExtension.Companion.CONFIG_NAME
import net.tlalka.gradle.plugin.example.HelloTask.Companion.TASK_NAME
import net.tlalka.gradle.plugin.example.extension.createTask
import net.tlalka.gradle.plugin.example.extension.findAppVariants
import net.tlalka.gradle.plugin.example.extension.toFilePath
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.logging.Logging

class HelloPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        LOGGER.debug("Register Hello plugin.")
        project.extensions.create(CONFIG_NAME, HelloExtension::class.java)

        project.findAppVariants { variant ->
            LOGGER.debug("Variants: $variant")

            project.tasks.createTask(variant, TASK_NAME, HelloTask::class) { taskVariantName ->
                description = "Hello report task for $variant variant"
                group = "Reporting"

                variantName = variant
                outputFile = "${project.buildDir}/reports/$taskVariantName.html".toFilePath()
            }
        }
    }

    companion object {
        private val LOGGER = Logging.getLogger(HelloPlugin::class.java)
    }
}
