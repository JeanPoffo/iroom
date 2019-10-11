package com.br.iroom.view.fragment.configuracoes;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.br.iroom.R;

/**
 * Classe Fragment do Menu de Configurações
 * @author Jean Poffo
 */
public class ConfiguracoesFragment extends Fragment {

    private ConfiguracoesViewModel viewModel;

    public static ConfiguracoesFragment newInstance() {
        return new ConfiguracoesFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.configuracoes_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        viewModel = ViewModelProviders.of(this).get(ConfiguracoesViewModel.class);
    }
}