package com.androiddesdecero.daggerfinal.ui.login;

import com.androiddesdecero.daggerfinal.model.User;

/**
 * Created by albertopalomarrobledo on 5/1/19.
 */

public interface Login {

    interface View{
        void usarioValido();
        void error();
    }

    interface Presenter{
        void validaUser(String user, String pass);
        void setView(Login.View view);
    }
}
