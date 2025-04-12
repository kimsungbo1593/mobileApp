package com.example.chapter5researchcodingchallenge;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    ImageView imageview;
    private RadioButton radio1, radio2, radio3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageview = findViewById(R.id.imageview);
        radio1 = findViewById(R.id.radio_1);
        radio2 = findViewById(R.id.radio_2);
        radio3 = findViewById(R.id.radio_3);
    }

    public void onClick2(View view) {
        if(radio1.isChecked()) {
            imageview.setImageResource(R.drawable.image0);
        } else if (radio2.isChecked()) {
            imageview.setImageResource(R.drawable.image1);
        } else if (radio3.isChecked()) {
            imageview.setImageResource(R.drawable.image2);
        }
    }
}