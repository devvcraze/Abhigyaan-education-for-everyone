package com.example.abhigyaan.ui.Volunteers;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class VolunteerViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public VolunteerViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("No Active Volunteers");
    }

    public LiveData<String> getText() {
        return mText;
    }
}