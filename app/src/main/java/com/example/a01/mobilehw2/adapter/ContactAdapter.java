package com.example.a01.mobilehw2.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a01.mobilehw2.R;
import com.example.a01.mobilehw2.model.Contact;
import com.example.a01.mobilehw2.util.ContactDiffCallback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;


public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactHolder> {

    private List<Contact> mDataSet;

    public ContactAdapter() {
        mDataSet = new ArrayList<>();
    }

    @NonNull
    @Override
    public ContactHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.grid_item, parent, false);
        return new ContactHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactHolder holder, int position) {
        Contact contact = mDataSet.get(position);
        Picasso.get().load(contact.getImageUrl()).into(holder.image);
        holder.text.setText(String.format("%s\n%s\n%s", contact.getName(), contact.getEmail(), contact.getPhone_number()));
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    public void setData(List<Contact> contacts){
        ContactDiffCallback callback = new ContactDiffCallback(mDataSet, contacts);
        DiffUtil.DiffResult result = DiffUtil.calculateDiff(callback);
        mDataSet.clear();
        mDataSet.addAll(contacts);
        result.dispatchUpdatesTo(this);
    }

    public class ContactHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView text;

        public ContactHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.iv_list_item);
            text = itemView.findViewById(R.id.tv_list_item);
        }
    }
}
