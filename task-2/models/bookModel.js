const mongoose = require('mongoose');

const bookSchema = new mongoose.Schema(
  {
    title: {
      type: String,
      required: true,
    },
    // searched high and low and tried query-middlewares try yyyy-mm-dd format but all failed (found a soultion)
    publishedDate: {
      type: Date,
      default: null,
    },
    // parent-referencing
    author: {
      type: mongoose.Schema.ObjectId,
      ref: 'Author',
      required: [true, 'a book is gotta have an author'],
    },
  },
  {
    toJSON: {
      virtuals: true,
      transform: (_, ret) => {
        ret.id = ret._id;
        ret.publishedDate = ret.publishedDate
          ? ret.publishedDate.toISOString().split('T')[0]
          : null;
        delete ret._id;
        return ret;
      },
    },
    toObject: { virtuals: true },
  },
);

const Book = mongoose.model('Book', bookSchema);
module.exports = Book;
