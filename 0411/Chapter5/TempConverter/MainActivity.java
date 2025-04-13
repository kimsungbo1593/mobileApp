package com.example.tempconverter;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        text = (EditText) findViewById(R.id.Temp);

    }

    public void onClicked(View view) {
        if( view.getId() == R.id.button) {
                RadioButton temp_c = (RadioButton) findViewById(R.id.temp_c);
                RadioButton temp_f = (RadioButton) findViewById(R.id.temp_f);

                if (text.getText().length() == 0) {
                    Toast.makeText(this, "정확한 값을 입력하시오.", Toast.LENGTH_LONG).show();
                    return;
                }

                float inputValue = Float.parseFloat(text.getText().toString());
                if (temp_c.isChecked()) {
                    text.setText(String.valueOf(convertFahrenheitToCelsius(inputValue)));
                    temp_c.setChecked(false);
                    temp_f.setChecked(true);
                } else {
                    text.setText(String.valueOf(convertCelsiusToFahrenheit(inputValue)));
                    temp_f.setChecked(false);
                    temp_c.setChecked(true);
                }
        }

    }
    private float convertFahrenheitToCelsius(float fahrenheit) {
        return ((fahrenheit - 32) * 5 / 9.0f);
    }
    private float convertCelsiusToFahrenheit(float celsius) {
        return ((celsius * 9) / 5) + 32.0f;
    }
}