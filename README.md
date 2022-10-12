<p align="center">
  <img src="https://miro.medium.com/max/1400/1*PujtpysRY1VKO4WL0pK2Wg.png">
</p>

<div style="text-align: center;"><h1>Starter-GraphQL-SpringBoot</h1></div>

##### GraphQL is a modern replacement for the well known REST API server. This is a pure GraphQL server application - an example API server.
### Introduction
This is a sample graphql spring boot project. This project has implemented all the crud operations in a simple way.

### Technologies:
1. Java 17
2. Spring Boot 2.7.4
3. Gradle 7.5.1
4. GraphQL Java

### Features:
1. Input data validation.
2. Custom Exception

### **Clone this project using:**
```
git clone --recurse-submodules https://github.com/codeprismtechnologies/heartfulness-backend.git
```
### **Pre-requisites:**
* Make sure you are using Java version 11 or 17
* Install and start MySQL server
* Make sure using gradle version using 7+

## Run
* After cloning project. Refresh gradle once.
* Run project as springboot application
* To start executing queries using graphiql/playground. Copy any url(playground recommended) from below and open in any browser Safari/Chrome/Mozilla..etc
```
http://localhost:9090/playground
```
```
http://localhost:9090/graphiql
```
## Query Examples
**To create new user:**
````
mutation{
  signUp(user:{
    displayName:"your nyce name"
    firebaseId:"123HFN",
    email:"your email",
    phoneNumber:"1234567890",
    dateOfBirth:"2022-01-10",
    gender:MALE,
    profileUrl:"your profile url",
    loginStatus:LOGGEDIN,
    role:USER,
    provider:FACEBOOK,
    language:"your language code",
    heartPoints:2.0,
    state:"your state name",
    country:"your country code",
    city:"your city name",
    address:"your full address",
    passportId:"your passport id",
    taxId:"your tax Id",
    postalId:"your postal id",
    timeZone:"Etc/UTC",
    cityZenShipCountry:"INDIA",
    lastLogin:"2020-04-03 12:10:00"
  }){
    id
    displayName
    .......
  }
}
````
**To update user details:**
````
mutation{
  updateSignUp(user:{
    userId:1
    displayName:"your updated nyce name"
    firebaseId:"123HFN",
    email:"your email",
    phoneNumber:"1234567890",
    dateOfBirth:"2022-01-10",
    gender:MALE,
    profileUrl:"your profile url",
    loginStatus:LOGGEDIN,
    role:USER,
    provider:FACEBOOK,
    language:"your language code",
    heartPoints:2.0,
    state:"your state name",
    country:"your country code",
    city:"your city name",
    address:"your full address",
    passportId:"your passport id",
    taxId:"your tax Id",
    postalId:"your postal id",
    timeZone:"Etc/UTC",
    cityZenShipCountry:"INDIA",
    lastLogin:"2020-04-03 12:10:00"
  }){
    id
    displayName
    ......
  }
}
````
**To Get user details:**
````
query{
  getUser(userId:1){
    id
    displayName
    profileUrl
    phoneNumber
    .....
  }
}
````
**To GetAll user details:**
````
# you can put count acording to your choice
query{
  getAllUser(count:2){
    id
     displayName
    profileUrl
    phoneNumber
  }
}
````
**To Delete user:**
````
mutation{
  deleteUser(userId:2)
}
````
# Screenshots:

### Playground:

<img width="1470" alt="Screenshot 2022-10-11 at 11 53 56 AM" src="https://user-images.githubusercontent.com/90640564/195012164-ab43abd6-eb40-4459-b0ed-26a07b4b67a1.png">
<img width="1470" alt="Screenshot 2022-10-11 at 11 53 26 AM" src="https://user-images.githubusercontent.com/90640564/195012187-f1d2059e-ffd3-41dd-a56e-a01ef1452235.png">
<img width="1470" alt="Screenshot 2022-10-11 at 11 51 31 AM" src="https://user-images.githubusercontent.com/90640564/195012189-bd376256-f3f5-46ff-b405-73b08b0e4418.png">

### Graphiql:

<img width="1470" alt="Screenshot 2022-10-10 at 11 44 24 PM" src="https://user-images.githubusercontent.com/90640564/194929541-1fea4cb4-638f-446c-b9a7-3e8a1b94f1af.png">
<img width="1470" alt="Screenshot 2022-10-10 at 11 46 20 PM" src="https://user-images.githubusercontent.com/90640564/194929583-f1fadf1a-0b03-4104-9e3b-acd53960a40b.png">
<img width="1470" alt="Screenshot 2022-10-10 at 11 46 36 PM" src="https://user-images.githubusercontent.com/90640564/194929599-caf89e82-56b0-4544-8ed0-07a134c852ac.png">

<p align="center"><a href="https://codeprism.in">
<img src="https://i.ibb.co/WPR5v8g/logo-codeprism-2f573bcb5c.png" alt="codeprism.in">
</a></p>