package net.tlalka.gradle.plugin.example.extension

import com.android.build.gradle.AppExtension
import com.android.build.gradle.AppPlugin
import com.android.build.gradle.LibraryExtension
import com.android.build.gradle.LibraryPlugin
import org.gradle.api.Project

internal fun Project.findAppVariants(block: (String) -> Unit) = when {
    plugins.hasPlugin(AppPlugin::class.java) -> {
        extensions.getByType(AppExtension::class.java).applicationVariants.all { block.invoke(it.name) }
    }
    plugins.hasPlugin(LibraryPlugin::class.java) -> {
        extensions.getByType(LibraryExtension::class.java).libraryVariants.all { block.invoke(it.name) }
    }
    else -> block.invoke("")
}
