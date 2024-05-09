package com.example.pocketcollege;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.pocketcollege.Response.Internal;

import java.util.ArrayList;
import java.util.List;

public class AddInternalMarksActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private Spinner studentNameSpinner, subjectNameSpinner;
    private EditText midMarksOneEditText, midMarksTwoEditText;
    private Button updateButton;

    // Data structures for student and subject names (replace with your data source)
    private List<String> studentNames = new ArrayList<>();
    private List<String> subjectNames = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_internal_marks);
        studentNameSpinner = findViewById(R.id.spinner_student_name);
        subjectNameSpinner = findViewById(R.id.spinner_subject_name);
        midMarksOneEditText = findViewById(R.id.edit_text_mid_marks_one);
        midMarksTwoEditText = findViewById(R.id.edit_text_mid_marks_two);
        updateButton = findViewById(R.id.button_update);

        // Set up the spinner for student names
        // Populate student and subject names (replace with your data source logic)
        studentNames.add("Select Student Name");
        studentNames.add("Harsha");
        studentNames.add("Kavitha Hars");
        studentNameSpinner.setOnItemSelectedListener(this);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, studentNames);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        studentNameSpinner.setAdapter(adapter);
        String[] stringArray = {
                "Select Subject Name",
                "Database Management Systems",
                "Java Programming",
                "Formal Languages & Automata Theory",
                "Computer Organization & Architecture",
                "Principles of Programming Languages",
                "Database Management Systems Lab",
                "Java Programming Lab",
                "Human Values & Professional Ethics (Audit Course)",
                "Design and Analysis of Algorithms"
        };
        ArrayAdapter<String> subjectAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, stringArray);
        subjectAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        subjectNameSpinner.setAdapter(subjectAdapter);
        createBasicValidate();
    }

    private void createBasicValidate() {
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String studentName = studentNameSpinner.getSelectedItem().toString();
                String subjectName = subjectNameSpinner.getSelectedItem().toString();
                String midMarksOne = midMarksOneEditText.getText().toString();
                String midMarksTwo = midMarksTwoEditText.getText().toString();
                if (studentName.equals("Select Student Name") || subjectName.equals("Select Subject Name") || midMarksOne.isEmpty() || midMarksTwo.isEmpty()) {
                        return;
                }
                Thread thread = new Thread(() -> {
                    NoticeDatabase database = NoticeDatabase.getDatabase(getApplicationContext());
                   InternalDao internalDao = database.internalDao();
                    Internal internal = new Internal();
                    internal.setStudentName(studentName);
                    internal.setSubjectName(subjectName);
                    internal.setMidOneMarks(Integer.parseInt(midMarksOne));
                    internal.setMidTwoMarks(Integer.parseInt(midMarksTwo));
                    internalDao.insertInternal(internal);

                });
                // Start the thread
                thread.start();
                try {
                    thread.join();
                    Toast.makeText(AddInternalMarksActivity.this, "Data inserted successfully", Toast.LENGTH_SHORT).show();
                    finish();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}