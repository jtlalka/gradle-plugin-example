/**
 * Gradle project configuration.
 */
object Config {

    object Info {

        const val pluginId = "hello-gradle-plugin"
        const val pluginName = "hello-gradle-plugin"
    }

    object Libs {

        const val androidBuildTools = "com.android.tools.build:gradle:3.4.1"
        const val junit = "junit:junit:4.12"
    }

    object Publish {

        const val artifactGroup = "net.tlalka"
        const val artifactName = "hello-gradle-plugin"
        const val artifactVersion = "1.0.0"

        const val nexusUsername = ""
        const val nexusPassword = ""
        const val nexusRepoUrl = ""
    }
}
