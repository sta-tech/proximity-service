plugins {
	java
	id("org.springframework.boot") version "3.2.5"
	id("io.spring.dependency-management") version "1.1.4"
	id("org.jooq.jooq-codegen-gradle") version "3.19.9"
}

group = "me.evgenii"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_21
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-jooq")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.liquibase:liquibase-core")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	developmentOnly("org.springframework.boot:spring-boot-docker-compose")
	runtimeOnly("org.postgresql:postgresql")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.boot:spring-boot-testcontainers")
	testImplementation("org.testcontainers:junit-jupiter")
	testImplementation("org.testcontainers:postgresql")
	jooqCodegen("org.jooq:jooq-meta-extensions-liquibase:3.19.9")
}

tasks.withType<Test> {
	useJUnitPlatform()
}

jooq {
	configuration {
		generator {
			name = "org.jooq.codegen.JavaGenerator"
			database {
				name = "org.jooq.meta.extensions.liquibase.LiquibaseDatabase"
				properties {
					property {
						key = "rootPath"
						value = "$projectDir/src/main/resources/db/changelog"
					}
					property {
						key = "scripts"
						value = "db.changelog-master.yaml"
					}
					property {
						key = "includeLiquibaseTables"
						value = "false"
					}
					property {
						key = "changeLogParameters.contexts"
						value = "!test"
					}
				}
			}
			generate {
				isPojos = true
			}
			target {
				packageName = "me.evgenii.proximityservice.database"
				directory = "src/main/java"
			}
		}
	}
}
