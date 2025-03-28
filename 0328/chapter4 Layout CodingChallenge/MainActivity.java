package com.example.chapter4layoutcodingchallenge;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button btnLetsGo;
    private ConstraintLayout mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnLetsGo = findViewById(R.id.button); // 버튼 ID 수정 (ID가 'button'일 경우)
        mainLayout = findViewById(R.id.main);

        btnLetsGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 배경색을 랜덤으로 변경
                RandomColor();
            }
        });
    }
    private void RandomColor() {
        Random random = new Random();
        // RGB 값 생성 (0~255)
        int red = random.nextInt(256);
        int green = random.nextInt(256);
        int blue = random.nextInt(256);

        // 랜덤한 색을 만들고 배경색으로 설정
        int randomColor = Color.rgb(red, green, blue);
        mainLayout.setBackgroundColor(randomColor);
    }
}