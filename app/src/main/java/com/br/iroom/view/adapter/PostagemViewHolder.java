package com.br.iroom.view.adapter;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.br.iroom.R;

/**
 * Classe de View Holder para o Adapter de postagens
 * @author Jean Poffo
 * @since 09/10/2019
 */
class PostagemViewHolder extends RecyclerView.ViewHolder {

    private CardView cardViewPostagem;
    private TextView textViewTitulo;
    private TextView textViewDescricao;
    private ImageView imageView1;
    private ImageView imageView2;
    private ImageView imageView3;

    PostagemViewHolder(@NonNull View view) {
        super(view);

        this.cardViewPostagem  = view.findViewById(R.id.cardViewPostagem);
        this.textViewTitulo    = view.findViewById(R.id.textViewTitulo);
        this.textViewDescricao = view.findViewById(R.id.textViewDescricao);
        this.imageView1        = view.findViewById(R.id.imageView1);
        this.imageView2        = view.findViewById(R.id.imageView2);
        this.imageView3        = view.findViewById(R.id.imageView3);
    }

    // <editor-fold defaultstate="collapsed" desc="Getters">

    CardView getCardViewPostagem() {
        return cardViewPostagem;
    }

    TextView getTextViewTitulo() {
        return textViewTitulo;
    }

    TextView getTextViewDescricao() {
        return textViewDescricao;
    }

    ImageView getImageView1() {
        return imageView1;
    }

    ImageView getImageView2() {
        return imageView2;
    }

    ImageView getImageView3() {
        return imageView3;
    }

    // </editor-fold>
}