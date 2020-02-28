package com.mostafijur.samplemvvmproject.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.mostafijur.samplemvvmproject.model.Students;
import com.mostafijur.samplemvvmproject.repository.StudentsRepository;
import java.util.List;

public class StudentsViewModel extends AndroidViewModel {

    StudentsRepository studentsRepository;

    public StudentsViewModel(@NonNull Application application) {
        super(application);

        studentsRepository = new StudentsRepository();
    }
    public LiveData<Students> liveData(){
        return studentsRepository.getMutableLiveData();
    }
}
