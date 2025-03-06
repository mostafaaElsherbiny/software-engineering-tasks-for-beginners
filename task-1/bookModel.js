const mongoose = require('mongoose');

const bookSchema = new mongoose.Schema(
  {
    title: {
      type: String,
      required: true,
    },
    author: {
      type: String,
      required: true,
    },
    // searched high and low and tried query-middlewares try yyyy-mm-dd format but all failed
    publishedDate: {
      type: Date,
      default: null,
    },
  },
  // thought i might need them
  {
    toJSON: { virtuals: true },
    toObject: { virtuals: true },
  },
);

const Book = mongoose.model('Book', bookSchema);
module.exports = Book;
