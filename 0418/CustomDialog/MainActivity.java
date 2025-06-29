package com.example.customdialog;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (TextView) findViewById(R.id.textView);
    }

    public void onClick(View v) {
        final Dialog loginDialog = new Dialog(this);
        loginDialog.setContentView(R.layout.custom_dialog);
        loginDialog.setTitle("로그인 화면");

        Button login = (Button) loginDialog.findViewById(R.id.login);
        Button cancel = (Button) loginDialog.findViewById(R.id.cancel);

        final EditText username = (EditText) loginDialog.findViewById(R.id.username);
        final EditText password = (EditText) loginDialog.findViewById(R.id.password);

        login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (username.getText().toString().trim().length() > 0 && password.getText().toString().trim().length() > 0) {
                    Toast.makeText(getApplicationContext(), "로그인 성공", Toast.LENGTH_LONG).show();
                    text.setText("아이디: " + username.getText() + "\n패스워드: " + password.getText());
                    loginDialog.dismiss();
                } else {
                    Toast.makeText(getApplicationContext(), "다시 입력하시오", Toast.LENGTH_LONG).show();
                }
            }
        });

        loginDialog.show();
    }
}