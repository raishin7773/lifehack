import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.4.2"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    id ("com.thinkimi.gradle.MybatisGenerator") version "2.1.2"
    kotlin("jvm") version "1.4.21"
    kotlin("plugin.spring") version "1.4.21"
}

group = "com.raishin"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
    mybatisGenerator
}

mybatisGenerator {
    verbose = true
    // 設定ファイル
    configFile = "src/main/resources/generatorConfig.xml"

    dependencies {
        mybatisGenerator ("com.itfsw:mybatis-generator-plugin:1.3.7")
        mybatisGenerator ("org.mybatis.generator:mybatis-generator-core:1.3.7")
        mybatisGenerator ("org.mariadb.jdbc:mariadb-java-client:2.4.4")
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation ("com.graphql-java-kickstart:graphql-spring-boot-starter:8.0.0")
    implementation ("com.graphql-java-kickstart:graphiql-spring-boot-starter:8.0.0")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:2.1.4")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.9.0")
    compileOnly("org.projectlombok:lombok")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    runtimeOnly("org.mariadb.jdbc:mariadb-java-client")
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "1.8"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
