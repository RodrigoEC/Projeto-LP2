package eCamara;

import eCamara.individuo.Pessoa;
import eCamara.legislativo.*;

import java.util.*;

/**
 * Objeto que representa o Controller do sistema, tem como atributos o objeto de Validacao, um Map de Pessoa e um Set de
 * Partido (String).
 */

public class SystemControl {
    private PessoaController controllerPessoas;
    private LeisController controllerLeis;
    private Votacao votacao;
    /**
     * Set de Partidos (String)
     */
    private Set<String> partidos;

    private Map<String, Comissao> comissoes;
    /**
     * Objeto de Validacao
     */
    private Validacao validaEntradas;

    /**
     * Constroi o SystemControl(Controller), inicia o Map e o Set e instancia o Objeto de validacao.
     */
    public SystemControl() {
        this.votacao = new Votacao();
        this.controllerLeis = new LeisController();
        this.controllerPessoas = new PessoaController();
        this.partidos = new HashSet<>();
        this.validaEntradas = new Validacao();
        this.comissoes = new HashMap<>();
    }



    public PessoaController getControllerDeputados() {
        return controllerPessoas;
    }


    /**
     * Metodo que cadastra um Pessoa que nao tem partido. Recebe Strings com o nome, dni, estado e
     * interesses. Delega a validacao para o objeto validador Validacao, faz uso do seu metodo validarCadastroPessoa.
     * Tambem verifica (antes de inserir no Map) se a Pessoa ja se encontra cadastrada pelo seu dni, se ja estiver sera
     * lancada excecao, se nao tiver sera cadastrada com sucesso.
     *
     * @param nome       String com o nome.
     * @param dni        String com o dni.
     * @param estado     String com o estado.
     * @param interesses String com o(s) interese(s).
     * @throws IllegalArgumentException Erro ao cadastrar pessoa: dni ja cadastrado.
     */

    public void cadastrarPessoaSemPartido(String nome, String dni, String estado, String interesses) {
        this.validaEntradas.validarCadastroPessoa(dni, nome, estado);

        this.controllerPessoas.cadastrarPessoaSemPartido(nome, dni, estado, interesses);
    }

    /**
     * Metodo que cadastra um Pessoa que tem partido. Recebe Strings com o nome, dni, estado, interesses e
     * partido. Delega a validacao para o objeto validador Validacao, faz uso do seu metodo validarCadastroPessoa.
     * Tambem verifica (antes de inserir no Map) se a Pessoa ja se encontra cadastrada pelo seu dni, se ja estiver sera
     * lancada excecao, se nao tiver sera cadastrada com sucesso.
     *
     * @param nome       String com o nome.
     * @param dni        String com o dni.
     * @param estado     String com o estado.
     * @param interesses String com o(s) interese(s).
     * @param partido    String com o partido.
     * @throws IllegalArgumentException Erro ao cadastrar pessoa: dni ja cadastrado.
     */

    public void cadastrarPessoa(String nome, String dni, String estado, String interesses, String partido) {
        this.validaEntradas.validarCadastroPessoa(dni, nome, estado);

        this.controllerPessoas.cadastrarPessoa(nome, dni, estado, interesses, partido);
    }

    /**
     * O metodo cadastraDeputado eh responsavel por cadastrar uma pessoa como deputado.
     * Recebe como parametros uma string que representa um dni (documento nacional de identificacao)
     * e uma string dataInicio que representa a data de inicio da vida publica como deputado.
     *
     * @param dni        String que representa o documento nacional de identificacao (dni) de uma pessoa.
     * @param dataInicio String que representa a data de inicio de uma pessoa na vida publica como deputado.
     * @throws IllegalArgumentException Erro ao cadastrar deputado: dni invalido
     * @throws IllegalArgumentException Erro ao cadastrar deputado: data invalida
     * @throws IllegalArgumentException Data de inicio da funcao como deputado não pode ser vazia ou nula
     * @throws IllegalArgumentException Erro ao cadastrar deputado: data futura"
     * @throws IllegalArgumentException Erro ao cadastrar deputado: data nao pode ser vazio ou nulo
     * @throws IllegalArgumentException Erro ao cadastrar pessoa: dni nao pode ser vazio ou nulo
     * @throws IllegalArgumentException Erro ao cadastrar deputado:pessoa nao encontrada.
     * @throws IllegalArgumentException Erro ao cadastrar deputado: pessoa ja e deputado.
     * @throws IllegalArgumentException Erro ao cadastrar deputado: pessoa sem partido
     */

    public void cadastraDeputado(String dni, String dataInicio) {
        this.validaEntradas.validaDniCadastraDeputado(dni);

        this.controllerPessoas.cadastraDeputado(dni, dataInicio);
    }

    /**
     * Metodo que exibe a representacao textual de uma Pessoa, com funcao ou nao, a partir do Dni recebido como
     * parametro. Se a pessoa nao estiver cadastrada, uma excecao sera lancada. O dni tambem e passado como parametro
     * para o metodo validaExibirPessoa da classe Validacao.
     *
     * @param dni String com dni.
     * @return Representacao textual de Pessoa.
     * @throws IllegalArgumentException Erro ao exibir pessoa: pessoa nao encontrada
     */
    public String exibirPessoa(String dni) {
        this.validaEntradas.validaExibirPessoa(dni);

        return this.controllerPessoas.exibirPessoa(dni);
    }

