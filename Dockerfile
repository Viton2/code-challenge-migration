# Etapa 1: Construção
FROM maven:3.8.8-eclipse-temurin-17 AS builder
WORKDIR /app

# Copia o arquivo pom.xml e outros arquivos necessários para o Maven resolver dependências
COPY pom.xml ./
COPY src ./src


# Baixa as dependências do Maven e compila o projeto
RUN mvn clean package

# Etapa 2: Imagem final com JDK para execução
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

# Copia o arquivo JAR gerado na etapa de build
COPY --from=builder /app/target/*.jar dummyjson-client-1.0-SNAPSHOT.jar

# Expõe a porta que o Spring Boot usa, geralmente 8080
EXPOSE 8080

# Comando de inicialização
ENTRYPOINT ["java", "-jar", "dummyjson-client-1.0-SNAPSHOT.jar"]

# First run:
# docker image build -t <image-name> .
# then:
# docker run --name <container-name> -p 8080:8080 -p 9001:9001 <image-name>

