🧱 Northwind Spring Boot API (Java)

A minimal, didactic Spring Boot (2.4.5) REST API that models a classic Northwind product catalog. 
It demonstrates a clean layered structure (Controller → Service → Repository), Spring Data JPA, Swagger documentation, and a simple Result/DataResult response pattern.

🎯 Purpose

Teach how to structure a small backend with:
	•	Clear separation of concerns (controller, business/service, data access).
	•	Spring Data JPA repositories (CRUD without boilerplate).
	•	Consistent API responses via Result / DataResult<T> wrappers (success flag + message + optional data).
	•	Auto-generated API docs using Swagger (springfox 2.9.2).

🧩 Tech Stack
	•	Java 8+, Maven
	•	Spring Boot 2.4.5
	•	spring-boot-starter-web (REST)
	•	spring-boot-starter-data-jpa (JPA/Hibernate)
	•	MySQL connector (runtime)
	•	Springfox Swagger 2 (swagger2 + swagger-ui)

🗂️ Project Structure (in words)
	•	api/controllers/ProductsController → Exposes REST endpoints under /api/products
	•	business/abstracts/ProductService and business/concretes/ProductManager → Business layer
	•	dataAccess/abstracts/ProductDao → Extends JpaRepository<Product, Integer>
	•	entities/concretes/Product → JPA entity mapped to products table
	•	core/utilities/results/* → Result, DataResult<T>, SuccessResult, SuccessDataResult, ErrorResult, ErrorDataResult
	•	NorthwindApplication → @SpringBootApplication + @EnableSwagger2 + Docket bean for Swagger

🔌 REST Endpoints (current)
	•	GET /api/products/getall → returns DataResult<List<Product>> (success flag, message, data)
	•	POST /api/products/add → accepts a Product JSON and returns Result (success flag, message)

The service currently replies with Turkish messages such as “Data listelendi” and “Ürün eklendi”.

🧾 Entity (Product)

Product is a JPA entity mapped to products. Typical fields include:
	•	id (primary key, identity)
	•	productName (string)
	•	unitPrice (numeric)
	•	unitsInStock (numeric/short)
	•	quantityPerUnit (string)
