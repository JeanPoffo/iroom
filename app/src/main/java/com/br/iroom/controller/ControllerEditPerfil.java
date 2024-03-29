package com.br.iroom.controller;

import android.app.Activity;

import com.br.iroom.core.Core;
import com.br.iroom.core.LocalDatabase;
import com.br.iroom.model.Usuario;
import com.br.iroom.view.PerfilEditActivity;

public class ControllerEditPerfil extends ControllerBaseActivity {

    public ControllerEditPerfil(Activity activity) {
        super(activity);

        this.adicionaListeners();
        this.adicionaDadosView();
    }

    @Override
    void adicionaListeners() {
        PerfilEditActivity perfilEditActivity = (PerfilEditActivity) this.activity;
        perfilEditActivity.getImageButtonSalvar().setOnClickListener(v -> {
            Usuario usuario = Core.getInstance().getUsuario();
            perfilEditActivity.bindDataToModel(usuario);
            LocalDatabase.getInstance().updateUsuario(usuario);
            perfilEditActivity.finish();
        });
    }

    @Override
    void adicionaDadosView() {
        PerfilEditActivity perfilEditActivity = (PerfilEditActivity) this.activity;
        perfilEditActivity.bindDataFromModel(Core.getInstance().getUsuario());
    }
}