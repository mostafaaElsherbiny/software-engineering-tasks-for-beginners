const express = require('express');
const bookController = require('./bookController');

const router = express.Router();

router
  .route('/')
  .get(bookController.getAllBooks)
  .post(bookController.createBook);

router
  .route('/:id')
  .get(bookController.getBook)
  .put(bookController.updateBook) // wanted to use patch
  .delete(bookController.deleteBook);

module.exports = router;
