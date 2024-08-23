plugins {
    `kotlin-dsl`
    `maven-publish`
    id("com.gradle.plugin-publish") version "1.2.1"
}

group = "io.github.qamarelsafadi"
version = "1.2.1"

gradlePlugin {
    website = "https://github.com/qamarelsafadi/KMPAppIconGeneratorPlugin"
    vcsUrl = "https://github.com/qamarelsafadi/KMPAppIconGeneratorPlugin.git"
    plugins {
        register("io.github.qamarelsafadi.generator.KMPAppIconGeneratorPlugin") {
            id = "io.github.qamarelsafadi.kmp.app.icon.generator"
            implementationClass = "com.qamar.icon.generator.KMPAppIconGeneratorPlugin"
            displayName = "KMPAppIconGeneratorPlugin"
            description = "KMPAppIconGeneratorPlugin is a plugin that helps you change your Android and iOS app icon from one line command"
            tags = listOf("Android", "KMP" , "Kotlin", "CM")
        }
    }
}
dependencies {
    implementation(gradleApi())
    compileOnly(libs.kotlin.gradle.plugin)
}

publishing {
    repositories {
        mavenLocal()
        maven {
            name = "localPluginRepository"
            url = uri("../local-plugin-repository")
        }
    }
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

kotlin {
    jvmToolchain(11)
}

tasks.named("build") {
    dependsOn("generateIcons")
}
