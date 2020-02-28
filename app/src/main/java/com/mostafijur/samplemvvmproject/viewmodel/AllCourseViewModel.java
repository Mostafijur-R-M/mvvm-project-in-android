package com.mostafijur.samplemvvmproject.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.mostafijur.samplemvvmproject.model.AllCourse;
import com.mostafijur.samplemvvmproject.repository.AllCourseRepository;

import java.util.List;

public class AllCourseViewModel extends AndroidViewModel {
    AllCourseRepository allCourseRepository;

    public AllCourseViewModel(@NonNull Application application) {
        super(application);
        allCourseRepository = new AllCourseRepository();
    }
    public LiveData<List<AllCourse>> liveData(){
        return allCourseRepository.getMutableLiveData();
    }
}
