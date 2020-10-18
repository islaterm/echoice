plugins {
  kotlin("jvm") version "1.4.10"
  id("application")
  id("org.openjfx.javafxplugin") version "0.0.8"
}

group = "com.github.islaterm"
version = "1.0-DEV"

repositories {
  mavenCentral()
  maven { url = uri("https://jitpack.io") }
}

dependencies {
  implementation(kotlin("stdlib"))
  implementation(group = "com.github.jkcclemens", name = "khttp", version = "-SNAPSHOT")
  testImplementation(group = "org.junit.jupiter", name = "junit-jupiter", version = "5.4.2")
  testRuntimeOnly(group="org.junit.jupiter", name="junit-jupiter-engine", version = "5.4.2")
}

tasks {
  test {
    useJUnitPlatform()
  }
}