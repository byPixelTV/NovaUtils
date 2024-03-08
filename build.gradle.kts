plugins {
    kotlin("jvm") version "1.9.22"
    id("io.papermc.paperweight.userdev") version "1.5.11"
    id("xyz.jpenilla.run-paper") version "1.1.0"
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "de.bypixeltv"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://jitpack.io")
    maven("https://repo.extendedclip.com/content/repositories/placeholderapi/")
    maven {
        name = "papermc"
        url = uri("https://repo.papermc.io/repository/maven-public/")
    }
}

dependencies {
    paperweight.paperDevBundle("1.20.4-R0.1-SNAPSHOT")

    implementation("dev.jorel", "commandapi-bukkit-shade", "9.3.0")
    implementation("dev.jorel", "commandapi-bukkit-kotlin", "9.3.0")
    implementation("net.axay:kspigot:1.20.3")
    implementation("org.mariadb.jdbc:mariadb-java-client:3.3.2")
    implementation("com.zaxxer:HikariCP:5.1.0")
    implementation("fr.mrmicky:fastboard:2.0.2")
    implementation("net.kyori:adventure-text-serializer-legacy:4.15.0")

    compileOnly("me.clip:placeholderapi:2.11.5")
    compileOnly("com.github.MilkBowl:VaultAPI:1.7")
}

kotlin {
    jvmToolchain(17)
}

tasks {
    assemble {
        dependsOn(reobfJar)
    }
    compileJava {
        options.encoding = "UTF-8"
        options.release.set(17)
    }
    compileKotlin {
        kotlinOptions.jvmTarget = "17"
    }
    shadowJar {
        relocate("fr.mrmicky.fastboard", "de.bypixeltv.novautils.fastboard")
    }
}