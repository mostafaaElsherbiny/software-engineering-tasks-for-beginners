const Author = require('../models/authorModel');

exports.createAuthor = async (req, res, next) => {
  try {
    const { name, birthdate } = req.body;

    if (!name) {
      return res.status(400).send('Please provide author name');
    }

    const newAuthor = new Author({
      name,
      birthdate,
    });
    await newAuthor.save();

    return res.status(201).json({
      message: 'success',
      data: {
        newAuthor,
      },
    });
  } catch (err) {
    return res
      .status(400)
      .json({ message: 'error creating an author', error: err.message });
  }
};

exports.getAllAuthors = async (req, res, next) => {
  try {
    const authors = await Author.find();

    if (authors.length === 0) {
      return res.status(404).json({
        message: 'There are no authors',
      });
    }

    return res.status(200).json({
      message: 'success',

      data: {
        authors,
      },
    });
  } catch (err) {
    res.status(500).json({
      message: 'Error getting all authors',
    });
  }
};

exports.getAuthor = async (req, res, next) => {
  try {
    const author = await Author.findById(req.params.id);

    if (!author) {
      return res.status(404).json({
        message: `Author with ${req.params.id} is not found`,
      });
    }
    return res.status(200).json({
      message: `success`,
      data: {
        author,
      },
    });
  } catch (err) {
    return res.status(500).json({
      message: `Error getting the author`,
    });
  }
};

exports.updateAuthor = async (req, res, next) => {
  try {
    const { name, birthdate } = req.body;

    if (!name) {
      return res.status(400).json({ message: 'Missing the author name' });
    }

    const updatedAuthor = await Author.findByIdAndUpdate(
      req.params.id,
      req.body,
    );

    if (!updatedAuthor) {
      return res.status(404).json({
        message: 'Author with this id is not found',
      });
    }

    return res.status(200).json({
      message: `success`,
      data: {
        updatedAuthor,
      },
    });
  } catch (err) {
    return res.status(500).json({
      message: `Error updating the author info`,
    });
  }
};

exports.deleteAuthor = async (req, res, next) => {
  try {
    const author = await Author.findByIdAndDelete(req.params.id);

    if (!author) {
      return res.status(404).json({ message: 'author with that id not found' });
    }

    return res.status(200).json({
      message: 'success',
      data: null,
    });
  } catch (err) {
    res.status(500).json({ message: 'Error deleting the author' });
  }
};
