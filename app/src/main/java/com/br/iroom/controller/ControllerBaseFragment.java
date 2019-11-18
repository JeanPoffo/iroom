package com.br.iroom.controller;

import androidx.fragment.app.Fragment;

public abstract class ControllerBaseFragment extends ControllerBase {

    private Fragment fragment;

    public ControllerBaseFragment(Fragment fragment) {
        this.fragment = fragment;
    }
}