package com.app.roomdatabase.app;

import android.app.Application;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.app.roomdatabase.R;
import com.app.roomdatabase.database.AppDatabase;

public class RoomApplication extends Application {

    public static AppDatabase appDatabase;

    @Override
    public void onCreate() {
        super.onCreate();

        appDatabase = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, getString(R.string.database_name))
                .setJournalMode(RoomDatabase.JournalMode.TRUNCATE)
                .allowMainThreadQueries()
                .build();
    }
}
