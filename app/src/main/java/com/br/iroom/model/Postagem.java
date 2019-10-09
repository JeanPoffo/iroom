package com.br.iroom.model;

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
    private Usuario usuario;
    private List<Imagem> imagens;

    public Postagem(long codigo, String titulo, String descricao) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.descricao = descricao;
        this.imagens = new ArrayList<>();
    }

    public Postagem() {}

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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Imagem> getImagens() {
        return imagens;
    }

    public void setImagens(List<Imagem> imagens) {
        this.imagens = imagens;
    }
}