package com.br.iroom.view;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.br.iroom.R;
import com.br.iroom.controller.ControllerBase;
import com.br.iroom.controller.LoginController;

public class LoginActivity extends AppCompatActivity {

    private ControllerBase controller;

    private EditText editTextUsuario;

    private EditText editTextSenha;

    private Button buttonLogin;

    public EditText getEditTextUsuario() {
        return editTextUsuario;
    }

    public EditText getEditTextSenha() {
        return editTextSenha;
    }

    public Button getButtonLogin() {
        return buttonLogin;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        this.editTextUsuario = findViewById(R.id.editTextUsuario);
        this.editTextSenha = findViewById(R.id.editTextSenha);
        this.buttonLogin = findViewById(R.id.buttonLogin);

        this.controller = new LoginController(this);
    }
}