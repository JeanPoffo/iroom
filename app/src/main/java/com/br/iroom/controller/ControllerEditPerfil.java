package com.br.iroom.controller;

import android.app.Activity;

import com.br.iroom.core.Core;
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
            perfilEditActivity.bindDataToModel(Core.getInstance().getUsuario());
            perfilEditActivity.finish();
        });
    }

    @Override
    void adicionaDadosView() {
        PerfilEditActivity perfilEditActivity = (PerfilEditActivity) this.activity;
        perfilEditActivity.bindDataFromModel(Core.getInstance().getUsuario());
    }
}