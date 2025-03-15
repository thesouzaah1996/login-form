# Usando uma imagem base do Java 17
FROM openjdk:17-jdk-slim

# Diretório de trabalho
WORKDIR /app

# Copiar o arquivo JAR gerado pelo build do Spring Boot
COPY target/backend-0.0.1-SNAPSHOT.jar app.jar

# Expor a porta que o Spring Boot vai rodar
EXPOSE 8080

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]