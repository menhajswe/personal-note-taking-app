# Personal Note-Taking App

### To the project:
- `git clone git@github.com:menhajswe/personal-note-taking-app.git`
- `cd personal-note-taking-app` 
- `grlade clean bootRun`

### CURL commands to test the API locally:


#### Create a User (POST /api/v1/user)
```
    curl -X POST http://localhost:8080/api/v1/user \
    -H "Content-Type: application/json" \
    -d '{
    "username": "john_doe",
    "password": "secret123",
    "role": "USER"
    }'
```

#### Get All Users (GET /api/v1/user/users)
    `curl -X GET http://localhost:8080/api/v1/user/users`

#### Create a Note for a User (POST /api/v1/note/user/{userId})
```
    curl -X POST http://localhost:8080/api/v1/note/user/1 \
    -H "Content-Type: application/json" \
    -d '{
    "title": "First Note",
    "content": "This is a note linked to the user"
    }'
```


## USER APIs
### Update User (PUT /api/v1/user/{id})
```
    curl -X PUT http://localhost:8080/api/v1/user/1 \
    -H "Content-Type: application/json" \
    -d '{
    "username": "john_updated",
    "password": "newpassword",
    "role": "ADMIN"
    }'
```

#### Response Example:
```
    {
    "id": 1,
    "username": "john_updated",
    "role": "ADMIN",
    "notes": []
    }
```
#### Delete User (DELETE /api/v1/user/{id})
    `curl -X DELETE http://localhost:8080/api/v1/user/1`

#### Response: HTTP 204 No Content (no body)

### NOTE APIs
#### Update Note (PUT /api/v1/note/{noteId})

```
    curl -X PUT http://localhost:8080/api/v1/note/1 \
    -H "Content-Type: application/json" \
    -d '{
    "title": "Updated Note Title",
    "content": "Updated content for this note"
    }'
```

#### Delete Note (DELETE /api/v1/note/{noteId})
    `curl -X DELETE http://localhost:8080/api/v1/note/1`


#### Response: HTTP 204 No Content (no body)

### Optional: Get Notes by User

    `curl -X GET http://localhost:8080/api/v1/note/user/1`


#### Response Example:
```    
    [
        {
            "id": 2,
            "title": "Second Note",
            "content": "Note linked to user 1"
        }
    ]

```