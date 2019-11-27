package com.br.iroom.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.br.iroom.R;
import com.br.iroom.model.Salvo;
import com.br.iroom.view.PostagemDetailActivity;

import java.util.List;

/**
 * Classe de Adapter de Itens Salvos
 * @author Jean Poffo
 */
public class SalvoAdapter extends RecyclerView.Adapter {

    private Context context;

    private List<Salvo> salvos;

    public SalvoAdapter(Context context, List<Salvo> salvos) {
        this.context = context;
        this.salvos = salvos;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SalvoViewHolder(LayoutInflater.from(this.context).inflate(R.layout.activity_salvo_adapter, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        SalvoViewHolder salvoViewHolder = (SalvoViewHolder) viewHolder;
        final Salvo salvo = this.salvos.get(position);

        salvoViewHolder.getTextViewTituloSalvo().setText(salvo.getPostagem().getTitulo());
        salvoViewHolder.getTextViewDescricaoSalvo().setText(salvo.getPostagem().getDescricao());

        if(!salvo.getPostagem().getImagem().isEmpty()) {
           salvoViewHolder.getImageViewSalvo().setImageBitmap(salvo.getPostagem().getImagem().get(0));
        }

        salvoViewHolder.getCardViewSalvo().setOnClickListener(view -> {
            Intent intent = new Intent(context, PostagemDetailActivity.class);

            intent.putExtra("postagem", salvo.getPostagem());

            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return this.salvos.size();
    }
}