package com.br.iroom.view.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.br.iroom.R;

/**
* Classe de View Holder para o Adapter de Itens Salvos
* @author Jean Poffo
*/
public class SalvoViewHolder extends RecyclerView.ViewHolder {

    private CardView cardViewSalvo;
    private ImageView imageViewSalvo;
    private TextView textViewTituloSalvo;
    private TextView textViewDescricaoSalvo;

    public SalvoViewHolder(@NonNull View view) {
        super(view);

        this.imageViewSalvo         = view.findViewById(R.id.imageViewSalvo);
        this.cardViewSalvo          = view.findViewById(R.id.cardViewSalvo);
        this.textViewTituloSalvo    = view.findViewById(R.id.textViewTituloSalvo);
        this.textViewDescricaoSalvo = view.findViewById(R.id.textViewDescricaoSalvo);
    }

    // <editor-fold defaultstate="collapsed" desc="Getters">

    public CardView getCardViewSalvo() {
        return cardViewSalvo;
    }

    public ImageView getImageViewSalvo() {
        return imageViewSalvo;
    }

    public TextView getTextViewTituloSalvo() {
        return textViewTituloSalvo;
    }

    public TextView getTextViewDescricaoSalvo() {
        return textViewDescricaoSalvo;
    }

    // </editor-fold>
}