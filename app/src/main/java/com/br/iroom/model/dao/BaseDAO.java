package com.br.iroom.model.dao;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Update;

public interface BaseDAO <E> {

    @Insert void insert(E... entity);

    @Update void update(E entity);

    @Delete void delete(E... entity);
}