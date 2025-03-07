const mongoose = require('mongoose');

const authorSchema = new mongoose.Schema(
  {
    name: {
      type: String,
      required: true,
    },
    birthdate: {
      type: Date,
      default: null,
    },
  },
  {
    toJSON: {
      virtuals: true,
      transform: (_, ret) => {
        ret.id = ret._id;
        if (ret.birthdate) {
          ret.birthdate = ret.birthdate.toISOString().split('T')[0];
        }
        delete ret._id;
        return ret;
      },
    },
    toObject: { virtuals: true },
  },
);

// virtual to populate books in controller
authorSchema.virtual('books', {
  ref: 'Book',
  localField: '_id',
  foreignField: 'author',
});

/* 
  found soultion for formating date 
  references: (https://mongoosejs.com/docs/api/schematypeoptions.html#SchemaTypeOptions.prototype.transform)
              (https://alexanderzeitler.com/articles/mongoose-tojson-toobject-transform-with-subdocuments/)
              (https://mongoosejs.com/docs/guide.html#toJSON)
  transform => called when calling toJSON() or toObject()
  (_) => mongoose document 
  ret => JSON that will be returned from mongoose
*/

const Author = mongoose.model('Author', authorSchema);
module.exports = Author;
