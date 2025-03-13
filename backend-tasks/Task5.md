## Task 5: Authorization Challenge

### Objective
Create a system that demonstrates different levels of authorization for users, including roles and permissions.

### Requirements
1. Use a web framework (e.g., Express for Node.js, Flask for Python).
2. Implement user roles and permissions:
   - Roles: Admin, Editor, Viewer.
   - Permissions: Create, Read, Update, Delete.
3. Implement the following endpoints with role-based access control:
   - `POST /books`: Create a new book (Admin, Editor).
   - `GET /books`: Retrieve a list of all books (Admin, Editor, Viewer).
   - `GET /books/:id`: Retrieve a specific book by ID (Admin, Editor, Viewer).
   - `PUT /books/:id`: Update a specific book by ID (Admin, Editor).
   - `DELETE /books/:id`: Delete a specific book by ID (Admin).
4. Use a database to store user, role, and book information (e.g., MongoDB, PostgreSQL).
5. Validate input data to ensure data integrity.
6. Handle errors gracefully and return appropriate HTTP status codes.

### Example
Here is an example of how the API endpoints should work:

- **Create a new book (Admin, Editor)**
  ```
  POST /books
  {
    "title": "The Great Gatsby",
    "author": "F. Scott Fitzgerald",
    "publishedDate": "1925-04-10"
  }
  ```

- **Retrieve all books (Admin, Editor, Viewer)**
  ```
  GET /books
  ```

- **Retrieve a specific book by ID (Admin, Editor, Viewer)**
  ```
  GET /books/1
  ```

- **Update a specific book by ID (Admin, Editor)**
  ```
  PUT /books/1
  {
    "title": "The Great Gatsby",
    "author": "F. Scott Fitzgerald",
    "publishedDate": "1925-04-10"
  }
  ```

- **Delete a specific book by ID (Admin)**
  ```
  DELETE /books/1
  ```

### Authorization Logic
- **Admin**: Can create, read, update, and delete any book.
- **Editor**: Can create, read, and update any book.
- **Viewer**: Can only read books.

### Test Cases

#### Test Case 1: Admin Role
- **Create a new book**
  ```
  POST /books
  {
    "title": "1984",
    "author": "George Orwell",
    "publishedDate": "1949-06-08"
  }
  ```
  - Expected: 201 Created

- **Retrieve all books**
  ```
  GET /books
  ```
  - Expected: 200 OK

- **Update a book**
  ```
  PUT /books/1
  {
    "title": "1984",
    "author": "George Orwell",
    "publishedDate": "1949-06-08"
  }
  ```
  - Expected: 200 OK

- **Delete a book**
  ```
  DELETE /books/1
  ```
  - Expected: 204 No Content

#### Test Case 2: Editor Role
- **Create a new book**
  ```
  POST /books
  {
    "title": "To Kill a Mockingbird",
    "author": "Harper Lee",
    "publishedDate": "1960-07-11"
  }
  ```
  - Expected: 201 Created

- **Retrieve all books**
  ```
  GET /books
  ```
  - Expected: 200 OK

- **Update a book**
  ```
  PUT /books/1
  {
    "title": "To Kill a Mockingbird",
    "author": "Harper Lee",
    "publishedDate": "1960-07-11"
  }
  ```
  - Expected: 200 OK

- **Delete a book**
  ```
  DELETE /books/1
  ```
  - Expected: 403 Forbidden

#### Test Case 3: Viewer Role
- **Create a new book**
  ```
  POST /books
  {
    "title": "Brave New World",
    "author": "Aldous Huxley",
    "publishedDate": "1932-08-01"
  }
  ```
  - Expected: 403 Forbidden

- **Retrieve all books**
  ```
  GET /books
  ```
  - Expected: 200 OK

- **Update a book**
  ```
  PUT /books/1
  {
    "title": "Brave New World",
    "author": "Aldous Huxley",
    "publishedDate": "1932-08-01"
  }
  ```
  - Expected: 403 Forbidden

- **Delete a book**
  ```
  DELETE /books/1
  ```
  - Expected: 403 Forbidden
