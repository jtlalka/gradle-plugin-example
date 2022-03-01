package net.tlalka.gradle.plugin.example.extension

import java.io.File
import java.util.Locale

internal fun String.capitalize(): String = replaceFirstChar { it.titlecase(Locale.getDefault()) }

internal fun String.toFilePath(): File = File(replace('/', File.separatorChar))
