package com.br.iroom.view;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.br.iroom.R;
import com.br.iroom.model.Postagem;

/**
 * Classe de View para o detalhametno das Postagens
 * @author Lucas Fusinato Wilhelm Chiodini Zanis
 */
public class PostagemDetailActivity extends AppCompatActivity implements BindDataView{

    private TextView textViewTitulo;
    private TextView textViewDescricao;
    private ImageView imageView1;
    private ImageView imageView2;
    private ImageView imageView3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postagem_detail);

        this.textViewTitulo    = findViewById(R.id.textViewTitulo);
        this.textViewDescricao = findViewById(R.id.textViewDescricao);
        this.imageView1        = findViewById(R.id.imageView1);
        this.imageView2        = findViewById(R.id.imageView2);
        this.imageView3        = findViewById(R.id.imageView3);

        this.bindDataFromModel(getIntent().getParcelableExtra("postagem"));
    }

    @Override
    public void bindDataToModel(Object entidade) {}

    @Override
    public void bindDataFromModel(Object entidade) {
        final Postagem postagem = (Postagem) entidade;

        this.textViewTitulo.setText(postagem.getTitulo());
        this.textViewDescricao.setText(postagem.getDescricao());

        if(!postagem.getImagem().isEmpty()) {
            this.imageView1.setImageBitmap(postagem.getImagem().get(0));
            this.imageView2.setImageBitmap(postagem.getImagem().get(1));
            this.imageView3.setImageBitmap(postagem.getImagem().get(2));
        }
    }
}