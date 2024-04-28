package com.example.pocketcollege;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pocketcollege.Response.Student;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {

    private List<Student> students;

    public StudentAdapter(List<Student> students) {
        this.students = students;
    }

    @Override
    public StudentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_student, parent, false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(StudentViewHolder holder, int position) {
        Student student = students.get(position);
        holder.studentName.setText(student.getName());
        holder.studentRegisterNumber.setText("Register Number: " + student.getRegisterNumber());
        holder.studentBranch.setText("Branch: " + student.getBranch());
        holder.studentPhoto.setImageResource(student.getPhotoId());
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    public static class StudentViewHolder extends RecyclerView.ViewHolder {

        TextView studentName, studentRegisterNumber, studentBranch;
        ImageView studentPhoto;


        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            studentName = itemView.findViewById(R.id.student_name);
            studentRegisterNumber = itemView.findViewById(R.id.student_register_number);
            studentBranch = itemView.findViewById(R.id.student_branch);
                studentPhoto = itemView.findViewById(R.id.student_photo);

        }
    }
}