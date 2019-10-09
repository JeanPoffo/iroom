package com.br.iroom.model.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.br.iroom.model.Usuario;

import java.util.List;

@Dao
public interface UsuarioDAO {

    @Query("SELECT * FROM usuario")
    List<Usuario> getAll();

    @Insert
    void insertAll(Usuario... usuarios);

    @Delete
    void delete(Usuario usuario);
}