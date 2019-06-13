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
    void setSituacao(String string);

    String getTramitacao();

    void setTramitacao(boolean aprovadoOuNao);

    String getVotante();

    void setVotante(String votante);

    void addVotacaoRealizada();
}
