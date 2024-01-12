plugins {
    application
    id("org.springframework.boot") version "3.2.1"
    id("io.spring.dependency-management") version "1.1.4"

    kotlin("jvm") version "1.9.22"
    kotlin("plugin.spring") version "1.9.22"
}

group = "no.blommish.spring-data-error"
version = "0.0.1-SNAPSHOT"

val javaVersion = JavaLanguageVersion.of(21)

kotlin {
    jvmToolchain(javaVersion.asInt())
    compilerOptions {
        freeCompilerArgs.add("-Xjsr305=strict")
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-reflect")

    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jdbc")

    implementation("org.flywaydb:flyway-core")
    implementation("org.postgresql:postgresql")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.testcontainers:postgresql:1.19.3")

}

tasks.withType<Test> {
    useJUnitPlatform()
}
