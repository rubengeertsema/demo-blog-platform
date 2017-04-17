# Backend for demo blog platform
This is the Spring Boot backend implementation for the demo blog platform. The frontend client can be found 
[here](../web/README.md) and the mobile clients can be found [here](../mobile/README.md).

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
