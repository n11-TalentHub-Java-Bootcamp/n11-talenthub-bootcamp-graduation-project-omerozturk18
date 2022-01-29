# Create Customer

**URL** : `/api/v1/customers`

**Method** : `POST`

**Request URL** : `/api/v1/customers`

## Request Body

```json
{
  "identityNumber": "string",
  "firstName": "string",
  "lastName": "string",
  "dateOfBirth": "2022-01-28T22:39:19842Z",
  "phoneNumber": "string",
  "salary": 0
}
```

## Success Responses

**Code** : `200 OK`

**Sample Response Body** :

```json
{
  "success": true,
  "message": "İşlem Başarılı",
  "data": {
    "id": 1,
    "identityNumber": "12345678912",
    "firstName": "ömer",
    "lastName": "öztürk",
    "dateOfBirth": "1997-01-28T21:07:31.520+00:00",
    "phoneNumber": "1234567891",
    "salary": 8000
  }
}
```

## Error Responses

>Mernis Check Customer

**Code** : `400`

**Sample Response Body** :

```json
{
  "errorDate": "2022-01-28T21:10:55.848+00:00",
  "message": "Müşteri Bilgileri Hatalı",
  "detail": "uri=/api/v1/customers"
}
```

## Error Responses - Not Valid

**Code** : `400`

**Sample Response Body** :

```json
{
  "errorDate": "2022-01-29T11:54:52.685+00:00",
  "message": "Kimlik No boş bırakılamaz, Kimlik No Rakam ve 11 Karakter Olmalıdır, Telefon Numarası Rakam ve 10 Karakter Olmalıdır",
  "detail": "uri=/api/v1/customers"
}
```