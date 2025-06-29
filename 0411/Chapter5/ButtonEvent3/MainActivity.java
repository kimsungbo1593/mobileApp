package com.example.buttonevent3;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private ImageView clothingImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        clothingImageView = findViewById(R.id.clothingImageView);

        Button colorButton1 = findViewById(R.id.colorButton1);
        Button colorButton2 = findViewById(R.id.colorButton2);
        Button colorButton3 = findViewById(R.id.colorButton3);
        Button colorButton4 = findViewById(R.id.colorButton4);

        colorButton1.setOnClickListener(View -> changeClothingColor(Color.RED));
        colorButton2.setOnClickListener(View -> changeClothingColor(Color.BLUE));
        colorButton3.setOnClickListener(View -> changeClothingColor(Color.GREEN));
        colorButton4.setOnClickListener(View -> changeClothingColor(Color.YELLOW));
    }

    private void changeClothingColor(int color) {
        clothingImageView.setBackgroundColor(color);
    }
}