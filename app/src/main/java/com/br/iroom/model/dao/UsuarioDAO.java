package com.br.iroom.model.dao;

import androidx.room.Dao;
import androidx.room.Query;

import com.br.iroom.model.Usuario;

import java.util.List;

@Dao
public interface UsuarioDAO extends BaseDAO<Usuario> {

    @Query("SELECT * FROM usuario WHERE codigo = :codigo")
    List<Usuario> get(int codigo);

    @Query("SELECT * FROM usuario")
    List<Usuario> getAll();

    @Query("SELECT * FROM usuario WHERE email = :email and senha = :senha")
    Usuario getUsuarioLogin(String email, String senha);
}