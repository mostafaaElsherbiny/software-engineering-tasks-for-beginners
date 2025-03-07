const express = require('express');
const authorController = require('../controllers/authorController');
const bookRouter = require('./bookRoutes');

const router = express.Router();

router.use((req, res, next) => {
  console.log(`incoming request made in: ${req.requestTime}`);
  next();
});

router.use('/:authorId/books', bookRouter);

/* REST */
router
  .route('/')
  .get(authorController.getAllAuthors)
  .post(authorController.createAuthor);

router
  .route('/:id')
  .get(authorController.getAuthor)
  .patch(authorController.updateAuthor) // wanted to use patch
  .delete(authorController.deleteAuthor);

module.exports = router;
