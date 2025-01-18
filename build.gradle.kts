plugins {
    id("java")
    `maven-publish`

    antlr
    // https://kotlinlang.org/docs/gradle-configure-project.html
    kotlin("jvm") version "2.1.0"
}

group = "io.github.warraft"
version = "0.0.2"

repositories {
    mavenCentral()
}

dependencies {
    // https://docs.gradle.org/current/userguide/antlr_plugin.html#sec:antlr_dependency_management
    // https://mvnrepository.com/artifact/org.antlr/antlr4-maven-plugin
    antlr("org.antlr:antlr4:4.13.2")

    testImplementation(kotlin("test"))
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.1")
}

java {
    withJavadocJar()
    withSourcesJar()
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
    archiveBaseName.set(rootProject.name)
    archiveVersion.set(version as String)
}

tasks.test {
    useJUnitPlatform()
}

// https://central.sonatype.com/account

// https://medium.com/@jtbsorensen/publish-your-artifact-to-the-maven-central-repository-using-github-actions-15d3b5d9ce88

// https://docs.gradle.org/current/userguide/publishing_maven.html

// https://stackoverflow.com/questions/74752707/github-actions-how-to-resolve-the-process-usr-bin-gpg-failed-with-exit-c

/*
publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            //artifactId = project.name
            from(components["java"])
            versionMapping {
                usage("java-api") {
                    fromResolutionOf("runtimeClasspath")
                }
                usage("java-runtime") {
                    fromResolutionResult()
                }
            }
            pom {
                name = "My Library"
                description = "A concise description of my library"
                url = "https://github.com/WarRaft/JASS-ANTLR-Kotlin"
                licenses {
                    license {
                        name = "MIT License"
                        url = "https://opensource.org/licenses/MIT"
                    }
                }
                developers {
                    developer {
                        id = "nazarpunk"
                        name = "nazarpunk"
                        email = "nazarpunk@gmail.com"
                    }
                }
                scm {
                    connection = "scm:git:git://github.com:WarRaft/JASS-ANTLR-Kotlin.git"
                    developerConnection = "scm:git:ssh://github.com:WarRaft/JASS-ANTLR-Kotlin.git"
                    url = "https://github.com/WarRaft/JASS-ANTLR-Kotlin"
                }
            }
        }
    }
    repositories {
        maven {
            val releasesRepoUrl = uri(layout.buildDirectory.dir("repos/releases"))
            val snapshotsRepoUrl = uri(layout.buildDirectory.dir("repos/snapshots"))
            url = if (version.toString().endsWith("SNAPSHOT")) snapshotsRepoUrl else releasesRepoUrl
        }
    }
}


tasks.javadoc {
    if (JavaVersion.current().isJava9Compatible) {
        (options as StandardJavadocDocletOptions).addBooleanOption("html5", true)
    }
}
*/
