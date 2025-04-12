package com.example.lifecycle;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
    }

    public void onStart() {
        super.onStart();
        Log.i("LifeCycle", "onStart() 호출");
    }
    public void onResume() {
        super.onResume();
        Log.i("LifeCycle", "onResume() 호출");
    }
    public void onPause() {
        super.onPause();
        Log.i("LifeCycle", "onPause() 호출");
    }
    public void onStop() {
        super.onStop();
        Log.i("LifeCycle", "onStop() 호출");
    }
    public void onDestroy() {
        super.onDestroy();
        Log.i("LifeCycle", "onDestroy() 호출");
    }
}