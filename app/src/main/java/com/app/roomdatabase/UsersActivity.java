package com.app.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.database.DatabaseUtils;
import android.os.Bundle;

import com.app.roomdatabase.adapter.UserAdapter;
import com.app.roomdatabase.app.RoomApplication;
import com.app.roomdatabase.databinding.ActivityUsersBinding;

public class UsersActivity extends AppCompatActivity {

    private ActivityUsersBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_users);

        binding.rvUsers.setLayoutManager(new LinearLayoutManager(this));
        binding.rvUsers.setAdapter(new UserAdapter(this, RoomApplication.appDatabase.userDao().getAll()));
    }
}