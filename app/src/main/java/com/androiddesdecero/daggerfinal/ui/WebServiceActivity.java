package com.androiddesdecero.daggerfinal.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.androiddesdecero.daggerfinal.R;
import com.androiddesdecero.daggerfinal.api.ApiClient;
import com.androiddesdecero.daggerfinal.di.BaseApp;
import com.androiddesdecero.daggerfinal.model.GitHubRepo;
import com.androiddesdecero.daggerfinal.model.User;
import com.androiddesdecero.daggerfinal.ui.login.LoginActivity;
import com.androiddesdecero.daggerfinal.ui.profile.Profile;
import com.androiddesdecero.daggerfinal.ui.profile.ProfileActivity;
import com.androiddesdecero.daggerfinal.ui.webservice.WebService;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WebServiceActivity extends AppCompatActivity implements WebService.View{

    @Inject
    WebService.Presenter presenter;

    private Button btVolverAProfile;

    private Button btHacerPeticionWeb;

    private TextView tvUserName;
    private TextView tvEdad;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_service);
        ((BaseApp)getApplication()).getAppComponent().inject(this);
        setUpView();
        presenter.setView(this);

    }

    private void setUpView(){
        btVolverAProfile = findViewById(R.id.btVolverAProfile);
        btVolverAProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
            }
        });

        btHacerPeticionWeb = findViewById(R.id.btHacerPeticionWeb);
        btHacerPeticionWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.solitudWebService();
            }
        });

        tvUserName =  findViewById(R.id.tvUserName);
        tvEdad = findViewById(R.id.tvEdad);
    }

    @Override
    public void showUser(User user) {
        tvUserName.setText(user.getEdad());
        tvEdad.setText(user.getUsername());
    }
}
