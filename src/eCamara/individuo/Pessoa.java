package eCamara.individuo;

import eCamara.Validacao;
import eCamara.legislativo.ProjetoDeLei;
import eCamara.propostaMaisRelacionada.Aprovacao;
import eCamara.propostaMaisRelacionada.Conclusao;
import eCamara.propostaMaisRelacionada.Constitucional;
import eCamara.propostaMaisRelacionada.EstrategiaProposta;

import java.io.Serializable;
import java.util.*;

/**
 * Objeto que representa uma Pessoa, tem como atributos, em String, um DNI, Nome, Estado, Partido e Interesses, tem tambem
 * uma Funcao do tipo Funcao, essa Funcao vai indicar se ele eh ou nao Deputado, por ultimo tem um Objeto de Validacao.
 */
public class Pessoa implements Serializable {
    /** String  com o dni. */
    private String dni;
    /** String com o nome. */
    private String nome;
    /** String com o estado. */
    private String estado;
    /** String com o partido. */
    private String partido;
    /** String com os interesses. */
    private String interesses; // precisa virar um ArrayList (US7)
    /** Funcao do tipo Funcao. */
    private Funcao funcao;
    /** estrategia do tipo EstrategiaProposta **/
    private EstrategiaProposta estrategia;
    /** validaEntrada do tipo Validacao*/
    private Validacao validaEntrada;

    private boolean voto;


    /**
     * Constroi a Pessoa recebe como parametro Strings com o nome, dni, estado e interesses. Lanca uma excecao caso o dni
     * seja invalido, um dni eh invalido se for nulo, vazio ou contiver caracteres diferentes de numero e -. Lanca excecao tambem
     * se o nome ou estado, se pelo menos um for vazio ou nulo. Faz uso do metodo validarCadastroPessoa de Validacao.
     *
     * @param nome String com o nome.
     * @param dni String com o dni.
     * @param estado String com o estado.
     * @param interesses String com os interesses.
     */

    public Pessoa(String nome, String dni, String estado, String interesses){
        this.validaEntrada = new Validacao();
        this.validaEntrada.validarCadastroPessoa(dni, nome, estado);
        this.dni = dni;
        this.nome =  nome;
        this.estado = estado;
        this.interesses = interesses;
        this.funcao = new Civil();
        this.estrategia = new Constitucional();
    }

    /**
     * Constroi a Pessoa recebe como parametro Strings com o nome, dni, estado, interesses e Partido. Lanca uma excecao caso o dni
     * seja invalido, um dni eh invalido se for nulo, vazio ou contiver caracteres diferentes de numero e -. Lanca excecao tambem
     * se o nome ou estado, se pelo menos um for vazio ou nulo. Faz uso do primeiro construtor.
     *
     * @param nome String com o nome.
     * @param dni String com o dni.
     * @param estado String com o estado.
     * @param interesses String com os interesses.
     * @param partido String com o partido.
     */

    public Pessoa(String nome, String dni, String estado, String interesses, String partido){
        this(nome, dni, estado, interesses);
        this.partido = partido;
    }

    /**
     * Metodo responsavel por fazer atribuicao da funcao de deputado a uma determinada pessoa.
     * Lanca uma excecao caso a data de inicio na vida publica como deputado seja invalida, a data sera invalida se for nula, ou vazia.
     * @param dataInicio String que contem a data de inicio na vida publica de deputado.
     */

    public void cadastraDeputado(String dataInicio){
        this.validaEntrada.validaDeputado(dataInicio);
        this.funcao = new Deputado(dataInicio);
    }

    /**
     * Metodo que verifica se uma Pessoa eh igual a outro objeto. Uma Pessoa eh igual a outro objeto se esse outro objeto
     * for do tipo Pessoa e se tiverem o mesmo dni. Retorna True se forem iguais e False se forem diferentes.
     *
     * @param o Objeto a ser comparado a igualdade.
     * @return boolean True se forem iguais e False se forem diferentes.
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(dni, pessoa.dni);
    }

    /**
     * Metodo que calcula o HashCode de uma Pessoa. Retorna um inteiro referente ao calculo do HashCode.
     * O HashCode eh calculado a partir do dni.
     *
     * @return Inteiro calculado a partir do dni.
     */
    @Override
    public int hashCode() {
        return Objects.hash(dni);
    }

    /**
     * Metodo responsavel por deixar disponivel o partido em que a pessoa esta filiada.
     *
     * @return uma string que representa o partido.
     */
    public String getPartido() {
        return partido;
    }

    /**
     * Metodo responsavel por deixar disponivel a funcao da pessoa na politica.
     *
     * @return o atributo funcao, um objeto do tipo Funcao
     */
    public Funcao getFuncao() {
        return funcao;
    }

    /**
     * Metodo que retorna a representacao textual de uma Pessoa que tem funcao. Essa representacao e feita a partir
     * da concatenacao do toString() de pessoa com o toString() da funcao.
     *
     * @return Representacao textual de Pessoa com funcao.
     */
    public String toStringPelaFuncao(){
        return this.funcao.toString(this.toString());
    }

