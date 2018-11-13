package com.alihn.gituser;

import android.app.Application;
import android.os.StrictMode;
import android.support.annotation.Nullable;

import com.alihn.gituser.details.DetailsComponent;
import com.alihn.gituser.details.DetailsModule;
import com.alihn.gituser.listing.ListingComponent;
import com.alihn.gituser.listing.ListingModule;
import com.alihn.gituser.network.NetworkModule;


public class BaseApplication extends Application
{
    private AppComponent appComponent;
    @Nullable
    private DetailsComponent detailsComponent;
    @Nullable
    private ListingComponent listingComponent;

    @Override
    public void onCreate()
    {
        super.onCreate();
        StrictMode.enableDefaults();
        appComponent = createAppComponent();

    }

    private AppComponent createAppComponent()
    {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .networkModule(new NetworkModule())
                .build();
    }

    @Nullable
    public DetailsComponent createDetailsComponent() {
        detailsComponent = appComponent.plus(new DetailsModule());
        return detailsComponent;
    }

    public void releaseDetailsComponent()
    {
        detailsComponent = null;
    }

    @Nullable
    public ListingComponent createListingComponent() {
        listingComponent = appComponent.plus(new ListingModule());
        return listingComponent;
    }

    public void releaseListingComponent()
    {
        listingComponent = null;
    }

}
