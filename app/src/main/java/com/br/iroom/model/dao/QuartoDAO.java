package com.br.iroom.model.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.br.iroom.model.Quarto;

import java.util.List;

/**
 * Classe de DAO de Quartos
 * @author Jean Poffo
 */
@Dao
public interface QuartoDAO {

    @Query("SELECT * FROM quarto")
    List<Quarto> getAll();

    @Query("SELECT * FROM salvo WHERE codigo = :codigo")
    Quarto findById(long codigo);

    @Insert
    void insertAll(Quarto... quartos);

    @Delete
    void delete(Quarto quarto);
}