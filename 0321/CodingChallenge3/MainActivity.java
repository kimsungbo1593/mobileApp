package com.example.codingch3;

import android.os.Bundle;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ImageView diceImage;
    private float currentRotation = 0f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        diceImage = findViewById(R.id.dice);
        Button rollButton = findViewById(R.id.ROLL);

        rollButton.setOnClickListener(view -> rotate());

    }

    private void rotate() {
        currentRotation += 45f;
        RotateAnimation rotate = new RotateAnimation(currentRotation - 45, currentRotation,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(500);
        rotate.setFillAfter(true);
        diceImage.startAnimation(rotate);
    }

}