package com.br.iroom.view.adapter;

import android.content.Context;
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

        postagemViewHolder.getTextViewTitulo().setText(this.postagens.get(position).getTitulo());
        postagemViewHolder.getTextViewDescricao().setText(this.postagens.get(position).getDescricao());

        if(!this.postagens.get(position).getImagens().isEmpty()) {
            postagemViewHolder.getImageView1().setImageBitmap(this.postagens.get(position).getImagens().get(0).getImagem());
            postagemViewHolder.getImageView2().setImageBitmap(this.postagens.get(position).getImagens().get(1).getImagem());
            postagemViewHolder.getImageView3().setImageBitmap(this.postagens.get(position).getImagens().get(2).getImagem());
        }
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