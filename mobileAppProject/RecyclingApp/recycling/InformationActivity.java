package com.example.recycling;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class InformationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.information);

        ImageView back = findViewById(R.id.back);
        if (back != null) {
            back.setOnClickListener(v -> finish());
        }

        findViewById(R.id.text1).setOnClickListener(v -> openUrl("https://www.sujigu.go.kr/lmth/04life0303.asp"));
        findViewById(R.id.text2).setOnClickListener(v -> openUrl("https://www.sujigu.go.kr/lmth/04life0303.asp"));
        findViewById(R.id.text3).setOnClickListener(v -> openUrl("https://www.sujigu.go.kr/lmth/04life030308.asp"));
        findViewById(R.id.text4).setOnClickListener(v -> openUrl("https://www.sujigu.go.kr/lmth/04life030307.asp"));
        findViewById(R.id.text5).setOnClickListener(v -> openUrl("https://www.sujigu.go.kr/lmth/04life030305.asp"));

    }

    private void openUrl(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
}