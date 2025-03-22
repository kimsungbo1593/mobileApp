package com.example.numberguess;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView textview;
    EditText eText;
    private int targetNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        eText = (EditText) findViewById(R.id.edittext);
        textview = (TextView) findViewById(R.id.textview);

        Random random = new Random();
        targetNumber = random.nextInt(101);
    }

    public void onClick(View v) {
        String Input = eText.getText().toString();

        int userGuess = Integer.parseInt(Input);

        if (userGuess < targetNumber) {
            textview.setText("Low!!!");
        } else if (userGuess > targetNumber) {
            textview.setText("High!!!");
        } else {
            textview.setText("축하합니다! 정답은 " + targetNumber + "였어요");
        }
    }

}