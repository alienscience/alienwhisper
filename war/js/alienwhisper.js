
// Alienwhisper namespace
var alienwhisper = {};

// Class that handles encryption and decryption
// constructor
alienwhisper.crypt = function () {}

// rest of class
alienwhisper.crypt.prototype = {

    // Encrypt the given data using the given key
    encrypt:function(key, data) {
        var params = {mode: "ocb2"};
        var returned_params = {};
        var encrypted = sjcl.encrypt(key, data, params, returned_params);
        return encrypted;
    },

    // Decrypt the given data using the given key
    decrypt:function(key, data) {
        var plaintxt = sjcl.decrypt(key, data);
        return plaintxt;   // stub
    }
};
