import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${project.properties["kotlin_version"]}")
    }
}
plugins {
    kotlin("jvm") version "1.9.23"
    kotlin("plugin.spring") version "1.9.23"
}

group = "vtVsCoroutines"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
    maven { url = uri("https://repo.spring.io/milestone") }
    maven { url = uri("https://repo.spring.io/snapshot") }
}
extra["springCloudVersion"] = "2023.0.0"

dependencies {
    compileOnly("org.projectlombok:lombok:1.18.34")
    implementation("org.springframework.boot:spring-boot-starter-parent:${project.properties["springBootVersion"]}")
    implementation ("org.jetbrains.kotlin:kotlin-stdlib-jdk8:${project.properties["kotlin_version"]}")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs += "-Xjsr305=strict"
        jvmTarget = "${project.properties["javaVersion"]}"
    }
}


kotlin {
    jvmToolchain("${project.properties["javaVersion"]}".toInt())
}