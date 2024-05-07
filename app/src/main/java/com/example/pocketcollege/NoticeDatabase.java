package com.example.pocketcollege;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Notice.class}, version = 1)
public abstract class NoticeDatabase extends RoomDatabase {

    public abstract NoticeDao noticeDao();

    public static final String DATABASE_NAME = "notice_database";

    private static volatile NoticeDatabase INSTANCE;

    public static NoticeDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (NoticeDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    NoticeDatabase.class, DATABASE_NAME)
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}