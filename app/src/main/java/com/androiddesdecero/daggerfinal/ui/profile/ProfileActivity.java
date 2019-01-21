package com.androiddesdecero.daggerfinal.ui.profile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.androiddesdecero.daggerfinal.R;
import com.androiddesdecero.daggerfinal.di.BaseApp;
import com.androiddesdecero.daggerfinal.model.User;
import com.androiddesdecero.daggerfinal.ui.WebServiceActivity;
import com.androiddesdecero.daggerfinal.ui.login.LoginActivity;

import javax.inject.Inject;

public class ProfileActivity extends AppCompatActivity implements Profile.View {

    private EditText etName;
    private EditText etEdad;
    private TextView tvLogout;
    private Button btNextActivity;
    private Button btUpdte;

    @Inject
    Profile.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ((BaseApp)getApplication()).getAppComponent().inject(this);
        setUpView();
    }

    private void setUpView(){
        etName = findViewById(R.id.etName);
        etEdad = findViewById(R.id.etEdad);
        tvLogout = findViewById(R.id.tvLogout);
        tvLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.logout();
            }
        });
        btNextActivity = findViewById(R.id.btNextActivity);
        btNextActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), WebServiceActivity.class));
            }
        });
        btUpdte = findViewById(R.id.btUpdate);
        btUpdte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User();
                user.setEdad(etEdad.getText().toString());
                user.setUsername(etName.getText().toString());
                presenter.updateUser(user);
            }
        });
        presenter.setView(this);
    }

    @Override
    public void showUser(User user) {
        etEdad.setText(user.getEdad());
        etName.setText(user.getUsername());
    }

    @Override
    public void logout(){
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    /*
    @Override
    protected void onStart(){
        super.onStart();
        if(user == null){
            logout();
        }
    }
    */
}
