# Backend Tasks

This repository contains a plan to complete 30 tasks. Each task is designed to help improve your skills in software development. Below is the list of tasks and detailed instructions for each.

## Task 1: REST API for CRUD Operations on a Book

### Objective
Create a REST API that allows users to perform CRUD (Create, Read, Update, Delete) operations on a book.

### Requirements
1. Use a web framework (e.g., Express for Node.js, Flask for Python).
2. Implement the following endpoints:
   - `POST /books`: Create a new book.
   - `GET /books`: Retrieve a list of all books.
   - `GET /books/:id`: Retrieve a specific book by ID.
   - `PUT /books/:id`: Update a specific book by ID.
   - `DELETE /books/:id`: Delete a specific book by ID.
3. Use a database to store book information (e.g., MongoDB, PostgreSQL).
4. Validate input data to ensure data integrity.
5. Handle errors gracefully and return appropriate HTTP status codes.

### Example
Here is an example of how the API endpoints should work:

- **Create a new book**
  ```
  POST /books
  {
    "title": "The Great Gatsby",
    "author": "F. Scott Fitzgerald",
    "publishedDate": "1925-04-10"
  }
  ```

- **Retrieve all books**
  ```
  GET /books
  ```

- **Retrieve a specific book by ID**
  ```
  GET /books/1
  ```

- **Update a specific book by ID**
  ```
  PUT /books/1
  {
    "title": "The Great Gatsby",
    "author": "F. Scott Fitzgerald",
    "publishedDate": "1925-04-10"
  }
  ```

- **Delete a specific book by ID**
  ```
  DELETE /books/1
  ```

## Task 2: REST API with Relations and Multiple CRUD Operations

### Objective
Create a REST API that manages authors and their books, demonstrating relations and multiple CRUD operations.

### Requirements
1. Use a web framework (e.g., Express for Node.js, Flask for Python).
2. Implement the following endpoints:
   - `POST /authors`: Create a new author.
   - `GET /authors`: Retrieve a list of all authors.
   - `GET /authors/:id`: Retrieve a specific author by ID.
   - `PUT /authors/:id`: Update a specific author by ID.
   - `DELETE /authors/:id`: Delete a specific author by ID.
   - `POST /authors/:authorId/books`: Create a new book for a specific author.
   - `GET /authors/:authorId/books`: Retrieve all books for a specific author.
   - `GET /authors/:authorId/books/:bookId`: Retrieve a specific book by ID for a specific author.
   - `PUT /authors/:authorId/books/:bookId`: Update a specific book by ID for a specific author.
   - `DELETE /authors/:authorId/books/:bookId`: Delete a specific book by ID for a specific author.
3. Use a database to store author and book information (e.g., MongoDB, PostgreSQL).
4. Validate input data to ensure data integrity.
5. Handle errors gracefully and return appropriate HTTP status codes.

### Example
Here is an example of how the API endpoints should work:

- **Create a new author**
  ```
  POST /authors
  {
    "name": "F. Scott Fitzgerald",
    "birthdate": "1896-09-24"
  }
  ```

- **Retrieve all authors**
  ```
  GET /authors
  ```

- **Retrieve a specific author by ID**
  ```
  GET /authors/1
  ```

- **Update a specific author by ID**
  ```
  PUT /authors/1
  {
    "name": "F. Scott Fitzgerald",
    "birthdate": "1896-09-24"
  }
  ```

- **Delete a specific author by ID**
  ```
  DELETE /authors/1
  ```

- **Create a new book for a specific author**
  ```
  POST /authors/1/books
  {
    "title": "The Great Gatsby",
    "publishedDate": "1925-04-10"
  }
  ```

- **Retrieve all books for a specific author**
  ```
  GET /authors/1/books
  ```

- **Retrieve a specific book by ID for a specific author**
  ```
  GET /authors/1/books/1
  ```

- **Update a specific book by ID for a specific author**
  ```
  PUT /authors/1/books/1
  {
    "title": "The Great Gatsby",
    "publishedDate": "1925-04-10"
  }
  ```

- **Delete a specific book by ID for a specific author**
  ```
  DELETE /authors/1/books/1
  ```

## Task 3: Books Management System

### Objective
Create a books management system with user registration, login, and CRUD operations for books only for authenticated users.

### Requirements
1. Implement user authentication and authorization:
   - `POST /register`: Register a new user.
   - `POST /login`: Login a user and return a token.
2. Implement the following book-related endpoints, accessible only to authenticated users:
   - `POST /books`: Create a new book.
   - `GET /books`: Retrieve a list of all books.
   - `GET /books/:id`: Retrieve a specific book by ID.
   - `PUT /books/:id`: Update a specific book by ID.
   - `DELETE /books/:id`: Delete a specific book by ID.
