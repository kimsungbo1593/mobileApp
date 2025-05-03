package com.example.vibecodingsurvey;

import android.graphics.Color;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;
import java.util.HashMap;

public class ResultActivity extends Fragment {

    private static final String[] QUESTIONS = {
            "전반적인 만족도",
            "이용 과정의 편리함",
            "직원의 친절도",
            "서비스 품질",
            "문제 대응",
            "가격 대비 가치",
            "재이용 의향",
            "추천 의향",
            "불편 사항",
            "개선 사항"
    };

    public static ResultActivity newInstance(String[] answers) {
        ResultActivity fragment = new ResultActivity();
        Bundle args = new Bundle();
        args.putStringArray("answers", answers);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.result, container, false);
        TextView resultText = view.findViewById(R.id.resultText);
        PieChart pieChart = view.findViewById(R.id.pieChart);  // <-- PieChart 연결

        String[] answers = getArguments().getStringArray("answers");
        StringBuilder result = new StringBuilder();

        // 텍스트 결과 표시
        for (int i = 0; i < QUESTIONS.length; i++) {
            result.append((i + 1)).append(". ").append(QUESTIONS[i]).append(": ")
                    .append(answers[i]).append("\n");
        }
        resultText.setText(result.toString());

        // PieChart 데이터 준비
        HashMap<String, Integer> countMap = new HashMap<>();
        for (String answer : answers) {
            if (answer != null) {
                countMap.put(answer, countMap.getOrDefault(answer, 0) + 1);
            }
        }

        ArrayList<PieEntry> entries = new ArrayList<>();
        for (String key : countMap.keySet()) {
            entries.add(new PieEntry(countMap.get(key), key));
        }

        PieDataSet dataSet = new PieDataSet(entries, "만족도 분포");
        dataSet.setColors(new int[]{
                Color.rgb(102, 204, 255), // 매우 만족
                Color.rgb(153, 255, 204), // 만족
                Color.rgb(255, 255, 153), // 보통
                Color.rgb(255, 204, 102), // 불만족
                Color.rgb(255, 102, 102)  // 매우 불만족
        });

        PieData pieData = new PieData(dataSet);
        pieChart.setData(pieData);
        pieChart.setUsePercentValues(true);
        pieChart.setEntryLabelColor(Color.BLACK);
        pieChart.setCenterText("응답 분포");
        pieChart.setCenterTextSize(16f);
        pieChart.getDescription().setEnabled(false);
        pieChart.invalidate();  // 그래프 새로고침

        return view;
    }
}
