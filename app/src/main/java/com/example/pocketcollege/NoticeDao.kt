package com.example.pocketcollege

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface NoticeDao {

    @Query("SELECT * FROM noticeboard ORDER BY id DESC")
    fun getAllNotices(): List<Notice>


    // ... other methods ...
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg notices: Notice?)

}