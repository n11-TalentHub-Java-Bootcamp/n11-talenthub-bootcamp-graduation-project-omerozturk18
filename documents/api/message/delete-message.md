# Delete Message

Returns a Result.

**URL** : `/api/v1/messages/{id}`

**Method** : `DELETE`

**Request URL** : `/api/v1/messages/1`

## Success Responses

**Code** : `200 OK`

**Sample Response Body** :

```json
{
  "success": true,
  "message": "Sms Silindi"
}
```

## Error Responses

**Code** : `404`

**Sample Response Body** :

```json
{
  "errorDate": "2022-01-28T23:11:19.204+00:00",
  "message": "Sms Bulunanamdı!",
  "detail": "uri=/api/v1/messages/2"
}
```