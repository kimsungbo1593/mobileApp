package com.example.mission1paintboard;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.SeekBar;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private DrawingView drawingView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawingView = findViewById(R.id.drawing_view);

        /* ---- 색상 버튼 ---- */
        Button btnRed   = findViewById(R.id.btn_red);
        Button btnBlue  = findViewById(R.id.btn_blue);
        Button btnGreen = findViewById(R.id.btn_black);

        btnRed.setOnClickListener(v -> drawingView.setPaintColor(Color.RED));
        btnBlue.setOnClickListener(v -> drawingView.setPaintColor(Color.BLUE));
        btnGreen.setOnClickListener(v -> drawingView.setPaintColor(Color.BLACK));

        /* ---- 굵기 SeekBar ---- */
        SeekBar seekStroke = findViewById(R.id.seek_stroke);
        seekStroke.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // progress 가 0 이면 아무것도 안 보일 수 있으니 최소값 보정
                float width = progress < 1 ? 1 : progress;
                drawingView.setStrokeWidth(width);
            }
            @Override public void onStartTrackingTouch(SeekBar seekBar) { }
            @Override public void onStopTrackingTouch(SeekBar seekBar) { }
        });

        Button btnClear = findViewById(R.id.btn_clear);
        btnClear.setOnClickListener(v -> drawingView.clearCanvas());

        Button btnUndo = findViewById(R.id.btn_undo);
        btnUndo.setOnClickListener(v -> drawingView.undoLast());
    }
}
