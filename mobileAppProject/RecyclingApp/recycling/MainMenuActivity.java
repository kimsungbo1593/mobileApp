package com.example.recycling;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainmenu);

        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);

        button1.setOnClickListener(v -> startActivity(new Intent(this, PrinciplesActivity.class)));
        button2.setOnClickListener(v -> startActivity(new Intent(this, SortingActivity.class)));
        button3.setOnClickListener(v -> startActivity(new Intent(this, InformationActivity.class)));
        button4.setOnClickListener(v -> startActivity(new Intent(this, MapActivity.class)));
    }
}