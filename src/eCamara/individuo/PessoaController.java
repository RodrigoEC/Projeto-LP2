package eCamara.individuo;

import eCamara.Validacao;
import eCamara.individuo.Deputado;
import eCamara.individuo.Pessoa;
import eCamara.legislativo.ProjetoDeLei;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Controller de Pessoa, tem um HashMap de Pessoa e um Objeto de validacao como atributos.
 */
public class PessoaController implements Serializable {
    /** Map de Pessoa */
    private HashMap<String, Pessoa> mapPessoas;
    /** Validador das entradas dos metodos */
    private Validacao validaEntradas;

    /**
     * Contrutor de PessoaController, inicia o map e o objeto de validacao.
     */
    public PessoaController() {
        this.mapPessoas = new HashMap<>();
        this.validaEntradas = new Validacao();
    }

    /**
     * Metodo responsavel por deixar disponivel o mapa de objetos do tipo Pessoa.
     *
     * @return o mapa de objetos do tipo Pessoa.
     */
    public HashMap<String, Pessoa> getMapPessoas() {
        return mapPessoas;
    }


    /**
     * Metodo que cadastra um Pessoa que nao tem partido. Recebe Strings com o nome, dni, estado e
     * interesses. Delega a validacao para o objeto validador Validacao, faz uso do seu metodo validarCadastroPessoa.
     * Tambem verifica (antes de inserir no Map) se a Pessoa ja se encontra cadastrada pelo seu dni, se ja estiver sera
     * lancada excecao, se nao tiver sera cadastrada com sucesso.
     *
     * @param nome String com o nome.
     * @param dni String com o dni.
     * @param estado String com o estado.
     * @param interesses String com o(s) interese(s).
     *
     * @throws IllegalArgumentException Erro ao cadastrar pessoa: dni ja cadastrado.
     */

    public void cadastrarPessoaSemPartido(String nome, String dni, String estado, String interesses) {

        if (this.mapPessoas.containsKey(dni)){
            throw new IllegalArgumentException("Erro ao cadastrar pessoa: dni ja cadastrado");
        }

        this.mapPessoas.put(dni, new Pessoa(nome, dni, estado, interesses));
    }

    /**
     * Metodo que cadastra uma Pessoa que tem partido. Recebe Strings com o nome, dni, estado, interesses e
     * partido. Delega a validacao para o objeto validador Validacao, faz uso do seu metodo validarCadastroPessoa.
     * Tambem verifica (antes de inserir no Map) se a Pessoa ja se encontra cadastrada pelo seu dni, se ja estiver sera
     * lancada excecao, se nao tiver sera cadastrada com sucesso.
     *
     * @param nome String com o nome.
     * @param dni String com o dni.
     * @param estado String com o estado.
     * @param interesses String com o(s) interese(s).
     * @param partido String com o partido.
     *
     * @throws IllegalArgumentException Erro ao cadastrar pessoa: dni ja cadastrado.
     */
    public void cadastrarPessoa(String nome, String dni, String estado, String interesses, String partido) {

        if (this.mapPessoas.containsKey(dni)){
            throw new IllegalArgumentException("Erro ao cadastrar pessoa: dni ja cadastrado");
        }

        this.mapPessoas.put(dni, new Pessoa(nome, dni, estado, interesses, partido));
    }

    /**
     * O metodo cadastraDeputado eh responsavel por cadastrar uma pessoa como deputado.
     * Recebe como parametros uma string que representa um dni (documento nacional de identificacao)
     * e uma string dataInicio que representa a data de inicio da vida publica como deputado.
     *
     * @throws IllegalArgumentException Erro ao cadastrar deputado: dni invalido
     * @throws IllegalArgumentException Erro ao cadastrar deputado: data invalida
     * @throws IllegalArgumentException Data de inicio da funcao como deputado não pode ser vazia ou nula
     * @throws IllegalArgumentException Erro ao cadastrar deputado: data futura"
     * @throws IllegalArgumentException Erro ao cadastrar deputado: data nao pode ser vazio ou nulo
     * @throws IllegalArgumentException Erro ao cadastrar pessoa: dni nao pode ser vazio ou nulo
     * @throws IllegalArgumentException Erro ao cadastrar deputado:pessoa nao encontrada.
     * @throws IllegalArgumentException Erro ao cadastrar deputado: pessoa ja e deputado.
     * @throws IllegalArgumentException Erro ao cadastrar deputado: pessoa sem partido
     *
     * @param dni String que representa o documento nacional de identificacao (dni) de uma pessoa.
     * @param dataInicio String que representa a data de inicio de uma pessoa na vida publica como deputado.
     */
    public void cadastraDeputado(String dni, String dataInicio) {
        if (!(mapPessoas.containsKey(dni))) {
            throw new IllegalArgumentException("Erro ao cadastrar deputado: pessoa nao encontrada");
        }
        this.validaEntradas.validaDataCadastroDeputado(dataInicio);

        if (!mapPessoas.get(dni).temPartido()) {
            throw new IllegalArgumentException("Erro ao cadastrar deputado: pessoa sem partido");

        }if (mapPessoas.get(dni).getFuncao() instanceof Deputado) {
            throw new IllegalArgumentException("Erro ao cadastrar deputado: pessoa ja e deputado");
        }
        this.mapPessoas.get(dni).cadastraDeputado(dataInicio);
    }

