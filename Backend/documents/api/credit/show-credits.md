# Find Credits

Returns a Credit List.

**URL** : `/api/v1/credits`

**Method** : `GET`

**Request URL** : `/api/v1/credits`

## Success Responses

**Code** : `200 OK`

**Sample Response Body** :

```json
{
  "success": true,
  "message": "Krediler Listelendi",
  "data": [
    {
      "id": 1,
      "name": "string",
      "shortName": "string",
      "explanation": "string"
    },
    {
      "id": 2,
      "name": "string",
      "shortName": "string",
      "explanation": "string"
    },
    {
      "id": 3,
      "name": "string",
      "shortName": "string",
      "explanation": "string"
    }
  ]
}
```

## Null Data

**Sample Response Body** :

```json
{
  "success": true,
  "message": "Krediler Listelendi",
  "data": []
}
```