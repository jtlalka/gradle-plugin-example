package net.tlalka.gradle.plugin.example

import net.tlalka.gradle.plugin.example.HelloExtension.Companion.CONFIG_NAME
import net.tlalka.gradle.plugin.example.HelloTask.Companion.TASK_NAME
import net.tlalka.gradle.plugin.example.extension.findAndroidVariants
import net.tlalka.gradle.plugin.example.extension.fullCompileClasspath
import net.tlalka.gradle.plugin.example.extension.variantTaskName
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.logging.Logging

class HelloPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        LOGGER.debug("Register Hello plugin.")
        project.extensions.create(CONFIG_NAME, HelloExtension::class.java)

        project.findAndroidVariants { variant ->
            LOGGER.debug("Variants: " + variant.name)

            project.tasks.create(variant.variantTaskName(TASK_NAME), HelloTask::class.java).apply {
                setVariantName(variant.name)
                setArtifactCollection(variant.fullCompileClasspath.artifactFiles)
            }
        }
    }

    companion object {

        private val LOGGER = Logging.getLogger(HelloPlugin::class.java)
    }
}