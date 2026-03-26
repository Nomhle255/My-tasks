package com.example.mytasks;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;

public class TasksFragment extends Fragment {

    private EditText editTextTask;
    private Button btnAddTask;
    private ListView listViewTasks;
    private ArrayList<String> taskList;
    private ArrayAdapter<String> adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tasks, container, false);

        editTextTask = view.findViewById(R.id.editTextTask);
        btnAddTask = view.findViewById(R.id.btnAddTask);
        listViewTasks = view.findViewById(R.id.listViewTasks);

        if (taskList == null) {
            taskList = new ArrayList<>();
        }

        adapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_list_item_1, taskList);
        listViewTasks.setAdapter(adapter);

        btnAddTask.setOnClickListener(v -> {
            String task = editTextTask.getText().toString().trim();
            if (!task.isEmpty()) {
                taskList.add(task);
                adapter.notifyDataSetChanged();
                editTextTask.setText("");
                Toast.makeText(getActivity(), "Task added!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getActivity(), "Please enter a task.", Toast.LENGTH_SHORT).show();
            }
        });

        listViewTasks.setOnItemClickListener((parent, v, position, id) -> {
            taskList.remove(position);
            adapter.notifyDataSetChanged();
            Toast.makeText(getActivity(), "Task removed!", Toast.LENGTH_SHORT).show();
        });

        return view;
    }

    public void clearAllTasks() {
        if (taskList != null) {
            taskList.clear();
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
            Toast.makeText(getActivity(), "All tasks cleared!", Toast.LENGTH_SHORT).show();
        }
    }
}