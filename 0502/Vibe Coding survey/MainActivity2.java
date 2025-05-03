package com.example.vibecodingsurvey;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity2 extends AppCompatActivity {
    int currentQuestionIndex = 0;
    String[] answers = new String[10];
    Fragment[] fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        fragments = new Fragment[]{
                new Survey1Activity(),
                new Survey2Activity(),
                new Survey3Activity(),
                new Survey4Activity(),
                new Survey5Activity(),
                new Survey6Activity(),
                new Survey7Activity(),
                new Survey8Activity(),
                new Survey9Activity(),
                new Survey10Activity()
        };

        loadFragment(fragments[currentQuestionIndex]);
    }

    public interface SurveyFragmentBase {
        String getSelectedAnswer();
    }

    public void next(View view) {
        if (currentQuestionIndex < fragments.length) {
            // 현재 프래그먼트에서 응답 가져오기
            SurveyFragmentBase current = (SurveyFragmentBase) fragments[currentQuestionIndex];
            String answer = current.getSelectedAnswer();

            if (answer == null) {
                // 선택하지 않았을 경우
                return;
            }

            answers[currentQuestionIndex] = answer;
            currentQuestionIndex++;

            if (currentQuestionIndex < fragments.length) {
                loadFragment(fragments[currentQuestionIndex]);
            } else {
                // 결과 프래그먼트로 이동
                ResultActivity resultFragment = ResultActivity.newInstance(answers);
                loadFragment(resultFragment);
            }
        }
    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.commit();
    }
}
