import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
	id("org.springframework.boot") version "3.3.2"
	id("io.spring.dependency-management") version "1.1.6"
	kotlin("jvm") version "1.9.24"
	id("application")
	kotlin("plugin.spring") version "1.9.24"
	id("org.flywaydb.flyway") version "10.16.0"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

val springBootAdminVersion="3.2.3"
val springCloudVersion="2023.0.1"

repositories {
	mavenCentral()
	maven{
		url=uri("https://repo.spring.io/milestone")
	}
}
buildscript {
	repositories {
		maven {
			url = uri("https://plugins.gradle.org/m2/")
		}
		maven{
			url=uri("https://repo.spring.io/milestone")
		}
	}

	dependencies {
		classpath("org.flywaydb:flyway-database-postgresql:10.4.1")
	}
}

dependencyManagement {
	imports {
		mavenBom("de.codecentric:spring-boot-admin-dependencies:${springBootAdminVersion}")
		mavenBom ("org.springframework.cloud:spring-cloud-dependencies:${springCloudVersion}")
	}
}

dependencies {
	implementation("org.flywaydb:flyway-database-postgresql:10.4.1")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation ("org.springframework.cloud:spring-cloud-starter-config")
	implementation("org.springframework.cloud:spring-cloud-starter-bootstrap")
	runtimeOnly("org.postgresql:postgresql")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa:3.3.2")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

kotlin {
	compilerOptions {
		freeCompilerArgs.addAll("-Xjsr305=strict")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
tasks.withType<BootJar>{
	enabled=false
}

tasks.withType<Jar>{
	enabled=true
}
flyway {
	url = "jdbc:postgresql://localhost:7432/demo"
	user = "myuser"
	password = "secret"
	schemas= arrayOf("demo")
	locations = arrayOf("classpath:db")
}