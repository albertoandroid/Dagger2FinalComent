package com.androiddesdecero.daggerfinal.di;

import com.androiddesdecero.daggerfinal.ui.WebServiceActivity;
import com.androiddesdecero.daggerfinal.ui.login.LoginActivity;
import com.androiddesdecero.daggerfinal.ui.profile.ProfileActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by albertopalomarrobledo on 5/1/19.
 */

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    void inject(LoginActivity loginActivity);
    void inject(ProfileActivity profileActivity);
    void inject(WebServiceActivity webServiceActivity);
}
