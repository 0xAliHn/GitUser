package com.alihn.gituser.details;

import android.support.annotation.NonNull;

import com.alihn.gituser.UserDetails;
import com.alihn.gituser.network.GitUserWebService;

import io.reactivex.Observable;

class UserDetailsInteractorImpl implements UserDetailsInteractor {

    private GitUserWebService gitUserWebService;

    UserDetailsInteractorImpl(GitUserWebService gitUserWebService) {
        this.gitUserWebService = gitUserWebService;
    }

    @NonNull
    @Override
    public Observable<UserDetails> getUserDetails(final int id) {
        return gitUserWebService.getUserDetails(id);
    }

}
