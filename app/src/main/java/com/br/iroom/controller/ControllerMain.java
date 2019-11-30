package com.br.iroom.controller;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

import com.br.iroom.core.Core;
import com.br.iroom.view.MainActivity;
import com.br.iroom.view.PerfilActivity;

/**
 * Controller da Activity Main do Sistema
 * @author Jean Poffo
 */
public class ControllerMain extends ControllerBaseActivity {

    public ControllerMain(Activity activity) {
        super(activity);
        this.adicionaListeners();
        this.adicionaDadosView();
    }

    @Override
    void adicionaListeners() {
        MainActivity mainActivity = (MainActivity) this.activity;

        View.OnClickListener onClickListener = v -> mainActivity.startActivity(new Intent(mainActivity.getBaseContext(), PerfilActivity.class));

        mainActivity.getImageViewFotoPerfil().setOnClickListener(onClickListener);
        mainActivity.getTextViewNomeUsuario().setOnClickListener(onClickListener);
        mainActivity.getTextViewBiografiaUsuario().setOnClickListener(onClickListener);
    }

    @Override
    void adicionaDadosView() {
        MainActivity mainActivity = (MainActivity) this.activity;
        mainActivity.bindDataFromModel(Core.getInstance().getUsuario());
    }
}