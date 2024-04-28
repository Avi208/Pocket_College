package com.example.pocketcollege;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pocketcollege.Response.FetchResponseToTables;
import com.example.pocketcollege.Response.Student;

import java.util.List;

public class AllStudentListActivity extends AppCompatActivity {

    private RecyclerView studentRecyclerView;
    private StudentAdapter studentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_all_student_list);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        // Get a reference to the RecyclerView
        // Replace with your RecyclerView's ID

        studentRecyclerView = findViewById(R.id.student_recycler_view); // Replace with your RecyclerView's ID

        // Get student data (replace with your data source)
        List<Student> students = FetchResponseToTables.getStudents();

        // Create the adapter
        studentAdapter = new StudentAdapter(students);

        // Set the adapter for the RecyclerView
        studentRecyclerView.setAdapter(studentAdapter);

        // Set a layout manager for the RecyclerView (optional)
        studentRecyclerView.setLayoutManager(new LinearLayoutManager(this));


        // Get a reference to the RecyclerView
        // Replace with your RecyclerView's ID

        studentRecyclerView = findViewById(R.id.student_recycler_view); // Replace with your RecyclerView's ID

        // Get student data (replace with your data source)
        List<Student> studentList = FetchResponseToTables.getStudents();

        // Create the adapter
        studentAdapter = new StudentAdapter(studentList);

        // Set the adapter for the RecyclerView
        studentRecyclerView.setAdapter(studentAdapter);

        // Set a layout manager for the RecyclerView (optional)
        studentRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}