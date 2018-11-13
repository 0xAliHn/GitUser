package com.alihn.gituser;

import android.support.annotation.NonNull;

import com.alihn.gituser.details.DetailsComponent;
import com.alihn.gituser.details.DetailsModule;
import com.alihn.gituser.listing.ListingComponent;
import com.alihn.gituser.listing.ListingModule;
import com.alihn.gituser.network.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        AppModule.class,
        NetworkModule.class})
public interface AppComponent
{
    @NonNull
    DetailsComponent plus(DetailsModule detailsModule);

    @NonNull
    ListingComponent plus(ListingModule listingModule);
}
