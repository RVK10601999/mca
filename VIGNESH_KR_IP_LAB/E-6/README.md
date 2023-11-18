## This is a Spring Boot Application using Spring Security and Spring Cache.
After running this project use the below link to access the API. While calling the API it will return to the spring boot internal login page.
On that page use the below user credentials to log in and access the API.

In the CouponController 4 endpoints is there:
1.  [Welcome Page](http://localhost:8080/myapp/)
2.  [User Page](http://localhost:8080/myapp/user/)
3.  [Admin Page](http://localhost:8080/myapp/admin/)
4.  [Admin Coupon Page](http://localhost:8080/myapp/admin/viewCoupon)

## Users Credentials:
1. User Name: user, Password: pass
2. Admin Name: admin, Password: pass

## Security:
1. Admin:  Admin can access all the endpoints.
2. User: User can access only [Welcome Page](http://localhost:8080/myapp/) and [User Page](http://localhost:8080/myapp/user/).

## Cache:
Implemented in Admin and Admin Coupon Page.
1. For Clearing and taking new value, call [Admin Page](http://localhost:8080/myapp/admin/)
2. For retrieving cache use [Admin Coupon Page](http://localhost:8080/myapp/admin/viewCoupon)

## H2 Database:
To access H2 database use the [link](http://localhost:8080/myapp/h2-console/)
#### H2 Credential:
url=jdbc:h2:mem:testdb

driverClassName=org.h2.Driver

username=sa

password=password
