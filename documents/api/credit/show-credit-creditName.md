# Find Credit By Credit Name

Returns a Credit By Credit Name.

**URL** : `/api/v1/credits/name/{creditName}`

**Method** : `GET`

**Request URL** : `/api/v1/credits/name/ihtiyac`

## Success Responses

**Code** : `200 OK`

**Sample Response Body** :

```json
{
  "success": true,
  "message": "Kredi Getirildi",
  "data": {
    "id": 2,
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