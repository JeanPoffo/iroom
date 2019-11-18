package com.br.iroom.model.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.br.iroom.model.Usuario;

import java.util.List;

/**
 * Classe de DAO do Usuário
 * @author Jean Poffo
 */
@Dao
public interface UsuarioDAO {

    @Query("SELECT * FROM usuario")
    List<Usuario> getAll();

    @Query("SELECT * FROM salvo WHERE codigo = :token")
    Usuario findById(String token);

    @Insert
    void insertAll(Usuario... usuarios);

    @Delete
    void delete(Usuario usuario);
}