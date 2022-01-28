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