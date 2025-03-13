const express = require('express');
const bookController = require('../controllers/bookController');

const router = express.Router({ mergeParams: true });

// test-middleware
router.use((req, res, next) => {
  console.log(`Route Hit: ${req.method} ${req.originalUrl}`);
  next();
});

router
  .route('/')
  .get(bookController.getAllBooks)
  .post(bookController.createBook);

router
  .route('/:bookId')
  .get(bookController.getBook)
  .patch(bookController.updateBook) // wanted to use patch
  .delete(bookController.deleteBook);

module.exports = router;
