package com.example.clothesinc;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class User implements Serializable {

    private String Username;
    private String Password;

    public void setUsername(String username){
        Username = username;
    }

    public void setPassword(String password){
        Password = password;
    }

    public String getUsername(){
        return Username;
    }

    public String getPassword(){
        return Password;
    }

    protected User (Parcel in){
        Username = in.readString();
        Password = in.readString();
    }

    public User(String username, String password) {
        this.Username = username;
        this.Password = password;
    }

//    public static final Creator<User> CREATOR = new Creator<User>() {
//        @Override
//        public User createFromParcel(Parcel in) {
//            return new User(in);
//        }
//
//        @Override
//        public User[] newArray(int size) {
//            return new User[size];
//        }
//    };

//    @Override
//    public int describeContents() {
//        return 0;
//    }

//    @Override
//    public void writeToParcel(Parcel dest, int flags) {
//        dest.writeString(Username);
//        dest.writeString(Password);
//    }
}
