# Delete Guarantee

Returns a Result.

**URL** : `/api/v1/guarantees/{id}`

**Method** : `DELETE`

**Request URL** : `/api/v1/guarantees/1`

## Success Responses

**Code** : `200 OK`

**Sample Response Body** :

```json
{
  "success": true,
  "message": "Teminat Silindi"
}
```

## Error Responses

**Code** : `404 OK`

**Sample Response Body** :

```json
{
  "errorDate": "2022-01-28T23:02:52.353+00:00",
  "message": "Teminat Bulunanamdı!",
  "detail": "uri=/api/v1/guarantees/4"
}
```