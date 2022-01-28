# Find Messages

Returns a Message List.

**URL** : `/api/v1/messages`

**Method** : `GET`

**Request URL** : `/api/v1/messages`

## Success Responses

**Code** : `200 OK`

**Sample Response Body** :

```json
{
  "success": true,
  "message": "Smsler Listelendi",
  "data": [
    {
      "id": 1,
      "title": "Kredi Onayı",
      "contents": "N11 Bootcamp: Krediniz Onaylandı. Kredinizi Kabul Etmek İçin Linke Basınız: https://bit.ly/3u0rdIG",
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
  "message": "Smsler Listelendi",
  "data": []
}
```