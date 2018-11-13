package com.alihn.gituser.network;

import android.support.annotation.NonNull;

import com.alihn.gituser.UserDetails;
import com.alihn.gituser.UserList;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface GitUserWebService {

    @NonNull
    @GET("/search/users?")
    Observable<UserList> getUserList(@Query("q") String filter);


    @NonNull
    @GET("/user/{id}")
    Observable<UserDetails> getUserDetails(@Path("id") int id);

}
