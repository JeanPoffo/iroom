package com.br.iroom.controller;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;

import com.br.iroom.core.Core;
import com.br.iroom.view.PerfilActivity;
import com.br.iroom.view.PerfilEditActivity;

/**
 * Classe de Controller do Perfil
 * @author Jean Poffo
 */
public class ControllerPerfil extends ControllerBaseActivity {

    public ControllerPerfil(Activity activity) {
        super(activity);

        this.adicionaListeners();
        this.adicionaDadosView();
    }

    @Override
    void adicionaListeners() {
        PerfilActivity perfilActivity = (PerfilActivity) this.activity;
        perfilActivity.getImageButtonAdicionarQuarto().setOnClickListener(v -> Toast.makeText(this.activity, "@todo", Toast.LENGTH_LONG).show());
        perfilActivity.getImageButtonEditarPerfil().setOnClickListener(v -> activity.startActivity(new Intent(activity.getBaseContext(), PerfilEditActivity.class)));
    }

    @Override
    void adicionaDadosView() {
        PerfilActivity perfilActivity = (PerfilActivity) this.activity;
        perfilActivity.bindDataFromModel(Core.getInstance().getUsuario());
    }
}