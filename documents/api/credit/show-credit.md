# Find Credit By Credit Id

Returns a Credit By Credit Id.

**URL** : `/api/v1/credits/{id}`

**Method** : `GET`

**Request URL** : `/api/v1/credits/1`

## Success Responses

**Code** : `200 OK`

**Sample Response Body** :

```json
{
  "success": true,
  "message": "Kredi Getirildi",
  "data": {
    "id": 1,
    "name": "ihtiyac",
    "shortName": "ihtiyac",
    "explanation": "string"
  }
}
```

## Error Responses

**Code** : `404 OK`

**Sample Response Body** :

```json
{
  "errorDate": "2022-01-28T20:42:55.700+00:00",
  "message": "Kredi Bulunanamdı!",
  "detail": "uri=/api/v1/credits/1"
}
```