# Find Customer By Id

Returns a Customer By Id.

**URL** : `/api/v1/customers/{id}`

**Method** : `GET`

**Request URL** : `/api/v1/customers/1`

## Success Responses

**Code** : `200 OK`

**Sample Response Body** :

```json
{
  "success": true,
  "message": "Müşteri Getirildi",
  "data": {
    "id": 1,
    "identityNumber": "123245678910",
    "firstName": "ömer",
    "lastName": "öztürk",
    "dateOfBirth": "1997-01-28T21:07:31.520+00:00",
    "phoneNumber": "12345657891",
    "salary": 8000
  }
}
```

## Error Responses

**Code** : `404`

**Sample Response Body** :

```json
{
  "errorDate": "2022-01-28T20:42:55.700+00:00",
  "message": "Müşteri Bulunanamdı!",
  "detail": "uri=/api/v1/customers/1"
}
```