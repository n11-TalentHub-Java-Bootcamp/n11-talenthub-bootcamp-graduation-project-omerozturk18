# Find Customer Credits By Customer Id

Returns a Customer Credit List  By Customer Id.

**URL** : `/api/v1/customer-credits/customer/{customerId}`

**Method** : `GET`

**Request URL** : `/api/v1/customer-credits/customer/1`

## Success Responses

**Code** : `200 OK`

**Sample Response Body** :

```json
{
  "success": true,
  "message": "Kullanıcının Kredileri Getirildi",
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
  "errorDate": "2022-01-28T22:17:26.265+00:00",
  "message": "Kullanıcıya Ait Kredi Bulunanamdı!",
  "detail": "uri=/api/v1/customer-credits/customer/2"
}
```