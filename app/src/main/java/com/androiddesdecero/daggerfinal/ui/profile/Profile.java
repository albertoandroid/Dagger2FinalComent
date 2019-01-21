package com.androiddesdecero.daggerfinal.ui.profile;

import com.androiddesdecero.daggerfinal.model.User;

/**
 * Created by albertopalomarrobledo on 5/1/19.
 */

public interface Profile {

    interface View{
        void showUser(User user);
        void logout();
    }

    interface Presenter{
        void setView(Profile.View view);
        void updateUser(User updateUser);
        void logout();
    }
}
