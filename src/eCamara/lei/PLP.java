package eCamara.lei;

public class PLP extends ProjetoDeLeiAbstract {
    private String artigos;

    public PLP(String dni, int ano, String ementa, String interesses, String url, String artigos) {
        super(dni, ano, ementa, interesses, url);
        this.artigos = artigos;
    }

    public String toString(String codigo){
        return "Projeto de Lei Complementar - " + codigo + " - " + super.dniAutor + " - " + super.ementa + " - " + this.artigos + " - " + super.situacao;
    }
}
