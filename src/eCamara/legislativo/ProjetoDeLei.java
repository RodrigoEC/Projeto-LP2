package eCamara.legislativo;

/**
 * Interface que serve para abstrair os diferentes tipos de lei.
 */

public interface ProjetoDeLei {

    /**
     * Representacao textual que representa o objeto que implemeneta a interface de projeto de legislativo.
     *
     * @param codigo codigo do projeto.
     * @return a representacao textual do projeto de legislativo.
     */
    String toString(String codigo);

    /**
     * Metodoq que retorna os interesses da lei.
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
    String getTramitacao();

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

}
