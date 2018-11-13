package com.alihn.gituser.listing;

import com.alihn.gituser.User;
import com.alihn.gituser.UserList;
import com.alihn.gituser.network.GitUserWebService;

import java.util.List;

import io.reactivex.Observable;


class UserListingInteractorImpl implements UserListingInteractor {
    private GitUserWebService gitUserWebService;

    UserListingInteractorImpl(GitUserWebService gitUserWebService) {
        this.gitUserWebService = gitUserWebService;
    }


    @Override
    public Observable<List<User>> getUserList(int page) {
        String params = "language:java";

        return gitUserWebService.getUserList(params).map(UserList::getItemList);

    }

}
