package com.br.iroom.controller;

import android.app.Activity;

public abstract class ControllerBaseActivity extends ControllerBase {

    protected Activity activity;

    public ControllerBaseActivity(Activity activity) {
        this.activity = activity;
    }
}