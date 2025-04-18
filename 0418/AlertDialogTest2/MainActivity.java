package com.example.alertdialogtest2;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private String selectDrink = "커피";
    ImageView imageview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageview = findViewById(R.id.image);
        Button DialogButton = findViewById(R.id.button);
        DialogButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                DrinkDialog();
            }
        });
    }

    private void DrinkDialog() {
        final String[] drinks = {"커피", "티", "밀크"};

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("음료 선택").setSingleChoiceItems(drinks, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        selectDrink = drinks[which];

                        if(which == 0) imageview.setImageResource(R.drawable.coffee);
                        else if(which == 1) imageview.setImageResource(R.drawable.tea);
                        else imageview.setImageResource(R.drawable.milk);
                    }
                })

                .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // 선택한 음료에 대한 추가 작업 수행
                        // 실제 액션을 수행하거나 화면에 표시하는 방식으로 변경 가능
                        dialog.dismiss();
                    }
                })
                .setPositiveButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // 선택한 음료에 대한 추가 작업 수행
                        // 실제 액션을 수행하거나 화면에 표시하는 방식으로 변경 가능
                        dialog.dismiss();
                    }
                });

        builder.create().show();
    }
}