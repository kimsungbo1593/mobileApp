package com.example.mission2todo;

import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity implements TodoAdapter.OnTodoListener {
    private RecyclerView recyclerView;
    private TodoAdapter todoAdapter;
    private List<TodoItem> todoItems;
    private EditText editTextTask;
    private Button buttonAdd;
    private int nextId = 1; // ID 카운터

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 초기화
        todoItems = new ArrayList<>();

        // UI 요소 연결
        recyclerView = findViewById(R.id.recyclerView);
        editTextTask = findViewById(R.id.editTextTask);
        buttonAdd = findViewById(R.id.buttonAdd);

        // RecyclerView 설정
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        todoAdapter = new TodoAdapter(todoItems, this);
        recyclerView.setAdapter(todoAdapter);

        // 샘플 데이터 추가 (원하면 제거 가능)
        addSampleTodos();

        // 추가 버튼 클릭 리스너
        buttonAdd.setOnClickListener(v -> addTodoItem());
    }

    // 샘플 데이터 추가
    private void addSampleTodos() {
        todoItems.add(new TodoItem(nextId++, "안드로이드 공부하기", false));
        todoItems.add(new TodoItem(nextId++, "운동하기", false));
        todoItems.add(new TodoItem(nextId++, "장보기", false));
        todoAdapter.notifyDataSetChanged();
    }

    // 새 할일 추가
    private void addTodoItem() {
        String task = editTextTask.getText().toString().trim();
        if (!task.isEmpty()) {
            TodoItem newItem = new TodoItem(nextId++, task, false);
            todoItems.add(0, newItem); // 리스트 맨 위에 추가
            todoAdapter.notifyItemInserted(0);
            recyclerView.scrollToPosition(0);
            editTextTask.setText("");

            // 키보드 숨기기
            InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            if (imm != null) {
                imm.hideSoftInputFromWindow(editTextTask.getWindowToken(), 0);
            }
        } else {
            Toast.makeText(this, "할일을 입력하세요", Toast.LENGTH_SHORT).show();
        }
    }

    // 체크박스 클릭 처리
    @Override
    public void onCheckBoxClick(int position, boolean isChecked) {
        TodoItem item = todoItems.get(position);
        item.setCompleted(isChecked);
        todoAdapter.notifyItemChanged(position);

        // 완료된 항목을 아래로 정렬 (선택 사항)
        if (isChecked) {
            sortTodoItems();
        }
    }

    // 완료된 항목을 아래로 정렬
    private void sortTodoItems() {
        Collections.sort(todoItems, new Comparator<TodoItem>() {
            @Override
            public int compare(TodoItem item1, TodoItem item2) {
                if (item1.isCompleted() && !item2.isCompleted()) {
                    return 1;
                } else if (!item1.isCompleted() && item2.isCompleted()) {
                    return -1;
                }
                return 0;
            }
        });
        todoAdapter.notifyDataSetChanged();
    }

    // 삭제 버튼 클릭 처리
    @Override
    public void onDeleteClick(int position) {
        todoItems.remove(position);
        todoAdapter.notifyItemRemoved(position);
    }
}