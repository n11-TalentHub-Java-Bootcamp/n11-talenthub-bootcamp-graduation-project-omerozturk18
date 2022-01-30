# N11 Bootcamp Graduation Project

Hello, this project it was developed in line with The graduation assignment for The bootcamp offered free of charge in partnership with <b>Patika & N11</b>.
## Technologies & Structures Used
<ul>
    <li>Backend
    <ul>
        <li>Java 11</li>
        <li>Spring Boot</li>
        <li>Spring Data JPA</li>
        <li>Spring HATEOAS</li>
        <li>MapStruct</li>
        <li>Loombak</li>
        <li>Validation</li>
		<li>Swagger</li>
		<li>PostgreSQL</li>
		<li>Unit Test</li>
        <li>Builder Design Pattern</li>
        <li>Factory Design Pattern</li>
		<li>Single Design Pattern</li>
        <li>Basic Result Type</li>
		<li>Twilio Sms Send</li>
		<li><b>tckimlik.nvi.gov.tr</b> Mernis Check Customer</li>
    </ul>
    </li>
    <li>Frontend
    <ul>
        <li>React</li>
		<li>Axios</li>
        <li>Reactstrap</li>
        <li>Formik</li>
        <li>Yup</li>
        <li>React Toastify</li>
    </ul>
    </li>
</ul>

# Setup

*** If You Do Not Have PostgreSQL Installed On Your Computer, You Can Use It Via Docker.

### Cloning The Project

```java
$ git clone https://github.com/n11-TalentHub-Java-Bootcamp/n11-talenthub-bootcamp-graduation-project-omerozturk18.git
cd n11-talenthub-bootcamp-graduation-project-omerozturk18/Backend
```
### Configuration Settings
	
- Open File `./src/main/resources/application.properties` .

- Adapt The Following Settings According to Yourself.
   - Replace The `172.25.192.1` Field Below With Your Own Ip Address.

```
spring.datasource.url=jdbc:postgresql://172.25.192.1:5432/n11-graduation-project
spring.datasource.username=postgres
spring.datasource.password=12345
spring.datasource.driver-class-name=org.postgresql.Driver
```
- If You Change The `database name, username and password` and Will Use Docker, Please Also Update The `docker-compose.yml` Files

## 1) Backend Setup

```java
mvn clean install
```
#### -> Running The Application Locally


- Create a Database named `n11-graduation-project` in PostgreSQL.

- Run The Application With The Commands Below.	
```java
mvn spring-boot:run
```

#### -> Running The Application With Docker

- Run The Application With The Commands Below.	

```docker
docker build -t omerozturk-backend . 
```

```docker
docker-compose up -d
```
*** If You Want To Use PostgreSQL Over Docker

- Please Follow The Steps Below for PostgreSQL
    - Go to http://localhost:5050/browser/
	- Password is Same as `docker-compose.yml`
	- Right Click on `Servers` on The Left and Add a New Server
	- Set a Name on The Screen That Comes Up and Switch To The Connection Tab
	- Just Write Your Ip Address To The Host Address and Save It
	- Create a Database Named `n11-graduation-project` in PostgreSQL.
	- Run The Application With The Command Below.	
	
```docker
docker start omerozturk-app-backend
```
*** If You Do Have PostgreSQL Installed On Your Computer
- Please Follow The Steps Below
    - Create a Database Named `n11-graduation-project` in PostgreSQL.
	- Run The Application With The Command Below.	
	
```docker
docker start omerozturk-app-backend
```
	
## 2) Frontend  Setup

```javascript
cd n11-talenthub-bootcamp-graduation-project-omerozturk18/Frontend
```
#### -> Running The Application Locally

- Install npm packages

```bash
npm install
```

- The Following Code is Used to Start The React Project.

```bash
npm start
```

#### -> Running The Application With Docker

- Run The Application With The Commands Below.	

```docker
docker build -t omerozturk-frontend . 
docker-compose up -d
```

