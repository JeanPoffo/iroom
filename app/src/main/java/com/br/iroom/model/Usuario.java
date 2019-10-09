package com.br.iroom.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Classe de Modelo de Usuarios
 * @author Jean Poffo
 * @since 09/10/2019
 */
@Entity
public class Usuario {

    @PrimaryKey
    private long codigo;

    @ColumnInfo(name = "nome")
    private String nome;

    @ColumnInfo(name = "sobrenome")
    private String sobrenome;

    @ColumnInfo(name = "email")
    private String email;

    @ColumnInfo(name = "telefone")
    private int telefone;

    @ColumnInfo(name = "biografia")
    private String biografia;

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
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
}