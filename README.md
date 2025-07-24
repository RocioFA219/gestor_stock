
Este proyecto es una API REST desarrollada en **Spring Boot** que permite la gestión de productos dentro de un sistema de inventario. Proporciona operaciones CRUD completas, así como funcionalidades de búsqueda avanzada para facilitar el control de stock.

## 🚀 Características principales

- **CRUD de productos**: Alta, baja, modificación y consulta.
- **Búsqueda por nombre y stock**: Consulta dinámica de productos según nombre, cantidad en stock o ambos.
- **Estado del producto**: Control del campo `activo` para gestión lógica.
- **Timestamps**: Registro automático de fechas de creación y actualización.
- **Arquitectura limpia**:
  - DTOs para separación de responsabilidades.
  - MapStruct para mapeo entre entidades y DTOs.
  - Lombok para evitar código repetitivo (getters/setters, constructores, etc.).

## 🛠️ Tecnologías utilizadas

- Java 17
- Spring Boot 3.5.3
- Spring Data JPA
- MySQL
- MapStruct 1.5.5.Final
- Lombok 1.18.30
- Maven

## 🧪 Endpoints principales

| Método | Endpoint             | Descripción                                 |
|--------|----------------------|---------------------------------------------|
| GET    | `/products`          | Lista todos los productos                   |
| GET    | `/products/{id}`     | Obtiene un producto por ID                  |
| GET    | `/products/buscar`   | Busca por nombre, stock o ambos             |
| POST   | `/products`          | Crea un nuevo producto                      |
| PUT    | `/products/{id}`     | Actualiza un producto                       |
| DELETE | `/products/{id}`     | Elimina un producto por ID                  |

### 🔍 Ejemplo de consulta filtrada en Postman:

```http
GET /products/buscar?name=Monitor&stock=10
## Estructura del proyecto
src/
├── controller/
├── dto/
├── mapper/
├── model/
├── repository/
├── service/
└── application.properties
