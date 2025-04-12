package com.example.a0411homeworkapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        Intent intent = null;
        int id = view.getId();
            if( id == R.id.how) {
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/emt-9119/223820946134"));
            }

            if( id == R.id.call) {
                intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:(+82)119"));
            }

            if( id == R.id.map) {
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:37.30,127.2?z=10"));
            }

            if ( id == R.id.help) {
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/hhlyun2337/223823210075"));
            }

            if ( id == R.id.weather) {
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://naver.me/GdyX395u"));
            }
            if ( id == R.id.contact) {
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("content://contacts/people/"));
                }

        if (intent != null) {
            startActivity(intent);
        }
    }
}