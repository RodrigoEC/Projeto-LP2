package eCamara.legislativo.propostaMaisRelacionada;

import eCamara.legislativo.ProjetoDeLei;

import java.util.Map;
import java.util.Set;

/**
 * Interface para generalizar as classes Aprovacao, Conclusao e Constitucional, que representam diferentes
 * estrategias para retornar a proposta mais comum com uma pessoa. Essas classes, por sua vez, herdam da
 * classe EstrategiaPropostaAbstract.
 */
public interface EstrategiaProposta {

    /**
     * Metodo responsavel por retornar a proposta mais proxima em relação aos interesses de uma pessoa.
     *
     * @param leis as leis cadastradas.
     * @param interesses os interesses da pessoa.
     *
     * @return o codgio da lei mais proxima da pessoa.
     */
    String pegarPropostaRelacionada(Map<String, ProjetoDeLei> leis, Set<String> interesses);
}
