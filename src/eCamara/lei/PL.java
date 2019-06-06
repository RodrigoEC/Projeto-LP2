package eCamara.lei;

public class PL extends ProjetoDeLeiAbstract {

    private boolean conclusivo;

    public PL(String dni, int ano, String ementa, String interesses, String url, boolean conclusivo){
        super(dni, ano, ementa, interesses, url);
        this.conclusivo = conclusivo;
    }

    public String toString(){
        return "";
    }
}
