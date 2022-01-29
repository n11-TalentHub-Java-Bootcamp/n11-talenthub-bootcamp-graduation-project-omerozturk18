# Find Customer Credit Result 

Returns a Customer Credit Result.

**URL** : `/api/v1/customer-credits/credit-result/{identityNumber}/{dateOfBirth}`

**Method** : `GET`

**Request URL** : `/api/v1/customer-credits/credit-result/12345678912/1997-08-09`

## Success Responses

**Code** : `200 OK`

**Sample Response Body** :

```json
{
  "success": true,
  "message": "Kredi Sonuçlarınız Listeleniyor",
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
  "errorDate": "2022-01-28T22:29:15.523+00:00",
  "message": "Müşteri Bulunanamdı!",
  "detail": "uri=/api/v1/customer-credits/credit-result-approved/27268468181/1997-09-08"
}
```

**Code** : `400`

**Sample Response Body** :

```json
{
  "success": false,
  "message": "Veriler Hatalı, Lütfen Bilgilerinizi Kontrol Ediniz!",
  "data": null
}
```

```json
{
  "success": false,
  "message": "Kimlik Numarası ve Doğum Tarihi Boş Geçilemez!",
  "data": null
}
```
