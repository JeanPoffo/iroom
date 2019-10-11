package com.br.iroom.view.adapter;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.br.iroom.R;

/**
 * Classe de View para o detalhametno das Postagens
 * @author Lucas Fusinato Wilhelm Chiodini Zanis
 * @since 11/10/2019
 * TODO Verificar se há possibilidade de reutilização entre essa classe e a classe PostagemViewHolder, já que possuem uma estrutura de componentes muito parecida
 */
public class PostagemDetailActivity extends AppCompatActivity {

    private TextView textViewTitulo;
    private TextView textViewDescricao;
    private ImageView imageView1;
    private ImageView imageView2;
    private ImageView imageView3;
    private ImageButton imageButtonClose;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postagem_detail);

        this.textViewTitulo    = findViewById(R.id.textViewTitulo);
        this.textViewDescricao = findViewById(R.id.textViewDescricao);
        this.imageView1        = findViewById(R.id.imageView1);
        this.imageView2        = findViewById(R.id.imageView2);
        this.imageView3        = findViewById(R.id.imageView3);
        this.imageButtonClose  = findViewById(R.id.imageButtonClose);

        this.textViewTitulo.setText(getIntent().getStringExtra("titulo"));
        this.textViewDescricao.setText(getIntent().getStringExtra("descricao"));
        if(getIntent().hasExtra("imagens")) {
            this.imageView1.setImageBitmap((Bitmap) getIntent().getParcelableExtra("imagem1"));
            this.imageView2.setImageBitmap((Bitmap) getIntent().getParcelableExtra("imagem2"));
            this.imageView3.setImageBitmap((Bitmap) getIntent().getParcelableExtra("imagem3"));
        }
        this.imageButtonClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
