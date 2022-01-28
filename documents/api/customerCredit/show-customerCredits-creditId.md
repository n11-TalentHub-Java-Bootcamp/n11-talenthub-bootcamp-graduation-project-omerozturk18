# Find Customer Credits By Credit Id

Returns a Customer Credit List  By Credit Id.

**URL** : `/api/v1/customer-credits/credit/{creditId}`

**Method** : `GET`

**Request URL** : `/api/v1/customer-credits/credit/2`

## Success Responses

**Code** : `200 OK`

**Sample Response Body** :

```json
{
  "success": true,
  "message": "Kredi Türüe Göre Kredileri Getirildi",
  "data": [
    {
      "id": 1,
      "creditAmount": 20000,
      "resultExplanation": "Kredi Onaylandı.",
      "creditResult": "SYSTEM_APPROVED",
      "status": "ACTIVE",
      "operationDate": "2022-01-28T21:54:55.716+00:00",
      "crdCreditId": 2,
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
  "errorDate": "2022-01-28T22:14:57.605+00:00",
  "message": "Kredi Bulunanamdı!",
  "detail": "uri=/api/v1/customer-credits/credit/3"
}
```