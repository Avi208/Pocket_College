package com.example.pocketcollege

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "noticeboard")
data class Notice(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val title: String,
    val content: String,
    val owner: String,
    val issued_on: String,
    val path: String
)