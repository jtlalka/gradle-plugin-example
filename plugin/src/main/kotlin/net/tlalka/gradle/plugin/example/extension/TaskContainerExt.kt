package net.tlalka.gradle.plugin.example.extension

import org.gradle.api.Task
import org.gradle.api.tasks.TaskContainer
import kotlin.reflect.KClass

internal fun <T : Task> TaskContainer.createTask(
    variantName: String,
    taskName: String,
    taskClass: KClass<T>,
    initBlock: T.(taskVariantName: String) -> Unit
) {
    val taskVariantName = taskName + variantName.capitalize()
    val taskJavaClass = taskClass.java

    create(taskVariantName, taskJavaClass).initBlock(taskVariantName)
}
