package eCamara.individuo;

import eCamara.individuo.Funcao;

public class SemFuncao implements Funcao {
    /**
     * metodo que recebe uma string que eh a representacao textual da pessoa e retorna essa representacao da mesma forma,
     * uma vez que a pessoa que possuir um atributo do tipo SemFuncao nao tera funcao na politica, fazendo que sua representacao
     * como politico seja igual a sua representacao como pessoa.
     *
     * @param toString representacao textual da pessoa.
     * @return a representacao textual da pessoa.
     */
    public String toString(String toString){
        return toString;
    }
}
