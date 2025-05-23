package com.example.mission2todo;

import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.ViewHolder> {
    private List<TodoItem> todoItems;
    private OnTodoListener onTodoListener;

    public interface OnTodoListener {
        void onCheckBoxClick(int position, boolean isChecked);
        void onDeleteClick(int position);
    }

    public TodoAdapter(List<TodoItem> todoItems, OnTodoListener onTodoListener) {
        this.todoItems = todoItems;
        this.onTodoListener = onTodoListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.todo_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TodoItem currentItem = todoItems.get(position);
        holder.textViewTask.setText(currentItem.getTask());
        holder.checkBoxComplete.setChecked(currentItem.isCompleted());

        // 체크 상태에 따라 텍스트에 취소선 적용
        if (currentItem.isCompleted()) {
            holder.textViewTask.setPaintFlags(holder.textViewTask.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        } else {
            holder.textViewTask.setPaintFlags(holder.textViewTask.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
        }
    }

    @Override
    public int getItemCount() {
        return todoItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CheckBox checkBoxComplete;
        TextView textViewTask;
        ImageButton buttonDelete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            checkBoxComplete = itemView.findViewById(R.id.checkBoxComplete);
            textViewTask = itemView.findViewById(R.id.textViewTask);
            buttonDelete = itemView.findViewById(R.id.buttonDelete);

            checkBoxComplete.setOnClickListener(v -> {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    onTodoListener.onCheckBoxClick(position, checkBoxComplete.isChecked());
                }
            });

            buttonDelete.setOnClickListener(v -> {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    onTodoListener.onDeleteClick(position);
                }
            });
        }
    }
}