package eCamara.individuo;

import eCamara.Validacao;

import java.io.Serializable;
import java.util.Objects;

/**
 * Classe que representa um deputado, possui os atributos String dataInicio, Integer qtdLeis e o objeto de validacao de entradas.
 */

public class Deputado implements Funcao, Serializable {

    /**
     * Data em que a pessoa virou deputado.
     */
    private String dataInicio;

    /**
     * quantidade de leis que foram criadas pelo deputado.
     */
    private Integer qtdLeis;

    /**
     * classe responsavel por validar as entradas dos metodos da classe Deputado
     */
    private Validacao validaEntrada;

    /**
     * Constroi o objeto deputado, recebendo como parametro a String dataInicio.
     * Uma excecao sera lancada, caso esta seja vazia ou nula.
     * @throws IllegalArgumentException Data de inicio da funcao como deputado não pode ser vazia ou nula
     *
     * @param dataInicio representa a data de inicio na vida publica como deputado.
     */
    public Deputado(String dataInicio) {
        this.validaEntrada = new Validacao();
        this.validaEntrada.validaDeputado(dataInicio);
        this.dataInicio = dataInicio;
        this.qtdLeis = 0;
    }

    /**
     * Metodo que verifica se um deputado eh igual a outro objeto. Uma deputado sera igual a outro objeto, se caso esse outro objeto
     * seja do tipo deputado e se tiverem a mesma data de inicio na vida publica e a mesma quantidade de leis.
     *
     * @param o Objeto a ser comparado a igualdade.
     * @return boolean True se forem iguais e False se forem diferentes.
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
     * Metodo que calcula o HashCode de um deputado. Retorna um inteiro referente ao calculo do HashCode.
     * O HashCode eh calculado a partir da dataInicio e qtdLeis.
     * @return Inteiro calculado a partir da dataInicio e a qtdLeis.
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
    public String toString(String toString){
        char[] data = this.dataInicio.toCharArray();
        String dataFormatada = "" + data[0] + data[1] + "/"+ data[2] + data[3]+ "/" + data[4] + data[5] + data[6] + data[7];

        return "POL: " + toString + " - " + dataFormatada + " - " + this.qtdLeis + " Leis";
    }

    /**
     * Metodo responsavel por adicionar uma lei na quantidade de leis criadas por um deputado.
     */

    @Override
    public void addLei() {
        this.qtdLeis++;
    }

    /**
     * Recupera a quantidade de leis criadas por um deputado.
     * @return qtdLeis
     */
    @Override
    public int getQtdLeis() {
        return qtdLeis;
    }

    /**
     * Recupera a dataInicio na vida publica de um deputado.
     * @return dataInicio da vida publica de um deputado.
     */
    public String getDataInicio() {
        return dataInicio;
    }
}