plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {

    implementation("org.seleniumhq.selenium", "selenium-java", "4.27.0")
    implementation("org.seleniumhq.selenium", "selenium-devtools-v111", "4.9.1")
    testImplementation("org.testng", "testng", "7.10.2")

}

tasks.test {
    useTestNG()
}