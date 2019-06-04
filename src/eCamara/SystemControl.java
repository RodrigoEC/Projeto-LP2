package eCamara;

import java.util.*;

/**
 * Objeto que representa o Controller do sistema, tem como atributos o objeto de Validacao, um Map de Pessoa e um Set de
 * Partido (String).
 */

public class SystemControl {
    /** Map de Pessoa */
    private Map<String, Pessoa> mapPessoas;
    /** Set de Partidos (String) */
    private Set<String> partidos;


    /** Objeto de Validacao */
    private Validacao validaEntradas;

    /**
     * Constroi o SystemControl(Controller), inicia o Map e o Set e instancia o Objeto de validacao.
     */
    public SystemControl(){
        this.mapPessoas =  new HashMap<>();
        this.partidos = new HashSet<>();
        this.validaEntradas = new Validacao();
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
        this.validaEntradas.validarCadastroPessoa(dni, nome, estado);

        if (this.mapPessoas.containsKey(dni)){
            throw new IllegalArgumentException("Erro ao cadastrar pessoa: dni ja cadastrado");
        }

        this.mapPessoas.put(dni, new Pessoa(nome, dni, estado, interesses));
    }

    /**
     * Metodo que cadastra um Pessoa que tem partido. Recebe Strings com o nome, dni, estado, interesses e
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
        this.validaEntradas.validarCadastroPessoa(dni, nome, estado);

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
        this.validaEntradas.validaDniCadastraDeputado(dni);

        if (!(mapPessoas.containsKey(dni))) {
            throw new IllegalArgumentException("Erro ao cadastrar deputado: pessoa nao encontrada");
        }
        this.validaEntradas.validaDataCadastroDeputado(dataInicio);

        if ((mapPessoas.get(dni).getPartido()) == null) {
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

        this.validaEntradas.validaExibirPessoa(dni);

        if (!this.mapPessoas.containsKey(dni)){
            throw new IllegalArgumentException("Erro ao exibir pessoa: pessoa nao encontrada");
        }

        if(this.mapPessoas.get(dni).getFuncao() != null){
            return this.mapPessoas.get(dni).toStringPelaFuncao();
        }

        return this.mapPessoas.get(dni).toString();
    }

    /**
     * Metodo responsavel por cadastrar um partido em um hashset de string, as strings representam os partidos que foram
     * cadastrador.
     *
     * @param partido string que representa o partido
     *
     * @throws IllegalArgumentException "Erro ao cadastrar partido: partido nao pode ser vazio ou nulo".
     * @throws NullPointerException "Erro ao cadastrar partido: partido nao pode ser vazio ou nulo".
     */
    public void cadastraPartido(String partido) {
        validaEntradas.validaCadastraPartido(partido);

        this.partidos.add(partido);
    }

    /**
     * Metodo responsavel por exibir todos os partidos que ja foram cadastrados no sistema. A string que sera retornada
     * pelo metodo possui todos os partidos organizados em ordem alfabetica e divididos por virgulas.
     *
     * @return uma string que representa todos os partidos ja cadastrados.
     */
    public String exibirBase() {
        // Ordenando os partidos em ordem alfabetica em uma lista.
        ArrayList<String> listaPartidos = new ArrayList<>(this.partidos);
        Collections.sort(listaPartidos);

        String partidos = "";
        boolean condicao = true;
        for (String partido : listaPartidos) {
            if (condicao) {
                partidos += partido;
                condicao = false;
            } else {
                partidos += "," + partido;
            }
        }

        return partidos;
    }

    /**
     * Metodo responsavel por deixar disponivel o atributo partidos, um set de string que representam partidos, os quais
     * serao usado nos testes do SystemControl.
     *
     * @return O set de string que representam os partidos.
     */
    public Set<String> getPartidos() {
        return partidos;
    }

    /**
     * Metodo responsavel por deixar disponivel o mapa de objetos do tipo Pessoa.
     *
     * @return o mapa de objetos do tipo Pessoa.
     */
    public Map<String, Pessoa> getMapPessoas(){
        return this.mapPessoas;
    }

    public void cadastrarComissao(String tema, String politicos) {
    }

    public String cadastrarPL(String dni, int ano, String ementa, String interesses, String url, boolean conclusivo) {
    }

    public String cadastrarPLP(String dni, int ano, String ementa, String interesses, String url, String artigos) {
    }

    public String cadastrarPEC(String dni, int ano, String ementa, String interesses, String url, String artigos) {
    }

    public String exibirProjeto(String codigo) {
    }

    public boolean votarComissao(String codigo, boolean governista, String comissao, String proximoLocal) {
    }

    public boolean votarPlenario(String codigo, boolean governista, String presentes) {
    }

    public String exibirTramitacao(String codigo) {
    }
}
