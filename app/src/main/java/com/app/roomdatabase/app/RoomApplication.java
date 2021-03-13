package com.app.roomdatabase.app;

import android.app.Application;
import android.util.Log;

import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.app.roomdatabase.R;
import com.app.roomdatabase.database.AppDatabase;

public class RoomApplication extends Application {

    public static AppDatabase appDatabase;

    @Override
    public void onCreate() {
        super.onCreate();

        Migration MIGRATION_1_2 = new Migration(1, 2) {
            @Override
            public void migrate(SupportSQLiteDatabase database) {

                database.execSQL("ALTER TABLE User "
                        + " ADD COLUMN email TEXT");

                database.execSQL("CREATE TABLE Fruit (id INTEGER, "
                        + "name TEXT, PRIMARY KEY(id))");
            }
        };

        appDatabase = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, getString(R.string.database_name))
                .addMigrations(MIGRATION_1_2)
                .setJournalMode(RoomDatabase.JournalMode.TRUNCATE)
                .allowMainThreadQueries()
                .build();
    }
}
