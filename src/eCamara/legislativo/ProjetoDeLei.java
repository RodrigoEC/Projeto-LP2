package eCamara.legislativo;

public interface ProjetoDeLei {

    /**
     * Representacao textual que representa o objeto que implemeneta a interface de projeto de legislativo.
     *
     * @param codigo codigo do projeto.
     * @return a representacao textual do projeto de legislativo.
     */
    String toString(String codigo);

    String getInteresses();

    String getSituacao();

    String getTramitacao();

    String getVotante();

    String getDniAutor();

    void setTramitacao(boolean aprovadoOuNao);

    void setSituacao(boolean estadoAprovacao, String proxLocal);

    void setVotante(String votante);

    void addVotacaoRealizada();
}
