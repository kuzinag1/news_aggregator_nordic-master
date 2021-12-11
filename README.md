# Meduza News Agregator
<p align="center"><img src="https://cdn-icons.flaticon.com/png/512/2353/premium/2353092.png?token=exp=1639225927~hmac=46ad7450b633af3cf47e9b84a3b1a3b8"
alt="Weather" height="300" />
  
  
 # Description
  This app use for getting news from Meduza.ru. The paltform which on based the app is Java and Spring Boot.
  
  ## Development
- Development language: Java 8
- Framework: Spring Boot 2.5.5, Spring Data JPA, Spring Cloud OpenFeign, Spring Cloud Eureka
- Database: PostgreSQL v 10.19
- Libraries: Lombok, MapStruct
- API: Meduza News Api
- Build automation: Gradle
  
  ## The url to open the App
- Open the admin page for control another user role
  -  http://localhost:8080/admin
  
- Open the authorization page to the App
  -  http://localhost:8080/auth/login
- Page for sign out from the App account
  -  http://localhost:8080/auth/logout
  
- Open the main page
  -  http://localhost:8080/news/main
  
  ## How to launch
1. You have to launch Eureka server
2. Write the command inside your server.
 console
    ./gradlew bootrun
3. After you need launch all services like database, back-end and front.
