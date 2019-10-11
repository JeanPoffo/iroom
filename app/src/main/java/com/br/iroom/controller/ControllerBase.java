package com.br.iroom.controller;

import android.app.Activity;

public abstract class ControllerBase {

    Activity activity;

    ControllerBase(Activity activity) {
        this.activity = activity;
        this.addListeners();
    }

    abstract void addListeners();
}