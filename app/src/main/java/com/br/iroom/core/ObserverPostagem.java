package com.br.iroom.core;

import com.br.iroom.model.Postagem;

import java.util.List;

/**
 * Interface para classes que observam alterações nas postagens
 * @author Lucas Fusinato Wilhelm Chiodini Zanis
 */
public interface ObserverPostagem {

    /**
     * Notifica atualização na lista de postagens
     * @param postagem
     */
    void updatePostagens(List<Postagem> postagem);

}
