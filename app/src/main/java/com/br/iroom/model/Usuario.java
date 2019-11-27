package com.br.iroom.model;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.firebase.auth.FirebaseUser;

/**
 * Classe de Modelo de Usuarios
 * @author Jean Poffo
 * @since 09/10/2019
 */
@Entity
public class Usuario implements Parcelable {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "token")
    private String token;

    @ColumnInfo(name = "nome")
    private String nome;

    @ColumnInfo(name = "email")
    private String email;

    @ColumnInfo(name = "telefone")
    private String telefone;

    @ColumnInfo(name = "biografia")
    private String biografia;

    @Ignore
    private Bitmap fotoPerfil;

    @Ignore
    private FirebaseUser firebaseUser;

    public Usuario() {}

    @Ignore
    public Usuario(String nome, String email, String telefone, String biografia) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.biografia = biografia;
    }

    // <editor-fold defaultstate="collapsed" desc="Getter and Setters">

    @NonNull
    public String getToken() {
        return token;
    }

    public void setToken(@NonNull String token) {
        this.token = token;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public Bitmap getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(Bitmap fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    public FirebaseUser getFirebaseUser() {
        return firebaseUser;
    }

    public void setFirebaseUser(FirebaseUser firebaseUser) {
        this.firebaseUser = firebaseUser;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Parcelable">

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.token);
        dest.writeString(this.nome);
        dest.writeString(this.email);
        dest.writeString(this.telefone);
        dest.writeString(this.biografia);
        dest.writeParcelable(this.firebaseUser, flags);
        dest.writeParcelable(this.fotoPerfil, flags);
    }

    protected Usuario(Parcel in) {
        this.token = in.readString();
        this.nome = in.readString();
        this.email = in.readString();
        this.telefone = in.readString();
        this.biografia = in.readString();
        this.firebaseUser = in.readParcelable(FirebaseUser.class.getClassLoader());
        this.fotoPerfil = in.readParcelable(Bitmap.class.getClassLoader());
    }

    public static final Parcelable.Creator<Usuario> CREATOR = new Parcelable.Creator<Usuario>() {
        @Override
        public Usuario createFromParcel(Parcel source) {
            return new Usuario(source);
        }

        @Override
        public Usuario[] newArray(int size) {
            return new Usuario[size];
        }
    };

    // </editor-fold>
}