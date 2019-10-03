package com.br.iroom.view.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.br.iroom.model.Postagem;

import java.util.List;

public class PostagemAdapter extends BaseAdapter {

    private Context context;

    private List<Postagem> postagens;

    public PostagemAdapter(Context context, List<Postagem> postagens) {
        this.context   = context;
        this.postagens = postagens;
    }

    @Override
    public int getCount() {
        return this.postagens.size();
    }

    @Override
    public Object getItem(int position) {
        return this.postagens.get(position);
    }

    @Override
    public long getItemId(int position) {
        return this.postagens.get(position).getCodigo();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}