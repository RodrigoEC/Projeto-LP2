package eCamara.legislativo;

/**
 * Objeto que representa uma PLP, herda atributos e metodos de ProjetoDeLeiAbstract. Unico atributo que a PLP tem a mais
 * eh a String com os artigos.
 */

public class PLP extends ProjetoDeLeiAbstract {
    /**
     * Atributo que representa os artigos da constituicao em aos quais o projeto de lei complmentar se relaciona.
     */
    private String artigos;
    private int turno;


    /**
     * Construtor responsavel por construir um objeto do tipo PLP(projeto de legislativo Complementar) a partir do dni do deputado
     * que o criou, do ano em que ele foi criado, da ementa, dos interesses relacionados ao projeto, da url do site em que o projeto
     * esta hospedado e um boolean indicando se o projeto eh conclusivo ou nao.
     * @param dni dni do deputado criador do projeto.
     * @param ano data de criacao do projeto.
     * @param ementa ementa do projeto.
     * @param interesses interesses relacionados ao projeto.
     * @param url url do site em que o projeto esta hospedado.
     * @param artigos serie de artigos da constituicao Que o PLP se relaciona.
     */
    public PLP(String dni, int ano, String ementa, String interesses, String url, String artigos) {
        super(dni, ano, ementa, interesses, url);
        this.artigos = artigos;
        this.tipoLei = "PLP";
        this.turno = 0;
    }

    /**
     * Retorna os artigos do Projeto de Lei Parlamentar.
     *
     * @return os artigos do Projeto de Lei Parlamentar.
     */
    public String getArtigos() {
        return artigos;
    }

    /**
     * Metodo responsavel por criar uma representacao textual do objeto atraves do dni do autor, da ementa, da conclusao
     * do projeto de legislativo complementar e da situacao em que ele se encontra.
     *
     * @param codigo codigo do projeto.
     * @return string que representa o objeto.
     */
    public String toString(String codigo){
        return "Projeto de Lei Complementar - " + codigo + " - " + super.dniAutor + " - " + super.ementa + " - " + this.artigos + " - " + super.situacao;
    }

    public void addTurno() {
        this.turno++;
    }

    @Override
    public void setTramitacao(boolean aprovadoOuNao) {
        if (!aprovadoOuNao && "plenario".equals(this.votante.toLowerCase())) {
            this.tramitacao += String.format("REJEITADO (plenario %do turno), ", this.turno);

        } else if (aprovadoOuNao && "plenario".equals(this.votante.toLowerCase())) {
            this.tramitacao += String.format("APROVADO (plenario %do turno), ", this.turno);

        } else if (aprovadoOuNao) {
            this.tramitacao += String.format("APROVADO (%s), ",this.votante);

        } else {
            this.tramitacao += String.format("REJEITADO (%s), ", this.votante);
        }
    }

    @Override
    public void setSituacao(boolean estadoAprovacao, String proxLocal) {
        if (!estadoAprovacao && this.turno == 2) {
            this.tramitacao += String.format("REJEITADO (%s), ", this.votante);
            this.situacao = "ARQUIVADO";

        } else if (estadoAprovacao && this.turno == 2) {
            this.tramitacao += String.format("APROVADO (%s), ", this.votante);
            this.situacao = "APROVADO";

        } else if (!estadoAprovacao && ("plenario".equals(proxLocal) || "plenario".equals(this.votante))){
            this.tramitacao += String.format("REJEITADO (%s), ", this.votante);
            this.situacao = "ARQUIVADO";


        }else if(("plenario".equals(proxLocal) || "plenario".equals(this.votante))) {
            this.situacao = String.format("EM VOTACAO (Plenario - %do turno)", this.turno + 1);

        } else {
            this.situacao = String.format("EM VOTACAO (%s)", proxLocal);
        }
    }

    public String getTipoLei() {
        return tipoLei ;
    }
}
