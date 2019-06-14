package eCamara.legislativo;

import eCamara.individuo.Pessoa;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


/**
 * Objeto que representa uma Comissao de votacao, tem como atributos uma string com o tema e o map com os politicos que fazem parte dela.
 */

public class Comissao {

    /**
     * Tema da comissao.
     */
    private String tema;
    /**
     * Politicos que fazem parte da comissao.
     */
    private HashMap<String, Pessoa> mapDeputados;

    /**
     * Constroi a Comissao, recebe uma string com o tema e mapa de politicos.
     * @param tema String com o tema.
     * @param mapDeputados Map com os politicos.
     */
    public  Comissao(String tema, HashMap<String, Pessoa> mapDeputados){
        this.mapDeputados = mapDeputados;
        this.tema =  tema;
    }

    /**
     * Metodo que verifica se duas Comissoes sao iguais, duas comissoes sao iguais se tiverem o mesmo tema e forem do mesmo tipo.
     * Retorna true se forem iguais e false se nao forem.
     *
     * @param o Objeto a ser comparado.
     * @return boolean True se forem iguais e False se forem diferentes.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comissao comissao = (Comissao) o;
        return Objects.equals(tema, comissao.tema);
    }

    /**
     * Metodo que calcula o hashcode de Comissao, o hashcode eh calculado a partir do atribto tema.
     *
     * @return Inteiro referente ao calculo do hashcode.
     */
    @Override
    public int hashCode() {
        return Objects.hash(tema);
    }

    /**
     * Metodo que retorna o mapa de Deputados que fazem parte da comissao.
     * @return HashMap de Pessoa.
     */
    public HashMap<String, Pessoa> getMapDeputados() {
        return mapDeputados;
    }

    /**
     * Metodo que retorna a quantidade de Deputado que fazem parte da Comissao.
     * @return Inteiro referente a quantidade de Deputados que fazem parte da comissao.
     */
    public int tamanhoComissao() {
        return this.mapDeputados.size();
    }
}
