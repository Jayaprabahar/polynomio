FROM openjdk:latest

COPY  ./target/*polynomio*.jar polynomio.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/polynomio.jar"]