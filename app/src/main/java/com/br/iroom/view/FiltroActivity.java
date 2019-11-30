package com.br.iroom.view;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.SeekBar;

import com.br.iroom.R;
import com.br.iroom.controller.ControllerFiltro;
import com.br.iroom.model.Filtro;
import com.br.iroom.view.maps.UdescIbiramaInitialGoogleMap;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Classe de Activity da Tela de Filtros
 * @author Jean Poffo
 */
public class FiltroActivity extends FragmentActivity implements BindDataView {

    private ImageButton imageButtonFiltro;
    private EditText editTextFiltroPalavraChave;
    private EditText editTextFiltroLocal;
    private SeekBar seekBarFiltroPreco;

    private UdescIbiramaInitialGoogleMap map;

    private ControllerFiltro controller;

    // <editor-fold defaultstate="collapsed" desc="Getters">

    public ImageButton getImageButtonFiltro() { return imageButtonFiltro; }

    // </editor-fold>

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filtro);

        this.imageButtonFiltro = findViewById(R.id.imageButtonFiltro);
        this.editTextFiltroPalavraChave = findViewById(R.id.editTextFiltroPalavraChave);
        this.editTextFiltroLocal = findViewById(R.id.editTextFiltroLocal);
        this.seekBarFiltroPreco = findViewById(R.id.seekBarFiltroPreco);

        this.map = new UdescIbiramaInitialGoogleMap();

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this.map);

        this.controller = new ControllerFiltro(this);
    }

    @Override
    public void bindDataToModel(Object entidade) {
        Filtro filtro = (Filtro) entidade;
        filtro.setPalavraChave(this.editTextFiltroPalavraChave.getText().toString());
        filtro.setLatitude(this.map.getLatitude());
        filtro.setLongitude(this.map.getLongitude());
        filtro.setLocal(this.editTextFiltroLocal.getText().toString());
    }

    @Override
    public void bindDataFromModel(Object entidade) {
        Filtro filtro = (Filtro) entidade;
        this.editTextFiltroPalavraChave.setText(filtro.getPalavraChave());
        this.editTextFiltroLocal.setText(filtro.getLocal());
        this.map.setLatitude(filtro.getLatitude());
        this.map.setLongitude(filtro.getLongitude());

        this.map = new UdescIbiramaInitialGoogleMap();

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this.map);
    }
}
