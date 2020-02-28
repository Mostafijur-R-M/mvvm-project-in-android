package com.mostafijur.samplemvvmproject.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.mostafijur.samplemvvmproject.model.Students;
import com.mostafijur.samplemvvmproject.network.ApiClient;
import com.mostafijur.samplemvvmproject.network.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StudentsRepository {

    MutableLiveData<Students> mutableLiveData;
    Students studentsList;

    public MutableLiveData<Students> getMutableLiveData(){
        if (mutableLiveData == null){
            mutableLiveData = new MutableLiveData<>();
        }
        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<Students> call = apiInterface.getAllStudent();
        call.enqueue(new Callback<Students>() {
            @Override
            public void onResponse(Call<Students> call, Response<Students> response) {
                studentsList = response.body();
                mutableLiveData.setValue(studentsList);
            }

            @Override
            public void onFailure(Call<Students> call, Throwable t) {
                Log.e("asdf", t.getLocalizedMessage());
            }
        });
        return mutableLiveData;
    }
}
