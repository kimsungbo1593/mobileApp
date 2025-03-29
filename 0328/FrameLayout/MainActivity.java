package com.example.framelayout;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity extends AppCompatActivity {
    TextView tv1, tv2, tv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        tv1 = (TextView) findViewById(R.id.view1);
        tv2 = (TextView) findViewById(R.id.view2);
        tv3 = (TextView) findViewById(R.id.view3);

    }

    public void onClick(View v) {
        tv1.setVisibility(View.INVISIBLE);
        tv2.setVisibility(View.INVISIBLE);
        tv3.setVisibility(View.INVISIBLE);

        if (v.getId() == R.id.button1) {
            tv1.setVisibility(View.VISIBLE); // 버튼1에 대한 동작
        } else if (v.getId() == R.id.button2) {
            tv2.setVisibility(View.VISIBLE); // 버튼2에 대한 동작
        } else if (v.getId() == R.id.button3) {
            tv3.setVisibility(View.VISIBLE); // 버튼3에 대한 동작
        }
    }
}
    /*public void onClick(View view) {
        tv1.setVisibility(View.INVISIBLE);
        tv2.setVisibility(View.INVISIBLE);
        tv3.setVisibility(View.INVISIBLE);
        switch (view.getId()) {
            case R.id.button1:
                tv1.setVisibility(View.VISIBLE);
                break;
            case R.id.button2:
                tv2.setVisibility(View.VISIBLE);
                break;
            case R.id.button3:
                tv3.setVisibility(View.VISIBLE);
                break;
        }
    }
}*/