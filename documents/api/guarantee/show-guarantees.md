# Find Guarantees

Returns a Guarantee List.

**URL** : `/api/v1/guarantees`

**Method** : `GET`

**Request URL** : `/api/v1/guarantees`

## Success Responses

**Code** : `200 OK`

**Sample Response Body** :

```json
{
  "success": true,
  "message": "Teminatlar Listelendi",
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

## Null Data

**Sample Response Body** :

```json
{
  "success": true,
  "message": "Teminatlar Listelendi",
  "data": []
}
```