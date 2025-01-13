# Usar una imagen base de OpenJDK
FROM openjdk:17-jdk-slim

# Crear un directorio de trabajo
WORKDIR /app

# Copiar el archivo JAR del servicio estudiantes
COPY target/ordencompra-0.0.1-SNAPSHOT.jar app.jar

# Exponer el puerto del servicio
EXPOSE 8003

# Ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
