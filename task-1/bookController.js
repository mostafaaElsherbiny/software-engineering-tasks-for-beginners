const Book = require('./bookModel');

exports.createBook = async (req, res, next) => {
  try {
    const { title, author, publishedDate } = req.body;

    if (!author || !title) {
      return res.status(400).send('Missing title or author');
    }

    const newBook = new Book({
      title,
      author,
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
    const books = await Book.find();

    if (books.length === 0) {
      return res.status(404).json({
        message: 'There are no books in the store',
      });
    }

    return res.status(200).json({
      message: 'success',

      data: {
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
    const book = await Book.findById(req.params.id);

    if (!book) {
      return res.status(404).json({
        message: `Book with ${req.params.id} is not found`,
      });
    }
    return res.status(200).json({
      message: `success`,
      data: {
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
    const { title, author, publishedDate } = req.body;

    if (!author || !title) {
      return res.status(400).send('Missing title or author');
    }

    const updateBook = await Book.findByIdAndUpdate(req.params.id, req.body, {
      new: true,
    });

    if (!updateBook) {
      return res.status(404).json({
        message: `Book with ${req.params.id} is not found`,
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
    const book = await Book.findByIdAndDelete(req.params.id);
    if (!book) {
      return res.status(404).json({ message: 'Book with that id not found' });
    }
    res.status(200).json();
  } catch (err) {
    res.status(500).json({ message: 'Error deleting the book' });
  }
};
