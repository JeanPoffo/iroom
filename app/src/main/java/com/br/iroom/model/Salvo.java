package com.br.iroom.model;

/**
 * Classe de Modelo de para Salvar Postagem
 * @author Jean Poffo
 * @since 26/10/2019
 */
public class Salvo {

    private long codigo;

    private Postagem postagem;

    private Usuario usuario;

    public Salvo(long codigo, Postagem postagem, Usuario usuario) {
        this.codigo = codigo;
        this.postagem = postagem;
        this.usuario = usuario;
    }

    public Salvo() {}

    // <editor-fold defaultstate="collapsed" desc="Getter and Setters">

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public Postagem getPostagem() {
        return postagem;
    }

    public void setPostagem(Postagem postagem) {
        this.postagem = postagem;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    // </editor-fold>
}