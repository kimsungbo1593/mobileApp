package com.example.recycling;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SortingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sorting);

        ImageView back = findViewById(R.id.back);
        if (back != null) {
            back.setOnClickListener(v -> finish());
        }

        // 이미지 클릭 리스너 등록
        findViewById(R.id.ps1).setOnClickListener(v ->
                startActivity(new Intent(this, Plastic1Activity.class)));
        findViewById(R.id.ps2).setOnClickListener(v ->
                startActivity(new Intent(this, Plastic2Activity.class)));
        findViewById(R.id.vn).setOnClickListener(v ->
                startActivity(new Intent(this, VinylActivity.class)));
        findViewById(R.id.pp).setOnClickListener(v ->
                startActivity(new Intent(this, PaperActivity.class)));
        findViewById(R.id.gl).setOnClickListener(v ->
                startActivity(new Intent(this, GlassActivity.class)));
        findViewById(R.id.can).setOnClickListener(v ->
                startActivity(new Intent(this, CanActivity.class)));
        findViewById(R.id.ip).setOnClickListener(v ->
                startActivity(new Intent(this, IcepackActivity.class)));
        findViewById(R.id.bt).setOnClickListener(v ->
                startActivity(new Intent(this, BatteryActivity.class)));
    }
}