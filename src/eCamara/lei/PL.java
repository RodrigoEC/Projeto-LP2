package eCamara.lei;

public class PL extends ProjetoDeLeiAbstract {

    private boolean conclusivo;

    public PL(String dni, int ano, String ementa, String interesses, String url, boolean conclusivo){
        super(dni, ano, ementa, interesses, url);
        this.conclusivo = conclusivo;
    }

    public String toString(String codigo){
        if (conclusivo){
            return "Projeto de Lei - " + codigo + super.dniAutor + " - " + super.ementa + " - Conclusiva - " + super.situacao;
        }
        return "Projeto de Lei - " + codigo + " - " + super.dniAutor + " - " + super.ementa + " - Nao conclusiva - " + super.situacao;
    }
}
