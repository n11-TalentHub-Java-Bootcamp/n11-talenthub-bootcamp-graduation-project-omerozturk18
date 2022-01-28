# Create Customer Credit (Apply For Credit)

**URL** : `/api/v1/customer-credits`

**Method** : `POST`

**Request URL** : `/api/v1/customer-credits`

## Request Body

```json
{
  "crdCreditId": 0,
  "csrCustomerId": 0
}
```

## Success Responses

**Code** : `200 OK`

**Sample Response Body** :

> SYSTEM_APPROVED Credit
```json
{
  "success": true,
  "message": "Kredi İsteğiniz Alındı",
  "data": {
    "id": 1,
    "creditAmount": 20000,
    "resultExplanation": "Kredi Onaylandı.",
    "creditResult": "SYSTEM_APPROVED",
    "status": "ACTIVE",
    "operationDate": "2022-01-28T21:41:24.011+00:00",
    "crdCreditId": 2,
    "csrCustomerId": 1
  }
}
```

> SYSTEM_DENIED Credit
```json
{
  "success": true,
  "message": "Kredi İsteğiniz Alındı",
  "data": {
    "id": 2,
    "creditAmount": 0,
    "resultExplanation": "Kredi Reddedildi. Kredi Skoru Yetersiz",
    "creditResult": "SYSTEM_DENIED",
    "status": "ACTIVE",
    "operationDate": "2022-01-28T21:41:24.011+00:00",
    "crdCreditId": 2,
    "csrCustomerId": 1
  }
}
```

> THERE IS A CREDIT PENDING APPROVAL
```json
{
  "success": true,
  "message": "Zaten Onay Bekleyen Bir Krediniz Var",
  "data": {
    "id": 2,
    "creditAmount": 20000,
    "resultExplanation": "Kredi Onaylandı.",
    "creditResult": "SYSTEM_APPROVED",
    "status": "ACTIVE",
    "operationDate": "2022-01-28T21:41:24.011+00:00",
    "crdCreditId": 2,
    "csrCustomerId": 1
  }
}
```

## Error Responses


**Code** : `404 OK`

**Sample Response Body** :

> Not Found Customers
```json
{
  "errorDate": "2022-01-28T21:10:55.848+00:00",
  "message": "Müşteri Bulunanamdı!",
  "detail": "uri=/api/v1/customer-credits"
}
```

> Not Found Credit
```json
{
  "errorDate": "2022-01-28T21:35:49.611+00:00",
  "message": "Kredi Bulunanamdı!",
  "detail": "uri=/api/v1/customer-credits"
}
```