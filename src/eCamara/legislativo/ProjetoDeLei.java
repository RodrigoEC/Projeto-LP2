package eCamara.legislativo;

import java.util.ArrayList;

/**
 * Interface que serve para abstrair os diferentes tipos de lei.
 */

public interface ProjetoDeLei {

    /**
     * Representacao textual que representa o objeto que implementa a interface de projeto de legislativo.
     *
     * @param codigo codigo do projeto.
     * @return a representacao textual do projeto de legislativo.
     */
    String toString(String codigo);

    /**
     * Metodo que retorna os interesses da lei.
     * @return String com os interesses da lei.
     */
    String getInteresses();

    /**
     * Metodo que retorna a situacao atual da lei.
     * @return String com a situacao atual da lei.
     */
    String getSituacao();

    /**
     * Metodo que retorna a tramitacao da lei.
     * @return String com a tramitacao da lei.
     */
    ArrayList<String> getTramitacao();

    /**
     * Metodo que retorna a comissao que deve fazer a votacao da lei.
     * @return String com o nome da comissao que deve fazer a votacao da lei.
     */
    String getVotante();

    /**
     * Metodo que retorna o dni do autor da lei.
     * @return String com o dni do autor da lei.
     */
    String getDniAutor();

    /**
     * Metodo que retorna o tipo da lei, sendo possivel ser "PL", "PLP" ou "PEC"
     * @return o tipo da lei.
     */
    String getTipoLei();

    /** Metodo que retorna toda a tramitacao feita sobre a lei ate o momento. */
    String getTodaTramitacao();

    /**
     * Metodo que modifica a tramitacao.. Recebe um boolean referente a aprovacao da lei.
     *
     * @param aprovadoOuNao boolean referente a aprovacao da lei, se for aprovcado eh true, se foi rejeitado eh false.
     */
    void setTramitacao(boolean aprovadoOuNao);

    /**
     * Metodo que modifica a situacao atual da lei. Recebe o proximo local de votacao.
     * @param estadoAprovacao
     * @param proxLocal String com o proximo local de votacao.
     */
    void setSituacao(boolean estadoAprovacao, String proxLocal);

    /**
     * Metodo que altera a Comissao que deve fazer a votacao da lei. Recebe uma String com a nova comissao.
     * @param votante String com a nova comissao
     */
    void setVotante(String votante);

    /**
     * Metodo que adicona 1 na contagem de votacao da lei.
     */
    void addVotacaoRealizada();

    /**
     * Metodo responsavel por adicionar 1 ao atributo turno.
     */
    void addTurno();

    /**
     * Metodo que retorna se o projeto de lei esta em tramitacao no momento.
     *
     * @return true se estiver em tramitacao e false se nao estiver.
     */
    boolean emTramite();

    /** Metodo que retorna a quantidade de aprovacoes nas votacoes que essa lei possui */
    int getQntAprovacoes();

    /**
     * Metodo responsavel por alterar o numero da lei, alterando para o numero passado como parametro.
     *
     * @param numero novo numero que a lei assumira como sua.
     */
    void setNumeroLei(int numero);

    /** Metodo que retorna o numero da lei, a fim de verificar a "idade" da lei em relacao as outras cadastradas */
    int getNumeroLei();

    /**
     * Metodo responsavel por verificar se a votacao ue esta sendo feita sobre o projeto de lei satisfaz a situacao de quorum minimo.
     *
     * @param deputadosPresentes deputados presentes.
     */
    void situacaoQuorumMinimo(String[] deputadosPresentes);
}
