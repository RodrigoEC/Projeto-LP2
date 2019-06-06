package eCamara.lei;

public class PEC extends ProjetoDeLeiAbstract {

    private String artigos;

    public PEC(String dni, int ano, String ementa, String interesses, String url, String artigos) {
        super(dni, ano, ementa, interesses, url);
        this.artigos = artigos;
    }

    public String toString(String codigo){
        return "Projeto de Emenda Constitucional - " + codigo + " - " + super.dniAutor + " - " + super.ementa + " - " + this.artigos + " - " + super.situacao;
    }
}
