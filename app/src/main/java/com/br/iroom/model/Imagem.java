package com.br.iroom.model;

import android.graphics.Bitmap;

/**
 * Classe de Modelo das Imagens da Postagem
 * @author Jean Poffo
 * @since 09/10/2019
 */
public class Imagem {

    private long codigo;
    private String descricao;
    private String endereco;
    private Bitmap imagem;

    public Imagem(Bitmap imagem) {
        this.imagem = imagem;
    }

    public Imagem() {}

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Bitmap getImagem() {
        return imagem;
    }

    public void setImagem(Bitmap imagem) {
        this.imagem = imagem;
    }
}