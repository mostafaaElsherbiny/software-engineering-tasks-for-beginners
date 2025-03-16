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

