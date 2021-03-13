package com.app.roomdatabase.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.roomdatabase.R;
import com.app.roomdatabase.user.User;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UsersHolder> {

    private Context context;
    private List<User> userList;

    public UserAdapter(Context context, List<User> userList) {
        this.context = context;
        this.userList = userList;
    }

    @NonNull
    @Override
    public UsersHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.raw_user, parent, false);
        return new UsersHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UsersHolder holder, int position) {
        holder.txtFirstName.setText(userList.get(position).getFirstName());
        holder.txtLastName.setText(userList.get(position).getLastName());
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class UsersHolder extends RecyclerView.ViewHolder {

        private TextView txtFirstName, txtLastName;

        public UsersHolder(@NonNull View itemView) {
            super(itemView);
            txtFirstName = itemView.findViewById(R.id.txtFirstName);
            txtLastName = itemView.findViewById(R.id.txtLastName);
        }
    }
}
