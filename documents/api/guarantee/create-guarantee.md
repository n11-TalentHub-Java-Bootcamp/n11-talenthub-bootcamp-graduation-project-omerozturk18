# Create Guarantee

**URL** : `/api/v1/guarantees`

**Method** : `POST`

**Request URL** : `/api/v1/guarantees`

## Request Body

```json
{
  "explanation": "string",
  "guaranteeAmount": 50000,
  "guaranteeType": "CAR",
  "csrCustomerId": 1
}
```

## Success Responses

**Code** : `200 OK`

**Sample Response Body** :

```json
{
  "success": true,
  "message": "Teminat Eklendi",
  "data": {
    "id": 1,
    "explanation": "string",
    "guaranteeType": "CAR",
    "guaranteeAmount": 50000,
    "operationDate": "2022-01-28T22:40:28.951+00:00",
    "csrCustomerId": 1
  }
}
```

## Error Responses

**Code** : `400`

**Sample Response Body** :

```json
{
  "errorDate": "2022-01-28T22:43:01.603+00:00",
  "message": "Müşteri Bulunanamdı!",
  "detail": "uri=/api/v1/guarantees"
}
```

## Error Responses - Not Valid

**Code** : `400`

**Sample Response Body** :

```json
{
  "errorDate": "2022-01-29T11:34:04.285+00:00",
  "message": "Teminat Açıklaması Boş Bırakılamaz",
  "detail": "uri=/api/v1/guarantees"
}
```