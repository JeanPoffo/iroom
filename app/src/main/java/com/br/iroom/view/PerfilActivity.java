package com.br.iroom.view;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.br.iroom.R;
import com.br.iroom.controller.ControllerPerfil;
import com.br.iroom.model.Usuario;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Classe de Activity do Perfil
 * @author Jean Poffo
 */
public class PerfilActivity extends AppCompatActivity implements BindDataView {

    private CircleImageView imageViewImagemPerfil;
    private TextView textViewNome;
    private TextView textViewEndereco;
    private TextView textViewDescricao;
    private ImageButton imageButtonAdicionarQuarto;
    private ImageButton imageButtonEditarPerfil;

    private ControllerPerfil controller;

    // <editor-fold defaultstate="collapsed" desc="Getters">

    public CircleImageView getImageViewImagemPerfil() {
        return imageViewImagemPerfil;
    }

    public TextView getTextViewNome() {
        return textViewNome;
    }

    public TextView getTextViewEndereco() {
        return textViewEndereco;
    }

    public TextView getTextViewDescricao() {
        return textViewDescricao;
    }

    public ImageButton getImageButtonAdicionarQuarto() {
        return imageButtonAdicionarQuarto;
    }

    public ImageButton getImageButtonEditarPerfil() {
        return imageButtonEditarPerfil;
    }

    // </editor-fold>

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        this.imageViewImagemPerfil      = findViewById(R.id.imageViewPerfil);
        this.textViewNome               = findViewById(R.id.textVieweditPerfilBiografia);
        this.textViewEndereco           = findViewById(R.id.textViewEndereco);
        this.textViewDescricao          = findViewById(R.id.textViewDescricao);
        this.imageButtonAdicionarQuarto = findViewById(R.id.imageButtonAdicionarQuarto);
        this.imageButtonEditarPerfil    = findViewById(R.id.imageButtonEditarPerfil);

        this.controller = new ControllerPerfil(this);
    }

    @Override
    public void bindDataToModel(Object entidade) {}

    @Override
    public void bindDataFromModel(Object entidade) {
        Usuario usuario = (Usuario) entidade;
        this.imageViewImagemPerfil.setImageBitmap(usuario.getFotoPerfil());
        this.textViewNome.setText(usuario.getNome());
        this.textViewDescricao.setText(usuario.getBiografia());

        //Verificar
        this.textViewEndereco.setText("Rua Palmeirinha 185");
    }
}