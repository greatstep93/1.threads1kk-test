plugins {
    java
}

group = "org.example"
version = "1.0-SNAPSHOT"
java {
    sourceCompatibility = JavaVersion.VERSION_21
}
repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

tasks.jar {
    manifest {
        attributes["Main-Class"] = "org.example.TestThreads"
    }
    archiveFileName.set("threads100k-test.jar")
}