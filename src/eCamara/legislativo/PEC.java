package eCamara.legislativo;

/**
 * Objeto que representa uma PEC, herda atributos e metodos de ProjetoDeLeiAbstract. Unico atributo que a PEC tem a mais
 * eh a String com os artigos.
 */
public class PEC extends ProjetoDeLeiAbstract {

    /**
     * Artigos da constituicao que a PEC se relaciona */
    private String artigos;

    /** metodo que representa em qual turno da votacao no plenario a PEC esta */
    private int turno;


    /**
     * Construtor responsavel por construir um objeto do tipo PEC(projeto de ementa constitucional) a partir do dni do deputado
     * que o criou, do ano em que ele foi criado, da ementa, dos interesses relacionados ao projeto, da url do site em que o projeto
     * esta hospedado e um boolean indicando se o projeto eh conclusivo ou nao.
     *
     * @param dni dni do deputado criador do projeto.
     * @param ano data de criacao do projeto.
     * @param ementa ementa do projeto.
     * @param interesses interesses relacionados ao projeto.
     * @param url url do site em que o projeto esta hospedado.
     * @param artigos serie de artigos da constituicao Que o PEC se relaciona.
     */
    public PEC(String dni, int ano, String ementa, String interesses, String url, String artigos) {
        super(dni, ano, ementa, interesses, url);
        this.artigos = artigos;
        this.tipoLei = "PEC";
        this.turno = 0;
    }

    /**
     * Retorna os artigos do Projeto de Emenda Constitucional.
     *
     * @return os artigos do projeto.
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
    @Override
    public String toString(String codigo){
        return "Projeto de Emenda Constitucional - " + codigo + " - " + super.dniAutor + " - " + super.ementa + " - " + (this.artigos.replace(",", ", ")) + " - " + super.situacao;
    }

    /**
     * Esse metodo adiciona 1 ao turno da votacao sobre a PEC, caso o turno ja seja maior ou igual a 2 uma excecao sera lancada.
     *
     * @throws NullPointerException "nao existe terceiro turno queridao".
     */
    public void addTurno() {
        if (this.turno >= 2) {
            throw new NullPointerException("nao existe terceiro turno queridao");
        }
        this.turno++;
    }

    /**
     * Metodo responsavel por modificar a tramitacao do projeto. caso o projeto tenha sido aprovado e quem esteja votando
     * seja o plenario eh adicionado a string da tramitacao "APROVADO (plenario [this.turno]o turno", caso o projeto
     * tenha sido rejeitado no plenario "REJEITADO (plenario [this.turn]o turno", se o projeto tiver sido aprovado e o
     * votante for diferente do plenario entao sera adicionado a string de tramitacao a string "APROVADO ([this.votante]),
     * caso o contrario, sera adicionado ao atributo tramitacao a string "REJEITADO ([votante]).
     *
     * @param aprovadoOuNao boolean referente a aprovacao da lei, se for aprovcado eh true, se foi rejeitado eh false.
     */
    @Override
    public void setTramitacao(boolean aprovadoOuNao) {
        if (aprovadoOuNao && "plenario".equals(this.votante.toLowerCase())) {
            this.tramitacao += String.format("APROVADO (plenario %do turno), ", this.turno);

        } else if (!aprovadoOuNao && "plenario".equals(this.votante.toLowerCase())) {
            this.tramitacao += String.format("REJEITADO (plenario %do turno), ", this.turno);

        } else if (aprovadoOuNao) {
            this.tramitacao += String.format("APROVADO (%s), ",this.votante);

        } else {
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
     * - Se o estadoAprovacao seja igual a true e o atributo votante seja igual "plenario" ou o proximo local a ser votado seja "Plenario"
     * a tramitacao sera adicionada a string "REJEITADO ([votante]) e o atributo situacao recebera a string "EM VOTACAO (Plenario - [turno]o turno).
     * - No ultimo caso, se o metodo nao entrar em nenhum dos casos acima o atributo situacao recebera "EM VOTACAO ([proxLocal])".
     *
     *
     * @param estadoAprovacao boolean que indica se a lei foi aprovada na votacao, true se ela foi aprovada e false se
     * ela for rejeitada.
     * @param proxLocal String com o proximo local de votacao.
     */
    @Override
    public void setSituacao(boolean estadoAprovacao, String proxLocal) {
        if (!estadoAprovacao && this.turno == 2) {
            this.tramitacao += String.format("REJEITADO (%s), ", this.votante);
            this.situacao = "ARQUIVADO";

        } else if (estadoAprovacao && this.turno == 2) {
            this.tramitacao += String.format("APROVADO (%s), ", this.votante);
            this.situacao = "APROVADO";

        } else if (!estadoAprovacao && "plenario".equals(this.votante)){
            this.tramitacao += String.format("REJEITADO (%s), ", this.votante);
            this.situacao = "ARQUIVADO";


        }else if(("plenario".equals(proxLocal) || "plenario".equals(this.votante))) {
            this.situacao = String.format("EM VOTACAO (Plenario - %do turno)", this.turno + 1);

        } else {
            this.situacao = String.format("EM VOTACAO (%s)", proxLocal);
        }
    }
}
