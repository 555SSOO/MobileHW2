package com.example.a01.mobilehw2.activity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.a01.mobilehw2.R;
import com.example.a01.mobilehw2.adapter.ContactAdapter;
import com.example.a01.mobilehw2.model.Contact;
import com.example.a01.mobilehw2.util.Util;
import com.example.a01.mobilehw2.viewmodel.MainViewModel;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class MainActivity extends AppCompatActivity {

    private EditText mInputEt;
    private EditText mFilterEt;
    private MainViewModel mViewModel;
    private List<Contact> mContacts;
    private ContactAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_main);

        init();
    }

    private void init() {
        mContacts = new ArrayList<>();
        initViews();
        initViewModels();
    }

    private void initViewModels() {
        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        mViewModel.getContacts().observe(this,
                contacts -> {
                    mContacts = new ArrayList<>(contacts);
                    mAdapter.setData(mContacts);
                });
    }

    private void initViews() {
        mInputEt = findViewById(R.id.et_main_input);
        Button addBtn = findViewById(R.id.btn_main_add);

        // Dodajemo studenta na poziciju 2
        addBtn.setOnClickListener(v -> {
            String s = mInputEt.getText().toString();
            mViewModel.addContact(new Contact(Util.generateId(), s));
            mViewModel.setContacts(mContacts);
        });


        mFilterEt = findViewById(R.id.et_filter);
        mFilterEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                mViewModel.filterContacts(charSequence.toString());
            }
            @Override
            public void afterTextChanged(Editable editable) {
            }
        });






        RecyclerView recycler = findViewById(R.id.rv_main_list);
        GridLayoutManager manager = new GridLayoutManager(this, 2);
        recycler.setLayoutManager(manager);
        mAdapter = new ContactAdapter();
        recycler.setAdapter(mAdapter);
    }


}
