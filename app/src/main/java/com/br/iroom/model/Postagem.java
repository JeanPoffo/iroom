package com.br.iroom.model;

import android.graphics.Bitmap;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe de Modelo de Postagens
 * @author Jean Poffo
 * @since 09/10/2019
 */
public class Postagem {

    private long codigo;
    private String titulo;
    private String descricao;
    private List<Bitmap> imagem = new ArrayList<>();
    private Quarto quarto;
    private Usuario usuario;

    public Postagem(long codigo, String titulo, String descricao) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.descricao = descricao;
    }

    public Postagem() {}

    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Bitmap> getImagem() {
        return imagem;
    }

    public void setImagem(List<Bitmap> imagem) {
        this.imagem = imagem;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    // </editor-fold>
}