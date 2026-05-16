# 📦 API Secundaria: Inventario de Artículos de Oficina

Esta es la API secundaria y simplificada del trabajo práctico, desarrollada como un proyecto independiente desde cero. Su objetivo es manejar el inventario interno de una empresa.

## ⚙️ Características
* **Arquitectura Ágil:** Implementación directa de un CRUD (Create, Read, Update, Delete) sin las complejidades de seguridad o testing de la API principal, respetando la consigna.
* **Modelado de Datos:** Entidades `Articulo` y `Categoria` relacionadas mediante `ManyToOne`.
* **Validaciones Básicas:** Uso de anotaciones de Jakarta Validation (`@NotBlank`, `@Min`, `@NotNull`) manejadas a través de DTOs simples.
* **Autonomía:** Configurada para correr en paralelo con otros servicios sin colisión de puertos.

## 🚀 Ejecución
1. Clonar el repositorio.
2. Ejecutar el script sql o crear una bd llamada `second_api`
3. La aplicación está configurada para ejecutarse en el puerto **`8081`** (asegurando que no haya conflictos si la API Principal está corriendo en el 8080).
4. Ejecutar el proyecto (la base de datos se levantará automáticamente).

> **Nota:** Para facilitar las pruebas y evitar errores de integridad referencial (Foreign Keys) al crear nuevos artículos, el componente `InventarioSeeder.java` inyectará 3 categorías base automáticamente al iniciar la aplicación por primera vez.

## 📡 Endpoints de Artículos
La ruta base es `http://localhost:8081/api/articulos`

* `GET /` - Lista todos los artículos del inventario.
* `POST /` - Crea un nuevo artículo. El JSON debe incluir un campo `"categoriaId"` válido (ej: `1`).
* `PUT /{id}` - Modifica un artículo existente.
* `DELETE /{id}` - Borra el artículo de la base de datos.
