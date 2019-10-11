package com.br.iroom.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.br.iroom.R;
import com.br.iroom.model.Postagem;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe adapter para o Recycler View de Postagens do Feed
 * @author Jean Poffo
 * @since 09/10/2019
 */
public class PostagemAdapter extends RecyclerView.Adapter {

    private Context context;

    private List<Postagem> postagens;

    public PostagemAdapter(Context context, List<Postagem> postagens) {
        this.context   = context;
        this.postagens = postagens;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PostagemViewHolder(LayoutInflater.from(this.context).inflate(R.layout.activity_postagem_adapter, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        PostagemViewHolder postagemViewHolder = (PostagemViewHolder) holder;
        final Postagem postagem = this.postagens.get(position);

        postagemViewHolder.getTextViewTitulo().setText(postagem.getTitulo());
        postagemViewHolder.getTextViewDescricao().setText(postagem.getDescricao());

        if(!postagem.getImagens().isEmpty()) {
            postagemViewHolder.getImageView1().setImageBitmap(postagem.getImagens().get(0).getImagem());
            postagemViewHolder.getImageView2().setImageBitmap(postagem.getImagens().get(1).getImagem());
            postagemViewHolder.getImageView3().setImageBitmap(postagem.getImagens().get(2).getImagem());
        }

        postagemViewHolder.getImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, PostagemDetailActivity.class);

                intent.putExtra("titulo", postagem.getTitulo());
                intent.putExtra("descricao", postagem.getDescricao());

                if(!postagem.getImagens().isEmpty()) {
                    intent.putExtra("imagens", true);
                    intent.putExtra("imagem1", postagem.getImagens().get(0).getImagem());
                    intent.putExtra("imagem2", postagem.getImagens().get(1).getImagem());
                    intent.putExtra("imagem3", postagem.getImagens().get(2).getImagem());
                }

                context.startActivity(intent);
            }
        });
    }

    @Override
    public long getItemId(int position) {
        return this.postagens.get(position).getCodigo();
    }

    @Override
    public int getItemCount() {
        return this.postagens.size();
    }
}