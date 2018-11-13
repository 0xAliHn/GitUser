package com.alihn.gituser.listing;


import dagger.Subcomponent;

@ListingScope
@Subcomponent(modules = {ListingModule.class})
public interface ListingComponent {
    UserListingFragment inject(UserListingFragment fragment);

}
