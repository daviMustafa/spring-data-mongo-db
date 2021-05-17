# Getting Started

## Steps
    - Install docker (Tested on linux containers)
    - Run: 'mvn clean package -Pdocker' to generate jar file
    - Go to your project folder and run 'docker-compose config' to check for docker-compose file errors
    - Run docker-compose up --build
    - If you have Mongo Compass, access using this connection string:
        -   mongodb://root:root@localhost:27017/test?authSource=test&readPreference=primary&appname=MongoDB%20Compass&ssl=false
    
## Using Intellij Http Request to test:

    POST http://localhost:8081/spring-data-mongo-db/customer
    accept: application/json;charset=UTF-8
    Content-Type: application/json;charset=UTF-8
    
    {
        "firstName": "Teste",
        "lastName": "Teste"
    }

    GET http://localhost:8081/spring-data-mongo-db/customer
    accept: application/json;charset=UTF-8
    Content-Type: application/json;charset=UTF-8
