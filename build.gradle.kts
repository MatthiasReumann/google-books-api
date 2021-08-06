val ktorVersion: String = "1.6.2"

plugins {
    id("org.jetbrains.kotlin.jvm") version "1.5.30-M1"
    `maven-publish`
    `java-library`
}

group = "com.github.MatthiasReumann"
version = "0.1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))

    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    testImplementation(kotlin("test"))

    implementation("io.ktor:ktor-client-core:$ktorVersion")
    implementation("io.ktor:ktor-client-cio:$ktorVersion")
    implementation("io.ktor:ktor-client-gson:$ktorVersion")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}


val sourcesJar by tasks.creating(Jar::class) {
    archiveClassifier.set("sources")
    from(sourceSets.main.get().allSource)
}


publishing {
    publications {
        create<MavenPublication>("googlebooksapi") {
            artifacts {
                archives(sourcesJar)
                //archives(jar)
            }
            pom {
                packaging = "jar"
                name.set("googlebooksapi")
                description.set("A Kotlin Wrapper of the Google Books APIs")
                url.set("https://github.com/MatthiasReumann/googlebooksapi")
            }
        }
    }
}
