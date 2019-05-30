package ECamara;

import java.util.Objects;

public class Deputado implements Funcao{

    private String dataInicio;
    private Integer qtdLeis;

    public Deputado(String dataInicio){

        //Fazer as validacoes do construtor
        this.dataInicio = dataInicio;
        this.qtdLeis = 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Deputado)) return false;
        Deputado deputado = (Deputado) o;
        return Objects.equals(dataInicio, deputado.dataInicio) &&
                Objects.equals(qtdLeis, deputado.qtdLeis);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dataInicio, qtdLeis);
    }

    @Override
    public String toString(){
        return " - " + this.dataInicio + " - " + this.qtdLeis + " Leis";
    }
}
