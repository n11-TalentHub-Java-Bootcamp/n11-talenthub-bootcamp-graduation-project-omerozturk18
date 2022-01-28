# Find Customer Credit By Id

Returns a Customer Credit By Id.

**URL** : `/api/v1/customer-credits/{id}`

**Method** : `GET`

**Request URL** : `/api/v1/customer-credits/1`

## Success Responses

**Code** : `200 OK`

**Sample Response Body** :

```json
{
  "success": true,
  "message": "Kredi Getirildi",
  "data": {
    "id": 1,
    "creditAmount": 20000,
    "resultExplanation": "Kredi Onaylandı.",
    "creditResult": "CUSTOMER_DENIED",
    "status": "ACTIVE",
    "operationDate": "2022-01-28T21:54:55.716+00:00",
    "crdCreditId": 2,
    "csrCustomerId": 1
  }
}
```

## Error Responses

**Code** : `404`

**Sample Response Body** :

```json
{
  "errorDate": "2022-01-28T21:58:08.412+00:00",
  "message": "Kredi Bulunanamdı!",
  "detail": "uri=/api/v1/customer-credits/5"
}
```