// post.model.js

const mongoose = require('mongoose');
const Schema = mongoose.Schema;

// Define collection and schema for Post
let Post = new Schema({
    fName: {
        type: String
    },
    lName: {
        type: String
    },
    phone: {
        type: String
    },
    address:{
        type:String
    },
    email:{
        type:String
    }
}, 

{

    collection: 'posts'
});

module.exports = mongoose.model('Post', Post);