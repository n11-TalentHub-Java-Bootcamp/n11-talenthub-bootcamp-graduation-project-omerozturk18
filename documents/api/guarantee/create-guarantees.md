# Create Guarantees

**URL** : `/api/v1/guarantees/all`

**Method** : `POST`

**Request URL** : `/api/v1/guarantees/all`

## Request Body

```json
[
  {
    "explanation": "string",
    "guaranteeAmount": 0,
    "guaranteeType": "CAR",
    "csrCustomerId": 0
  }
]
```

## Success Responses

**Code** : `200 OK`

**Sample Response Body** :

```json
{
  "success": true,
  "message": "Teminatlar Eklendi",
  "data": [
    {
      "id": 1,
      "explanation": "string",
      "guaranteeType": "CAR",
      "guaranteeAmount": 50000,
      "operationDate": "2022-01-28T22:40:28.951+00:00",
      "csrCustomerId": 1
    },
    {
      "id": 2,
      "explanation": "string",
      "guaranteeType": "GOLD",
      "guaranteeAmount": 30000,
      "operationDate": "2022-01-28T22:40:54.711+00:00",
      "csrCustomerId": 1
    }
  ]
}
```

## Error Responses

**Code** : `404`

**Sample Response Body** :

```json

{
  "errorDate": "2022-01-28T23:00:40.966+00:00",
  "message": "Müşteri Bulunanamdı!",
  "detail": "uri=/api/v1/guarantees/all"
}
```

**Code** : `400`

**Sample Response Body** :

```json
{
  "errorDate": "2022-01-28T22:43:01.603+00:00",
  "message": "Müşteri Bulunanamdı!",
  "detail": "uri=/api/v1/guarantees"
}
```

```json
{
  "success": false,
  "message": "Farklı Kullnıcılara Aynı Anda Teminat Eklenemez!",
  "data": null
}
```