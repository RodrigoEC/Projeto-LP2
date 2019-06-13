package eCamara.legislativo;

public class PL extends ProjetoDeLeiAbstract {

    private boolean conclusivo;


    /**
     * Construtor responsavel por construir um objeto do tipo PL(projeto de legislativo) a partir do dni do deputado que o criou,
     * do ano em que ele foi criado, da ementa, dos interesses relacionados ao projeto, da url do site em que o projeto
     * esta hospedado e um boolean indicando se o projeto eh conclusivo ou nao.
     *
     * @param dni dni do deputado criador do projeto.
     * @param ano data de criacao do projeto.
     * @param ementa ementa do projeto.
     * @param interesses interesses relacionados ao projeto.
     * @param url url do site em que o projeto esta hospedado.
     * @param conclusivo boolean que representa se o projeto de legislativo eh conclusivo ou nao.
     */
    public PL(String dni, int ano, String ementa, String interesses, String url, boolean conclusivo){
        super(dni, ano, ementa, interesses, url);
        this.conclusivo = conclusivo;
    }

    /**
     * Retorna true se o projeto de lei for conclusivo e false se não for conclusivo.
     *
     * @return true se o projeto de lei for conclusivo e false se não for conclusivo.
     */
    public boolean isConclusivo() {
        return conclusivo;
    }

    @Override
    public void addVotacaoRealizada() {
        if (this.votacaoRealizadas == 2) {
            throw new IllegalArgumentException("Erro ao votar proposta: tramitacao encerrada");
        }
        this.votacaoRealizadas++;
    }

    @Override
    public void setTramitacao(boolean aprovadoOuNao) {
        if (aprovadoOuNao && !"ARQUIVADA".equals(this.situacao) && !"APROVADA".equals(this.situacao)) {
            this.tramitacao += String.format("APROVADO (%s), ",this.votante);
        } else if (!aprovadoOuNao && !"ARQUIVADA".equals(this.situacao) && !"APROVADA".equals(this.situacao)) {
            this.tramitacao += String.format("REJEITADO (%s), ", this.votante);
        }
    }
    @Override
    public void setSituacao(boolean estadoAprovacao, String proxLocal) {
        if (!estadoAprovacao && conclusivo) {
            this.tramitacao += String.format("APROVADO (%s), ",this.votante);
            this.situacao = "ARQUIVADA";
        } else if (this.votacaoRealizadas == 2 && estadoAprovacao && conclusivo) {

            this.tramitacao += String.format("REJEITADO (%s), ", this.votante);
            this.situacao = "APROVADO";
        } else {
            this.situacao = String.format("EM VOTACAO (%s)", proxLocal);
        }
    }

    /**
     * Metodo responsavel por criar uma representacao textual do objeto atraves do dni do autor, da ementa, da conclusao
     * do projeto e da situacao em que ele se encontra.
     *
     * @param codigo codigo do projeto.
     * @return string que representa o objeto.
     */
    public String toString(String codigo){
        if (conclusivo){
            return "Projeto de Lei - " + codigo + " - " + super.dniAutor + " - " + super.ementa + " - Conclusiva - " + super.situacao;
        }
        return "Projeto de Lei - " + codigo + " - " + super.dniAutor + " - " + super.ementa + " - " + super.situacao;
    }
}
