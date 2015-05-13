var exec = cordova.require('cordova/exec');


window.requestActivityUpdate = function() {    
  cordova.exec(function(activityTyperesult) {alert(activityTyperesult);},
             function(error) {alert(error);},
             "ActivityDetectionPlugin",
             "requestActivityUpdate",
             []);
};
