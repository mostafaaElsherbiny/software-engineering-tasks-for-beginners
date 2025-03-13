const express = require('express');

const authorRouter = require('./routes/authorRoutes');

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
app.use('/api/authors', authorRouter);

app.all('*', (req, res, next) => {
  res.status(403).json({
    message: 'No Other Routes, Go Back to The Shadow You came from',
  });
});

module.exports = app;
