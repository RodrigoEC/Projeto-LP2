package eCamara.legislativo;

import eCamara.Validacao;

import java.util.ArrayList;

public abstract class ProjetoDeLeiAbstract implements ProjetoDeLei {

    protected String votante;
    /**
     * Dni do autor do projeto.
     */
    protected String dniAutor;

    /**
     * Ano em que o projeto foi criado.
     */
    private int ano;

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

    protected String tramitacao;

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
        this.tramitacao = "";
        this.votacaoRealizadas = 0;
    }



    @Override
    public String getInteresses() {
        return interesses;
    }


    public int getAno() {
        return ano;
    }

    public String getDniAutor() {
        return dniAutor;
    }

    public String getEmenta() {
        return ementa;
    }

    public String getUrl() {
        return url;
    }

    public String getVotante() {
        return votante;
    }

    public void setVotante(String votante) {
        this.votante = votante;
    }

    public String getTramitacao() {
        return tramitacao;
    }

    public void setTramitacao(boolean aprovadoOuNao) {
        if (aprovadoOuNao) {
            this.tramitacao += String.format("APROVADO (%s), ",this.votante);
        } else {
            this.tramitacao += String.format("REJEITADO (%s), ", this.votante);
        }
    }

    @Override
    public String getSituacao() {
        return situacao;
    }

    @Override
    public void setSituacao(boolean estadoAprovacao, String proxLocal) {
        this.situacao = String.format("EM VOTACAO (%s)", proxLocal);

    }

    public void addVotacaoRealizada() {
        this.votacaoRealizadas++;
    }

}
