package com.br.iroom.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Classe de modelo de filtro para o feed
 * @author Lucas Fusinato Wilhelm Chiodini Zanis
 */
public class Filtro implements Parcelable {

    private String palavraChave;
    private String local;
    private double preco;
    private double latitude;
    private double longitude;

    public Filtro() {}

    // <editor-fold defaultstate="collapsed" desc="Getter and Setters">

    public String getPalavraChave() {
        return palavraChave;
    }

    public void setPalavraChave(String palavraChave) {
        this.palavraChave = palavraChave;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Parcelable">

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.palavraChave);
        dest.writeString(this.local);
        dest.writeDouble(this.preco);
        dest.writeDouble(this.latitude);
        dest.writeDouble(this.longitude);
    }

    public Filtro(Parcel in) {
        this.palavraChave = in.readString();
        this.local = in.readString();
        this.preco = in.readDouble();
        this.latitude = in.readDouble();
        this.longitude = in.readDouble();
    }

    public static final Parcelable.Creator<Filtro> CREATOR = new Parcelable.Creator<Filtro>() {
        @Override
        public Filtro createFromParcel(Parcel source) {
            return new Filtro(source);
        }

        @Override
        public Filtro[] newArray(int size) {
            return new Filtro[size];
        }
    };

    // </editor-fold>
}
