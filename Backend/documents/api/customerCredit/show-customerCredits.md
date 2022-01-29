# Find Customer Credits

Returns a Customer Credit List.

**URL** : `/api/v1/customer-credits`

**Method** : `GET`

**Request URL** : `/api/v1/customer-credits`

## Success Responses

**Code** : `200 OK`

**Sample Response Body** :

```json
{
  "success": true,
  "message": "Krediler Listelendi",
  "data": [
    {
      "id": 1,
      "creditAmount": 20000,
      "resultExplanation": "Kredi Onaylandı.",
      "creditResult": "CUSTOMER_DENIED",
      "status": "ACTIVE",
      "operationDate": "2022-01-28T21:54:55.716+00:00",
      "crdCreditId": 2,
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
  "message": "Krediler Listelendi",
  "data": []
}
```