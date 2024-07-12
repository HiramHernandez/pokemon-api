#helloworld-app.jar
# Usa una imagen base con Java
FROM maven:3.8.4-openjdk-17-slim AS build

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia los archivos de configuración de Maven (pom.xml) para descargar dependencias
COPY pom.xml ./

# Descarga las dependencias del proyecto
RUN mvn -B dependency:go-offline

# Copia el resto de los archivos del proyecto
COPY src ./src

# Compila la aplicación
RUN mvn -B clean package

# Usa una imagen base ligera de Java para la ejecución
FROM eclipse-temurin:17-jdk-alpine

# Establece el directorio de trabajo
WORKDIR /app

# Copia el archivo JAR generado desde la etapa anterior
COPY --from=build /app/target/*.jar abilities-service.jar

# Establece el comando de entrada para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "abilities-service.jar"]
