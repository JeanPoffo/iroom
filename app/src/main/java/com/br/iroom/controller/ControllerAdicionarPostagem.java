package com.br.iroom.controller;

import android.app.Activity;

import com.br.iroom.core.LocalDatabase;
import com.br.iroom.model.Postagem;
import com.br.iroom.view.AdicionarPostagemActivity;

/**
 * Controller para activity de adicionar postagem.
 * @author Lucas Fusinato Wilhelm Chiodini Zanis
 */
public class ControllerAdicionarPostagem extends ControllerBaseActivity {

    public ControllerAdicionarPostagem(Activity activity) {
        super(activity);

        this.adicionaListeners();
        this.adicionaDadosView();
    }

    @Override
    void adicionaListeners() {
        AdicionarPostagemActivity adicionarPostagemActivity = (AdicionarPostagemActivity) this.activity;
        adicionarPostagemActivity.getImageButtonSalvar().setOnClickListener(v -> {
            Postagem postagem = new Postagem();
            adicionarPostagemActivity.bindDataToModel(postagem);
            LocalDatabase.getInstance().addPostagem(postagem);
            adicionarPostagemActivity.finish();
        });
    }

    @Override
    void adicionaDadosView() {

    }
}
