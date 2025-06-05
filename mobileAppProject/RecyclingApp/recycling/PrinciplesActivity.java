package com.example.recycling;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PrinciplesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.principles);

        ImageView back = findViewById(R.id.back);
        back.setOnClickListener(v -> {

            Intent intent = new Intent(PrinciplesActivity.this, MainMenuActivity.class);
            startActivity(intent);
            finish();
        });
    }
}