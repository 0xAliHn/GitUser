package com.alihn.gituser.details;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.alihn.gituser.User;
import com.alihn.gituser.UserDetails;
import com.alihn.gituser.util.RxUtils;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


class UserDetailsPresenterImpl implements UserDetailsPresenter {
    @Nullable
    private UserDetailsView view;
    private UserDetailsInteractor userDetailsInteractor;
    private Disposable usersSubscription;

    @Inject
    UserDetailsPresenterImpl(UserDetailsInteractor userDetailsInteractor) {
        this.userDetailsInteractor = userDetailsInteractor;
    }

    @Override
    public void setView(UserDetailsView view) {
        this.view = view;
    }

    @Override
    public void destroy() {
        view = null;
        RxUtils.unsubscribe(usersSubscription);
    }

    private boolean isViewAttached() {
        return view != null;
    }

    @Override
    public void userDetails(@NonNull User user) {
        usersSubscription = userDetailsInteractor.getUserDetails(user.getId())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onGetUsersSuccess, t -> onGetUsersFailure());
    }

    private void onGetUsersSuccess(UserDetails userDetails) {
        if (isViewAttached()) {
            view.showDetails(userDetails);
        }
    }

    private void onGetUsersFailure() {
        // Do nothing
    }


}
