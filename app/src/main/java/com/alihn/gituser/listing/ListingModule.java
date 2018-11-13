package com.alihn.gituser.listing;

import android.support.annotation.NonNull;

import com.alihn.gituser.network.GitUserWebService;

import dagger.Module;
import dagger.Provides;


@Module
public class ListingModule {
    @NonNull
    @Provides
    @ListingScope
    UserListingInteractor provideUserListingInteractor(GitUserWebService gitUserWebService) {
        return new UserListingInteractorImpl(gitUserWebService);
    }

    @NonNull
    @Provides
    @ListingScope
    UserListingPresenter provideUserListingPresenter(UserListingInteractor interactor) {
        return new UserListingPresenterImpl(interactor);
    }
}
