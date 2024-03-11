# App subscription service

### Description:

* Java 21
* Springboot 3.2.3
* Mongo atlas database

### minimal settings to start project

1. Create .env file in root of the project
2. Add env variables to it

``` java
# app-subscription-service:
APP_SUBSCRIPTION_SERVICE_MONGODB_URI - url to mongo db
APP_SUBSCRIPTION_SERVICE_JWT_TOKEN - bearer token
APP_SUBSCRIPTION_SERVICE_JWT_SECRET_KEY - secred key
```

### API documentation

Project uses OpenAPI (link: https://springdoc.org/) that will describe the API
of REST endpoints.

Configuration api documentation endpoint in *.yaml file

```
springdoc:
  swagger-ui:
    path: /api/documentation
```

API documentation endpoint:  <br>

* http://{URL}:{port}/api/documentation

### Spring Data Reactive Mongo DB

Reactive mongo db:

* [Tutorial Spring Data MongoDB](https://docs.spring.io/spring-data/mongodb/docs/2.0.0.RC2/reference/html/#mongo.reactive.repositories.usage)

* [Spring Data MongoDB](https://docs.spring.io/spring-data/mongodb/reference/index.html)

### Atlas cloud Mongo DB

* Cloud db: https://cloud.mongodb.com/
* [Working with Spring Data Repositories](https://docs.spring.io/spring-data/mongodb/docs/current/reference/html/#repositories)

##### Transactional support in Reactive style of Mongo DB & Spring Boot:

* [Transactional Mongo DB & Spring Boot](https://stackoverflow.com/questions/56360094/calling-methods-in-two-different-reactivemongorepositorys-in-a-transaction-usin/61676211#61676211)

#### How to set up database:

1. Login to Mongo cluster
    * https://account.mongodb.com/account/login


2. Get or set new admin credentials:<br>
    * login
    * password
    * and set permission - Atlas admin


3. Create a Shared Cluster
    * FREE >> Sandbox (Shared RAM, 512 MB Storage)


4. Go to Quick Start Security

    * Set up a username and a new password


5. Set up network access for database:

    * Network Access tab >> Edit IP Access List Entry >>  Allow Access from Anywhere


6. Database Deployments Options <br>
   Go to: Database >> Database Deployments >> Connect button <br>
    * Select your driver and version: Java and latest version of driver <br>
    * Add your connection string into your application code <br>

   example: <br>
   <code>
   mongodb+srv://<username>:<password>@cluster0.8seexos.mongodb.net/?retryWrites=true&w=majority
   </code>


7. Create new DATABASES
    * Go to: DATABASE >> Cluster >> Collections >> Add My Own Data
    * Set up Database name (example: sampleDB ) and collection name (example: collectionDB)


8. Set up required ENV Variables for application:
    * MONGODB_DATABASE - Database name from DATABASE >> Cluster >> Collections  (example: sampleDB )
    * MONGODB_URI - mongodb+srv://<username>:<password>@cluster0.8seexos.mongodb.net/?retryWrites=true&w=majority



