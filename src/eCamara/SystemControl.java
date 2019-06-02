package eCamara;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Objeto que representa o Controller do sistema, tem como atributos o objeto de Validacao, um Map de Pessoa e um Set de Partido (String).
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
     * As validacoes do formato de data e de data futura eh delegada ao objeto Validacao validaEntradas, que utiliza o metodo validaDniCadastraDeputado,
     * que faz a validacao do dni, se apenas possui numeros e "-", caso tenha letras ou outros caracteres, lancara excecao.
     * @throws IllegalArgumentException Erro ao cadastrar deputado: dni invalido
     * O metodo validaDataCadastroDeputado, faz a validacao do formato da data passada como parametro, caso esteja fora do formato "ddMMyyyy",
     * (dia, mes e ano),nesta ordem ,lancara excecao, faz tambem  a validacao de se a data nao foi passada como nula ou vazia, caso sim lancara excecao.
     * @throws IllegalArgumentException Erro ao cadastrar deputado: data invalida
     * @throws IllegalArgumentException Data de inicio da funcao como deputado não pode ser vazia ou nula
     * Caso a data esteja no futuro, tambem lancara excecao.
     * @throws IllegalArgumentException Erro ao cadastrar deputado: data futura"
     * O metodo validaString verifica se os parametros dni e dataInicio sejam nulos ou vazios, uma excecao sera lancada.
     * @throws IllegalArgumentException Erro ao cadastrar deputado: data nao pode ser vazio ou nulo
     * @throws IllegalArgumentException Erro ao cadastrar pessoa: dni nao pode ser vazio ou nulo
     * Caso o dni da pessoa que sera cadastrada como deputado nao estiver no Map mapPessoas ou seja nao tenha sido cadastrada como pessoa, uma excecao sera lancada.
     * @throws IllegalArgumentException Erro ao cadastrar deputado:pessoa nao encontrada.
     * Caso a pessoa que seria cadastrada, ja seja deputado, uma excecao sera lancada.
     * @throws IllegalArgumentException Erro ao cadastrar deputado: pessoa ja e deputado.
     * Caso uma pessoa que seria cadastrada como deputado, nao possua partido, partido nulo ou vazio, uma excecao sera lancada.
     * @throws IllegalArgumentException Erro ao cadastrar deputado: pessoa sem partido
     * Se nenhuma das excecoes tenham sido lancadas, a pessoa sera cadastrada como deputado.
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

        }else if (mapPessoas.get(dni).getFuncao() instanceof Deputado) {
            throw new IllegalArgumentException("Erro ao cadastrar deputado: pessoa ja e deputado");
        }
        this.mapPessoas.get(dni).cadastraDeputado(dataInicio);
    }

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
     * Metodo responsavel por cadastrar um partidos no Hashset de partidos, o partido eh uma string.
     * @param partido string que representa o partido
     */
    public void cadastraPartido(String partido) {
        validaEntradas.validaCadastraPartido(partido);

        this.partidos.add(partido);
    }

    /**
     * Metodo responsavel por exibir todos os partidos que ja foram cadastrados no sistema.
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

    public Set<String> getPartidos() {
        return partidos;
    }

    public Map<String, Pessoa> getMapPessoas(){
        return this.mapPessoas;
    }
}
