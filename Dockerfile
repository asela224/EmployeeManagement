FROM openjdk:8
EXPOSE 8080
ADD target/EmployeeManagement.jar EmployeeManagement.jar
ENTRYPOINT ["java","-jar","/EmployeeManagement.jar"]