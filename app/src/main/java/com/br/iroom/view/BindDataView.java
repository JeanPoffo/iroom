package com.br.iroom.view;

/**
 * Interfafce para troca de dados de entidade entre a View e outras classes
 * @author Jean Poffo
 * @since 27/10/2019
 */
public interface BindDataView {

    void bindDataToModel(Object entidade);

    void bindDataFromModel(Object entidade);
}