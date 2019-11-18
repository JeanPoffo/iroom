package com.br.iroom.core;

import android.content.Context;

import com.br.iroom.model.Usuario;
import com.br.iroom.model.dao.Database;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * Classe core do Sistema
 * @author Jean Poffo
 */
public class Core {

    private static final Core instance = new Core();

    private Context applicationContext;

    private Usuario usuario;

    public Usuario getUsuario() {
        return usuario;
    }

    public Context getApplicationContext() {
        return applicationContext;
    }

    public static Core getInstance() {
        return instance;
    }

    private Core() {}

    /**
     * Inicialização do Core
     */
    public void init(Context applicationContext) {
        this.applicationContext = applicationContext;

        this.setupUsuario();
    }

    /**
     * @todo Verificar uma maneira de controlar melhor o FirebaseUser aqui
     */
    private void setupUsuario() {
        final FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        if (firebaseUser != null) {
            //Usuario usuarioLogin = Database.getAppDatabase(this.applicationContext).usuarioDao().findById(firebaseUser.getUid());
            Usuario usuarioLogin = null;

            if(usuarioLogin == null) {
                usuarioLogin = new Usuario();
                usuarioLogin.setToken(firebaseUser.getUid());
                usuarioLogin.setNome(firebaseUser.getDisplayName());
                usuarioLogin.setEmail(firebaseUser.getEmail());
                usuarioLogin.setBiografia("Adoro divir quartos");
                //Database.getAppDatabase(this.applicationContext).usuarioDao().insertAll(usuarioLogin);
            }

            usuarioLogin.setFirebaseUser(firebaseUser);

            if(usuarioLogin.getFirebaseUser().getPhotoUrl() != null) {
                new DownloadBitmapUsuario(usuarioLogin).execute(usuarioLogin.getFirebaseUser().getPhotoUrl());
                /** Desespero */
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ignored) {}
            }
            this.usuario = usuarioLogin;
        }
        else {
            System.exit(0);
        }
    }
}