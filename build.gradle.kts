import kotlin.collections.mutableListOf

plugins {
    kotlin("jvm") version "1.3.61"
    id("application")
    id("org.openjfx.javafxplugin") version "0.0.8"
}

group = "com.github.islaterm"
version = "1.0-DEV"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    // https://mvnrepository.com/artifact/org.openjfx/javafx
    compile(group = "org.openjfx", name = "javafx", version = "14-ea+6", ext = "pom")
    implementation("no.tornado:tornadofx:1.7.17")
}

javafx {
    version = "14-ea+6"
    modules = mutableListOf("javafx.controls")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}