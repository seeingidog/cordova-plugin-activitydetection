var exec = require('cordova/exec');

function requestActivityUpdates() {
    exec(null, null, "ActivityDetectionPlugin", "requestActivityUpdate", []);
}
