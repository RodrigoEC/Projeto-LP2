package eCamara.individuo;

import java.io.Serializable;

/**
 * Funcao Civil de Pessoa, pois se uma Pessoa nao eh politico ela eh Civil.
 */

public class Civil implements Funcao, Serializable {
    /**
     * metodo que recebe uma string que eh a representacao textual da pessoa e retorna essa representacao da mesma forma,
     * uma vez que a pessoa que possuir um atributo do tipo Civil nao tera funcao na politica, fazendo que sua representacao
     * como politico seja igual a sua representacao como pessoa.
     *
     * @param toString representacao textual da pessoa.
     * @return a representacao textual da pessoa.
     */
    public String toString(String toString){
        return toString;
    }

    /**
     * Metodo que retona a quantidade de leis.
     * @return Inteiro 45.
     */
    @Override
    public int getQtdLeis() {
        return 0;
    }

    /**
     * Metodo que adiciona lei, porem um civil nao tem lei, entao nao faz nada.
     */
    @Override
    public void addLei() {
    }
}
