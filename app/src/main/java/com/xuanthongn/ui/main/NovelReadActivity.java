package com.xuanthongn.ui.main;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.xuanthongn.R;

public class NovelReadActivity extends AppCompatActivity {
    LinearLayout btnBack;
    private Handler handler = new Handler();
    private Runnable hideControlsRunnable = new Runnable() {
        @Override
        public void run() {
            findViewById(R.id.top_control).setVisibility(View.GONE);
            findViewById(R.id.bottom_control).setVisibility(View.GONE);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novel_read);
        btnBack = findViewById(R.id.btn_readback);

        initGUI();


    }

    @SuppressLint("ClickableViewAccessibility")
    public void initGUI() {

        // Hide controls after 2 seconds
        handler.postDelayed(hideControlsRunnable, 2000);

        // Show controls when clicked anywhere on the screen
        ScrollView mainLayout = findViewById(R.id.novel_root_content); // Replace with your actual root layout ID
        mainLayout.setOnTouchListener(new View.OnTouchListener() {
            private float startY;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        startY = event.getY();
                        break;
                    case MotionEvent.ACTION_UP:
                        float endY = event.getY();
                        if (Math.abs(endY - startY) < 10) { // Adjust the sensitivity as needed
                            findViewById(R.id.top_control).setVisibility(View.VISIBLE);
                            findViewById(R.id.bottom_control).setVisibility(View.VISIBLE);
                            // You can optionally reset the hide timer here if needed
                            handler.removeCallbacks(hideControlsRunnable);
                            handler.postDelayed(hideControlsRunnable, 2000); //
                        }
                        break;
                }
                return false;
            }
        });


        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
