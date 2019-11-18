package com.br.iroom.model.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.br.iroom.model.Postagem;

import java.util.List;

/**
 * Classe de DAO de Postagens
 * @author Jean Poffo
 */
@Dao
public interface PostagemDAO {

    @Query("SELECT * FROM Postagem")
    List<Postagem> getAll();

    @Query("SELECT * FROM salvo WHERE codigo = :codigo")
    Postagem findById(long codigo);

    @Insert
    void insertAll(Postagem... postagens);

    @Delete
    void delete(Postagem postagem);
}
