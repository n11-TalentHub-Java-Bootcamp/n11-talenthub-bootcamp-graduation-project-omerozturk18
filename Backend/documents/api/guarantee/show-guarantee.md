# Find Guarantee By Id

Returns a Guarantee By Id.

**URL** : `/api/v1/guarantees/{id}`

**Method** : `GET`

**Request URL** : `/api/v1/guarantees/1`

## Success Responses

**Code** : `200 OK`

**Sample Response Body** :

```json
{
  "success": true,
  "message": "Teminat Getirildi",
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

**Code** : `404`

**Sample Response Body** :

```json
{
  "errorDate": "2022-01-28T23:04:06.046+00:00",
  "message": "Teminat Bulunanamdı!",
  "detail": "uri=/api/v1/guarantees/4"
}
```