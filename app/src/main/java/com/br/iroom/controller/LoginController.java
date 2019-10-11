package com.br.iroom.controller;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;

import com.br.iroom.model.Usuario;
import com.br.iroom.model.dao.Persistence;
import com.br.iroom.view.LoginActivity;
import com.br.iroom.view.feed.FeedActivity;

/**
 * Classe de Controller do Login
 * @author Jean Poffo
 * @since 09/10/2019
 */
public class LoginController extends ControllerBase {

    public LoginController(Activity activity) {
        super(activity);
    }

    @Override
    void addListeners() {
        LoginActivity loginActivity = (LoginActivity) this.activity;

        loginActivity.getButtonLogin().setOnClickListener(view -> this.validaLogin());
    }

    private void validaLogin() {
        LoginActivity loginActivity = (LoginActivity) this.activity;

        String email = loginActivity.getEditTextUsuario().getText().toString();
        String senha = loginActivity.getEditTextSenha().getText().toString();

        Usuario usuarioLogin = Persistence.getAppDatabase(this.activity).usuarioDao().getUsuarioLogin(email, senha);

        if(usuarioLogin != null) {
            Toast.makeText(this.activity, "Seja Bem Vindo " + usuarioLogin.getNome(), Toast.LENGTH_LONG).show();
            this.activity.startActivity(new Intent(this.activity, FeedActivity.class));
        }
        else {
            Toast.makeText(this.activity, "Login Incorreto", Toast.LENGTH_LONG).show();
        }
    }

    private void insertTesteUsuario() {
        LoginActivity loginActivity = (LoginActivity) this.activity;

        Usuario usuario = new Usuario();
        usuario.setNome("Jean");
        usuario.setSobrenome("Poffo");
        usuario.setTelefone(988273116);
        usuario.setBiografia("Adoro fazer varias coisas mds");
        usuario.setEmail(loginActivity.getEditTextUsuario().getText().toString());
        usuario.setSenha(loginActivity.getEditTextSenha().getText().toString());

        Persistence.getAppDatabase(this.activity).usuarioDao().insert(usuario);
    }
}