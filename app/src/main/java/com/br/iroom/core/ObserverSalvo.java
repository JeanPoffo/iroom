package com.br.iroom.core;

import com.br.iroom.model.Postagem;
import com.br.iroom.model.Salvo;

import java.util.List;

/**
 * Interface para classes que observam alterações nas postagens salvas
 * @author Lucas Fusinato Wilhelm Chiodini Zanis
 */
public interface ObserverSalvo {

    /**
     * Notifica atualização na lista de salvos
     * @param salvos
     */
    void updateSalvos(List<Salvo> salvos);
}
