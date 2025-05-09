package com.example.mission1paintboard;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private DrawingView drawingView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawingView = findViewById(R.id.drawing_view);

        // 색상 버튼
        Button btnRed = findViewById(R.id.btn_red);
        Button btnBlue = findViewById(R.id.btn_blue);
        Button btnBlack = findViewById(R.id.btn_black);

        btnRed.setOnClickListener(v -> drawingView.setPaintColor(Color.RED));
        btnBlue.setOnClickListener(v -> drawingView.setPaintColor(Color.BLUE));
        btnBlack.setOnClickListener(v -> drawingView.setPaintColor(Color.BLACK));

        // 액션 버튼
        Button btnClear = findViewById(R.id.btn_clear);
        btnClear.setOnClickListener(v -> drawingView.clearCanvas());

        Button btnUndo = findViewById(R.id.btn_undo);
        btnUndo.setOnClickListener(v -> drawingView.undoLast());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.stroke_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.stroke_thin) {
            drawingView.setStrokeWidth(4f);
            return true;
        } else if (item.getItemId() == R.id.stroke_medium) {
            drawingView.setStrokeWidth(8f);
            return true;
        } else if (item.getItemId() == R.id.stroke_thick) {
            drawingView.setStrokeWidth(16f);
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
}
