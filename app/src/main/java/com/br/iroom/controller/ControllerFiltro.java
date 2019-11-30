package com.br.iroom.controller;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;

import com.br.iroom.R;
import com.br.iroom.core.Core;
import com.br.iroom.core.LocalDatabase;
import com.br.iroom.model.Filtro;
import com.br.iroom.view.AdicionarPostagemActivity;
import com.br.iroom.view.FiltroActivity;
import com.br.iroom.view.LoginActivity;
import com.br.iroom.view.PerfilActivity;
import com.br.iroom.view.PerfilEditActivity;

/**
 * Controlador para a tela de filtro
 * @author Lucas Fusinato Wilhelm Chiodini Zanis
 */
public class ControllerFiltro extends ControllerBaseActivity {

    public ControllerFiltro(Activity activity) {
        super(activity);

        this.adicionaListeners();
        this.adicionaDadosView();
    }

    @Override
    void adicionaListeners() {
        FiltroActivity activity = (FiltroActivity) this.activity;
        activity.getImageButtonFiltro().setOnClickListener(e -> {
            Filtro filtro = new Filtro();
            activity.bindDataToModel(filtro);
            LocalDatabase.getInstance().updateFiltro(filtro);
            activity.finish();
        });
    }

    @Override
    void adicionaDadosView() {
        Filtro filtro = LocalDatabase.getInstance().getFiltro();
        if(filtro != null) {
            FiltroActivity activity = (FiltroActivity) this.activity;
            activity.bindDataFromModel(filtro);
        }
    }

}
