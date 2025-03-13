const express = require('express');

const bookRouter = require('./bookRoutes');

const app = express();

/* 1) GLOBAL MIDDLEWARES */
// Body parser, reading data from body into req.body
app.use(express.json());

// TEST middleware
app.use((req, res, next) => {
  req.requestTime = new Date().toISOString();
  next();
});

/* 3) ROUTES */
app.use('/api/books', bookRouter);

app.all('*', (req, res, next) => {
  res.status(403).json({
    message: 'Do not continue',
  });
  process.exit(1);
});

module.exports = app;
