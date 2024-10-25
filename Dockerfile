
FROM maven:3.8.4-openjdk-17 AS build

# Establecer el directorio de trabajo
WORKDIR /app

# Copiar los archivos de tu proyecto al contenedor
COPY . .

# Ejecutar los comandos  para compilar y empaquetar el proyecto
RUN mvn clean install
RUN mvn package

# Crear una nueva imagen para ejecutar la aplicación
FROM openjdk:17-jdk-alpine

# Establecer el directorio de trabajo
WORKDIR /app

# Copiar el archivo JAR generado desde la imagen de compilación
COPY --from=build /app/target/protobootapp-0.0.1-SNAPSHOT.jar app.jar

# Exponer el puerto en el que la aplicación se ejecutará
EXPOSE 6500

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]


