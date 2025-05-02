package com.example.simpleitem2;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView);

        // 데이터 준비
        List<Map<String, String>> data = new ArrayList<>();

        Map<String, String> item1 = new HashMap<>();
        item1.put("title", "첫 번째 아이템");
        item1.put("subtitle", "첫 번째 설명입니다.");
        data.add(item1);

        Map<String, String> item2 = new HashMap<>();
        item2.put("title", "두 번째 아이템");
        item2.put("subtitle", "두 번째 설명입니다.");
        data.add(item2);

        // 어댑터 설정
        SimpleAdapter adapter = new SimpleAdapter(
                this,
                data,
                android.R.layout.simple_list_item_2,
                new String[] {"title", "subtitle"},
                new int[] {android.R.id.text1, android.R.id.text2}
        );

        listView.setAdapter(adapter);
    }
}