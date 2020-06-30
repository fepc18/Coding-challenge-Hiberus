FROM openjdk:14-jdk-alpine
#Nueva carpeta /app
WORKDIR /app
#Copia el jar a la carpeta app
COPY /target/CheckoutTS-0.0.1-SNAPSHOT.jar /app/
#Exposicion del puerto
EXPOSE 1001
#Iniciacion del servicio
ENTRYPOINT ["java", "-jar", "CheckoutTS-0.0.1-SNAPSHOT.jar"]