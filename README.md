# 🎬 Movie API – Spring Boot + WebFlux + TMDB

¡Bienvenido a **Movie API**!  
Esta es una **API de películas** desarrollada en **Java + Spring Boot + WebFlux**, que consume datos en tiempo real desde la [API de TheMovieDB (TMDB)](https://www.themoviedb.org/).  
El proyecto incluye una arquitectura reactiva, CI/CD con **GitHub Actions**, y despliegue con **Docker en Render**.

---

## 🚀 Características principales

- **Listar películas populares** con paginación dinámica.
- **Buscar películas** por nombre.
- **Obtener detalles de una película** por ID.
- API **100% reactiva** gracias a `Mono` y `Flux`.
- **Dockerizado** para despliegues ágiles en Render u otras plataformas.
- **Pipeline CI/CD** automatizado con **GitHub Actions**.

---

## 📦 Tecnologías utilizadas

- **Java 21**
- **Spring Boot 3.5**
- **Spring WebFlux** (programación reactiva)
- **Lombok** (para reducir boilerplate)
- **Maven** (gestión de dependencias)
- **Docker** (para empaquetar y desplegar)
- **GitHub Actions** (CI/CD)
- **Render** (hosting en la nube)

---

## 🛠️ Endpoints disponibles

### **Películas populares (limitadas)**
```http
GET /peliculas/limited?pages={n}
```
Ejemplo:
```
http://localhost:8080/peliculas/limited?pages=3
```
Obtiene las películas populares de las primeras `n` páginas de TMDB.

---

### **Buscar películas**
```http
GET /peliculas/search?query={nombre}
```
Ejemplo:
```
http://localhost:8080/peliculas/search?query=batman
```
Busca películas que contengan el texto `batman`.

---

### **Obtener película por ID**
```http
GET /peliculas/{id}
```
Ejemplo:
```
http://localhost:8080/peliculas/550
```
Obtiene los detalles de la película con el ID `550` (Fight Club).

---

## ⚙️ Instalación y ejecución local

### **1. Clonar el repositorio**
```bash
git clone https://github.com/tuusuario/movie-api.git
cd movie-api/demo
```

### **2. Configurar API Key de TMDB**
La API necesita una **API Key de TheMovieDB**.  
Cámbiala en `PeliculaService.java`:
```java
private static final String API_KEY = "TU_API_KEY";
```

### **3. Ejecutar el proyecto**
Con Maven:
```bash
mvn spring-boot:run
```

O generar el `.jar`:
```bash
mvn clean package
java -jar target/demo-0.0.1-SNAPSHOT.jar
```

---

## 🐳 Ejecutar con Docker

### **1. Construir la imagen**
```bash
docker build -t movie-api .
```

### **2. Levantar el contenedor**
```bash
docker run -p 8080:8080 movie-api
```

---

## 🧪 Pruebas (CI)

El proyecto usa **JUnit 5** para tests unitarios.  
Ejecuta:
```bash
mvn test
```

El pipeline de GitHub Actions se ejecuta automáticamente en cada **push** o **pull request**, corriendo tests y validando el build.

---

## 🔄 CI/CD con GitHub Actions + Render

- **CI:**  
  - El archivo `.github/workflows/ci.yml` compila, testea y valida el proyecto.
- **CD:**  
  - Render detecta el `Dockerfile` y publica la última versión automáticamente.

---

## 📂 Estructura del proyecto

```
demo/
 ├── src/main/java/com/example/demo
 │   ├── controller/       # Controladores REST
 │   ├── service/          # Lógica de negocio
 │   ├── DTO/              # Data Transfer Objects
 ├── src/test/java/        # Tests unitarios
 ├── pom.xml               # Dependencias Maven
 └── Dockerfile            # Imagen Docker
```

---

## 🤓 ¿Por qué WebFlux?

- **Programación reactiva** con `Mono` y `Flux`.
- **Alto rendimiento** en llamadas concurrentes.
- **Escalabilidad** en aplicaciones orientadas a microservicios.

---

## ✨ Próximas mejoras

- Autenticación con API Key vía `application.yml`.
- Cache de resultados (para reducir llamadas a TMDB).
- Integración con base de datos para películas favoritas.

---

## 👨‍💻 Autor

**Sebastián Amaya**  
💼 [LinkedIn](https://www.linkedin.com/) | 📧 samaya@example.com

---

## 📝 Licencia

Este proyecto está bajo la licencia **MIT**.
