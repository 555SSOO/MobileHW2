package com.example.a01.mobilehw2.viewmodel;

import com.example.a01.mobilehw2.model.Contact;
import com.example.a01.mobilehw2.util.Util;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


public class MainViewModel extends ViewModel {

    private MutableLiveData<List<Contact>> contactLiveData;

    public MainViewModel() {
        contactLiveData = new MutableLiveData<>();
        List<Contact> contacts = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            contacts.add(new Contact(Util.generateId(), "Contact " + i));
        }
        contactLiveData.setValue(contacts);
    }

    public LiveData<List<Contact>> getStudents() {
        return contactLiveData;
    }

    public void setStudents(List<Contact> contacts) {
        this.contactLiveData.setValue(new ArrayList<>(contacts));
    }
}
