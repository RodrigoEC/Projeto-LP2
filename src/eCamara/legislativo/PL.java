package eCamara.legislativo;

/**
 * Objeto que representa um Projeto de Lei, herda atributos e metodos de ProjetoDeLeiAbstract. Unico atributo que a PL tem a mais
 * eh o boolean conclusivo.
 */

public class PL extends ProjetoDeLeiAbstract {

    /**
     * Atributo responsavel por determinar se uma pl eh conclusivo. se o atributo for true, implica em uma pl conclusiva,
     * se o atributo for false implica em uma pl nao conclusiva.
     */
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

    /**
     * Metodoq ue adciona mais 1 na contagem de quantas votacoes foram realizada. Porem se o contador ja tiver atingido o
     * valor de 2 e esse metodo for chamado sera lancado excecao.
     *
     * @throws IllegalArgumentException Erro ao votar proposta: tramitacao encerrada
     */
    @Override
    public void addVotacaoRealizada() {
        if (this.votacaoRealizadas == 2) {
            throw new IllegalArgumentException("Erro ao votar proposta: tramitacao encerrada");
        }
        this.votacaoRealizadas++;
    }

    /**
     * Metodo que adiciona APROVADO ou REGEITADO na tramitacao. Recebe um boolean referente a aprovacao da lei
     * se ela foi aprovada e a situacao dela nao esta como ARQUIVADA e APROVADA, entao eh adicionado "APROVADO (votante)"
     * onde votante eh a comissao que fez a votacao. Se a lei nao foi aprovada e  a situacao nao esta como ARQUIVADA
     * e APROVADA entao eh adcionado "REJEITADA (votante)".
     * @param aprovadoOuNao boolean referente a aprovacao da lei, se for aprovcado eh true, se foi rejeitado eh false.
     */
    @Override
    public void setTramitacao(boolean aprovadoOuNao) {
        if (aprovadoOuNao && !"ARQUIVADO".equals(this.situacao) && !"APROVADO".equals(this.situacao)) {
            this.tramitacao += String.format("APROVADO (%s), ",this.votante);

        } else if (!aprovadoOuNao && !"ARQUIVADO".equals(this.situacao) && !"APROVADO".equals(this.situacao)) {
            this.tramitacao += String.format("REJEITADO (%s), ", this.votante);
        }
    }

    /**
     * Metodo que muda a situacao da lei. Recebe o proximo local de votacao e um boolean referente ao estado de aprovacao.
     * Se ela nao foi aprovada e eh conclusiva, entao a situacao vai ser alterada pra ARQUIVADA e na tramitacao vai ser
     * adicionado "APROVADO (votante)" onde votante eh a comissao que fez a votacao. Se ela foi aprovada, ja houve duas votacoes
     * e eh conclusiva entao na tramitacao vai ser adcionado "REGEITADO (votante)" e a situacao ira ser alterada para "APROVADO".
     * Se nao  a situacao vai ser alterada para "EM VOTACAO (proximo local).
     *
     * @param estadoAprovacao boolean referente ao estado de aprovacao da lei.
     * @param proxLocal String com o proximo local de votacao.
     */
    @Override
    public void setSituacao(boolean estadoAprovacao, String proxLocal) {
        if (!estadoAprovacao && conclusivo) {
            this.tramitacao += String.format("APROVADO (%s), ",this.votante);
            this.situacao = "ARQUIVADO";

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
