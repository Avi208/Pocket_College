package com.example.pocketcollege;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.pocketcollege.Response.Internal;

import java.util.List;

@Dao
public interface InternalDao {
    @Insert
    void insertInternal(Internal internal);

    @Update
    void updateInternal(Internal internal);

    @Delete
    void deleteInternal(Internal internal);

    @Query("SELECT * FROM internal_marks")
    List<Internal> getAllInternals();

    @Query("SELECT * FROM internal_marks WHERE studentName = :studentName")
    List<Internal> getInternalsByStudentName(String studentName);

    @Query("SELECT * FROM internal_marks WHERE subjectName = :subjectName")
    List<Internal> getInternalsBySubjectName(String subjectName);
     @Query("SELECT subjectName FROM internal_marks")
     List<String> getAllSubjectNames();
     @Query("SELECT * FROM internal_marks WHERE  subjectName = :subjectName")
     Internal getInternalByStudentNameAndSubjectName(String subjectName);
}