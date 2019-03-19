package com.example.a01.mobilehw2.util;

import com.example.a01.mobilehw2.model.Contact;

import java.util.List;

import androidx.recyclerview.widget.DiffUtil;

public class ContactDiffCallback extends DiffUtil.Callback {

    private List<Contact> mOldList;
    private List<Contact> mNewList;

    public ContactDiffCallback(List<Contact> oldList, List<Contact> newList){
        mOldList = oldList;
        mNewList = newList;
    }

    @Override
    public int getOldListSize() {
        return mOldList.size();
    }

    @Override
    public int getNewListSize() {
        return mNewList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        Contact oldContact = mOldList.get(oldItemPosition);
        Contact newContact = mNewList.get(newItemPosition);
        return oldContact.getId() == newContact.getId();
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        Contact oldContact = mOldList.get(oldItemPosition);
        Contact newContact = mNewList.get(newItemPosition);
        return oldContact.getName().equals(newContact.getName());
    }
}
