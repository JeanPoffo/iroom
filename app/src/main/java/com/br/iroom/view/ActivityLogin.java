package com.br.iroom.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.br.iroom.R;
import com.br.iroom.view.feed.FeedActivity;

public class ActivityLogin extends AppCompatActivity {

    private EditText editTextUsuario;

    private EditText editTextSenha;

    private Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        this.editTextUsuario = findViewById(R.id.editTextUsuario);
        this.editTextSenha = findViewById(R.id.editTextSenha);
        this.buttonLogin = findViewById(R.id.buttonLogin);

        this.buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ActivityLogin.this, FeedActivity.class));
                finish();
            }
        });
    }
}