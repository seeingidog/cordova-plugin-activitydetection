var exec = require('cordova/exec');

exports.requestActivityUpdates = function(arg0, success, error) {
    exec(success, error, "cordova-plugin-activitydetection", "requestActivityUpdates");
};
