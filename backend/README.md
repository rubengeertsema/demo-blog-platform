# Backend for demo blog platform
This is the Spring Boot backend implementation for the demo blog platform. The frontend client can be found 
[here](http://project-to-be-created) and the mobile clients can be found [here](http://project-to-be-created).

Purpose of the platform project is to create a simple blog platform with a backend, a web client and a mobile app for 
iOS and Android. In the blog platform project I intend to explore several technologies, like:
* Spring-Boot for the backend
* Angular (version 4) for the web client
* React-Native for the mobile apps
* Docker because it is awesome
* REST-assured for api/integration testing
* protractor for e2e-testing
* Gatling for performance testing
* Pipeline as code with a Jenkinsfile
* Probably more to come...

Note: This project has just started and is a Work in Progress... 

## Run the backend application
Run the commands below from the project root:
* Start mongodb: <code>docker-compose -f src/main/docker/mongo.yml up</code>
* Start the blog backend: <code>./mvnw spring-boot:run</code>

## Api
* Get pageable blog posts: <code>http://\<server\>:\<host\>/api/blog?page=\<page\>&size=\<size\> (GET)</code>
* Get blog post by id: <code>http://\<server\>:\<host\>/api/blog/{id} (GET)</code>
* Create a new blog post: <code>http://\<server\>:\<host\>/api/blog (POST)</code>
* Update a blog post: <code>http://\<server\>:\<host\>/api/blog (PUT)</code>
* Delete a blog post: <code>http://\<server\>:\<host\>/api/blog/{id} (DELETE)</code>
* Delete all blog posts: <code>http://\<server\>:\<host\>/api/blog (DELETE)</code>
