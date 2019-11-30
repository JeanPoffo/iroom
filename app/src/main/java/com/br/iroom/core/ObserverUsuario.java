package com.br.iroom.core;

import com.br.iroom.model.Usuario;

/**
 * Interface para classes que observam alterações no usuário
 * @author Lucas Fusinato Wilhelm Chiodini Zanis
 */
public interface ObserverUsuario {

    /**
     * Notifica atualização no usuário
     * @param usuario
     */
    void updateUsuario(Usuario usuario);
}