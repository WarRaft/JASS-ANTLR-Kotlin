import com.vanniktech.maven.publish.SonatypeHost

plugins {
    java
    antlr
    // https://kotlinlang.org/docs/gradle-configure-project.html
    kotlin("jvm") version "2.1.0"
    // https://mvnrepository.com/artifact/com.vanniktech/gradle-maven-publish-plugin
    id("com.vanniktech.maven.publish") version "0.30.0"
}

group = "io.github.warraft"

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

mavenPublishing {
    coordinates(
        groupId = "io.github.warraft",
        artifactId = "jass-antlr",
        version = "0.0.20"
    )

    pom {
        name.set("JASS ANTLR tools")
        description.set("You can use this tools")
        inceptionYear.set("2025")
        url.set("https://github.com/WarRaft/JASS-ANTLR-Kotlin")

        licenses {
            license {
                name.set("MIT")
                url.set("https://opensource.org/licenses/MIT")
            }
        }

        developers {
            developer {
                id.set("nazarpunk")
                name.set("nazarpunk")
                email.set("nazarpunk@gmail.com")
            }
        }

        scm {
            url.set("https://github.com/WarRaft/JASS-ANTLR-Kotlin")
        }
    }

    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)

    signAllPublications()
}

// https://medium.com/@cristurean.marius.ovidiu/how-to-publish-your-own-kotlin-multiplatform-library-to-mavencentral-4bc02c8e109d
