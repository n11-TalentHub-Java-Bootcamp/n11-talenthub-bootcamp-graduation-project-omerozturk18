# Find Message By Phone Number

Returns a Message By Phone Number.

**URL** : `/api/v1/messages/phone/{phoneNumber }`

**Method** : `GET`

**Request URL** : `/api/v1/messages/phone/1234567890`

## Success Responses

**Code** : `200 OK`

**Sample Response Body** :

```json
{
  "success": true,
  "message": "Telefon Numarasına Ait Smsler Listelendi",
  "data": [
    {
      "id": 52,
      "title": "string",
      "contents": "string",
      "csrCustomerId": 52
    },
    {
      "id": 52,
      "title": "Kredi Onayı",
      "contents": "N11 Bootcamp: Krediniz Onaylandı. Kredinizi Kabul Etmek İçin Linke Basınız: https://bit.ly/3u0rdIG",
      "csrCustomerId": 52
    }
  ]
}
```

## Error Responses

**Code** : `404`

**Sample Response Body** :


```json
{
  "errorDate": "2022-01-28T23:21:20.946+00:00",
  "message": "Bu Telefon Numarasına Ait Sms Bulunanamdı!",
  "detail": "uri=/api/v1/messages/phone/%7BphoneNuber%7D"
}
```




