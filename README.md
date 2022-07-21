# An API that allows mobile clients to retrieve and add suburb and postcode combinations

#######################<br />
## Technology stack <br/>
#######################
1. Spring Boot
2. Spring Data JPA
3. Spring Security
4. JWT
5. Swagger
6. Lombok
7. H2 In memory database
8. Maven
9. Junit
10. Mockito

#########################<br />
## Design <br />
#########################
The microservice is developed in Spring boot. 
I have used Spring MVC and Spring Data JPA. 
The layers of microservice are-

1. Controller - This accepts the GET Request. 
     Versioning added in url to support multiple versions for future enhancements. 
     There are 3 REST endpoints configured in the controller
     * GET - /v1/api/search/postCode/{postCode} - Used to fetch details using the postcode.
     * GET - /v1/api/search/suburb/{suburb} - Used to fetch details using the suburb name.
     * POST - /v1/api/update/addressRecord - To add a new record
2. Service - The service layer of application
3. Repository - Used to perform Data Access Operation
4. Model - DTO and Entity
5. The H2 database table created and the initial values is added using the data.sql
6. Spring security is enabled using the JWT token.
7. Validation is done on postcode
8. Exceptions are handled


#########################<br />
## Details<br />
#########################

**The project is executable and the microservices will run on the port: 9000**

1. Build:

>mvn clean package

2. Run:

>java -jar target/demo-0.0.1-SNAPSHOT.jar


#########################<br />
Testing the Restful Web Services:t<br />
#########################################

### 1. Searching By PostCode Example:

#### API Request-

   >$ curl -s http://localhost:9000/v1/api/search/postCode/3009

#### APIResponse-
 HTTP STATUS - 
 >200 OK 

RESPONSE BODY
>[
{
"postCode": "3000",
"suburb": "Melbourne"
}
]

### 2. Searching By Suburb Example:

#### API Request-

>$ curl -s http://localhost:9000/v1/api/search/suburb/Melbourne

#### API Response-

>200 OK

RESPONSE BODY
>[
{
"postCode": "3000",
"suburb": "Melbourne"
}
]

### 2. Add a new record Example:

#### AUTHENTICATE

#### API Request to get a token-

>curl --location --request POST 'http://localhost:9000/authenticate' \
--header 'Content-Type: application/json' \
--data-raw '{
"username": "foo",
"password": "foo"
}'

#### API Response-

> {
"jwt": "sampleToken"
}

Copy the token and use in the next request.

#### Add a new Record

>curl --location --request POST 'http://localhost:9000/v1/api/update/addressRecord' \
--header 'Content-Type: application/json' \
--header 'Authorization: Bearer sampleToken' \
--data-raw '{
"postCode":"3009",
"suburb":"ABC"
}'

#### API Response-

>201 CREATED 

RESPONSE BODY
>{
"postCode": "3008",
"suburb": "North Melbourne"
}

#########################<br />
## Steps to deploy in EC2 <br />
#########################


## NOTE: A JAR has been added in GIT already for reference
**Location: src/test/resources/samplejar/demo-0.0.1-SNAPSHOT.jar**

1. Take the JAR file from "src/test/resources/samplejar/demo-0.0.1-SNAPSHOT.jar"
2. Copy the Spring boot JAR on EC2 instance
3. Allow port 8080 on the instance security group
4. Test the application deployed on EC2

## NOTE: A postman collection is also added in location "src/test/resources/postmanCollection"

#########################<br />
## TO DO items <br />
#########################


1. System testing can also be implemented by using cucumber.
2. More unit testing can be added to improve coverage.
3. Swagger can be added.
4. Security keys can be placed in AWS parameter store and password encoding can be added for better security.
5. Any hardcoded values can be parameterized.


