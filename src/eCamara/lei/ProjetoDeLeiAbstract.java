package eCamara.lei;

import eCamara.Validacao;
import eCamara.lei.ProjetoDeLei;

public abstract class ProjetoDeLeiAbstract implements ProjetoDeLei {

    protected String dniAutor;
    private int ano;
    protected String ementa;
    private String interesses;
    private String url;
    protected String situacao;
    private Validacao validaEntrada;

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
