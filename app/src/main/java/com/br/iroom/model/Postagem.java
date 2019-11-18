package com.br.iroom.model;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe de Modelo de Postagens
 * @author Jean Poffo
 * @since 09/10/2019
 */
@Entity
public class Postagem implements Parcelable {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "codigo")
    private long codigo;

    @ColumnInfo(name = "titulo")
    private String titulo;

    @ColumnInfo(name = "descricao")
    private String descricao;

    @Ignore
    private List<Bitmap> imagem = new ArrayList<>();

    @ForeignKey(entity = Quarto.class, parentColumns = "codigo", childColumns = "quarto")
    @Ignore
    private Quarto quarto;

    @ForeignKey(entity = Usuario.class, parentColumns = "token", childColumns = "usuario")
    @Ignore
    private Usuario usuario;

    @Ignore
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

    // <editor-fold defaultstate="collapsed" desc="Parcelable">

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.codigo);
        dest.writeString(this.titulo);
        dest.writeString(this.descricao);
        dest.writeTypedList(this.imagem);
        dest.writeParcelable(this.quarto, flags);
        dest.writeParcelable(this.usuario, flags);
    }

    protected Postagem(@NotNull Parcel in) {
        this.codigo = in.readLong();
        this.titulo = in.readString();
        this.descricao = in.readString();
        this.imagem = in.createTypedArrayList(Bitmap.CREATOR);
        this.quarto = in.readParcelable(Quarto.class.getClassLoader());
        this.usuario = in.readParcelable(Usuario.class.getClassLoader());
    }

    public static final Creator<Postagem> CREATOR = new Creator<Postagem>() {
        @Override
        public Postagem createFromParcel(Parcel source) {
            return new Postagem(source);
        }

        @Override
        public Postagem[] newArray(int size) {
            return new Postagem[size];
        }
    };

    // </editor-fold>
}