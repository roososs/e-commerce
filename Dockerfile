# Utilise une image Java officielle
FROM openjdk:17-jdk-slim

# Définit le répertoire de travail
WORKDIR /app

# Copie le JAR dans le conteneur
COPY target/e-commerce-0.0.1-SNAPSHOT.jar app.jar

# Expose le port 8080
EXPOSE 8080

# Commande pour exécuter l'application
CMD ["java", "-jar", "app.jar"]