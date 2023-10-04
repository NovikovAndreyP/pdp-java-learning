FROM maven:3.9.4-amazoncorretto-11
WORKDIR /app
COPY ../ /app
RUN cd ./core
RUN mvn install
ENTRYPOINT ["java","-jar","core/target/core-0.0.1.jar"]