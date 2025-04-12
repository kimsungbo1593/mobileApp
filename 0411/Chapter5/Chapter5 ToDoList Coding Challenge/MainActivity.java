package com.example.chapter5todolistcodingchallenge;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.edit);
        linearLayout = findViewById(R.id.main);
    }

    public void onClick(View view) {
        String todoText = editText.getText().toString();

        if (!todoText.isEmpty()) {
            CheckBox newCheckBox = new CheckBox(this);
            newCheckBox.setText(todoText);
            linearLayout.addView(newCheckBox);
        }
    }
}