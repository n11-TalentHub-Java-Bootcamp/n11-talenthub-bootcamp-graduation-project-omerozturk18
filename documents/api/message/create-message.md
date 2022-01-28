# Create Message

**URL** : `/api/v1/messages`

**Method** : `POST`

**Request URL** : `/api/v1/messages`

## Request Body

```json
{
  "title": "string",
  "contents": "string",
  "csrCustomerId": 0
}
```

## Success Responses

**Code** : `200 OK`

**Sample Response Body** :

```json
{
  "success": true,
  "message": "Sms Gönderildi",
  "data": {
    "id": 102,
    "title": "string",
    "contents": "string",
    "csrCustomerId": 52
  }
}
```

## Error Responses

**Code** : `404`

**Sample Response Body** :

```json
{
  "errorDate": "2022-01-28T23:25:14.470+00:00",
  "message": "Müşteri Bulunanamdı!",
  "detail": "uri=/api/v1/messages"
}
```
