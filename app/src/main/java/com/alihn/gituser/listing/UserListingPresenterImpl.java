package com.alihn.gituser.listing;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.alihn.gituser.User;
import com.alihn.gituser.util.RxUtils;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

class UserListingPresenterImpl implements UserListingPresenter {
    @Nullable
    private UserListingView view;
    private UserListingInteractor usersInteractor;
    private Disposable fetchSubscription;
    private int currentPage = 1;
    @NonNull
    private List<User> loadedItems = new ArrayList<>();

    UserListingPresenterImpl(UserListingInteractor interactor) {
        usersInteractor = interactor;
    }

    @Override
    public void setView(UserListingView view) {
        this.view = view;
        displayUsers();
    }

    @Override
    public void destroy() {
        view = null;
        RxUtils.unsubscribe(fetchSubscription);
    }

    private void displayUsers() {
        showLoading();

        fetchSubscription = usersInteractor.getUserList(currentPage)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onUserFetchSuccess, this::onUserFetchFailed);
    }

    @Override
    public void firstPage() {
        currentPage = 1;
        loadedItems.clear();
        displayUsers();
    }

    @Override
    public void nextPage() {
            currentPage++;
        displayUsers();
    }


    private void showLoading() {
        if (isViewAttached()) {
            view.loadingStarted();
        }
    }

    private void onUserFetchSuccess(@NonNull List<User> items) {
        if (!loadedItems.isEmpty()) {
            loadedItems.addAll(items);
        } else {
            loadedItems = new ArrayList<>(items);
        }
        if (isViewAttached()) {
            view.showUsers(loadedItems);
        }
    }

    private void onUserFetchFailed(Throwable e) {
        view.loadingFailed(e.getMessage());
    }

    private boolean isViewAttached() {
        return view != null;
    }
}
