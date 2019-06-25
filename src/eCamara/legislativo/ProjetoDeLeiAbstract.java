package eCamara.legislativo;

import eCamara.Validacao;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Classe abstrata de lei para reuso de codigo. Tem como atributos votante, dniAutor, ano, votacaoRealizadas, ementa
 * interesses, url, situacao, tramiacao e o objeto para validar entradas.
 */
public abstract class ProjetoDeLeiAbstract implements ProjetoDeLei, Serializable {

    /**
     * Comissao que deve fazer a votacao da lei.
     */
    protected String votante;
    /**
     * Dni do autor do projeto.
     */
    protected String dniAutor;

    /**
     * Ano em que o projeto foi criado.
     */
    private int ano;

    /**
     * Quantidade de votacao realizada.
     */
    protected int votacaoRealizadas;

    /**
     * Ementa do projeto.
     */
    protected String ementa;

    /**
     * Interesses relacionados ao projeto.
     */
    private String interesses;

    /**
     * Url da pagina em que o projeto esta hospedado.
     */
    private String url;

    /**
     * Situacao atual do projeto na camara.
     */
    protected String situacao;

    /**
     * objeto responsavel por validar as entradas dos metodos pertencentes a esta classe.
     */
    private Validacao validaEntrada;
    /**
     * Tramitacao da lei.
     */
    protected ArrayList<String> tramitacao;

    /**
     * Tipo de lei que a lei intanciada sera, sendo deixado para os filhos dessa classe decidirem seus "tipos", existindo
     * 3 tipos, PL, PLP e PEC
     */
    protected String tipoLei;

    protected int qntAprovacoes;

    private int numeroLei;

    /**
     * Construtor responsavel por inicializar os atributosque do objeto ProjetoDeLeiAbstract.
     *
     * @param dni dni do autor do projeto.
     * @param ano ano que o projeto foi criado.
     * @param ementa ementa do projeto.
     * @param interesses interesses relacionados ao projeto.
     * @param url url da pagina em que o projeto esta.
     */
    public ProjetoDeLeiAbstract(String dni, int ano, String ementa, String interesses, String url){
        this.validaEntrada = new Validacao();
        this.validaEntrada.validaCadastrarPL(dni, ano, ementa, interesses, url);
        this.dniAutor = dni;
        this.ano = ano;
        this.ementa = ementa;
        this.interesses = interesses;
        this.url = url;
        this.situacao = "EM VOTACAO (CCJC)";
        this.votante = "CCJC";
        this.tramitacao = new ArrayList<>();
        this.votacaoRealizadas = 0;
        this.tipoLei = "";
        this.qntAprovacoes = 0;
        this.numeroLei = 0;
    }

    /**
     * Metodoq que retorna os interesses da lei.
     * @return String com os interesses da lei.
     */
    @Override
    public String getInteresses() {
        return interesses;
    }

    /**
     * Metodo que retorna o ano da lei.
     * @return int com o ano.
     */
    public int getAno() {
        return ano;
    }

    /**
     * Metodo que retorna o dni do autor da lei.
     * @return String com o dni do autor da lei.
     */
    public String getDniAutor() {
        return dniAutor;
    }

    /**
     * Metodo que retorna a ementa da lei.
     * @return String com a ementa da lei.
     */
    public String getEmenta() {
        return ementa;
    }

    /**
     * Metodo que retorna a url da lei.
     * @return String com a url da lei.
     */
    public String getUrl() {
        return url;
    }

    /**
     * Metodo que retorna a comissao responsavel por realizar a votacao da lei no momento.
     * @return String com o nome da comissao que deve fazer a votacao da lei.
     */
    public String getVotante() {
        return votante;
    }

    /**
     * Metodo que retorna a tramitacao da lei.
     * @return String com a tramitacao da lei.
     */
    public ArrayList<String> getTramitacao() {
        return tramitacao;
    }

    /**
     * Metodo que retorna a situacao atual da lei.
     * @return String com a situacao atual da lei.
     */
    @Override
    public String getSituacao() {
        return situacao;
    }

    /**
     * Metodo responsavel por retornar o tipo da lei, existindo 3 opcoes: PL, PLP ou PEC
     * @return uma string que representa o tipo da lei(PL, PLP ou PEC).
     */
    @Override
    public String getTipoLei() {
        return tipoLei;
    }

    /**
     * Metodo responsavel por retornar uma string que representa toda a tramitacao feita em cima do projeto de lei.
     * Caso nenhuma votacao tiver sido feita em cima da proposta apenas a suta situacao sera retornada, caso as votacoes
     * realizadas sobre a proposta ja tiverem se encerrado o metodo retorna apenas a string com todas as votacoes separados
     * por virgulas. Por fim, caso nenhuma das condicoes sejam satisfeitas o metodo retornara uma string com todas as votacoes
     * feitas e a situacao atual do projeto na camara, tudo separado por virgula.
     *
     * @return uma string que representa a tramitacao do projeto na camara.
     */
    public String getTodaTramitacao() {
        String stringSaida = "";

        if (this.tramitacao.size() != 0) {
            for (int i = 0; i < this.tramitacao.size(); i++) {
                if (i == 0) {
                    stringSaida += this.tramitacao.get(i);
                } else {
                    stringSaida += String.format(", %s", this.tramitacao.get(i));
                }
            }
        }


        if ("APROVADO".equals(this.situacao) || "ARQUIVADO".equals(this.situacao)) {
            return stringSaida;
        }
        if (this.tramitacao.size() == 0) {
            return this.situacao;
        }

        return stringSaida + ", " + this.situacao;
    }

    /**
     * Metodoq que altera a Comissao que deve fazer a votacao da lei. Recebe uma String com a nova comissao.
     * @param votante String com a nova comissao
     */
    public void setVotante(String votante) {
        this.votante = votante;
    }


    /**
     * Metodo que adciona na tramitacao se ela foi aprovada ou nao. Recebe um boolean referente a aprovacao da lei.
     * Se o boolean recebido for true, entao sera adicionado "APROVADO (votante)" onde votante eh a comissao atual em que
     * a lei se encontra. Se for false sera adicionado "REJEITADO (votante)".;
     *
     * @param aprovadoOuNao boolean referente a aprovacao da lei, se for aprovcado eh true, se foi rejeitado eh false.
     */
    public abstract void setTramitacao(boolean aprovadoOuNao);


    /**
     * Metodo que modifica a situacao atual da lei. Recebe o proximo local de votacao.
     * @param estadoAprovacao boolean que indica se a lei foi aprovada na votacao, true se ela foi aprovada e false se
     * ela for rejeitada.
     * @param proxLocal String com o proximo local de votacao.
     */
    @Override
    public abstract void setSituacao(boolean estadoAprovacao, String proxLocal);

    /**
     * Metodo que adiciona 1 na contagem de votacao da lei.
     */
    public void addVotacaoRealizada() {
        this.votacaoRealizadas++;
    }

    public boolean emTramite(){
        if ("aprovado".equals(this.getSituacao().toLowerCase()) || "arquivado".equals(this.getSituacao().toLowerCase())){
            return false;
        }
        return true;
    }

    public int getQntAprovacoes(){
        return this.qntAprovacoes;
    }

    public void setNumeroLei(int numero){
        this.numeroLei = numero;
    }

    public int getNumeroLei(){
        return this.numeroLei;
    }

}
