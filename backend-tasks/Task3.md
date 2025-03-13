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