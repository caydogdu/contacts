# contacts
A spring boot application with vue.js to search, list contacts

This is a spring boot application with vue.js to search, list contacts by Cemil Aydogdu. https://github.com/caydogdu/contacts

These are the main ability of project

    Ability to read contact list csv file and store id to in-memory db
    Ability to search in contact list with spring data
    Ability to view contact list in front end page
    
This project was developed with spring boot. Java 8 is required. h2 in-memory db is used. Front end page is developed with vue.js

To see main page, you can browse http://localhost:8081/index after application run

There is a REST Service in this project. Here is an example request and response
Below request indicates that you would like to search in contact list for name contains Bart and you would like to get first 10 records.

    To search in contact list POST localhost:8081/contacts with body 
    {
      "filters":[
        {
          "key":"name",
          "operator":"CONTAINS",
          "value":"Bart"
        }
      ],
      "pageNumber":1,
      "size":10
    }
    
Response for the above request will be like this
    
    {
      "success": true,
      "result": [
        {
            "id": 4,
            "name": "Bart Simpson",
            "url": " https://vignette.wikia.nocookie.net/simpsons/images/6/65/Bart_Simpson.png/revision/latest/scale-to-width-down/87?cb=20180319061933"
        },
        {
            "id": 268,
            "name": "Bart Simpson",
            "url": " https://vignette.wikia.nocookie.net/simpsons/images/6/65/Bart_Simpson.png/revision/latest/scale-to-width-down/70?cb=20180319061933"
        },
        {
            "id": 302,
            "name": "Bart Simpson",
            "url": " Jr."
        },
        {
            "id": 641,
            "name": "Bart Simpson",
            "url": " https://vignette.wikia.nocookie.net/simpsons/images/6/65/Bart_Simpson.png/revision/latest/scale-to-width-down/89?cb=20180319061933"
        },
        {
            "id": 643,
            "name": "Bart Simpson",
            "url": " Jr."
        }
      ],
      "resultInfo": {
        "totalElements": 5,
        "size": 10,
        "totalPages": 1,
        "pageNumber": 1
      }
    }

To see metrics you can use http://localhost:8081/actuator/metrics/

For online documentation of REST API http://localhost:8081/swagger-ui.html

## Run options and deployment

This project is a microservice. So you can easily run it.

1- Running as a packaged application If you use the Spring Boot Maven or Gradle plugins first create an executable jar then you can run your application using java -jar. For example: 

    $ java -jar target/contacts-0.0.1-SNAPSHOT.jar 
    
It is also possible to run a packaged application with remote debugging support enabled. This allows you to attach a debugger to your packaged application:

You can also run it with executing the main class (**com.contacts.Application**)

2- Using the Maven plugin The Spring Boot Maven plugin includes a run goal which can be used to quickly compile and run your application. Applications run in an exploded form just like in your IDE.

    $ mvn spring-boot:run
