# Vivo


<br>
<br>


# Informações


* A porta do servidor é :8080

* A Database utilizada tem o nome user_table

## Pessoa

* O modelo pessoa possui essas rotas:

- **GET** http://localhost:8080/users/id/{id} -> Retorna o user pelo Id // {id} -> inserir o id do user desejado
- **GET** http://localhost:8080/users/document/{user_document} -> Retorna o user pelo documento // {user_document} -> inserir o documento do user desejado
- **POST** http://localhost:8080/users -> Atualiza um user ao banco, é necessário passar o Body seguindo padrão:
```json
{
    "name": "User Name",
    "email": "User Email",
    "document": "User Document"
}

```

- **PUT** http://localhost:8080/users -> Atualiza um user ao banco, é necessário passar o Body seguindo padrão:
```json
{
    "id": 1,
    "name": "User Name",
    "email": "User Email",
    "document": "User Document"
}
```
