package com.alihn.gituser.listing;


public interface UserListingPresenter
{
    void firstPage();

    void nextPage();

    void setView(UserListingView view);

    void destroy();
}
