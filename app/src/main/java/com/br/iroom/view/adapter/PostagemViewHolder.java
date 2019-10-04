package com.br.iroom.view.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.br.iroom.R;

class PostagemViewHolder extends RecyclerView.ViewHolder {

    private TextView textViewTitulo;
    private TextView textViewDescricao;

    PostagemViewHolder(@NonNull View view) {
        super(view);

        this.textViewTitulo    = view.findViewById(R.id.textViewTitulo);
        this.textViewDescricao = view.findViewById(R.id.textViewDescricao);
    }

    TextView getTextViewTitulo() {
        return textViewTitulo;
    }

    TextView getTextViewDescricao() {
        return textViewDescricao;
    }
}