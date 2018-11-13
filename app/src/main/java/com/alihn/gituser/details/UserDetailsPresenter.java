package com.alihn.gituser.details;

import com.alihn.gituser.User;


public interface UserDetailsPresenter {
    void userDetails(User user);

    void setView(UserDetailsView view);

    void destroy();
}
