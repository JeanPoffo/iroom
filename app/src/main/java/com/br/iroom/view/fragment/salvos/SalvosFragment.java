package com.br.iroom.view.fragment.salvos;

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
import com.br.iroom.view.adapter.SalvoAdapter;

/**
 * Classe Fragment do Menu de Salvos
 * @author Jean Poffo
 */
public class SalvosFragment extends Fragment {

    private RecyclerView recyclerViewSalvos;

    private SalvosViewModel viewModel;

    public static SalvosFragment newInstance() {
        return new SalvosFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.salvos_fragment, container, false);

        this.recyclerViewSalvos = view.findViewById(R.id.recyclerViewSalvos);
        this.recyclerViewSalvos.setLayoutManager(new LinearLayoutManager(this.getContext()));

        this.recyclerViewSalvos.setAdapter(new SalvoAdapter(this.getContext(), LocalDatabase.getInstance().getListPostagemSalvo()));

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel = ViewModelProviders.of(this).get(SalvosViewModel.class);
    }
}