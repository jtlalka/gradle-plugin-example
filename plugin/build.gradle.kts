import Config.Publish.artifactGroup
import Config.Publish.artifactName
import Config.Publish.artifactVersion
import Config.Publish.nexusPassword
import Config.Publish.nexusRepoUrl
import Config.Publish.nexusUsername
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.jetbrains.kotlin.jvm") version embeddedKotlinVersion
    `java-gradle-plugin`
    `maven-publish`
}

apply {
    plugin("kotlin")
}

group = artifactGroup
version = artifactVersion

gradlePlugin {
    plugins {
        create(Config.Info.pluginName) {
            id = Config.Info.pluginId
            implementationClass = "net.tlalka.gradle.plugin.example.HelloPlugin"
        }
    }
}

publishing {
    repositories {
        maven {
            credentials {
                username = nexusUsername
                password = nexusPassword
            }
            url = uri(nexusRepoUrl)
        }
    }
    publications {
        create<MavenPublication>("maven") {
            groupId = artifactGroup
            artifactId = artifactName
            version = artifactVersion

            from(components["java"])
        }
    }
}

dependencies {
    compileOnly(gradleApi())
    compileOnly(kotlin(module = "stdlib-jdk8"))
    compileOnly(Config.Libs.androidBuildTools)

    testImplementation(gradleTestKit())
    testImplementation(Config.Libs.junit)
}

tasks {
    withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "1.8"
    }

    register("install") {
        dependsOn("publishToMavenLocal")
    }
}
