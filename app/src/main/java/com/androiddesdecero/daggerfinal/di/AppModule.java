package com.androiddesdecero.daggerfinal.di;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.androiddesdecero.daggerfinal.api.ApiClient;
import com.androiddesdecero.daggerfinal.model.User;
import com.androiddesdecero.daggerfinal.ui.login.Login;
import com.androiddesdecero.daggerfinal.ui.login.LoginActivity;
import com.androiddesdecero.daggerfinal.ui.login.LoginPresenter;
import com.androiddesdecero.daggerfinal.ui.profile.Profile;
import com.androiddesdecero.daggerfinal.ui.profile.ProfileActivity;
import com.androiddesdecero.daggerfinal.ui.profile.ProfilePresenter;
import com.androiddesdecero.daggerfinal.ui.webservice.WebService;
import com.androiddesdecero.daggerfinal.ui.webservice.WebServicePresenter;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by albertopalomarrobledo on 5/1/19.
 */

@Module
public class AppModule {

    private final Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    /*
    Exponer la application al grafo
     */
    @Provides
    @Singleton
    public Application provideApplication() {
        return application;
    }

    @Provides
    @Singleton
    public Context provideApplicationContext() {
        return application;
    }

    /*
    User
     */
    @Singleton
    @Provides
    User provideUser() {
        return new User();
    }

    /*
    Grafo de Retrofit
     */
    private static final String BASE_URL = "https://api.github.com";

    @Singleton
    @Provides
    GsonConverterFactory provideGsonConverterFactory(){
        GsonConverterFactory gsonConverterFactory = GsonConverterFactory.create();
        return gsonConverterFactory;
    }

    @Singleton
    @Provides
    OkHttpClient provideOkHttpClient(){
        return new OkHttpClient.Builder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .build();
    }

    @Singleton
    @Provides
    Retrofit provideRetrofit(OkHttpClient client, GsonConverterFactory converterFactory){
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(converterFactory)
                .client(client)
                .build();
    }

    @Singleton
    @Provides
    ApiClient provideApliClient(Retrofit retrofit){
        return retrofit.create(ApiClient.class);
    }

    /*
    Grafo de Activities
     */

    @Singleton
    @Provides
    Login.Presenter providePresenterLogin(User user){
        return new LoginPresenter(user);
    }

    @Singleton
    @Provides
    Profile.Presenter providePresenterProfile(User user){
        return new ProfilePresenter(user);
    }

    @Singleton
    @Provides
    WebService.Presenter providePresenterWebService(User user, ApiClient apiClient){
        return new WebServicePresenter(user, apiClient);
    }

}
