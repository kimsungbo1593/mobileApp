package com.example.mission1paintboard;

import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

public class DrawingView extends View {

    private Path currentPath;
    private Paint currentPaint;
    private ArrayList<Pair<Path, Paint>> paths = new ArrayList<>();

    public DrawingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    private void initPaint() {
        currentPaint = new Paint();
        currentPaint.setColor(Color.BLACK);
        currentPaint.setAntiAlias(true);
        currentPaint.setStyle(Paint.Style.STROKE);
        currentPaint.setStrokeJoin(Paint.Join.ROUND);
        currentPaint.setStrokeCap(Paint.Cap.ROUND);
        currentPaint.setStrokeWidth(8f);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                currentPath = new Path();
                currentPath.moveTo(x, y);
                paths.add(new Pair<>(currentPath, new Paint(currentPaint)));
                break;
            case MotionEvent.ACTION_MOVE:
                if (currentPath != null) {
                    currentPath.lineTo(x, y);
                }
                break;
        }
        invalidate();
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (Pair<Path, Paint> pair : paths) {
            canvas.drawPath(pair.first, pair.second);
        }
    }

    // Optional: clear the drawing
    public void clearDrawing() {
        paths.clear();
        invalidate();
    }

    // Pair class since Android does not include one by default for older APIs
    public static class Pair<F, S> {
        public final F first;
        public final S second;
        public Pair(F first, S second) {
            this.first = first;
            this.second = second;
        }
    }
//------------------------------------------
    public void setPaintColor(int color) {
        currentPaint.setColor(color);
    }

    public void setStrokeWidth(float width) {
        currentPaint.setStrokeWidth(width);
    }

    public void clearCanvas() {
        paths.clear();       // 그려진 모든 선 제거
        invalidate();        // 화면 다시 그리기
    }

    public void undoLast() {
        if (!paths.isEmpty()) {
            paths.remove(paths.size() - 1);
            invalidate();
        }
    }
}
