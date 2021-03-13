package com.app.roomdatabase.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.app.roomdatabase.user.User;
import com.app.roomdatabase.user.UserDao;

@Database(entities = {User.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}