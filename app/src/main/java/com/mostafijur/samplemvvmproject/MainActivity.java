package com.mostafijur.samplemvvmproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;

import com.mostafijur.samplemvvmproject.adapter.AllCourseAdapter;
import com.mostafijur.samplemvvmproject.adapter.StudentsAdapter;
import com.mostafijur.samplemvvmproject.model.AllCourse;
import com.mostafijur.samplemvvmproject.model.Course;
import com.mostafijur.samplemvvmproject.model.Result;
import com.mostafijur.samplemvvmproject.model.Students;
import com.mostafijur.samplemvvmproject.viewmodel.AllCourseViewModel;
import com.mostafijur.samplemvvmproject.viewmodel.StudentsViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //student data
    StudentsViewModel studentsViewModel;
    List<Result> resultList = new ArrayList<>();
    Students studentsList;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    StudentsAdapter studentsAdapter;

    //course data
    AllCourseViewModel allCourseViewModel;
    List<Course> courseList = new ArrayList<>();
    AllCourseAdapter allCourseAdapter;

    //progress dialog
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Loading....");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();

        recyclerView = findViewById(R.id.student_rcv_id);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        //networkCall();
        studentApiCall();
    }

    //student network call
    private void studentApiCall() {
        studentsViewModel = ViewModelProviders.of(this).get(StudentsViewModel.class);
        studentsViewModel.liveData().observe(this, new Observer<Students>() {
            @Override
            public void onChanged(Students students) {
                progressDialog.dismiss();
                resultList = students.getResult();
                studentsAdapter = new StudentsAdapter(MainActivity.this, resultList);
                recyclerView.setAdapter(studentsAdapter);
                recyclerView.setLayoutManager(layoutManager);
            }
        });
    }

    private void networkCall() {
        allCourseViewModel = ViewModelProviders.of(this).get(AllCourseViewModel.class);
        allCourseViewModel.liveData().observe(this, new Observer<List<AllCourse>>() {
            @Override
            public void onChanged(List<AllCourse> allCourses) {
                courseList = allCourses.get(0).getCourses();
                Log.e("asdf","aaa "+courseList.size());
                allCourseAdapter = new AllCourseAdapter(MainActivity.this, courseList);
                recyclerView.setAdapter(allCourseAdapter);
                recyclerView.setLayoutManager(layoutManager);
            }
        });
    }
}