    /**
     * Metodo responsavel por cadastrar um partido em um hashset de string, as strings representam os partidos que foram
     * cadastrador.
     *
     * @param partido string que representa o partido
     * @throws IllegalArgumentException "Erro ao cadastrar partido: partido nao pode ser vazio ou nulo".
     * @throws NullPointerException     "Erro ao cadastrar partido: partido nao pode ser vazio ou nulo".
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
     * Metodo responsavel por cadastrar uma nova comissao, o metodo recebe o tema da comissao e uma string com todos os
     * dnis dos deputados participantes da comissao separados por virgula. Verifica se as strings sao validas, se nao for sera lancado excecao. Se forem
     * validas, sera verifiicado se aquele tema ja foi cadastrado se foi sera lancado excecaom se nao for
     * sera verificado se os deputados que fazem parte da comissao existem e se sao de fato debutados, caso nao exista ou nao seja deputado sera
     * lancado excecao. Se tudo for valido a Comissao sera cadastrada. Faz uso dos metodos validaCadastrarComissao e validaCadastroComissaoDnis da classe de Validacao.
     *
     * @param tema      o tema do projeto.
     * @param politicos string contendo os dnis do deputados participantes da comissao separados por virgula.
     * @throws IllegalArgumentException Erro ao cadastrar comissao: tema existente
     * @throws IllegalArgumentException Erro ao cadastrar comissao: pessoa inexistente
     * @throws NullPointerException     Erro ao cadastrar comissao: pessoa nao eh deputado
     */
    public void cadastrarComissao(String tema, String politicos) {
        this.validaEntradas.validaCadastrarComissao(tema, politicos);

        if (this.comissoes.containsKey(tema)) {
            throw new IllegalArgumentException("Erro ao cadastrar comissao: tema existente");
        }

        this.validaEntradas.validaCadastroComissaoDnis(politicos);

        String[] listaDnis = politicos.trim().split(",");

        HashMap<String, Pessoa> politicosMap = new HashMap<>();

        for (String dni : listaDnis) {
            this.controllerPessoas.procuraDniNoMapa(dni, "Erro ao cadastrar comissao: pessoa inexistente");
            this.controllerPessoas.ehDeputado(dni, "Erro ao cadastrar comissao: pessoa nao eh deputado");

            politicosMap.put(dni, this.controllerPessoas.getPessoa(dni));
        }

        this.comissoes.put(tema, new Comissao(tema, politicosMap));
    }

    /**
     * Metodo responsavel por cadastrar um projeto de legislativo no sistema, o metodo recebe o dni do deputado que criou o projeto
     * de legislativo, o que o projeto propoe(ementa), os interesses relacionados ao projeto, a url do site em que o projeto esta
     * hospedado, e um boolean que indica se o projeto eh ou nao conclusivo.
     *
     * @param dni        dni do autor do projeto.
     * @param ano        ano em que o projeto foi criado.
     * @param ementa     ementa do projeto.
     * @param interesses interesses relacionados ao projeto de legislativo.
     * @param url        url do site em que o projeto esta hospedado.
     * @param conclusivo boolean que mostra se o projeto eh conclusivo ou nao.
     * @return A key do projeto no mapa de projetos.
     */
    public String cadastrarPL(String dni, int ano, String ementa, String interesses, String url, boolean conclusivo) {
        this.validaEntradas.validaCadastrarPL(dni, ano, ementa, interesses, url);

        this.controllerPessoas.procuraDniNoMapa(dni, "Erro ao cadastrar projeto: pessoa inexistente");
        this.controllerPessoas.ehDeputado(dni, "Erro ao cadastrar projeto: pessoa nao eh deputado");

        return this.controllerLeis.cadastrarPL(dni, ano, ementa, interesses, url, conclusivo);

    }

    /**
     * Metodo responsavel por cadastrar um projeto de legislativo complementar no sistema, o metodo recebe o dni do deputado que criou o projeto
     * de legislativo, o que o projeto propoe(ementa), os interesses relacionados ao projeto, a url do site em que o projeto esta
     * hospedado, e uma string com os artigos da constituicao que estao relacionados ao projeto..
     *
     * @param dni        dni do autor do projeto.
     * @param ano        ano em que o projeto foi criado.
     * @param ementa     ementa do projeto.
     * @param interesses interesses relacionados ao projeto de legislativo.
     * @param url        url do site em que o projeto esta hospedado.
     * @param artigos    string que representa os artigos da constituicao relacionados a plp.
     * @return A key do projeto no mapa de projetos.
     */
    public String cadastrarPLP(String dni, int ano, String ementa, String interesses, String url, String artigos) {
        this.validaEntradas.validaCadastrarPLP(dni, ano, ementa, interesses, url, artigos);

        this.controllerPessoas.procuraDniNoMapa(dni, "Erro ao cadastrar projeto: pessoa inexistente");
        this.controllerPessoas.ehDeputado(dni, "Erro ao cadastrar projeto: pessoa nao eh deputado");

        return this.controllerLeis.cadastrarPLP(dni, ano, ementa, interesses, url, artigos);
    }

