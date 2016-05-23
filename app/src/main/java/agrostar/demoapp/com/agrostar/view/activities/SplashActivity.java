package agrostar.demoapp.com.agrostar.view.activities;

import android.app.Activity;
import android.os.Bundle;

import agrostar.demoapp.com.agrostar.R;
import agrostar.demoapp.com.agrostar.utils.UtilsMethod;

/**
 * Created by Deep Verma on 21-05-2016.
 */
public class SplashActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        //UtilsMethod.getInstance(this).setStatusBar(this);
        UtilsMethod.getInstance(this).launchActivityWithDelay(this, DashBoardActivity.class, -1, 2000, new Runnable() {
            @Override
            public void run() {
                SplashActivity.this.finish();
            }
        });
    }
}
