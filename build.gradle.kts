import org.jetbrains.kotlin.gradle.dsl.Coroutines
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

val logback_version: String by project
val ktor_version: String by project
val kotlin_version: String by project

plugins {
    application
    id("com.github.johnrengelman.shadow") version "5.1.0"
    kotlin("jvm") version "1.4.10"
}

group = "com.magnojr"
version = "0.0.1-SNAPSHOT"

application {
    mainClassName = "io.ktor.server.netty.EngineMain"

}

repositories {
    mavenLocal()
    jcenter()
    maven { url = uri("https://kotlin.bintray.com/ktor") }
}

tasks.withType<ShadowJar>() {
    manifest {
        attributes["Main-Class"] = "com.magnojr.ApplicationKr"
    }
}



dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlin_version")
    implementation("io.ktor:ktor-server-netty:$ktor_version")
    implementation("ch.qos.logback:logback-classic:$logback_version")
    implementation("io.ktor:ktor-server-core:$ktor_version")
    implementation("io.ktor:ktor-auth:$ktor_version")
    implementation("io.ktor:ktor-auth-jwt:$ktor_version")
    implementation("io.ktor:ktor-jackson:$ktor_version")
    testImplementation("io.ktor:ktor-server-tests:$ktor_version")
}

kotlin.sourceSets["main"].kotlin.srcDirs("src")
kotlin.sourceSets["test"].kotlin.srcDirs("test")

sourceSets["main"].resources.srcDirs("resources")
sourceSets["test"].resources.srcDirs("testresources")
