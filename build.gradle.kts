plugins {
    java
    `maven-publish`

    antlr
    // https://kotlinlang.org/docs/gradle-configure-project.html
    kotlin("jvm") version "2.1.0"
}

group = "io.github.warraft"
version = "0.0.62"

repositories {
    mavenCentral()
}

buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        // https://mvnrepository.com/artifact/com.android.tools.build/gradle
        classpath("com.android.tools.build:gradle:8.8.0")
        // https://mvnrepository.com/artifact/org.jetbrains.kotlin/kotlin-gradle-plugin
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:2.1.0")
    }
}


dependencies {
    // https://docs.gradle.org/current/userguide/antlr_plugin.html#sec:antlr_dependency_management
    // https://mvnrepository.com/artifact/org.antlr/antlr4-maven-plugin
    antlr("org.antlr:antlr4:4.13.2")

    testImplementation(kotlin("test"))
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

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "io.github.warraft"
            artifactId = "jass-antlr"
            version = version
            from(components["java"])
        }
    }
}

tasks.generateGrammarSource {
    maxHeapSize = "64m"

    // https://codeberg.org/UniGrammar/antlr4/src/branch/tool_refactoring/doc/tool-options.md
    arguments = listOf(
        "-package", "io.github.warraft.jass.antlr",
        //"-lib", "src/main/kotlin/",
        "-no-visitor",
        "-no-listener"
    )

    //source = fileTree("src/main/kotlin").matching {include("**/*.g4")}

    outputDirectory = file("src/main/gen")
}

tasks.jar {
    manifest {
        attributes["Main-Class"] = "MainKt"
    }
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    from(configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) })
    archiveBaseName.set("JASS")
    archiveVersion.set("ANTLR")
}

tasks.test {
    useJUnitPlatform()
}

tasks.publishToMavenLocal {

}

// https://docs.github.com/en/actions/use-cases-and-examples/publishing-packages/publishing-java-packages-with-gradle

// https://developerlife.com/2021/02/06/publish-kotlin-library-as-gradle-dep/
