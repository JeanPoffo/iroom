package com.br.iroom.view.fragment.feed;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.br.iroom.R;
import com.br.iroom.model.Postagem;
import com.br.iroom.view.adapter.PostagemAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe Fragment do Menu de Feed
 * @author Jean Poffo
 */
public class FeedFragment extends Fragment {

    private RecyclerView recyclerViewPostagens;

    private FeedViewModel viewModel;

    public static FeedFragment newInstance() {
        return new FeedFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.feed_fragment, container, false);

        this.recyclerViewPostagens = view.findViewById(R.id.recyclerViewPostagens);
        this.recyclerViewPostagens.setLayoutManager(new LinearLayoutManager(this.getContext()));

        this.testRecyclerViewPost();

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        viewModel = ViewModelProviders.of(this).get(FeedViewModel.class);
    }

    private void testRecyclerViewPost() {
        List<Postagem> postagens = new ArrayList<>();
        postagens.add(new Postagem(1, "Apartamento Beira Mar", "Apartamento localizado proximo ao mar"));
        postagens.add(new Postagem(2, "Apartamento Na Ladeira", "Barato pra um caramba"));
        postagens.add(new Postagem(3, "Divido apartamento 6 quartos", "Apartamento com custo baixissimo, 4 vagas disponiveis"));

        this.recyclerViewPostagens.setAdapter(new PostagemAdapter(this.getContext(), postagens));
    }
}