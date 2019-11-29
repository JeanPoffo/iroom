package com.br.iroom.view;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.br.iroom.R;
import com.br.iroom.controller.ControllerPostagemDetail;
import com.br.iroom.model.Postagem;
import com.br.iroom.model.Quarto;

/**
 * Classe de View para o detalhametno das Postagens
 * @author Lucas Fusinato Wilhelm Chiodini Zanis
 */
public class PostagemDetailActivity extends AppCompatActivity implements BindDataView{

    private TextView textViewTitulo;
    private TextView textViewDescricao;
    private TextView textViewQuantidadeQuartos;
    private TextView textViewQuantidadeSuites;
    private ImageView imageView1;
    private ImageView imageView2;
    private ImageView imageView3;
    private ImageButton imageButtonFavorite;
    private ImageButton imageButtonMessage;

    private ControllerPostagemDetail controller;

    // <editor-fold defaultstate="collapsed" desc="Getters">

    public ImageButton getImageButtonFavorite() { return imageButtonFavorite; }

    public ImageButton getImageButtonMessage() { return imageButtonMessage; }

    // </editor-fold>

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postagem_detail);

        this.textViewTitulo            = findViewById(R.id.textViewTitulo);
        this.textViewDescricao         = findViewById(R.id.textViewDescricao);
        this.textViewQuantidadeQuartos = findViewById(R.id.textViewQuantidadeQuartos);
        this.textViewQuantidadeSuites  = findViewById(R.id.textViewQuantidadeSuites);
        this.imageView1                = findViewById(R.id.imageView1);
        this.imageView2                = findViewById(R.id.imageView2);
        this.imageView3                = findViewById(R.id.imageView3);
        this.imageButtonFavorite       = findViewById(R.id.imageButtonFavorite);
        this.imageButtonMessage        = findViewById(R.id.imageButtonMessage);

        this.controller = new ControllerPostagemDetail(this);
    }

    @Override
    public void bindDataToModel(Object entidade) {}

    @Override
    public void bindDataFromModel(Object entidade) {
        final Postagem postagem = (Postagem) entidade;

        this.textViewTitulo.setText(postagem.getTitulo());
        this.textViewDescricao.setText(postagem.getDescricao());
        if(!postagem.hasQuarto()) {
            postagem.resetQuarto();
        }
        this.textViewQuantidadeQuartos.setText("Quartos: " + postagem.getQuarto().getQuantidadeQuarto());
        this.textViewQuantidadeSuites.setText("Suítes: " + postagem.getQuarto().getQuantidadeSuite());

        if(!postagem.getImagem().isEmpty()) {
            this.imageView1.setImageBitmap(postagem.getImagem().get(0));
            this.imageView2.setImageBitmap(postagem.getImagem().get(1));
            this.imageView3.setImageBitmap(postagem.getImagem().get(2));
        }
    }
}