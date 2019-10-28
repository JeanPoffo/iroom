package com.br.iroom.model;

/**
 * Classe de Modelo de Usuarios
 * @author Jean Poffo
 * @since 09/10/2019
 */
public class Usuario {

    private long codigo;
    private String senha;
    private String nome;
    private String sobrenome;
    private String email;
    private int telefone;
    private String biografia;

    // <editor-fold defaultstate="collapsed" desc="Getter and Setters">
    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }
    // </editor-fold>
}