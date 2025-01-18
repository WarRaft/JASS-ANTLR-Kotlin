plugins {
    id("java")
    `maven-publish`
    signing

    antlr
    // https://kotlinlang.org/docs/gradle-configure-project.html
    kotlin("jvm") version "2.1.0"
}

group = "raft.war.antlr"
version = "0.0.2"

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


tasks.register("generateCustomANTLR", JavaExec::class) {
    group = "build"
    description = "Генерация ANTLR-кода с пользовательскими параметрами"

    // Указываем путь к JAR-файлу ANTLR
    val antlrJar = configurations["antlr"].resolve().first()

    // Настраиваем параметры выполнения
    mainClass.set("org.antlr.v4.Tool")
    classpath = files(antlrJar)
    args = listOf(
        "-visitor",
        "-no-listener",
        "-Xexact-output-dir",
        "-o", "${buildDir}/generated-src/antlr",
        "src/main/antlr/MyGrammar.g4"
    )

    // Обеспечиваем, что каталог создается
    doFirst {
        file("${buildDir}/generated-src/antlr").mkdirs()
    }
}


tasks.jar {
    manifest {
        attributes["Main-Class"] = "MainKt"
    }
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    from(configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) })
    archiveBaseName.set("ANTLR")
    archiveVersion.set(version as String)
}

tasks.test {
    useJUnitPlatform()
}


publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            artifactId = "JASS-ANTLR"
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
                name = "JASS-ANTLR"
                description = "ANTLR tools for JASS"
                url = "https://github.com/WarRaft/JASS-ANTLR-Kotlin"

                licenses {
                    license {
                        name = "The Apache License, Version 2.0"
                        url = "http://www.apache.org/licenses/LICENSE-2.0.txt"
                    }
                }
                developers {
                    developer {
                        id = "nazarpunk"
                        name = "nazarpunk"
                        email = "nazarpunk@gmail.com"
                    }
                }
            }
        }
    }
    repositories {
        maven {
            // change URLs to point to your repos, e.g. http://my.org/repo
            val releasesRepoUrl = uri(layout.buildDirectory.dir("repos/releases"))
            val snapshotsRepoUrl = uri(layout.buildDirectory.dir("repos/snapshots"))
            url = if (version.toString().endsWith("SNAPSHOT")) snapshotsRepoUrl else releasesRepoUrl
        }
    }
}

signing {
    sign(publishing.publications["mavenJava"])
}

/*
tasks.javadoc {
    if (JavaVersion.current().isJava9Compatible) {
        (options as StandardJavadocDocletOptions).addBooleanOption("html5", true)
    }
}

 */
