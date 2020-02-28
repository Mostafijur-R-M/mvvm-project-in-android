package com.mostafijur.samplemvvmproject.network;

import com.mostafijur.samplemvvmproject.model.AllCourse;
import com.mostafijur.samplemvvmproject.model.Students;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("api.php")
    Call<Students> getAllStudent();
    @GET("api/courses/1")
    Call<List<AllCourse>> getAllCourse();
}
