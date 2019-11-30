package com.br.iroom.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.br.iroom.R;
import com.br.iroom.controller.ControllerAdicionarPostagem;
import com.br.iroom.model.Postagem;
import com.br.iroom.view.maps.UdescIbiramaInitialGoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

/**
 * Activity para tela de adicionar postagem.
 * @author Lucas Fusinato Wilhelm Chiodini Zanis
 */
public class AdicionarPostagemActivity extends AppCompatActivity implements BindDataView {

    private ControllerAdicionarPostagem controller;

    private UdescIbiramaInitialGoogleMap map;

    private EditText editTextTitulo;
    private EditText editTextDescricao;
    private EditText editTextQuantidadeQuarto;
    private EditText editTextQuantidadeSuite;
    private EditText editTextPostagemPreco;
    private ImageButton imageButtonSalvar;
    private View adicionarPostagemMap;

    // <editor-fold defaultstate="collapsed" desc="Getters">

    public EditText getEditTextTitulo() {
        return editTextTitulo;
    }

    public EditText getEditTextDescricao() {
        return editTextDescricao;
    }

    public EditText getEditTextQuantidadeQuarto() {
        return editTextQuantidadeQuarto;
    }

    public EditText getEditTextQuantidadeSuite() {
        return editTextQuantidadeSuite;
    }

    public EditText getEditTextPostagemPreco() { return editTextPostagemPreco; }

    public ImageButton getImageButtonSalvar() {
        return imageButtonSalvar;
    }

    public UdescIbiramaInitialGoogleMap getMap() { return map; }

    // </editor-fold>

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_postagem);

        this.map = new UdescIbiramaInitialGoogleMap();

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.adicionarPostagemMap);
        mapFragment.getMapAsync(this.map);

        this.editTextTitulo           = findViewById(R.id.editTextPostagemTitulo);
        this.editTextDescricao        = findViewById(R.id.editTextPostagemDescricao);
        this.editTextQuantidadeQuarto = findViewById(R.id.editTextPostagemQuantidadeQuarto);
        this.editTextQuantidadeSuite  = findViewById(R.id.editTextPostagemQuantidadeSuite);
        this.editTextPostagemPreco    = findViewById(R.id.editTextPostagemPreco);
        this.imageButtonSalvar        = findViewById(R.id.imageButtonAdicionarPostagemSalvar);
        this.adicionarPostagemMap     = findViewById(R.id.adicionarPostagemMap);

        this.controller = new ControllerAdicionarPostagem(this);
    }

    @Override
    public void bindDataToModel(Object entidade) {
        Postagem postagem = (Postagem) entidade;
        postagem.setTitulo(this.getEditTextTitulo().getText().toString());
        postagem.setDescricao(this.getEditTextDescricao().getText().toString());
        postagem.resetQuarto();
        try { postagem.getQuarto().setQuantidadeQuarto(Integer.parseInt(this.getEditTextQuantidadeQuarto().getText().toString())); } catch(NumberFormatException e) {}
        try { postagem.getQuarto().setQuantidadeSuite(Integer.parseInt(this.getEditTextQuantidadeSuite().getText().toString())); } catch(NumberFormatException e) {}
        try { postagem.getQuarto().setPreco(Double.parseDouble(this.getEditTextPostagemPreco().getText().toString())); } catch(NumberFormatException e) {}
        postagem.getQuarto().setLatitude(this.getMap().getLatitude());
        postagem.getQuarto().setLongitude(this.getMap().getLongitude());
    }

    @Override
    public void bindDataFromModel(Object entidade) {
        Postagem postagem = (Postagem) entidade;
        this.getEditTextTitulo().setText(postagem.getTitulo());
        this.getEditTextDescricao().setText(postagem.getDescricao());
        if(postagem.hasQuarto()) {
            this.getEditTextQuantidadeQuarto().setText(postagem.getQuarto().getQuantidadeQuarto());
            this.getEditTextQuantidadeSuite().setText(postagem.getQuarto().getQuantidadeSuite());
            this.getEditTextPostagemPreco().setText(String.valueOf(postagem.getQuarto().getPreco()));
            this.getMap().setLatitude(postagem.getQuarto().getLatitude());
            this.getMap().setLongitude(postagem.getQuarto().getLongitude());
        }
    }
}
