package com.br.iroom.model.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.br.iroom.model.Salvo;

import java.util.List;

/**
 * Classe de DAO de Postagens Salvas
 * @author Jean Poffo
 */
@Dao
public interface SalvoDAO {

    @Query("SELECT * FROM salvo")
    List<Salvo> getAll();

    @Query("SELECT * FROM salvo WHERE codigo = :codigo")
    Salvo findById(long codigo);

    @Insert
    void insertAll(Salvo... salvos);

    @Delete
    void delete(Salvo salvo);
}