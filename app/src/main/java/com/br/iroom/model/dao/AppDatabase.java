package com.br.iroom.model.dao;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.br.iroom.model.Postagem;
import com.br.iroom.model.Quarto;
import com.br.iroom.model.Salvo;
import com.br.iroom.model.Usuario;

/**
 * Classe de Database das DAO's
 * @author Jean Poffo
 */
@Database(entities = {
    Usuario.class,
    Salvo.class,
    Quarto.class,
    Postagem.class
}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
//    public abstract UsuarioDAO usuarioDao();
//    public abstract SalvoDAO salvoDao();
//    public abstract QuartoDAO quartoDao();
//    public abstract PostagemDAO postagemDao();
}