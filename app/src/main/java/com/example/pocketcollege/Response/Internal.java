package com.example.pocketcollege.Response;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "internal_marks")
public class Internal {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String studentName;
    private String subjectName;
    private int midOneMarks;
    private int midTwoMarks;

    public Internal(String studentName, String subjectName, int midOneMarks, int midTwoMarks) {
        this.studentName = studentName;
        this.subjectName = subjectName;
        this.midOneMarks = midOneMarks;
        this.midTwoMarks = midTwoMarks;
    }

    public Internal(    ) {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getMidOneMarks() {
        return midOneMarks;
    }

    public void setMidOneMarks(int midOneMarks) {
        this.midOneMarks = midOneMarks;
    }

    public int getMidTwoMarks() {
        return midTwoMarks;
    }

    public void setMidTwoMarks(int midTwoMarks) {
        this.midTwoMarks = midTwoMarks;
    }
}