## This is a Spring Boot Application using Spring JPA
After running this project use the below link to access the API endpoint.

1.  [Without Pagination and sorting](http://localhost:8080/springJPA/)
2.  [With Pagination and sorting](http://localhost:8080/springJPA/students?pageNumber=0&pageSize=5&sortBy=id&sortOrder=asc)


## H2 Database:
To access H2 database use the [link](http://localhost:8080/springJPA/h2-console/)
#### H2 Credential:
url=jdbc:h2:mem:testdb

driverClassName=org.h2.Driver

username=sa

password=1234


### NOTE:
You can change the H2 credentials in application.properties file
