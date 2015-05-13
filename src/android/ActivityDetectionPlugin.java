package org.seeingidog.activitydetection;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.google.android.gms.location.ActivityRecognitionResult;
import com.google.android.gms.location.DetectedActivity;

public class ActivityDetectionPlugin extends CordovaPlugin {
  protected void pluginInitialize() {
  }
  
  public boolean execute(String action, JSONArray args, CallbackContext callbackContext)
    throws JSONException {
    if (action.equals("requestActivityUpdate")) {
      return true;
    }
    return false;
  }
    
  public class ActivityRecognitionIntentService extends IntentService { 
      @Override
      protected void onHandleIntent(Intent intent) {
            // If the intent contains an update
          if (ActivityRecognitionResult.hasResult(intent)) {
              // Get the update
              ActivityRecognitionResult result =
                ActivityRecognitionResult.extractResult(intent);
 
               DetectedActivity mostProbableActivity
                      = result.getMostProbableActivity();
 
               // Get the confidence % (probability)
              int confidence = mostProbableActivity.getConfidence();
  
              // Get the type
              int activityType = mostProbableActivity.getType();

              callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, activityType));              
            }
        }
    }
  }
  
}
