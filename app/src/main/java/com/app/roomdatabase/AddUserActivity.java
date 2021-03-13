package com.app.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.app.roomdatabase.app.RoomApplication;
import com.app.roomdatabase.databinding.ActivityAddUserBinding;
import com.app.roomdatabase.user.User;

public class AddUserActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityAddUserBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_user);

        binding.btnAddUser.setOnClickListener(this);
        binding.btnAllUsers.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnAddUser) {
            if (isValidate()) {
                User user = new User();
                user.firstName = binding.edtFirstName.getText().toString();
                user.lastName = binding.edtLastName.getText().toString();
                user.email = binding.edtEmail.getText().toString();
                RoomApplication.appDatabase.userDao().insertAll(user);

                Toast.makeText(this, getResources().getString(R.string.user_added), Toast.LENGTH_SHORT).show();

                binding.edtFirstName.setText("");
                binding.edtLastName.setText("");
                binding.edtEmail.setText("");
            }
        } else if (v.getId() == R.id.btnAllUsers) {
            startActivity(new Intent(AddUserActivity.this, UsersActivity.class));
        }
    }

    private boolean isValidate() {
        if (binding.edtFirstName.getText().toString().trim().length() == 0) {
            Toast.makeText(this, getResources().getString(R.string.please_enter_first_name), Toast.LENGTH_SHORT).show();
            return false;
        } else if (binding.edtLastName.getText().toString().trim().length() == 0) {
            Toast.makeText(this, getResources().getString(R.string.please_eneter_last_name), Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}