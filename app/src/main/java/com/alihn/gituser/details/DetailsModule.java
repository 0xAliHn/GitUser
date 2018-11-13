package com.alihn.gituser.details;

import android.support.annotation.NonNull;

import com.alihn.gituser.network.GitUserWebService;

import dagger.Module;
import dagger.Provides;


@Module
public class DetailsModule {
    @NonNull
    @Provides
    @DetailsScope
    UserDetailsInteractor provideInteractor(GitUserWebService gitUserWebService) {
        return new UserDetailsInteractorImpl(gitUserWebService);
    }

    @NonNull
    @Provides
    @DetailsScope
    UserDetailsPresenter providePresenter(UserDetailsInteractor detailsInteractor) {
        return new UserDetailsPresenterImpl(detailsInteractor);
    }
}
