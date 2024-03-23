package com.xuanthongn.ui.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;


import com.xuanthongn.R;
import com.xuanthongn.base.BaseActivity;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bg_splashscreen);
        new Thread() {
            @Override
            public void run() {
                try {
                    sleep(1000); // Simulate splash screen for 2 seconds
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    Intent intent = new Intent(SplashActivity.this, MainActivity.class);  // Replace with your main activity
                    startActivity(intent);
                    finish();
                }
            }
        }.start();
    }

}