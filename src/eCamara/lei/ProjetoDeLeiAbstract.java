package eCamara.lei;

import eCamara.Validacao;
import eCamara.lei.ProjetoDeLei;

public abstract class ProjetoDeLeiAbstract implements ProjetoDeLei {

    /**
     * Dni do autor do projeto.
     */
    protected String dniAutor;

    /**
     * Ano em que o projeto foi criado.
     */
    private int ano;

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
    }

}
