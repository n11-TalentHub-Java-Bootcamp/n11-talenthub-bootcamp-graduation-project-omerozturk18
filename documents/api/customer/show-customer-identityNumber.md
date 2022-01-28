# Find Customer By Identity Number

Returns a Customer By Customer Identity Number.

**URL** : `/api/v1/customers/name/{identityNumber}`

**Method** : `GET`

**Request URL** : `/api/v1/customers/identityNumber/12345678910`

## Success Responses

**Code** : `200 OK`

**Sample Response Body** :

```json
{
  "success": true,
  "message": "Müşteri Getirildi",
  "data": {
    "id": 1,
    "identityNumber": "12345678910",
    "firstName": "ömer",
    "lastName": "öztürk",
    "dateOfBirth": "1997-01-28T21:07:31.520+00:00",
    "phoneNumber": "1234567891",
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