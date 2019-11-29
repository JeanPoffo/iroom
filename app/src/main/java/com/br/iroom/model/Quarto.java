package com.br.iroom.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

/**
 * Classe de Modelo de Quatos
 * @author Jean Poffo
 * @since 26/10/2019
 */
@Entity
public class Quarto implements Parcelable {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "codigo")
    private long codigo;

    @ColumnInfo(name = "quantidadeQuarto")
    private int quantidadeQuarto;

    @ColumnInfo(name = "quantidadeSuite")
    private int quantidadeSuite;

    @ColumnInfo(name = "latitude")
    private double latitude;

    @ColumnInfo(name = "longitude")
    private double longitude;

    @Ignore
    public Quarto(long codigo, int quantidadeQuarto, int quantidadeSuite) {
        this.codigo = codigo;
        this.quantidadeQuarto = quantidadeQuarto;
        this.quantidadeSuite = quantidadeSuite;
    }

    public Quarto() {}

    // <editor-fold defaultstate="collapsed" desc="Getter and Setters">

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public int getQuantidadeQuarto() {
        return quantidadeQuarto;
    }

    public void setQuantidadeQuarto(int quantidadeQuarto) {
        this.quantidadeQuarto = quantidadeQuarto;
    }

    public int getQuantidadeSuite() {
        return quantidadeSuite;
    }

    public void setQuantidadeSuite(int quantidadeSuite) {
        this.quantidadeSuite = quantidadeSuite;
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
        dest.writeLong(this.codigo);
        dest.writeInt(this.quantidadeQuarto);
        dest.writeInt(this.quantidadeSuite);
        dest.writeDouble(this.latitude);
        dest.writeDouble(this.longitude);
    }

    protected Quarto(Parcel in) {
        this.codigo = in.readLong();
        this.quantidadeQuarto = in.readInt();
        this.quantidadeSuite = in.readInt();
        this.latitude = in.readDouble();
        this.longitude = in.readDouble();
    }

    public static final Creator<Quarto> CREATOR = new Creator<Quarto>() {
        @Override
        public Quarto createFromParcel(Parcel source) {
            return new Quarto(source);
        }

        @Override
        public Quarto[] newArray(int size) {
            return new Quarto[size];
        }
    };

    // </editor-fold>
}