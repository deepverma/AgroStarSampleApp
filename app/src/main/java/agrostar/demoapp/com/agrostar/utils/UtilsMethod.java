package agrostar.demoapp.com.agrostar.utils;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

import agrostar.demoapp.com.agrostar.R;

/**
 * Created by Deep Verma on 21-05-2016.
 */

public class UtilsMethod {

    public static UtilsMethod utilsMethod;
    private static Context ctx;

    public static synchronized UtilsMethod getInstance(Context context) {
        if (utilsMethod == null) {
            utilsMethod = new UtilsMethod();
        }
        ctx = context;

        return utilsMethod;
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void setStatusBar(Activity activity) {
        if (Build.VERSION.SDK_INT > 20 && activity != null) {
            Window window = activity.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(ContextCompat.getColor(activity, R.color.colorPrimaryDark));

        }
    }

    public static void launchActivityWithDelay(final Context context, Class activityName, int flags, long delay, final Runnable after) {
        final Handler handler = new Handler();
        final Intent _activtyLaunchIntent = new Intent(context, activityName);
//        Setting flags to activity
        if (flags != -1) _activtyLaunchIntent.setFlags(flags);
//        runnable to launch Activity and call the after callback
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                context.startActivity(_activtyLaunchIntent);
                if (null != after) {
                    after.run();
                }
            }
        }, delay);
    }

    public int getRelativeLeft(View myView) {
        if (myView.getParent() == myView.getRootView())
            return myView.getLeft();
        else
            return myView.getLeft() + getRelativeLeft((View) myView.getParent());
    }

    public int getRelativeTop(View myView) {
        if (myView.getParent() == myView.getRootView())
            return myView.getTop();
        else
            return myView.getTop() + getRelativeTop((View) myView.getParent());
    }

    public void hideKeyboard(Activity activity) {
        // Check if no view has focus:
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
        } catch (Exception e) {
        }
    }

}
