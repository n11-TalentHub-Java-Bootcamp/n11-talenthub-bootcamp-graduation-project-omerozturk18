# Update Customer

**URL** : `/api/v1/customers`

**Method** : `PUT`

**Request URL** : `/api/v1/customers`

## Request Body

```json
{
  "id": 0,
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

**Code** : `404`

**Sample Response Body** :

```json
{
  "errorDate": "2022-01-28T21:10:55.848+00:00",
  "message": "Müşteri Bulunamadı",
  "detail": "uri=/api/v1/customers"
}
```

## Error Responses - Not Valid

**Code** : `400`

**Sample Response Body** :

```json
{
  "errorDate": "2022-01-29T11:54:10.558+00:00",
  "message": "Telefon Numarası Rakam ve 10 Karakter Olmalıdır, Telefon Numarası Boş Bırakılamaz",
  "detail": "uri=/api/v1/customers"
}
```