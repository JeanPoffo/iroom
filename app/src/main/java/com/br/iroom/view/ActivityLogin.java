package com.br.iroom.view;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.br.iroom.R;

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
    }
}