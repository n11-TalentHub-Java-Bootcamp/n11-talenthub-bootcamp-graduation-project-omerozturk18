# N11 Bootcamp Graduation Project

Hello, this project it was developed in line with the graduation assignment for the bootcamp offered free of charge in partnership with <b>Patika & N11</b>.
## Technologies & Structures Used
<ul>
    <li>Back-End
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
    <li>Front-End
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

# Setup - Back-End

### Cloning the Project

```java
$ git clone https://github.com/n11-TalentHub-Java-Bootcamp/n11-talenthub-bootcamp-graduation-project-omerozturk18.git
cd n11-talenthub-bootcamp-graduation-project-omerozturk18/Backend
```
#### -> Running the Application Locally

- Open File `./src/main/resources/application.properties` .

- Adapt the Following Settings According to Yourself.
```
spring.datasource.url=jdbc:postgresql://localhost:5432/N11GraduationProject
spring.datasource.username=postgres
spring.datasource.password=12345
spring.datasource.driver-class-name=org.postgresql.Driver
```

- Create a Database named `N11GraduationProject` in PostgreSQL.

- Run the Application With the Commands Below.	
```java
mvn clean install
mvn spring-boot:run
```

#### -> Running the Application With Docker
```docker
docker-compose up -d
```

## Setup - Front-End

```javascript
cd n11-talenthub-bootcamp-graduation-project-omerozturk18/Frontend
```


- Install npm packages

```bash
npm install
```

- The Following Code is Used to Start the React Project.

```bash
npm start
```

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

* [Show Crd Package Uml Diagram](Backend/documents/UmlDiagram/crd/readme.md) 
* [Show Csr Package Uml Diagram](Backend/documents/UmlDiagram/csr/readme.md) 
* [Show Cnt Package Uml Diagram](Backend/documents/UmlDiagram/cnt/readme.md) 

## OpenApi Swagger

* [Show OpenApi Yaml File](Backend/documents/swagger/openapi.yaml) 
* [Show OpenApi Json File](Backend/documents/swagger/openapi.json) 

* [You Can Access Swagger Here When The App Is Running](http://localhost:8080/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config#/)

## Author

**Ömer Öztürk**

* [github/omerozturk18](https://github.com/omerozturk18)
