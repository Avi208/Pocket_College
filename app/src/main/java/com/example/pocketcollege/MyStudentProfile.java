package com.example.pocketcollege;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

public class MyStudentProfile extends AppCompatActivity {

    private TextView headerName;
    private TextView header_regester_name;
    private TextView strudent_name;
    private TextView student_regester;
    private TextView address;
    private TextView blood_group;
    private TextView student_branch_name;
    private TextView student_mobile_number;
    private TextView student_father_name;
    private TextView student_mother_name;
    private TextView student_parent_email;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_my_student_profile);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        // Initialize views for this xml element
        // Initialize views
        headerName = (TextView) findViewById(R.id.header_name);
        header_regester_name = (TextView) findViewById(R.id.header_regester_name);
        strudent_name = (TextView) findViewById(R.id.strudent_name);
        student_regester = (TextView) findViewById(R.id.student_regester);
            student_mobile_number = (TextView) findViewById(R.id.student_mobile_number);
        student_father_name = (TextView) findViewById(R.id.student_father_name);
        student_mother_name = (TextView) findViewById(R.id.student_mother_name);
        student_parent_email = (TextView) findViewById(R.id.student_parent_email);
        student_branch_name = (TextView) findViewById(R.id.student_branch_name);
        blood_group = (TextView) findViewById(R.id.blood_group);
        address = (TextView) findViewById(R.id.address);

        // create a method that returns a list of student for this textview
       List<String> listStudent= getStudentList();

    }

    private List<String> getStudentList() {
        // create dummy list of students for this textview
        List<String> listStudent = new ArrayList<>();
        listStudent.add("

        return null;
    }
}