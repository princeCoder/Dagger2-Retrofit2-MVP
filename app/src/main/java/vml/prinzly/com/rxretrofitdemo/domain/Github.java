package vml.prinzly.com.rxretrofitdemo.domain;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by prinzlyngotoum on 8/3/16.
 */
public class Github implements Parcelable {

    private String login;
    private String blog;
    private int public_repos;

    protected Github(Parcel in) {
        login = in.readString();
        blog = in.readString();
        public_repos = in.readInt();
    }

    public static final Creator<Github> CREATOR = new Creator<Github>() {
        @Override
        public Github createFromParcel(Parcel in) {
            return new Github(in);
        }

        @Override
        public Github[] newArray(int size) {
            return new Github[size];
        }
    };

    public String getLogin() {
        return login;
    }

    public String getBlog() {
        return blog;
    }

    public int getPublicRepos() {
        return public_repos;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(login);
        parcel.writeString(blog);
        parcel.writeInt(public_repos);
    }
}
