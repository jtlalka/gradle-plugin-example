package net.tlalka.gradle.plugin.example.extension

import com.android.build.gradle.AppExtension
import com.android.build.gradle.AppPlugin
import com.android.build.gradle.LibraryExtension
import com.android.build.gradle.LibraryPlugin
import com.android.build.gradle.TestExtension
import com.android.build.gradle.TestPlugin
import com.android.build.gradle.api.BaseVariant
import org.gradle.api.Project

internal fun Project.findAndroidVariants(block: (BaseVariant) -> Unit) {
    if (plugins.withType(AppPlugin::class.java).isNotEmpty()) {
        extensions.getByType(AppExtension::class.java).applicationVariants.all(block)
    }
    if (plugins.withType(LibraryPlugin::class.java).isNotEmpty()) {
        extensions.getByType(LibraryExtension::class.java).libraryVariants.all(block)
    }
    if (plugins.withType(TestPlugin::class.java).isNotEmpty()) {
        extensions.getByType(TestExtension::class.java).applicationVariants.all(block)
    }
}
