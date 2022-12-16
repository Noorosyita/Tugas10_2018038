package com.example.tugas6_alarmmanager;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import com.example.tugas6_alarmmanager.databinding.ActivityLogoutBinding;
public class Logout extends AppCompatActivity {
    private ActivityLogoutBinding binding;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    private SessionManager session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setup view binding
        binding = ActivityLogoutBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        preferences = getSharedPreferences("AndroidHiveLogin",
                0);
        editor = preferences.edit();
        session = new SessionManager(getApplicationContext());
        binding.buttonLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Logout.this,
                        LoginActivity.class);
                session.setLogin(false);
                startActivity(intent);
                finish();
            }
        });
    }
}