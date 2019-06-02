package eCamara;

import java.util.Objects;

/**
 *
 */

public class Deputado implements Funcao{

    private String dataInicio;
    private Integer qtdLeis;
    private Validacao validaEntrada;

    /**
     *
     * @param dataInicio
     */
    public Deputado(String dataInicio) {
        this.validaEntrada = new Validacao();
        this.validaEntrada.validaDeputado(dataInicio);
        this.dataInicio = dataInicio;
        this.qtdLeis = 0;
    }

    /**
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Deputado)) return false;
        Deputado deputado = (Deputado) o;
        return Objects.equals(dataInicio, deputado.dataInicio) &&
                Objects.equals(qtdLeis, deputado.qtdLeis);
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(dataInicio, qtdLeis);
    }

    /**
     * Metodo que retorna a representacao textual de Deputado. Essa representacao e composta pela data de inicio
     * do mandato e da quantidade de leis aprovadas, na forma: - [data] - [qtdLeis] Leis
     *
     * @return representacao textual de Deputado.
     */
    @Override
    public String toString(){
        char[] data = this.dataInicio.toCharArray();
        String dataFormatada = "" + data[0] + data[1] + "/"+ data[2] + data[3]+ "/" + data[4] + data[5] + data[6] + data[7];

        return " - " + dataFormatada + " - " + this.qtdLeis + " Leis";
    }

    /**
     *
     * @return
     */
    public String getDataInicio() {
        return dataInicio;
    }
}