package com.aston_cdnt17.amovies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.amovies.R;
import com.example.amovies.databinding.ActivityHomeBinding;
import com.example.amovies.databinding.ActivityMovieBinding;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener{
    Button btn_cnx;
    TextView tv_ins;

    ActivityHomeBinding binding;
    HomeViewModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        model = new ViewModelProvider(this).get(HomeViewModel.class);
        btn_cnx = binding.btnCnx;
        tv_ins = binding.tvIns;

        // rendre les boutons cliquable
        btn_cnx.setOnClickListener(l ->{
            String email = binding.etLogin.getText().toString();
            String pwd = binding.etPassword.getText().toString();

            model.login(email,pwd);

        });

model.isAuth.observe(this, isAuth ->{
    if(isAuth){
        Intent mainIntent = new Intent(this, MainActivity.class);
        startActivity(mainIntent);
    }else{
        binding.tvIns.setText("Email ou mot de passe incorrect.");
    }
});
        tv_ins.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_cnx:
                Toast.makeText(getApplicationContext(), "vous avez cliqué sur le bouton connecté", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_ins:
                Intent i = new Intent(this,RegisterActivity.class);
                startActivity(i);
        }
    }
}