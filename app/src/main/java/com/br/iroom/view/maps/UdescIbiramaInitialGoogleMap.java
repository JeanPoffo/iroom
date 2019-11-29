package com.br.iroom.view.maps;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Callback para
 */
public class UdescIbiramaInitialGoogleMap implements OnMapReadyCallback, GoogleMap.OnMapClickListener {

    private GoogleMap mMap;
    private double latitude;
    private double longitude;

    public UdescIbiramaInitialGoogleMap() {
        this.latitude = -27.0599736;
        this.longitude = -49.5391181;
    }

    // <editor-fold defaultstate="collapsed" desc="Getters">

    public GoogleMap getGoogleMap() {
        return mMap;
    }

    public double getLongitude() { return longitude; }

    public double getLatitude() { return latitude; }

    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Setters">

    public void setLongitude(double longitude) { this.longitude = longitude; }

    public void setLatitude(double latitude) { this.latitude = latitude; }

    // </editor-fold>

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setOnMapClickListener(this);
        updateMarker();
    }

    @Override
    public void onMapClick(LatLng latLng) {
        latitude = latLng.latitude;
        longitude = latLng.longitude;
        updateMarker();
    }

    private void updateMarker() {
        mMap.clear();
        LatLng position = new LatLng(this.getLatitude(), this.getLongitude());
        MarkerOptions marker = new MarkerOptions().position(position);
        mMap.addMarker(marker);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(position));
    }
}