    /**
     * Metodo responsavel por cadastrar um projeto de ementa constitucional no sistema, o metodo recebe o dni do deputado que criou o projeto
     * de legislativo, o que o projeto propoe(ementa), os interesses relacionados ao projeto, a url do site em que o projeto esta
     * hospedado, e uma string com os artigos da constituicao que estao relacionados ao projeto..
     *
     * @param dni        dni do autor do projeto.
     * @param ano        ano em que o projeto foi criado.
     * @param ementa     ementa do projeto.
     * @param interesses interesses relacionados ao projeto de legislativo.
     * @param url        url do site em que o projeto esta hospedado.
     * @param artigos    string que representa os artigos da constituicao relacionados a plp.
     * @return A key do projeto no mapa de projetos.
     */
    public String cadastrarPEC(String dni, int ano, String ementa, String interesses, String url, String artigos) {
        this.validaEntradas.validaCadastrarPEC(dni, ano, ementa, interesses, url, artigos);

        this.controllerPessoas.procuraDniNoMapa(dni, "Erro ao cadastrar projeto: pessoa inexistente");
        this.controllerPessoas.ehDeputado(dni, "Erro ao cadastrar projeto: pessoa nao eh deputado");

        return this.controllerLeis.cadastrarPEC(dni, ano, ementa, interesses, url, artigos);


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

        return this.controllerLeis.exibirProjeto(codigo);
    }

    /**
     * Metodo que simula a votacacao de uma lei por uma comissao. Por padrao, toda lei comeca a ser votada na CCJC, caso ela nao estaja
     * cadastrada sera lancada excecao. Eh passado como parametro Strings contendo o codigo da lei, o statusGovernista da lei (indicando
     * se eh da base governista ou da oposição) e o proximo local a ser votado. Sera verificado se a lei existe, se nao exiastir sera lancado
     * excecao, tambem ira verificar se a lei ja foi encerrada, se foi vai ser lancado excecao e tambem vai ser verificado se a lei ja foi encaminhada
     * pro plenario, se foi  sera lancado excecao. Usa-se a classe Votacao para fazer a votacao, se a lei for aprovada o retorno sera true e
     * se foi reprovada o retorno sera false. Se a lei for aprovada sera registrado no deputado que fez a lei.
     *
     * @param codigoDaLei String com o codigo da lei a ser votada.
     * @param statusGovernista String com o status gorvernista.
     * @param proximoLocal String com o proximo local a ser votada a lei.
     * @return boolean referente a aprovacao da lei, se foi aprovada o retorno sera true, se foi reprovada o retrono sera false.
     *
     * @throws NullPointerException Erro ao votar proposta: CCJC nao cadastrada
     * @throws NullPointerException nao tem ainda :3
     * @throws IllegalArgumentException Erro ao votar proposta: tramitacao encerrada
     * @throws NullPointerException Erro ao votar proposta: proposta encaminhada ao plenario
     */

    public boolean votarComissao(String codigoDaLei, String statusGovernista, String proximoLocal) {

        if (!this.comissoes.containsKey("CCJC")) {
            throw new NullPointerException("Erro ao votar proposta: CCJC nao cadastrada");
        }
        this.validaEntradas.validaVotarComissao(statusGovernista, proximoLocal);

        this.controllerLeis.temLei(codigoDaLei, "Erro ao votar proposta: projeto inexistente");


        String comissaoVotante = this.controllerLeis.getLei(codigoDaLei).getVotante();

        ProjetoDeLei lei = this.controllerLeis.getLeis().get(codigoDaLei);
        if ("APROVADO".equals(lei.getSituacao()) || "ARQUIVADO".equals(lei.getSituacao())) {
            throw new IllegalArgumentException("Erro ao votar proposta: tramitacao encerrada");
        }

        if ("plenario".equals(comissaoVotante)) {
            throw new NullPointerException("Erro ao votar proposta: proposta encaminhada ao plenario");
        }


        boolean resultadoVotacao =  this.votacao.votarComissao(this.controllerLeis.getLeis().get(codigoDaLei), statusGovernista, proximoLocal,
                this.comissoes.get(comissaoVotante), this.partidos);

        if ("APROVADO".equals(lei.getSituacao())) {
            this.controllerPessoas.getPessoa(lei.getDniAutor()).addQtdLei();
        }
        return resultadoVotacao;
    }


    /*public boolean votarPlenario(String codigo, boolean governista, String presentes) {
    }
*/

    /**
     * Metodo que exibe a tramitacao de uma lei. Recebe o codigo da lei a ser exibidida.
     *v
     * @param codigo String com o codigo da lei que se quer exibir.
     * @return String com a tramitacao da lei.
     */
    public String exibirTramitacao(String codigo) {
        return this.controllerLeis.exibirTramitacao(codigo);
    }
}

