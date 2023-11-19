
# TP Spring Boot 📘

Proyecto Spring Boot de ejemplo para el curso DESARROLLADOR JAVA INTERMEDIO en el marco de Argentina Programa 4.0

## Ejecutar de forma local 	📁

Clonar el projecto

```bash
  git clone https://github.com/ScenturionZ/TPSpringBoot
```

Instalar las dependencias del pom.xml

```maven
  mvn clean install
```

Ejecutar el servidor con maven

```bash
  mvn spring-boot:run
```


## API Reference 📮

#### Listar personas 📖

```http
  GET localhost:8080/personas
```

#### Crear una persona 💾

```http
  POST localhost:8080/personas
```
JSON a enviar
```json
{
    "nombre": "Persona 1",
    "email": "mail1@correo.com",
    "celular": "3459876543",
    "nacionalidadID" : 1,//ARGENTINA
    "mascotas": [1,3]//IDS DE MASCOTA GARFIELD Y TOM YA CREADOS EN LA BASE
}
```

#### Actualizar una persona 📝

```http
  PUT localhost:8080/personas/id
```

| Parameter | Type      | Description                    |
| :-------- | :-------  | :----------------------------- |
| `id`      | `Integer` | **Required**. ID de la persona |

#### Eliminar una persona ⛔

```http
  DELETE localhost:8080/personas/id
```

| Parameter | Type      | Description                    |
| :-------- | :-------  | :----------------------------- |
| `id`      | `Integer` | **Required**. ID de la persona |

## Paginas utilizadas 🔗

 - [Spring Initializr](https://start.spring.io/)
 - [Thymeleaf](https://www.thymeleaf.org/)

