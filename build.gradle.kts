plugins {
    id("java")
}

group = "com.github.zdziszkee.verifyjson"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("software.amazon.awssdk:securityhub:2.25.24")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.17.0")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}
tasks.withType<Jar> {
    manifest {
        attributes["Main-Class"] = "com.github.zdziszkee.verifyjson.VerifyJson"
    }
    val dependencies = configurations
            .runtimeClasspath
            .get()
            .map(::zipTree) // OR .map { zipTree(it) }
    from(dependencies)
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE

}
tasks.test {
    useJUnitPlatform()
}