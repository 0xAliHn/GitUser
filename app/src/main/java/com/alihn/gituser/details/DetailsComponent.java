package com.alihn.gituser.details;

import dagger.Subcomponent;

@DetailsScope
@Subcomponent(modules = {DetailsModule.class})
public interface DetailsComponent
{
    void inject(UserDetailsFragment target);
}
