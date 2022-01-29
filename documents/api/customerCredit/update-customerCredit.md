# Update Customer Credit (Customer Credit Response)

**URL** : `/api/v1/customer-credits`

**Method** : `PUT`

**Request URL** : `/api/v1/customer-credits`

## Request Body

```json
{
  "id": 0,
  "creditResult": "SYSTEM_DENIED",
  "crdCreditId": 0,
  "csrCustomerId": 0
}
```

## Success Responses

**Code** : `200 OK`

**Sample Response Body** :

> CUSTOMER_APPROVED Credit
```json
{
  "success": true,
  "message": "Kredinizi Onayladınız, Krediniz Hesabınıza Yatırılacaktır.",
  "data": {
    "id": 1,
    "creditAmount": 20000,
    "resultExplanation": "Kredi Onaylandı.",
    "creditResult": "CUSTOMER_APPROVED",
    "status": "ACTIVE",
    "operationDate": "2022-01-28T21:52:18.234+00:00",
    "crdCreditId": 2,
    "csrCustomerId": 1
  }
}
```

> CUSTOMER_DENIED Credit
```json
{
  "success": false,
  "message": "Krediyi Reddettiniz, Krediden Yararlanamayacaksınız.",
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


**Code** : `400 `

**Sample Response Body** :

```json
{
  "success": false,
  "message": "Krediniz Onaylanmamıştır.",
  "data": null
}
```

>

```json
{
  "success": false,
  "message": "Bu Krediyi Zaten Cevapladınız.",
  "data": null
}
```