    /**
     * Metodo que exibe a representacao textual de uma Pessoa, com funcao ou nao, a partir do Dni recebido como
     * parametro. Se a pessoa nao estiver cadastrada, uma excecao sera lancada. O dni tambem e passado como parametro
     * para o metodo validaExibirPessoa da classe Validacao.
     *
     *
     * @param dni String com dni.
     *
     * @throws IllegalArgumentException Erro ao exibir pessoa: pessoa nao encontrada
     *
     * @return Representacao textual de Pessoa.
     */
    public String exibirPessoa(String dni) {

        if (!this.mapPessoas.containsKey(dni)){
            throw new IllegalArgumentException("Erro ao exibir pessoa: pessoa nao encontrada");
        }

        return this.mapPessoas.get(dni).toStringPelaFuncao();
    }

    /**
     * Metodo que verifica se um dni esta no mapa. Se nao tiver sera lancado excecao.
     * Recebe Strings com o dni a ser procurado e a mensagem de excecao.
     *
     * @param dni String com o dni.
     * @param mensagem String com a mensagem.
     * @throws NullPointerException mensagem.
     */
    public void procuraDniNoMapa(String dni, String mensagem) {
        if(!this.mapPessoas.containsKey(dni)) {
            throw new NullPointerException(mensagem);
        }
    }

    /**
     * Metodo que verifica se um dni eh dni de Deputado. Se nao for sera lancado excecao.
     * Recebe Strings com o dni a ser verificado e a mensagem de excecao.
     *
     * @param dni String com o dni.
     * @param mensagem String com a mensagem.
     * @throws NullPointerException mensagem.
     */
    public void ehDeputado(String dni, String mensagem) {
        if(!this.mapPessoas.get(dni).ehDeputado()) {
            throw new NullPointerException(mensagem);
        }
    }

    /**
     * Metodo que retorna uma Pessoa, recebe uma string com o dni.
     * @param dni String com o dni.
     * @return Pessoa referente aquele dni.
     */
    public Pessoa getPessoa(String dni) {
        return this.mapPessoas.get(dni);

    }

    /**
     * Metodo que realiza a configuracao da estrategia para a busca de proposta de lei mais relacionada
     * com determinada pessoa.
     *
     * @param dni o dni da pessoa.
     * @param estrategia estrategia que sera implementada.
     */
    public void configurarEstrategiaPropostaRelacionada(String dni, String estrategia) {
        this.validaEntradas.validaconfigurarEstrategiaPropostaRelacionada(dni, estrategia);

        if(!this.mapPessoas.containsKey(dni)){
            throw new IllegalArgumentException("Erro ao configurar estrategia: dni invalido");
        }

        this.mapPessoas.get(dni).configurarEstrategiaPropostaRelacionada(estrategia);
    }

    /**
     * Retorna a proposta mais relacionada com uma pessoa, de acordo com a estrategia previamente cadastrada.
     *
     * @param dni o dni da pessoa.
     * @param leis as leis cadastradas.
     *
     * @return retorna o codigo da proposta de lei mais relacionada com uma pessoa.
     */
    public String pegarPropostaRelacionada(String dni, HashMap<String, ProjetoDeLei> leis) {
        this.validaEntradas.validaPegarPropostaRelacionada(dni);

        if(!this.mapPessoas.containsKey(dni)){
            throw new IllegalArgumentException("Erro ao pegar proposta relacionada: pessoa nao cadastrada");
        }

        return this.mapPessoas.get(dni).pegarPropostaRelacionada(leis);
    }

    /**
     * Metodo que muda permite a alteracao do mapa de Pessoas, recebe um mapa como parametro e altera o mapa
     * atual para o mapa passado como parametro. Metodo usado no carregar do sistema.
     * @param pessoas HashMap novo.
     */
    public void setMap(HashMap pessoas) {
        this.mapPessoas = pessoas;
    }
}
