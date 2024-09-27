# Usar una imagen base que incluya Maven y el JDK
FROM maven:3.8.4-openjdk-17 AS build

# Copiar los archivos de definición del proyecto al contenedor
COPY pom.xml /usr/src/app/

# Copiar el código fuente del proyecto
COPY src /usr/src/app/src

# Compilar y empaquetar la aplicación en un JAR con todas las dependencias
RUN mvn -f /usr/src/app/pom.xml clean package -DskipTests

# Utilizar una imagen base de Java para ejecutar la aplicación
FROM openjdk:17-oracle

# Copiar el JAR empaquetado desde la etapa de construcción a la etapa de ejecución
COPY --from=build /usr/src/app/target/*.jar /usr/app/app.jar

# Exponer el puerto que la aplicación utiliza
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/usr/app/app.jar"]
