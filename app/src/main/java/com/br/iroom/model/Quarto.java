package com.br.iroom.model;

/**
 * Classe de Modelo de Quatos
 * @author Jean Poffo
 * @since 26/10/2019
 */
public class Quarto {

    private long codigo;
    private int quantidadeQuarto;
    private int quantidadeSuite;
    private long latitude;
    private long longitude;

    public Quarto(int quantidadeQuarto, int quantidadeSuite, long latitude, long longitude) {
        this.quantidadeQuarto = quantidadeQuarto;
        this.quantidadeSuite = quantidadeSuite;
        this.latitude = latitude;
        this.longitude = longitude;
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

    public long getLatitude() {
        return latitude;
    }

    public void setLatitude(long latitude) {
        this.latitude = latitude;
    }

    public long getLongitude() {
        return longitude;
    }

    public void setLongitude(long longitude) {
        this.longitude = longitude;
    }

    // </editor-fold>
}