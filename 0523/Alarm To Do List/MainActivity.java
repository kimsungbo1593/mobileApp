package com.example.mission2todo;

import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Calendar;
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
    
    // 알림 기능
    private long selectedAlarmTime = 0L; // 알림 시간 임시 저장
    private Button buttonSetAlarm;

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

        // 알림 기능
        buttonSetAlarm = findViewById(R.id.buttonSetAlarm);
        buttonSetAlarm.setOnClickListener(v -> showDateTimePicker());

    }

    // 샘플 데이터 추가
    private void addSampleTodos() {
        todoItems.add(new TodoItem(nextId++, "study", false, 0L));
        todoItems.add(new TodoItem(nextId++, "health", false, 0L));
        todoItems.add(new TodoItem(nextId++, "shopping", false, 0L));
        todoAdapter.notifyDataSetChanged();
    }

    // 새 할일 추가
    private void addTodoItem() {
        String task = editTextTask.getText().toString().trim();
        if (!task.isEmpty()) {
            TodoItem newItem = new TodoItem(nextId++, task, false, selectedAlarmTime);
            todoItems.add(0, newItem); // 리스트 맨 위에 추가
            todoAdapter.notifyItemInserted(0);
            recyclerView.scrollToPosition(0);
            editTextTask.setText("");

            // 키보드 숨기기
            InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            if (imm != null) {
                imm.hideSoftInputFromWindow(editTextTask.getWindowToken(), 0);

            // 알림 예약
            if (selectedAlarmTime > 0) {
                scheduleAlarm(newItem);
            } selectedAlarmTime = 0L; // 알림 초기화
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

    // 알림 기능
    private void showDateTimePicker() {
        // DatePickerDialog로 날짜, TimePickerDialog로 시간 선택 후 selectedAlarmTime에 millis 저장
        Calendar calendar = Calendar.getInstance();

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                (view, year, month, dayOfMonth) -> {
                    calendar.set(Calendar.YEAR, year);
                    calendar.set(Calendar.MONTH, month);
                    calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                    // 날짜 고르고 시간 고르기
                    TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                            (timeView, hourOfDay, minute) -> {
                                calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
                                calendar.set(Calendar.MINUTE, minute);
                                calendar.set(Calendar.SECOND, 0);
                                selectedAlarmTime = calendar.getTimeInMillis();
                                Toast.makeText(this, "알림 시간 설정: " + new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm").format(calendar.getTime()), Toast.LENGTH_SHORT).show();
                            },
                            calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), false
                    );
                    timePickerDialog.show();
                },
                calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)
        );
        datePickerDialog.show();
    }

    // 알림 기능
    private void scheduleAlarm(TodoItem item) {
        if (item.getAlarmTime() <= System.currentTimeMillis()) {
            Toast.makeText(this, "미래 시간을 선택하세요", Toast.LENGTH_SHORT).show();
            return;
        }
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        Intent intent = new Intent(this, AlarmReceiver.class);
        intent.putExtra("task", item.getTask());
        PendingIntent pendingIntent = PendingIntent.getBroadcast(
                this, item.getId(), intent, PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE
        );
        if (alarmManager != null) {
            alarmManager.setExact(AlarmManager.RTC_WAKEUP, item.getAlarmTime(), pendingIntent);
        }
    }
}