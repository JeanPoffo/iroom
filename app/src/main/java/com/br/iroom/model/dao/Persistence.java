package com.br.iroom.model.dao;

import android.content.Context;

import androidx.room.Room;

/**
 * Classe de Persistencia
 * @author Jean Poffo
 * @since 10/10/2019
 */
public class Persistence {

    public static AppDatabase getAppDatabase(Context context) {
        return Room.databaseBuilder(context, AppDatabase.class, "iroom-database").allowMainThreadQueries().build();
    }
}