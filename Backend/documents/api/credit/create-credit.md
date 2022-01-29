# Create Credit

**URL** : `/api/v1/credits`

**Method** : `POST`

**Request URL** : `/api/v1/credits`
## Request Body

```json
{
  "name": "string",
  "shortName": "string",
  "explanation": "string"
}
```
## Success Responses

**Code** : `200 OK`

**Sample Response Body** :

```json
{
  "success": true,
  "message": "Kredi Eklendi",
  "data": {
    "id": 1,
    "name": "string",
    "shortName": "string",
    "explanation": "string"
  }
}
```
## Error Responses - Not Valid

**Code** : `400`

**Sample Response Body** :

```json
{
  "errorDate": "2022-01-29T11:55:20.232+00:00",
  "message": "Kredi İsmi Boş Olamaz",
  "detail": "uri=/api/v1/credits"
}
```