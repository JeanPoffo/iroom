package com.br.iroom.controller;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;

import com.br.iroom.core.Core;
import com.br.iroom.core.LocalDatabase;
import com.br.iroom.core.ObserverUsuario;
import com.br.iroom.model.Usuario;
import com.br.iroom.view.AdicionarPostagemActivity;
import com.br.iroom.view.PerfilActivity;
import com.br.iroom.view.PerfilEditActivity;

/**
 * Classe de Controller do Perfil
 * @author Jean Poffo
 */
public class ControllerPerfil extends ControllerBaseActivity implements ObserverUsuario {

    public ControllerPerfil(Activity activity) {
        super(activity);

        LocalDatabase.getInstance().addUsuarioObserver(this);
        this.adicionaListeners();
        this.adicionaDadosView();
    }

    @Override
    void adicionaListeners() {
        PerfilActivity perfilActivity = (PerfilActivity) this.activity;
        perfilActivity.getImageButtonAdicionarQuarto().setOnClickListener(v -> {
            perfilActivity.startActivity(new Intent(perfilActivity.getApplicationContext(), AdicionarPostagemActivity.class));
        });
        perfilActivity.getImageButtonEditarPerfil().setOnClickListener(v -> activity.startActivity(new Intent(activity.getBaseContext(), PerfilEditActivity.class)));
    }

    @Override
    void adicionaDadosView() {
        PerfilActivity perfilActivity = (PerfilActivity) this.activity;
        perfilActivity.bindDataFromModel(Core.getInstance().getUsuario());
    }

    @Override
    public void updateUsuario(Usuario usuario) {
        adicionaDadosView();
    }
}