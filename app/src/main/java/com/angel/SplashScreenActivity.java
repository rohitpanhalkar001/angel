package com.angel;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.angel.Util.SharedPreferencesUtils;
import com.angel.activity.FreeSpiritActivity;
import com.angel.activity.HomeActivity;
import com.angel.activity.UserSelectionActivity;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                if(SharedPreferencesUtils.LoadFromWhichUser(SplashScreenActivity.this).equals("angel")) {
                    startActivity(new Intent(SplashScreenActivity.this, HomeActivity.class));
                    finish();
                }else if (SharedPreferencesUtils.LoadFromWhichUser(SplashScreenActivity.this).equals("freeSprit")){
                    startActivity(new Intent(SplashScreenActivity.this, FreeSpiritActivity.class));
                    finish();
                }else {
                    startActivity(new Intent(SplashScreenActivity.this, UserSelectionActivity.class));
                    finish();
                }
            }
        },2000);
    }
}
