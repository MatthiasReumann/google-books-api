val ktorVersion: String = "1.6.2"

plugins {
    java
    id("org.jetbrains.kotlin.jvm") version "1.5.30-M1"
    id("maven-publish")
}

group = "com.github.matthiasreumann"
version = "0.0.1"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))

    implementation("io.ktor:ktor-client-core:$ktorVersion")
    implementation("io.ktor:ktor-client-cio:$ktorVersion")
    implementation("io.ktor:ktor-client-gson:$ktorVersion")
}

tasks{
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    val sourcesJar by creating(Jar::class) {
        archiveClassifier.set("sources")
        from(sourceSets.main.get().allSource)
    }

    artifacts{
        archives(sourcesJar)
        archives(jar)
    }
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "org.github.matthiasreumann"
            artifactId = "googlebooksapi"
            version = "0.0.1"

            from(components["java"])
        }
    }
}
