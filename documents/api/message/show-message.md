# Find Message By Id

Returns a Message By Id.

**URL** : `/api/v1/messages/{id}`

**Method** : `GET`

**Request URL** : `/api/v1/messages/1`

## Success Responses

**Code** : `200 OK`

**Sample Response Body** :

```json
{
  "success": true,
  "message": "Sms Getirildi",
  "data": {
    "id": 1,
    "title": "Kredi Onayı",
    "contents": "N11 Bootcamp: Krediniz Onaylandı. Kredinizi Kabul Etmek İçin Linke Basınız: https://bit.ly/3u0rdIG",
    "csrCustomerId": 1
  }
}
```

## Error Responses

**Code** : `404`

**Sample Response Body** :

```json
{
  "errorDate": "2022-01-28T23:12:23.403+00:00",
  "message": "Sms Bulunanamdı!",
  "detail": "uri=/api/v1/messages/3"
}
```