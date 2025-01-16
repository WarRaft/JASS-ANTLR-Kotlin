plugins {
    id("java")
    antlr

    // https://kotlinlang.org/docs/gradle-configure-project.html
    kotlin("jvm") version "2.1.0"
}

group = "raft.war"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("org.antlr:antlr4:4.13.2")
    implementation("org.antlr:antlr4-runtime:4.13.2")
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.1")
}


java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}

sourceSets {
    main {
        java {
            srcDirs("src/main/gen")
        }
    }

    configureEach {
        val generateGrammarSource = tasks.named(getTaskName("generate", "GrammarSource"))
        java.srcDir(generateGrammarSource.map { files() })
    }
}

kotlin {
    jvmToolchain(21)
}

tasks.jar {
    manifest {
        attributes["Main-Class"] = "MainKt"
    }
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    from(configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) })
    archiveBaseName.set("ANTLR")
    archiveVersion.set("0.0.2")
}

tasks.test {
    useJUnitPlatform()
}
