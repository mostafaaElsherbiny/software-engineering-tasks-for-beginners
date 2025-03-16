const mongoose = require('mongoose');
const dotenv = require('dotenv');

dotenv.config({ path: './config.env' });

const app = require('./app');

const DB = process.env.DB.replace(
  '<db_password>',
  process.env.DB_PASSWORD.trim(),
);

mongoose.connect(DB).then(() => console.log('DB connection successful!'));

const port = process.env.PORT || 8080;

// app-server
const server = app.listen(port, () => {
  console.log(`App running on port ${port}...`);
});

process.on('unhandledRejection', (err) => {
  console.log(err);

  server.close(() => {
    console.log('closing because Unhandled Rejection💢❌');
    process.exit(1);
  });
});
