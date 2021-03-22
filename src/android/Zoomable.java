package de.mopsdom.zoomable;

import android.os.Handler;
import android.os.Looper;
import android.webkit.WebView;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;


public class Zoomable extends CordovaPlugin {

    private final String pluginName = "cordova-plugin-zoomable";

    @Override
    public boolean execute(final String action, final JSONArray data, final CallbackContext callbackContext) {

        if (action.equals("enable")||action.equals("disable")||action.equals("enablecontrols")||action.equals("disablecontrols")) {
            final WebView webView = (WebView) this.webView.getEngine().getView();
            try
            {
                Handler mainHandler = new Handler(cordova.getActivity().getMainLooper());
                final Looper myLooper = Looper.myLooper();
                mainHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (action.equals("enable")) {
                            webView.getSettings().setSupportZoom(true);
                            webView.getSettings().setBuiltInZoomControls(true);
                        } else if (action.equals("disable")) {
                            webView.getSettings().setSupportZoom(false);
                            webView.getSettings().setBuiltInZoomControls(false);
                        }
                        else if (action.equals("enablecontrols")) {
                            webView.getSettings().setDisplayZoomControls(true);
                        }
                        else if (action.equals("disablecontrols")) {
                            webView.getSettings().setDisplayZoomControls(false);
                        }

                        new Handler(myLooper).post(new Runnable() {
                            @Override
                            public void run() {
                                callbackContext.success();
                            }
                        });
                    }
                });

            } catch (Throwable e) {
                callbackContext.error(e.getMessage());
            }
            return true;
        }
        else
        {
            return false;
        }
    }
}