    /**
     * Metodo que retorna a representacao textual de Pessoa. Existem 4 representacoes possiveis: quando Pessoa
     * tem partido e interesses; quando Pessoa só tem partido, mas nao tem interesses; quando Pessoa apenas tem
     * interesses, mas nao tem partido; e quando Pessoa nao tem partido e nao tem interesses. Essa representacao
     * e feita na forma: [nome] - [dni] ([estado]) - [partido] - Interesses: [interesses]
     *
     * @return representacao textual de Pessoa.
     */
    @Override
    public String toString(){
        if (this.partido == null){
            if (this.interesses.trim().equals("")) {
                return this.nome + " - " + this.dni + " (" + this.estado + ")";
            } else{
                return this.nome + " - " + this.dni + " (" + this.estado + ")" + " - Interesses: " + this.interesses;
            }
        } else{
            if ("".trim().equals(this.interesses)){
                return this.nome + " - " + this.dni + " (" + this.estado + ")" + " - " + this.partido;
            }
        }

        return this.nome + " - " + this.dni + " (" + this.estado + ")" + " - " + this.partido + " - Interesses: " + this.interesses;
    }

    /**
     * Metodo que retorna uma String com o dni da Pessoa.
     *
     * @return String com o dni.
     */
    public String getDni() {
        return this.dni;
    }

    /**
     * Metodo que retorna uma String com o nome da Pessoa.
     *
     * @return String com o nome.
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Metodo quue retorna uma String com o estado da Pessoa.
     *
     * @return String com o estado.
     */
    public String getEstado() {
        return this.estado;
    }

    /**
     * Metodo que retorna uma String com o(s) interesse(s) da Pessaoa.
     *
     * @return String com o(s) interesse(s).
     */
    public String getInteresses() {
        return this.interesses;
    }

    /**
     * Metodo que adiciona mais uma lei referente a funcao de uma pessoa.
     */
    public void addQtdLei() {
        this.funcao.addLei();
    }

    /**
     * Metodo que retorna a quantidade de leis de uma Pessoa se a sua funcao tiver leis.
     *
     * @return Inteiro referente a quntidade de leis.
     */
    public int getQtdLei() {
        return this.funcao.getQtdLeis();
    }

    /**
     * Metodo que mostra se a pessoa tem uma funcao na politica, se o atributo funcao da pessoa for do tipo Civil
     * o metodo retorna true, indicando que a pessoa nao tem funcao na politica, se o atributo for de qualquer outro tipo
     * o metodo retornar false, indicando que a pessoa tem alguma funcao na politica.
     *
     * @return um boolean que indica se a pessoa tem ou nao uma funcao na politica.
     */
    public boolean ehDeputado() {
        if (this.funcao instanceof Civil) {
            return false;
        } return true;
    }

    /**
     * Metodo responsavel por determinar se uma pessoa tem um partido ou nao, se ela nao tiver partido, ou seja, o partido
     * for null o metodo retorna true, se ele tiver partido o metodo retorna false.
     *
     * @return um boolean que representa se a pessoa tem ou nao um partido.
     */
    public boolean temPartido(){
        if (this.partido != null){
            return true;
        }
        return false;
    }

    /**
     * Metodo responsavel por delegar a responsabilidade da escolha do voto a pessoa.
     *
     * @param statusGovernista String com o status governista da lei
     * @param partidos  Set de partidos representados por String;
     *
     * @param interesses
     * @return true se o voto for a favor e false quando o voto for contra.
     */

    public boolean decideVoto(String statusGovernista, Set<String> partidos, String interesses) {
        if ("governista".equals(statusGovernista.toLowerCase()) && partidos.contains(this.partido)) {
            return true;

        } else if ("oposicao".equals(statusGovernista.toLowerCase()) && !partidos.contains(this.partido)) {
            return true;

        } else if ("livre".equals(statusGovernista.toLowerCase())) {
            String[] arrayInteressesLei = interesses.split(",");
            List<String> listaInteressesLei = Arrays.asList(arrayInteressesLei);

            for (String interessePolitico : this.interesses.split(",")) {
                if (listaInteressesLei.contains(interessePolitico)) {
                    return true;
                }
            }
        }


        return false;
    }


    /**
     * Metodo que realiza a configuracao da estrategia para a busca de proposta de lei mais relacionada
     * com determinada pessoa. Ela pode ser do tipo Constitucional, Conclusao ou Aprovacao.
     *
     * @param estrategia estrategia que sera implementada.
     */
    public void configurarEstrategiaPropostaRelacionada(String estrategia) {
        if (estrategia.toLowerCase().equals("constitucional")){
            this.estrategia = new Constitucional();
        } else if(estrategia.toLowerCase().equals("conclusao")){
            this.estrategia = new Conclusao();
        } else if (estrategia.toLowerCase().equals("aprovacao")){
            this.estrategia = new Aprovacao();
        }
    }

    /**
     * Retorna a proposta mais relacionada com uma pessoa, de acordo com a estrategia previamente cadastrada.
     *
     * @param leis as leis cadastradas.
     *
     * @return retorna o codigo da proposta de lei mais relacionada com uma pessoa.
     */
    public String pegarPropostaRelacionada(Map<String, ProjetoDeLei> leis){
        HashSet<String> grupo = new HashSet<>();

        for (String interesse: this.interesses.trim().split(",")){
            grupo.add(interesse);
        }

        return estrategia.pegarPropostaRelacionada(leis, grupo);
    }
}
