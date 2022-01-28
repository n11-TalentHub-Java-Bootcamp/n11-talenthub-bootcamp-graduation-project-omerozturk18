# Delete Customer

Returns a Result.

**URL** : `/api/v1/customers/{id}`

**Method** : `DELETE`

**Request URL** : `/api/v1/customers/1`

## Success Responses

> Customer Status `DELETED`
> Customer Update

**Code** : `200 OK`

**Sample Response Body** :

```json
{
  "success": true,
  "message": "Müşteri Silindi"
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