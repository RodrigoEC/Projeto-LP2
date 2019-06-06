package eCamara.lei;

import eCamara.Validacao;
import eCamara.lei.ProjetoDeLei;

public abstract class ProjetoDeLeiAbstract implements ProjetoDeLei {

    private String dniAutor;
    private int ano;
    private String ementa;
    private String interesses;
    private String url;
    private Validacao validaEntrada;

    public ProjetoDeLeiAbstract(String dni, int ano, String ementa, String interesses, String url){
        this.validaEntrada = new Validacao();
        this.validaEntrada.validaCadastrarPL(dni, ano, ementa, interesses, url);
        this.dniAutor = dni;
        this.ano = ano;
        this.ementa = ementa;
        this.interesses = interesses;
        this.url = url;
    }

}
