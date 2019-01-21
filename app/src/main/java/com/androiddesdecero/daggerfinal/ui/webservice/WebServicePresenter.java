package com.androiddesdecero.daggerfinal.ui.webservice;

import android.util.Log;

import com.androiddesdecero.daggerfinal.api.ApiClient;
import com.androiddesdecero.daggerfinal.model.GitHubRepo;
import com.androiddesdecero.daggerfinal.model.User;
import com.androiddesdecero.daggerfinal.ui.login.Login;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by albertopalomarrobledo on 5/1/19.
 */

public class WebServicePresenter implements WebService.Presenter {

    private User user;
    private ApiClient api;
    private WebService.View view;

    public WebServicePresenter(User user, ApiClient apiClient){
        this.user = user;
        api = apiClient;
    }

    @Override
    public void setView(WebService.View view) {
        this.view = view;
        view.showUser(user);
    }

    @Override
    public void solitudWebService() {
        Call<List<GitHubRepo>> call = api.getReposForUser("albertoandroid");
        call.enqueue(new Callback<List<GitHubRepo>>() {
            @Override
            public void onResponse(Call<List<GitHubRepo>> call, Response<List<GitHubRepo>> response) {
                for(int i=0; i<response.body().size(); i++){
                    GitHubRepo repo = response.body().get(i);
                    Log.d("TAG1", "Respositorio: " + i + " Nombre: " + repo.getName() +
                            " Avatar: " + repo.getOwner().getAvatarUrl() + " login: " + repo.getOwner().getLogin());
                }
            }

            @Override
            public void onFailure(Call<List<GitHubRepo>> call, Throwable t) {

            }
        });
    }

}
