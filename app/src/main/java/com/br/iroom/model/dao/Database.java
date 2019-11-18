package com.br.iroom.model.dao;

import android.content.Context;

import androidx.room.Room;

/**
 * Classe para inicialização de Instancias do RoomDatabase
 * @author Jean Poffo
 */
public class Database {

    private static AppDatabase db;

    public static AppDatabase getAppDatabase(Context context) {
        if(db == null) {
            db = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "database-iroom").allowMainThreadQueries().build();
        }
        return db;
    }
}