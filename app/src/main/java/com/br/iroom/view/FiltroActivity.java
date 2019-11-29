package com.br.iroom.view;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.br.iroom.R;
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
public class FiltroActivity extends FragmentActivity {

    private UdescIbiramaInitialGoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filtro);

        this.map = new UdescIbiramaInitialGoogleMap();

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this.map);
    }
}
