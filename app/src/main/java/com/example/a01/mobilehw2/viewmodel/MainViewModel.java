package com.example.a01.mobilehw2.viewmodel;

import android.annotation.SuppressLint;

import com.example.a01.mobilehw2.model.Contact;
import com.example.a01.mobilehw2.util.Util;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


public class MainViewModel extends ViewModel {

    private MutableLiveData<List<Contact>> contactLiveData;
    private List<Contact> contacts;

    public MainViewModel() {
        contactLiveData = new MutableLiveData<>();
        contacts = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            contacts.add(new Contact(Util.generateId(), "Contact " + i));
        }
        contactLiveData.setValue(contacts);
    }

    public LiveData<List<Contact>> getContacts() {
        return contactLiveData;
    }

    public void setContacts(List<Contact> contacts) {
        this.contactLiveData.setValue(new ArrayList<>(contacts));
    }

    public void addContact(Contact contact) {
        contacts.add(0,contact);
        this.contactLiveData.setValue(new ArrayList<>(contacts));
    }


    @SuppressLint("NewApi")
    public void filterContacts(String filter_query) {
        List<Contact> filtered_list = new ArrayList<>(contacts);
        filtered_list.removeIf(contact -> !contact.getName().toLowerCase().contains(filter_query.toLowerCase()));
        contactLiveData.postValue(filtered_list);
    }

}
