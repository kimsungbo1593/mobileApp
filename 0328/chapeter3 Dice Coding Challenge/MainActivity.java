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
    private Button Button;
    private int[] diceImages = {
            R.drawable.dice1, R.drawable.dice2, R.drawable.dice3,
            R.drawable.dice4, R.drawable.dice5, R.drawable.dice6
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        diceImage = findViewById(R.id.dice);
        Button = findViewById(R.id.ROLL);

        Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RandomDice();
            }
        });
    }
    private void RandomDice() {
        Random random = new Random();
        int randomIndex = random.nextInt(6);

        diceImage.setImageResource(diceImages[randomIndex]);
    }
}


