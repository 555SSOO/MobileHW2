package com.example.a01.mobilehw2.model;

public class Contact {

    private int mId;
    private String mName;
    private String mImageUrl;
    private String phone_number;
    private String email;

    public Contact(int id, String name) {
        this(id, name, "https://picsum.photos/300/300/?random", "0610000000", "test@test.com");
    }

    public Contact(int id, String name, String imageUrl, String _phone_number, String _email) {
        mId = id;
        mName = name;
        mImageUrl = imageUrl;
        phone_number = _phone_number;
        email = _email;
    }

    public int getId() {
        return mId;
    }

    public void setmId(int id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        mImageUrl = imageUrl;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
