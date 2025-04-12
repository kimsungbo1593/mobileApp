package com.example.implicitintent;

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
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        Intent intent = null;
        int id = view.getId();
        if( id == R.id.web) {
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
        } else if ( id == R.id.call) {
                intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:(+82)12345789"));
        } else if ( id == R.id.map) {
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:37.30,127.2?z=10"));
        } else if ( id == R.id.contact) {
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("content://contacts/people/"));
        }
        if (intent != null) {
            startActivity(intent);
        }
    }
}