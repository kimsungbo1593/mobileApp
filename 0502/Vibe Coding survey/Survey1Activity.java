package com.example.vibecodingsurvey;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

public class Survey1Activity extends Fragment implements MainActivity2.SurveyFragmentBase {
    private RadioGroup radioGroup;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.survey1, container, false);
        ((TextView) view.findViewById(R.id.questionText)).setText("1. 서비스 전반적인 만족도는 어떠신가요?");
        radioGroup = view.findViewById(R.id.radioGroup);
        return view;
    }

    @Override
    public String getSelectedAnswer() {
        int checkedId = radioGroup.getCheckedRadioButtonId();
        if (checkedId == -1) return null;
        return ((RadioButton) radioGroup.findViewById(checkedId)).getText().toString();
    }


}
