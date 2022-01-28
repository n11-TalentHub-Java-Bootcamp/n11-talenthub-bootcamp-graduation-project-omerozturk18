# Find Guarantee By Customer Id

Returns a Customer By Customer Identity Number.

**URL** : `/api/v1/guarantees/customer/{customerId}`

**Method** : `GET`

**Request URL** : `/api/v1/guarantees/customer/1`

## Success Responses

**Code** : `200 OK`

**Sample Response Body** :

```json
{
  "success": true,
  "message": "Kullanıcının Teminatları Getirildi",
  "data": [
    {
      "id": 1,
      "explanation": "string",
      "guaranteeType": "CAR",
      "guaranteeAmount": 50000,
      "operationDate": "2022-01-28T22:40:28.951+00:00",
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
  "errorDate": "2022-01-28T23:06:45.268+00:00",
  "message": "Müşteri Bulunanamdı!",
  "detail": "uri=/api/v1/guarantees/customer/3"
}
```