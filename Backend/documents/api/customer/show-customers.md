# Find Customers

Returns a Customer List.

**URL** : `/api/v1/customers`

**Method** : `GET`

**Request URL** : `/api/v1/customers`

## Success Responses

**Code** : `200 OK`

**Sample Response Body** :

```json
{
  "success": true,
  "message": "Müşteriler Listelendi",
  "data": [
    {
      "id": 1,
      "identityNumber": "12345678910",
      "firstName": "ömer",
      "lastName": "öztürk",
      "dateOfBirth": "1997-01-28T21:07:31.520+00:00",
      "phoneNumber": "123456789",
      "salary": 8000
    }
  ]
}
```

## Null Data

**Sample Response Body** :

```json
{
  "success": true,
  "message": "Müşteriler Listelendi",
  "data": []
}
```