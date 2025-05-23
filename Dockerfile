FROM eclipse-temurin:21-jdk-alpine

RUN apk add --no-cache bash curl dos2unix

WORKDIR /app

COPY .mvn/ .mvn
COPY mvnw pom.xml ./
COPY wait-for-mysql.sh ./

RUN dos2unix wait-for-mysql.sh

RUN chmod +x mvnw && ./mvnw dependency:go-offline
RUN chmod +x wait-for-mysql.sh

COPY src ./src

RUN ./mvnw clean package -DskipTests

EXPOSE 8080

ENTRYPOINT ["./wait-for-mysql.sh"]
CMD ["java", "-jar", "target/doce-encontro-0.0.1-SNAPSHOT.jar"]
