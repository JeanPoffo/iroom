package com.br.iroom.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

/**
 * Classe de Modelo de para Salvar Postagem
 * @author Jean Poffo
 * @since 26/10/2019
 */
@Entity
public class Salvo implements Parcelable {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "codigo")
    private long codigo;

    @ForeignKey(entity = Postagem.class, parentColumns = "codigo", childColumns = "postagem")
    @Ignore
    private Postagem postagem;

    @ForeignKey(entity = Usuario.class, parentColumns = "token", childColumns = "usuario")
    @Ignore
    private Usuario usuario;

    @Ignore
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

    // <editor-fold defaultstate="collapsed" desc="Parcelable">
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.codigo);
        dest.writeParcelable(this.postagem, flags);
        dest.writeParcelable(this.usuario, flags);
    }

    protected Salvo(Parcel in) {
        this.codigo = in.readLong();
        this.postagem = in.readParcelable(Postagem.class.getClassLoader());
        this.usuario = in.readParcelable(Usuario.class.getClassLoader());
    }

    public static final Parcelable.Creator<Salvo> CREATOR = new Parcelable.Creator<Salvo>() {
        @Override
        public Salvo createFromParcel(Parcel source) {
            return new Salvo(source);
        }

        @Override
        public Salvo[] newArray(int size) {
            return new Salvo[size];
        }
    };

    // </editor-fold>
}