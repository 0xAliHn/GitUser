package com.alihn.gituser.listing;

import com.alihn.gituser.User;

import java.util.List;

interface UserListingView {
    void showUsers(List<User> items);

    void loadingStarted();

    void loadingFailed(String errorMessage);

    void onUserClicked(User user);
}
