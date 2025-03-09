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


