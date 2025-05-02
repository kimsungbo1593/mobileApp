package com.example.chapter8quizcodingchallenge;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity2 extends AppCompatActivity {
    private int fragmentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        setFragment(fragmentIndex);
    }

    public void next(View view) {
        fragmentIndex++;

        if (fragmentIndex < 5) {
            setFragment(fragmentIndex);
        } else {
            Toast.makeText(this, "완료했습니다!", Toast.LENGTH_SHORT).show();
        }
    }

    private void setFragment(int index) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        Fragment fragment;

        switch (index) {
            case 0:
                fragment = new FragmentActivity();
                break;
            case 1:
                fragment = new Fragment2Activity();
                break;
            case 2:
                fragment = new Fragment3Activity();
                break;
            case 3:
                fragment = new Fragment4Activity();
                break;
            case 4:
                fragment = new Fragment5Activity();
                break;
            default:
                fragment = new FragmentActivity();
                break;
        }

        transaction.replace(R.id.frame_container, fragment);
        transaction.commitAllowingStateLoss();
    }
}