3. Use a database to store user and book information (e.g., MongoDB, PostgreSQL).
4. Validate input data to ensure data integrity.
5. Handle errors gracefully and return appropriate HTTP status codes.

### Example
Here is an example of how the API endpoints should work:

- **Register a new user**
  ```
  POST /register
  {
    "username": "user1",
    "password": "password123"
  }
  ```

- **Login a user**
  ```
  POST /login
  {
    "username": "user1",
    "password": "password123"
  }
  ```

- **Create a new book (authenticated)**
  ```
  POST /books
  {
    "title": "The Great Gatsby",
    "author": "F. Scott Fitzgerald",
    "publishedDate": "1925-04-10"
  }
  ```

- **Retrieve all books (authenticated)**
  ```
  GET /books
  ```

- **Retrieve a specific book by ID (authenticated)**
  ```
  GET /books/1
  ```

- **Update a specific book by ID (authenticated)**
  ```
  PUT /books/1
  {
    "title": "The Great Gatsby",
    "author": "F. Scott Fitzgerald",
    "publishedDate": "1925-04-10"
  }
  ```

- **Delete a specific book by ID (authenticated)**
  ```
  DELETE /books/1
  ```

## Task 4: Category, Product, and Order Management System

### Objective
Create a system to manage categories, products, and orders with order items.

### Requirements
1. Use a web framework (e.g., Express for Node.js, Flask for Python).
2. Implement the following endpoints for categories:
   - `POST /categories`: Create a new category.
   - `GET /categories`: Retrieve a list of all categories.
   - `GET /categories/:id`: Retrieve a specific category by ID.
   - `PUT /categories/:id`: Update a specific category by ID.
   - `DELETE /categories/:id`: Delete a specific category by ID.
3. Implement the following endpoints for products:
   - `POST /products`: Create a new product.
   - `GET /products`: Retrieve a list of all products.
   - `GET /products/:id`: Retrieve a specific product by ID.
   - `PUT /products/:id`: Update a specific product by ID.
   - `DELETE /products/:id`: Delete a specific product by ID.
4. Implement the following endpoints for orders:
   - `POST /orders`: Create a new order.
   - `GET /orders`: Retrieve a list of all orders.
   - `GET /orders/:id`: Retrieve a specific order by ID.
   - `PUT /orders/:id`: Update a specific order by ID.
   - `DELETE /orders/:id`: Delete a specific order by ID.
5. Use a database to store category, product, and order information (e.g., MongoDB, PostgreSQL).
6. Validate input data to ensure data integrity.
7. Handle errors gracefully and return appropriate HTTP status codes.

### Example
Here is an example of how the API endpoints should work:

- **Create a new category**
  ```
  POST /categories
  {
    "name": "Fiction",
    "parentCategoryId": null
  }
  ```

- **Retrieve all categories**
  ```
  GET /categories
  ```

- **Retrieve a specific category by ID**
  ```
  GET /categories/1
  ```

- **Update a specific category by ID**
  ```
  PUT /categories/1
  {
    "name": "Classic Fiction",
    "parentCategoryId": null
  }
  ```

- **Delete a specific category by ID**
  ```
  DELETE /categories/1
  ```

- **Create a new product**
  ```
  POST /products
  {
    "name": "The Great Gatsby",
    "price": 10.99,
    "categories": [1, 2]
  }
  ```

- **Retrieve all products**
  ```
  GET /products
  ```

- **Retrieve a specific product by ID**
  ```
  GET /products/1
  ```

- **Update a specific product by ID**
  ```
  PUT /products/1
  {
    "name": "The Great Gatsby",
    "price": 12.99,
    "categories": [1, 2]
  }
  ```

- **Delete a specific product by ID**
  ```
  DELETE /products/1
  ```

- **Create a new order**
  ```
  POST /orders
  {
    "userId": 1,
    "items": [
      {
        "productId": 1,
        "quantity": 2
      },
      {
        "productId": 2,
        "quantity": 1
      }
    ]
  }
  ```

- **Retrieve all orders**
  ```
  GET /orders
  ```

- **Retrieve a specific order by ID**
  ```
  GET /orders/1
  ```

- **Update a specific order by ID**
  ```
  PUT /orders/1
  {
    "userId": 1,
    "items": [
      {
        "productId": 1,
        "quantity": 3
      }
    ]
  }
  ```

- **Delete a specific order by ID**
  ```
  DELETE /orders/1
  ```

