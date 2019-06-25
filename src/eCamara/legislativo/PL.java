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
        this.tipoLei = "PL";

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
     * Metodo que adiciona mais 1 na contagem de quantas votacoes foram realizada. Porem se o contador ja tiver atingido o
     * valor de 2 e esse metodo for chamado sera lancado excecao.
     *
     * @throws IllegalArgumentException Erro ao votar proposta: tramitacao encerrada
     */
    @Override
    public void addVotacaoRealizada() {
        if (this.votacaoRealizadas == 2 && this.conclusivo) {
            throw new IllegalArgumentException("Erro ao votar proposta: tramitacao encerrada");
        }
        this.votacaoRealizadas++;
    }

    /** Metodo responsavel por adicionar 1 ao atributo turno.*/
    @Override
    public void addTurno() {
    }


    /**
     * Metodo que adiciona APROVADO ou REJEITADO na tramitacao. Recebe um boolean referente a aprovacao da lei
     * se ela foi aprovada e a situacao dela nao esta como ARQUIVADA e APROVADA, entao eh adicionado "APROVADO (votante)"
     * onde votante eh a comissao que fez a votacao. Se a lei nao foi aprovada e  a situacao nao esta como ARQUIVADA
     * e APROVADA entao eh adcionado "REJEITADA (votante)".
     * @param aprovadoOuNao boolean referente a aprovacao da lei, se for aprovcado eh true, se foi rejeitado eh false.
     */
    @Override
    public void setTramitacao(boolean aprovadoOuNao) {
        if (aprovadoOuNao && !"ARQUIVADO".equals(this.situacao) && !"APROVADO".equals(this.situacao)) {
            this.tramitacao += String.format("APROVADO (%s), ",this.votante);
            super.qntAprovacoes += 1;

        } else if (!aprovadoOuNao && !"ARQUIVADO".equals(this.situacao) && !"APROVADO".equals(this.situacao)) {
            this.tramitacao += String.format("REJEITADO (%s), ", this.votante);
        }
    }

    /**
     * Metodo responsavel por modificar a situacao do projeto na camara.
     * - Caso o resultado da votacao seja FALSE e a quantidade de turnos seja igual a 2 o a string "REJEITADO ([votante])
     * eh adicionado ao atributo tramitacao e a situcao eh modificada para "ARQUIVADO".
     * - Caso o estadoAprovacao seja true e a quantidade de turnos seja iguala a 2 a string "APROVADO ([votante]) eh
     * adicionado ao atributo tramitacao e a situcao eh modificada para "APROVADO".
     * - Se o estadoAprovacao seja igual a false e o atributo votante seja igual a "Plenario" a tramitacao sera adicionada
     * a string "REJEITADO ([votante]) e o atributo situacao recebera a string "ARQUIVADO".
     * - Se as votacoes realizadas igualarem a 2, o estadoAprovacao for igual a true e a PL for conclusiva, o atributo tramitacao
     * soma a sua string, a string "APROVADO ([votante]).
     * - No ultimo caso, se o metodo nao entrar em nenhum dos casos acima o atributo situacao recebera "EM VOTACAO ([proxLocal])".
     *
     * @param estadoAprovacao boolean que indica se a lei foi aprovada na votacao, true se ela foi aprovada e false se
     * ela for rejeitada.
     * @param proxLocal String com o proximo local de votacao.
     */
    @Override
    public void setSituacao(boolean estadoAprovacao, String proxLocal) {
        if (!estadoAprovacao && !this.conclusivo && "plenario".equals(this.votante)) {
            this.tramitacao += String.format("REJEITADO (%s)",this.votante);
            this.situacao = "ARQUIVADO";

        } else if (estadoAprovacao && !this.conclusivo && "plenario".equals(this.votante)){
            this.tramitacao += String.format("APROVADO (%s)", this.votante);
            this.situacao = "APROVADO";

        } else if (!estadoAprovacao && this.conclusivo) {
            this.tramitacao += String.format("REJEITADO (%s)",this.votante);
            this.situacao = "ARQUIVADO";

        } else if (this.votacaoRealizadas == 2 && estadoAprovacao && this.conclusivo) {
            this.tramitacao += String.format("APROVADO (%s)", this.votante);
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
