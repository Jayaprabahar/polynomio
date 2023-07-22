FROM openjdk:21-ea-26-slim-bookworm

COPY  ./target/*polynomio*.jar polynomio.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/polynomio.jar"]