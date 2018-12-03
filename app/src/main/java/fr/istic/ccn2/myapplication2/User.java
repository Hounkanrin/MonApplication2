package fr.istic.ccn2.myapplication2;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {
    private String mName;
    private String mLastname;
    private String mDate;
    private String mVille;
    private String mDepartement;

 public User(String mName, String mLastname, String mDate, String mVille, String mDepartement) {
        this.mName = mName;
        this.mLastname = mLastname;
        this.mDate = mDate;
        this.mVille = mVille;
        this.mDepartement = mDepartement;
    }


    protected User(Parcel in) {
        mName = in.readString();
        mLastname = in.readString();
        mDate = in.readString();
        mVille = in.readString();
        mDepartement = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mName);
        dest.writeString(mLastname);
        dest.writeString(mDate);
        dest.writeString(mVille);
        dest.writeString(mDepartement);
    }

    public String getmName() {
        return mName;
    }

    public String getmLastname() {
        return mLastname;
    }

    public String getmDate() {
        return mDate;
    }

    public String getmVille() {
        return mVille;
    }

    public String getmDepartement() {
        return mDepartement;
    }
}
