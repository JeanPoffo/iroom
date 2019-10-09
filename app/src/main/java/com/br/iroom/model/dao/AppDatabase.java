package com.br.iroom.model.dao;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.br.iroom.model.Usuario;

@Database(entities = {Usuario.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UsuarioDAO usuarioDao();
}