package com.br.iroom.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;

import com.br.iroom.R;
import com.br.iroom.controller.ControllerEditPerfil;
import com.br.iroom.model.Usuario;

/**
 * Classe Activity da Edição de Perfil
 * @author Jean Poffo
 */
public class PerfilEditActivity extends AppCompatActivity implements BindDataView{

    private EditText editTextNome;
    private EditText editTextEmail;
    private EditText editTextBiografia;
    private ImageButton imageButtonSalvar;

    private ControllerEditPerfil controller;

    // <editor-fold defaultstate="collapsed" desc="Getters">

    public EditText getEditTextNome() {
        return editTextNome;
    }

    public EditText getEditTextEmail() {
        return editTextEmail;
    }

    public EditText getEditTextBiografia() {
        return editTextBiografia;
    }

    public ImageButton getImageButtonSalvar() {
        return imageButtonSalvar;
    }

    // </editor-fold>

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_edit);

        this.editTextNome      = findViewById(R.id.editTextEditPerfilNome);
        this.editTextEmail     = findViewById(R.id.editTexteditPerfilEmail);
        this.editTextBiografia = findViewById(R.id.editTextEditPerfilBiografia);
        this.imageButtonSalvar = findViewById(R.id.imageButtonEditPerfilSalvar);

        this.controller = new ControllerEditPerfil(this);
    }

    @Override
    public void bindDataToModel(Object entidade) {
        Usuario usuario = (Usuario) entidade;
        usuario.setNome(this.getEditTextNome().getText().toString());
        usuario.setEmail(this.getEditTextEmail().getText().toString());
        usuario.setBiografia(this.getEditTextBiografia().getText().toString());
    }

    @Override
    public void bindDataFromModel(Object entidade) {
        Usuario usuario = (Usuario) entidade;
        this.getEditTextNome().setText(usuario.getNome());
        this.getEditTextEmail().setText(usuario.getEmail());
        this.getEditTextBiografia().setText(usuario.getBiografia());
    }
}