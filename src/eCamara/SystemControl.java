package eCamara;

import eCamara.individuo.Deputado;
import eCamara.individuo.Pessoa;
import eCamara.legislativo.*;

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

    private Map<String, Comissao> comissoes;

    private Map<String, ProjetoDeLei> leis;


    /** Objeto de Validacao */
    private Validacao validaEntradas;

    /**
     * Constroi o SystemControl(Controller), inicia o Map e o Set e instancia o Objeto de validacao.
     */
    public SystemControl(){
        this.mapPessoas =  new HashMap<>();
        this.partidos = new HashSet<>();
        this.validaEntradas = new Validacao();
        this.comissoes =  new HashMap<>();
        this.leis = new HashMap<>();
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

        this.validaEntradas.validaExibirPessoa(dni);

        if (!this.mapPessoas.containsKey(dni)){
            throw new IllegalArgumentException("Erro ao exibir pessoa: pessoa nao encontrada");
        }

        return this.mapPessoas.get(dni).toStringPelaFuncao();
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

    /**
     * Metodo responsavel por cadastrar uma nova comissao, o metodo recevbe o tema da comissao e uma string com todos os
     * dnis dos deputados participantes da comissao separados por virgula.
     *
     * @param tema o tema do projeto.
     * @param politicos string contendo os dnis do deputados participantes da comissao separados por virgula.
     */
    public void cadastrarComissao(String tema, String politicos) {
        this.validaEntradas.validaCadastrarComissao(tema, politicos);

        if (this.comissoes.containsKey(tema)){
            throw new IllegalArgumentException("Erro ao cadastrar comissao: tema existente");
        }

        this.validaEntradas.validaCadastroComissaoDnis(politicos);

        String[] listaDnis = politicos.trim().split(",");

        Map<String, Pessoa> politicosMap = new HashMap<>();

        for (String dni: listaDnis){
           if(!this.mapPessoas.containsKey(dni)){
               throw new IllegalArgumentException("Erro ao cadastrar comissao: pessoa inexistente");
           }
           if(! this.mapPessoas.get(dni).temFuncao()){
                throw new NullPointerException("Erro ao cadastrar comissao: pessoa nao eh deputado");
           }
           politicosMap.put(dni, this.mapPessoas.get(dni));
        }

        this.comissoes.put(tema, new Comissao(tema, politicosMap));
    }

    /**
     * Metodo responsavel por cadastrar um projeto de legislativo no sistema, o metodo recebe o dni do deputado que criou o projeto
     * de legislativo, o que o projeto propoe(ementa), os interesses relacionados ao projeto, a url do site em que o projeto esta
     * hospedado, e um boolean que indica se o projeto eh ou nao conclusivo.
     *
     * @param dni dni do autor do projeto.
     * @param ano ano em que o projeto foi criado.
     * @param ementa ementa do projeto.
     * @param interesses interesses relacionados ao projeto de legislativo.
     * @param url url do site em que o projeto esta hospedado.
     * @param conclusivo boolean que mostra se o projeto eh conclusivo ou nao.
     * @return A key do projeto no mapa de projetos.
     */
   public String cadastrarPL(String dni, int ano, String ementa, String interesses, String url, boolean conclusivo) {
        this.validaEntradas.validaCadastrarPL(dni, ano, ementa, interesses, url);

        if (! this.mapPessoas.containsKey(dni)){
            throw new NullPointerException("Erro ao cadastrar projeto: pessoa inexistente");
        }
        if (! this.mapPessoas.get(dni).temFuncao()) {
            throw new IllegalArgumentException("Erro ao cadastrar projeto: pessoa nao eh deputado");
        }

        int contador = 1;
        String key = "PL " + contador + "/" + ano;
        for (String e :  this.leis.keySet()){
            if (e.equals(key)){
                contador += 1;
                key  = "PL " + contador + "/" + ano;
            }
        }

        this.leis.put(key, new PL(dni, ano, ementa, interesses, url, conclusivo));
        return key;

    }

    /**
     * Metodo responsavel por cadastrar um projeto de legislativo complementar no sistema, o metodo recebe o dni do deputado que criou o projeto
     * de legislativo, o que o projeto propoe(ementa), os interesses relacionados ao projeto, a url do site em que o projeto esta
     * hospedado, e uma string com os artigos da constituicao que estao relacionados ao projeto..
     *
     * @param dni dni do autor do projeto.
     * @param ano ano em que o projeto foi criado.
     * @param ementa ementa do projeto.
     * @param interesses interesses relacionados ao projeto de legislativo.
     * @param url url do site em que o projeto esta hospedado.
     * @param artigos string que representa os artigos da constituicao relacionados a plp.
     * @return A key do projeto no mapa de projetos.
     */
    public String cadastrarPLP(String dni, int ano, String ementa, String interesses, String url, String artigos) {
        this.validaEntradas.validaCadastrarPLP(dni, ano, ementa, interesses, url, artigos);

        if (! this.mapPessoas.containsKey(dni)){
            throw new NullPointerException("Erro ao cadastrar projeto: pessoa inexistente");
        }
        if (! this.mapPessoas.get(dni).temFuncao()) {
            throw new IllegalArgumentException("Erro ao cadastrar projeto: pessoa nao eh deputado");
        }

        int contador = 1;
        String key = "PLP " + contador + "/" + ano;
        for (String e :  this.leis.keySet()){
            if (e.equals(key)){
                contador += 1;
                key  = "PLP " + contador + "/" + ano;
            }
        }
        this.leis.put(key, new PLP(dni, ano, ementa, interesses, url, artigos));
        return key;

    }

    /**
     * Metodo responsavel por cadastrar um projeto de ementa constitucional no sistema, o metodo recebe o dni do deputado que criou o projeto
     * de legislativo, o que o projeto propoe(ementa), os interesses relacionados ao projeto, a url do site em que o projeto esta
     * hospedado, e uma string com os artigos da constituicao que estao relacionados ao projeto..
     *
     * @param dni dni do autor do projeto.
     * @param ano ano em que o projeto foi criado.
     * @param ementa ementa do projeto.
     * @param interesses interesses relacionados ao projeto de legislativo.
     * @param url url do site em que o projeto esta hospedado.
     * @param artigos string que representa os artigos da constituicao relacionados a plp.
     * @return A key do projeto no mapa de projetos.
     */
    public String cadastrarPEC(String dni, int ano, String ementa, String interesses, String url, String artigos) {
        this.validaEntradas.validaCadastrarPEC(dni, ano, ementa, interesses, url, artigos);

        if (! this.mapPessoas.containsKey(dni)){
            throw new NullPointerException("Erro ao cadastrar projeto: pessoa inexistente");
        }
        if (! this.mapPessoas.get(dni).temFuncao()) {
            throw new IllegalArgumentException("Erro ao cadastrar projeto: pessoa nao eh deputado");
        }

        int contador = 1;
        String key = "PEC " + contador + "/" + ano;
        for (String e :  this.leis.keySet()){
            if (e.equals(key)){
                contador += 1;
                key  = "PEC " + contador + "/" + ano;
            }
        }
        this.leis.put(key, new PEC(dni, ano, ementa, interesses, url, artigos));
        return key;

    }

    /**
     * Metodo responsavel por criar e retornar uma representacao textual do projeto que tem o codigo que eh passado como
     * parametro.
     *
     * @param codigo codigo do projeto no mapa.
     * @return uma string que representa os dados relevantes do projeto.
     */
    public String exibirProjeto(String codigo) {
        this.validaEntradas.validaExibeLei(codigo);

        if (! this.leis.containsKey(codigo)){
            throw new NullPointerException("Nao contem esse codigo");
        }

        return this.leis.get(codigo).toString(codigo);
    }

    /*public boolean votarComissao(String codigo, boolean governista, String comissao, String proximoLocal) {
    }

    public boolean votarPlenario(String codigo, boolean governista, String presentes) {
    }

    public String exibirTramitacao(String codigo) {
    }*/
}
