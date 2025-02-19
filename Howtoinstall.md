# Installation

In this section we will talk about which steps we will take to install netflix eureka and Kubernetes.

## Netflix Eureka

### Prerequisites
* JDK 17 or higher
* Maven or Gradle
* IDE (e.g., IntelliJ IDEA, Eclipse)
* Basic knowledge of Spring Boot

1. To install Netflix Eureka we need to go to [Spring Intializr](https://start.spring.io/). and set the Project to Maven and spring Boot to the latest stable version.
2. Set the project metadata:
* Group: com.example
* Artifact: eureka-server
* Name: Eureka Server
* Description: Eureka Server for Service Discovery
* Package Name: com.example.eurekaserver
* Packaging: Jar
* Java: 17 (or higher)
3. Add dependencies:
* Eureka Server
* Spring Boot Actuator [Exposes health metrics]
* Spring web [For REST api's]
* Spring Boot DevTools [Provides LiveReload]
* Prometheus [Exposes the health metric in a prometheus format]
4. Click on Generate to download the project.
5. Unzip the downloaded project and open it in your IDE
6. Configure the src/main/resources/application.properties and configure the main application
7. Navigate to the server and start the server with ``` ./mvnw spring-boot:run ```
8. Repeat the same steps from 1-7 but instead remove Eureka Server and add Eureka Client

Dont forget to add management.endpoints.web.exposure.include=prometheus in the application.properties files to expose the prometheus end points. 
Install prometheus from their official site and configure the yml file to add:

```yml
scrape_configs:
  # The job name is added as a label `job=<job_name>` to any timeseries scraped from this config.
  - job_name: "prometheus"
    # metrics_path defaults to '/metrics'
    # scheme defaults to 'http'.
    static_configs:
      - targets: ["localhost:9090"]
  - job_name: 'eureka'
    metrics_path: '/actuator/prometheus'
    static_configs:
      - targets: ['localhost:8761']  # Eureka server URL
  
  - job_name: "EurkaClient"
    metrics_path: "/actuator/prometheus"
    static_configs:
      - targets: ['localhost:8081']  
      ```
