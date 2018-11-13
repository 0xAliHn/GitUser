package com.alihn.gituser.listing;

import com.alihn.gituser.User;

import java.util.List;

import io.reactivex.Observable;

public interface UserListingInteractor {

    Observable<List<User>> getUserList(int page);
}
