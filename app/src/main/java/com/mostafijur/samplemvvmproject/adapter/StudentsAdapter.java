package com.mostafijur.samplemvvmproject.adapter;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mostafijur.samplemvvmproject.R;
import com.mostafijur.samplemvvmproject.model.Result;

import java.util.List;

public class StudentsAdapter extends RecyclerView.Adapter<StudentsAdapter.MyViewHolder> {
    private Context context;
    List<Result> resultList;

    public StudentsAdapter(Context context, List<Result> resultList) {
        this.context = context;
        this.resultList = resultList;
    }

    @NonNull
    @Override
    public StudentsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.profile_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentsAdapter.MyViewHolder holder, int position) {

        holder.idTV.setText("ID: "+resultList.get(position).getId());
        holder.nameTV.setText("Name: "+resultList.get(position).getName());
        holder.emailTV.setText("Email: "+resultList.get(position).getEmail());
        holder.createdAtTV.setText("Created Time: "+resultList.get(position).getCreatedAt());

    }

    @Override
    public int getItemCount() {
        return resultList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView idTV, nameTV, emailTV, createdAtTV;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            idTV = itemView.findViewById(R.id.student_id_tv_id);
            nameTV = itemView.findViewById(R.id.student_name_tv_id);
            emailTV = itemView.findViewById(R.id.student_email_tv_id);
            createdAtTV = itemView.findViewById(R.id.student_created_at_tv_id);
        }
    }
}
