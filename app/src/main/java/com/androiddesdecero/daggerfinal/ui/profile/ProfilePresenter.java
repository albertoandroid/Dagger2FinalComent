package com.androiddesdecero.daggerfinal.ui.profile;

import android.util.Log;

import com.androiddesdecero.daggerfinal.di.BaseApp;
import com.androiddesdecero.daggerfinal.model.User;

import javax.inject.Inject;

/**
 * Created by albertopalomarrobledo on 5/1/19.
 */

public class ProfilePresenter implements Profile.Presenter {

    private User user;
    private Profile.View view;

    public ProfilePresenter(User user){
        this.user = user;
    }

    @Override
    public void setView(Profile.View view){
        this.view = view;
        if(view != null){
            view.showUser(user);
        }
    }

    @Override
    public void updateUser(User updateUsuario) {
        user.setUsername(updateUsuario.getUsername());
        user.setEdad(updateUsuario.getEdad());
    }

    @Override
    public void logout() {
        user.setUsername("");
        user.setEdad("");
        view.logout();
    }
}
