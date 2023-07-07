# JWT_Auth - An authentication and authorization backend application using spring security and JWT

## Steps To Run the application -
  - Clone this Repository using  "Git clone https://github.com/Rushikesh0125/JWT_Auth.git" command
  - Open the folder into your IDE
  - Navigate to pom.xml and Load maven application to download dependecies.
  - If you want to run project through CLI - mvn spring-boot:run [Make sure maven is installed]

## Testing the application - 
  - You can test this application using Postman or Insomnia
  - ### ***Request for Sign Up***
      - ***URL -*** `http://localhost:8080/api/v1/auth/signup`
      - **Request Body - Type JSON***
        `
          {
            "username":"Rushikesh250901",
            "password":"password123"
          }
        `
      - In ***Headers section*** select content type `application/json`.
      - You will get response as `eyJhbGciOiJIU.........DK6Ip_zfVZTlNxLXPocU66guBf3lY74jFr7AwU` JWT Token.
      - Make sure that it is a ***Put Mapping***.
      - **Sign Up Request***
      -  <img width="738" alt="singup" src="https://github.com/Rushikesh0125/JWT_Auth/assets/85375791/445293ed-293d-4fda-ba35-6d749bf54270">

  - ### ***Request for Sign In***
      - ***URL -*** `http://localhost:8080/api/v1/auth/signin`
      - ***Request Body - Type JSON***
        `
          {
            "username":"Rushikesh250901",
            "password":"password123"
          }
        `
      - In ***Headers section*** select content type `application/json`
      - In ***Auth*** Section select `Bearer`
      - Put the JWT token as ***token*** [Received as response for sign up & make sure same user information passed in body]  &  `Bearer ` as prefix[Striclty put space after Bearer in prefix]
      - Make sure that it is a ***Put Mapping***.
      - ***Sign In Request***
      - <img width="737" alt="Signin" src="https://github.com/Rushikesh0125/JWT_Auth/assets/85375791/9cbe39e8-a1fc-4e2a-a19b-c8e98488902e">

  - ### ***Request for Resources [Authorization check]***
      - ***URL -*** `http://localhost:8080/api/v1/resource`
      - ***No Request Body***
      - In ***Headers section*** select content type `application/json`
      - In ***Auth*** Section select `Bearer`
      - Put the JWT token as ***token*** [Received as response for sign in/up & make sure same user information passed in body]  &  `Bearer ` as prefix[Striclty put space after Bearer in prefix]
      - Make sure that it is a ***Get Mapping***.
      - ***Get Request***
      - <img width="737" alt="Get" src="https://github.com/Rushikesh0125/JWT_Auth/assets/85375791/b6884e37-7003-45c8-84d0-4463257e2ab0">

## To Check you h2 Database
    - Put `http://localhost:8080/h2-console` in your browser
    - Username :- root
    - Password :- 12345
    - URL :- jdbc:h2:mem:springsecurity



