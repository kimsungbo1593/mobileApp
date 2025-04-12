package com.example.chapter6appcodingchallenge;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        Intent intent = null;
        int id = view.getId();
        if (id == R.id.introduction) {
            intent = new Intent(this, IntroductionActivity.class);
        }

        if (id == R.id.settings) {
            intent = new Intent(this, SettingsActivity.class);
        }

        if (id == R.id.start) {
            intent = new Intent(this, StartActivity.class);
        }

        if (intent != null) {
            startActivity(intent);
        }
    }
}