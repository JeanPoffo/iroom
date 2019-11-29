package com.br.iroom.controller;

import android.app.Activity;
import android.os.LocaleList;
import android.util.Log;
import android.widget.Toast;

import com.br.iroom.R;
import com.br.iroom.core.Core;
import com.br.iroom.core.LocalDatabase;
import com.br.iroom.model.Postagem;
import com.br.iroom.model.Salvo;
import com.br.iroom.view.PostagemDetailActivity;

import java.util.List;

/**
 * Controller para activity de detalhamento de postagem.
 * @author Lucas Fusinato Wilhelm Chiodini Zanis
 */
public class ControllerPostagemDetail extends ControllerBaseActivity {

    public ControllerPostagemDetail(Activity activity) {
        super(activity);

        this.adicionaListeners();
        this.adicionaDadosView();
    }

    @Override
    void adicionaListeners() {
        PostagemDetailActivity postagemDetailActivity = (PostagemDetailActivity) this.activity;
        postagemDetailActivity.getImageButtonFavorite().setOnClickListener(v -> {
            Postagem postagem = this.getPostagem();
            List<Salvo> salvos = LocalDatabase.getInstance().getListPostagemSalvo();
            for(Salvo salvo : salvos) {
                if(salvo.getPostagem().getCodigo() == postagem.getCodigo()) {
                    LocalDatabase.getInstance().removeSalvo(salvo);
                    Toast.makeText(postagemDetailActivity, "Postagem removida dos salvos.", Toast.LENGTH_LONG).show();
                    return;
                }
            }
            LocalDatabase.getInstance().addPostagemSalvo(postagem);
            Toast.makeText(postagemDetailActivity, "Postagem adicionada aos salvos.", Toast.LENGTH_LONG).show();
        });
        postagemDetailActivity.getImageButtonMessage().setOnClickListener(v -> Toast.makeText(postagemDetailActivity, "@todo", Toast.LENGTH_LONG).show());
    }

    @Override
    void adicionaDadosView() {
        PostagemDetailActivity postagemDetailActivity = (PostagemDetailActivity) this.activity;
        postagemDetailActivity.bindDataFromModel(this.getPostagem());
    }

    private Postagem getPostagem() {
        return (Postagem) this.activity.getIntent().getParcelableExtra("postagem");
    }
}
