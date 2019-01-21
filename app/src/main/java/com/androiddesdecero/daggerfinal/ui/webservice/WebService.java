package com.androiddesdecero.daggerfinal.ui.webservice;

import com.androiddesdecero.daggerfinal.model.User;
import com.androiddesdecero.daggerfinal.ui.login.Login;

/**
 * Created by albertopalomarrobledo on 5/1/19.
 */

public interface WebService {

    interface View{
        void showUser(User user);
    }

    interface Presenter{
        void setView(WebService.View view);
        void solitudWebService();

    }
}
