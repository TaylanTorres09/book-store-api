# Book Store Api

## Descrição do Projeto

Projeto consiste na criação de uma api para uma biblioteca, onde os livros serão cadastrados, atualizados e deletados.

Cada livro terá uma categoria associada, onde para cadastrar um livro deverá preexistir uma categoria para o mesmo.

## End-Points do Projeto

### Para Livros
- [GET] consultar todos os livros: {url}/book/books

- [GET] consultar 1 livro especifico, passar id por parametro na requisição: {url}/book/{id}

- [GET] consultar livros por categoria, passar id de categoria query ex: {url}/book?category=1

- [POST] criar Livro, passar id de categoria no corpo da requisição: {url}/book/create
``` Json Body
{
    "title": "type string",
    "author": "type string",
    "text": "type string",
    "categoryId": "type long",
}
```

- [PutORPatch] atualizar Livro, passar id do livro por parametro da requisição: {url}/book/update/{id}
``` Json Body
{
    "title": "type string",
    "author": "type string",
    "text": "type string",
}
```

- [DELETE] deletar Livro, passar id do livro por parametro da requisição: {url}/book/delete/{id}

### Para Categoria

- [GET] consultar todas as categorias: {url}/category/categories

- [GET] consultar 1 categoria especifica, passar id por parametro na requisição: {url}/category/{id}

- [GET] consultar categoria, sem retornar lista de livros: {url}/category

- [POST] criar Categoria: {url}/category/create
``` Json Body
{
    "name": "type string",
    "description": "type string",
}
```

- [Put] atualizar Categoria, passar id da Categoria parametro da requisição: {url}/category/update/{id}
``` Json Body
{
    "name": "type string",
    "description": "type string",
}
```

- [DELETE] deletar Categoria, passar id da categoria parametro da requisição: {url}/category/delete/{id}

## Descrição da Api
### Executar Api localmente:

## Próximos Passos

## Autor
<a href="https://www.linkedin.com/in/taylan-torres" target="_blank"><img src="https://img.shields.io/badge/-LinkedIn-%230077B5?style=for-the-badge&logo=linkedin&logoColor=white" target="_blank"></a> 