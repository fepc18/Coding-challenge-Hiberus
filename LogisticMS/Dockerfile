FROM openjdk:14-jdk-alpine
#Nueva carpeta /app
WORKDIR /app
#Copia el jar a la carpeta app
COPY /target/LogisticMS-0.0.1-SNAPSHOT.jar /app/
#Exposicion del puerto
EXPOSE 1003
#Iniciacion del servicio
ENTRYPOINT ["java", "-jar", "LogisticMS-0.0.1-SNAPSHOT.jar"]