* [Frontend Url](http://localhost:3000/)

## Basic Result Type
#### DataResult
> - SuccessDataResult

200 Response body

```bash
{
  "success": true,
  "message": "",
  "data": []
}
```
> - SuccessResult

200	Response body

```bash
{
  "success": true,
  "message": "sdsd"
}
```
> - ErrorDataResult

Error: response status is 400

```bash
{
  "success": false,
  "message": "",
  "data": null
}
```

> - ErrorResult

Error: response status is 400

```bash
{
  "success": false,
  "message": "",
}
```

> - NotFoundException

Error: response status is 404

```bash
{
  "errorDate": "",
  "message": "",
  "detail": ""
}
```


## ENDPOINTS

## Crd Package

> - Credit Package
### For Credit

* [Show Credits](Backend/documents/api/credit/show-credits.md) : `GET /api/credits`
* [Show Credit](Backend/documents/api/credit/show-credit.md) : `GET /api/credits/{id}`
* [Show Credit By Credit Name](Backend/documents/api/credit/show-credit-creditName.md) : `GET /api/credits/name/{creditName}`
* [Create Credit](Backend/documents/api/credit/create-credit.md) : `POST /api/credits`
* [Delete Credit](Backend/documents/api/credit/delete-credit.md) : `DELETE /api/credits/{id}`

## Csr Package

> - Customer Package
### For Customer

* [Show Customers](Backend/documents/api/customer/show-customers.md) : `GET /api/customers`
* [Show Customer](Backend/documents/api/customer/show-customer.md) : `GET /api/customers/{id}`
* [Show Customer By Identity Number](Backend/documents/api/customer/show-customer-identityNumber.md) : `GET /api/customers/identityNumber/{identityNumber}`
* [Create Customer](Backend/documents/api/customer/create-customer.md) : `POST /api/customers`
* [Update Customer](Backend/documents/api/customer/update-customer.md) : `PUT /api/customers`
* [Delete Customer](Backend/documents/api/customer/delete-customer.md) : `DELETE /api/customers/{id}`

### For Customer Guarantee

* [Show Guarantees](Backend/documents/api/guarantee/show-guarantees.md) : `GET /api/guarantees`
* [ShowGuarantee](Backend/documents/api/guarantee/show-guarantee.md) : `GET /api/guarantees/{id}`
* [Show Customer By Customer Id](Backend/documents/api/guarantee/show-guarantee-customerId.md) : `GET /api/guarantees/customer/{customerId}`
* [Create Guarantee](Backend/documents/api/guarantee/create-guarantee.md) : `POST /api/guarantees`
* [Create Guarantees](Backend/documents/api/guarantee/create-guarantees.md) : `POST /api/guarantees/all`
* [Delete Guarantee](Backend/documents/api/guarantee/delete-guarantee.md) : `DELETE /api/guarantees/{id}`

### For Customer Credit

* [Show Customer Credits](Backend/documents/api/customerCredit/show-customerCredits.md) : `GET /api/customer-credits`
* [Show Customer Credit](Backend/documents/api/customerCredit/show-customerCredit.md) : `GET /api/customer-credits/{id}`
* [Show Customer Credits By Customer Id](Backend/documents/api/customerCredit/show-customerCredits-customerId.md) : `GET /api/customer-credits/customer/{customerId}`
* [Show Customer Credits By Credit Id](Backend/documents/api/customerCredit/show-customerCredits-creditId.md) : `GET /api/customer-credits/credit/{creditId}`
* [Show Customer Credit Result](Backend/documents/api/customerCredit/show-customerCredits-result.md) : `GET /api/customer-credits/credit-result/{identityNumber}/{dateOfBirth}`
* [Show Customer Credit Result Approved](Backend/documents/api/customerCredit/show-customerCredits-resultApproved.md) : `GET /api/customer-credits/credit-result-approved/{identityNumber}/{dateOfBirth}`
* [Show Customer Credit Active Credit By Customer](Backend/documents/api/customerCredit/show-customerCredits-activeCredits.md) : `GET /api/customer-credits/active-credits-customer/{customerId}`
* [Create Customer Credit Apply](Backend/documents/api/customerCredit/create-customerCredit.md) : `POST /api/customer-credits`
* [Put Customer Credit Response](Backend/documents/api/customerCredit/update-customerCredit.md) : `POST /api/customer-credits`
* [Delete Customer Credit](Backend/documents/api/customerCredit/delete-customerCredit.md) : `DELETE /api/customer-credits/{id}`

## Cnt Package

> - Contact Package
### For Message

* [Show Messages](Backend/documents/api/message/show-messages.md) : `GET /api/messages`
* [Show Message](Backend/documents/api/message/show-message.md) : `GET /api/messages/{id}`
* [Show Message By Phone Number](Backend/documents/api/message/show-messages-phoneNumber.md) : `GET /api/messages/phone/{phoneNumber}`
* [Create Message](Backend/documents/api/message/create-message.md) : `POST /api/messages`
* [Delete Message](Backend/documents/api/message/delete-message.md) : `DELETE /api/messages/{id}`

## Gen Package

> - Generic Package
- [Adapter](src/main/java/com/omerozturk/N11GraduationProject/gen/adapter) 
   - Credit Score Service
   - Mernis Service
   - Twilio Sms Service
   
- [Configuration](src/main/java/com/omerozturk/N11GraduationProject/gen/configuration)
   - SwaggerConfiguration 
   - TwilioConfiguration
   
   
- [Excaption](src/main/java/com/omerozturk/N11GraduationProject/gen/excaption)
   - CustomizedResponseEntityExceptionHandler
   - ExceptionResponse
   
- [Utilities](src/main/java/com/omerozturk/N11GraduationProject/gen/utilities)
   - Entity
        - BaseEntity
		- SmsRequest
		
   - Enums
        - EnumStatus
		- EnumYesNo
		
   - Result
        - Result
		   - SuccessResult		
		   - ErrorResult   
        - DataResult
		   - SuccessDataResult		
		   - ErrorDataResult

   - Service
        - BaseEntityService
		   - findAll		
		   - findById
		   - save		
		   - delete		   
		   

## Uml Diagram

* [Show Crd Package Uml Diagram](Backend/documents/UmlDiagram/crd/README.md) 
* [Show Csr Package Uml Diagram](Backend/documents/UmlDiagram/csr/README.md) 
* [Show Cnt Package Uml Diagram](Backend/documents/UmlDiagram/cnt/README.md) 

## OpenApi Swagger

* [Show OpenApi Yaml File](Backend/documents/swagger/openapi.yaml) 
* [Show OpenApi Json File](Backend/documents/swagger/openapi.json) 

* [You Can Access Swagger Here When The App Is Running](http://localhost:8080/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config#/)

## Author

**Ömer Öztürk**

* [github/omerozturk18](https://github.com/omerozturk18)
