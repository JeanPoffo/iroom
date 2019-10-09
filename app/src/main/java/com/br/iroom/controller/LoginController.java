package com.br.iroom.controller;

import android.content.Context;

import androidx.room.Room;

import com.br.iroom.model.Usuario;
import com.br.iroom.model.dao.AppDatabase;

import java.util.List;

/**
 * Classe de Controller do Login
 * @author Jean Poffo
 * @since 09/10/2019
 */
public class LoginController {

    private Context context;

    public void salvarUsuario(Usuario usuario){
        AppDatabase db = Room.databaseBuilder(this.context, AppDatabase.class, "iroom-database").allowMainThreadQueries().build();
        db.usuarioDao().insertAll(usuario);
    }

    public List<Usuario> buscarUsuario(){
        AppDatabase db = Room.databaseBuilder(this.context, AppDatabase.class, "iroom-database").allowMainThreadQueries().build();
        return db.usuarioDao().getAll();
    }
}