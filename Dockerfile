FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline -B

COPY src ./src
RUN mvn clean package -DskipTests

FROM payara/server-full:6.2025.11-jdk17
COPY post-boot-commands.asadmin /opt/payara/config/post-boot-commands.asadmin
COPY --from=build /app/target/*.war ${DEPLOY_DIR}/api.war