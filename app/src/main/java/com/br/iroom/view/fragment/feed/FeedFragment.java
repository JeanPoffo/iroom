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
import com.br.iroom.core.LocalDatabase;
import com.br.iroom.view.adapter.PostagemAdapter;

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

<<<<<<< HEAD
        PostagemAdapter postagemAdapter = new PostagemAdapter(this.getContext(), LocalDatabase.getInstance().getListPostagemFeed());
        LocalDatabase.getInstance().addObserverPostagem(postagemAdapter);
        this.recyclerViewPostagens.setAdapter(postagemAdapter);
=======
        this.recyclerViewPostagens.setAdapter(new PostagemAdapter(this.getContext(), LocalDatabase.getInstance().getListPostagemFeed()));
>>>>>>> 79c757ba65370b1ec1f557cd37c75ebe12f51b96

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        viewModel = ViewModelProviders.of(this).get(FeedViewModel.class);
    }
}