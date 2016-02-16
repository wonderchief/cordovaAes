cordova.define("cordova/plugins/cordovaAes", 
  function(require, exports, module) {
    var exec = require("cordova/exec");
    var cordovaAes = function() {};
	cordovaAes.prototype.encrypto = function(key,text,successCallback, errorCallback) {
        exec(successCallback, errorCallback, 'legleaes', 'encrypto', [key, text]);
    };
    cordovaAes.prototype.decrypto = function(key,text,successCallback, errorCallback) {
        exec(successCallback, errorCallback, 'legleaes', 'decrypto', [key, text]);
    };
    var cordovaAes = new cordovaAes();
    module.exports = cordovaAes;

});

  
if(!window.plugins) {
    window.plugins = {};
}
if (!window.plugins.legleAES) {
    window.plugins.legleAES = cordova.require("cordova/plugins/cordovaAes");
}

