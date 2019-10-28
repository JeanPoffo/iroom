package com.br.iroom.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.br.iroom.R;
import com.br.iroom.model.Postagem;

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

        if(!postagem.getImagem().isEmpty()) {
            postagemViewHolder.getImageView1().setImageBitmap(postagem.getImagem().get(0));
            postagemViewHolder.getImageView2().setImageBitmap(postagem.getImagem().get(1));
            postagemViewHolder.getImageView3().setImageBitmap(postagem.getImagem().get(2));
        }

        postagemViewHolder.getCardViewPostagem().setOnClickListener(view -> {
            Intent intent = new Intent(context, PostagemDetailActivity.class);

            intent.putExtra("titulo", postagem.getTitulo());
            intent.putExtra("descricao", postagem.getDescricao());

            if(!postagem.getImagem().isEmpty()) {
                intent.putExtra("imagens", true);
                intent.putExtra("imagem1", postagem.getImagem().get(0));
                intent.putExtra("imagem2", postagem.getImagem().get(1));
                intent.putExtra("imagem3", postagem.getImagem().get(2));
            }

            context.startActivity(intent);
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