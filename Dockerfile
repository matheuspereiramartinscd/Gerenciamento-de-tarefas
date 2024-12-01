# Usando a imagem oficial do OpenJDK 17
FROM openjdk:17-jdk-slim

# Definir o diretório de trabalho no container
WORKDIR /app

# Copiar o arquivo JAR gerado pelo Spring Boot para o diretório de trabalho
COPY target/gerenciamento-tarefas-0.0.1-SNAPSHOT.jar /app/sgte-backend.jar


# Expor a porta 8080 (ou a porta que a sua aplicação usa)
EXPOSE 8080

# Comando para rodar a aplicação Spring Boot
CMD ["java", "-jar", "sgte-backend.jar"]
