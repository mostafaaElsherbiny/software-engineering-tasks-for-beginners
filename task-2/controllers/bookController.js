const Book = require('../models/bookModel');
const Author = require('../models/authorModel');

exports.createBook = async (req, res, next) => {
  try {
    const { title, publishedDate } = req.body;

    if (!title) {
      return res.status(400).send('Missing title, please provide title');
    }

    const newBook = new Book({
      author: req.params.authorId,
      title,
      publishedDate,
    });

    await newBook.save();

    return res.status(201).json({
      message: 'success',
      data: {
        newBook,
      },
    });
  } catch (err) {
    return res
      .status(400)
      .json({ message: 'error creating a book', error: err.message });
  }
};

exports.getAllBooks = async (req, res, next) => {
  try {
    const author = await Author.findById(req.params.authorId).select(
      'name birthdate',
    );

    if (!author) {
      return res.status(404).json({
        message: 'Author with this ID is not found',
      });
    }

    const books = await Book.find({ author }).select('title publishedDate');

    if (books.length === 0) {
      return res.status(404).json({
        message: 'Books for this author are not found',
      });
    }

    return res.status(200).json({
      message: 'success',

      data: {
        author,
        books,
      },
    });
  } catch (err) {
    res.status(500).json({
      message: 'Error getting all books',
    });
  }
};

exports.getBook = async (req, res, next) => {
  try {
    const author = await Author.findById(req.params.authorId).select(
      'name birthdate',
    );

    if (!author) {
      return res.status(404).json({
        message: 'Author with this ID is not found',
      });
    }

    const book = await Book.findById(req.params.bookId).select(
      'title publishedDate',
    );

    if (!book) {
      return res.status(404).json({
        message: 'This book for this author is not found',
      });
    }

    return res.status(200).json({
      message: `success`,
      data: {
        author,
        book,
      },
    });
  } catch (err) {
    return res.status(500).json({
      message: `Error getting the book`,
    });
  }
};

exports.updateBook = async (req, res, next) => {
  try {
    console.log(req.params);

    const { title } = req.body;

    if (!title) {
      return res.status(400).json({ message: 'Missing title' });
    }

    const updateBook = await Book.findByIdAndUpdate(
      req.params.bookId,
      req.body,
      { new: true },
    );

    if (!updateBook) {
      return res.status(404).json({
        message: `Book with ${req.params.bookId} is not found`,
      });
    }

    return res.status(200).json({
      message: `success`,
      data: {
        updateBook,
      },
    });
  } catch (err) {
    return res.status(500).json({
      message: `Error getting the book`,
      error: err.message,
    });
  }
};

exports.deleteBook = async (req, res, next) => {
  try {
    const book = await Book.findByIdAndDelete(req.params.bookId);
    if (!book) {
      return res.status(404).json({ message: 'Book with that id not found' });
    }
    res.status(200).json();
  } catch (err) {
    res.status(500).json({ message: 'Error deleting the book' });
  }
};
