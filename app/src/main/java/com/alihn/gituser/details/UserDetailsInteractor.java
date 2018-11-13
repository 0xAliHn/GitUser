package com.alihn.gituser.details;

import com.alihn.gituser.UserDetails;

import io.reactivex.Observable;

public interface UserDetailsInteractor {
    Observable<UserDetails> getUserDetails(int id);
}
