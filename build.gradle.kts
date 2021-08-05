val ktorVersion: String = "1.6.2"

plugins {
    id("org.jetbrains.kotlin.jvm") version "1.5.21"
    `maven-publish`
    `java-library`
}

group = "com.github.MatthiasReumann"
version = "0.1.0"

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))

    implementation("io.ktor:ktor-client-core:$ktorVersion")
    implementation("io.ktor:ktor-client-cio:$ktorVersion")
    implementation("io.ktor:ktor-client-gson:$ktorVersion")
}

tasks {
    val sourcesJar by creating(Jar::class) {
        archiveClassifier.set("sources")
        from(sourceSets.main.get().allSource)
    }

    artifacts {
        archives(sourcesJar)
    }
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            pom {
                name.set("googlebooksapi")
                description.set("A Kotlin Wrapper of the Google Books APIs")
                url.set("https://github.com/MatthiasReumann/googlebooksapi")
            }
        }
    }
}
