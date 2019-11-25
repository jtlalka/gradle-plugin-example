package net.tlalka.gradle.plugin.example.extension

import com.android.build.gradle.api.BaseVariant
import org.gradle.api.artifacts.ArtifactCollection

internal fun BaseVariant.variantTaskName(taskName: String): String =
    taskName + name.capitalize()

internal val BaseVariant.fullCompileClasspath: ArtifactCollection
    get() = this.getCompileClasspathArtifacts(null)
