# Delete Customer Credit

Returns a Result.

**URL** : `/api/v1/customer-credits/{id}`

**Method** : `DELETE`

**Request URL** : `/api/v1/customer-credits/1`

## Success Responses

> Customer Credit Status `DELETED`
> Customer Credit Update

**Code** : `200 OK`

**Sample Response Body** :

```json
{
  "success": true,
  "message": "Müşteri Kredisi Silindi"
}
```

## Error Responses

**Code** : `404 OK`

**Sample Response Body** :

```json
{
  "errorDate": "2022-01-28T20:42:55.700+00:00",
  "message": "Kredi Bulunanamdı!",
  "detail": "uri=/api/v1/customer-credits/1"
}
```