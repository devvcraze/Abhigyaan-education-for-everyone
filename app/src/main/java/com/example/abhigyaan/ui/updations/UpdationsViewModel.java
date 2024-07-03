package com.example.abhigyaan.ui.updations;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class UpdationsViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public UpdationsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("No updations");
    }

    public LiveData<String> getText() {
        return mText;
    }
}