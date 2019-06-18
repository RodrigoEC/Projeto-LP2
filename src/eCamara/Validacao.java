package eCamara;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.Date;

/**
 * Classe que representa um validador de entradas dos parametros de todos os metodos os sistemas, se esses parametros
 * forem invalidoss o nulos as excecoes adequadas serao lancadas.
 *
 */
public class Validacao {

    /**
     * Metodo que verifica se uma String e valida, uma String eh valida se ela nao for nula nem vazia. Recebe uma
     * String a ser avaliada e uma mensagem a ser exibida no erro.
     *
     * @param frase String com a frase a ser avaliada.
     * @param mensagem String com a mensagem a ser exibida.
     *
     * @throws NullPointerException mensagem.
     * @throws IllegalArgumentException mensagem.
     */
    private void validaString(String frase, String mensagem) {
        if (frase == null) {
            throw new NullPointerException(mensagem);
        }
        if ("".equals(frase.trim())) {
            throw new IllegalArgumentException(mensagem);
        }
    }

    /**
     * Metodo que valida o dni, o dni eh valido se nele so contiver numeros e -. Recebe o dni a ser avaliado
     * e a mensagem a ser exibida.
     *
     * @param dni String com o dni.
     * @param mensagem String com a mensagem.
     *
     * @throws IllegalArgumentException mensagem.
     */
    private void validaDni(String dni, String mensagem) {
        String[] array = dni.split("-");
        try {
            Integer.parseInt(array[0]);
            Integer.parseInt(array[1]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(mensagem);
        }
    }

    /**
     * Metodo responsavel por verificar se a data passada como parametro eh uma data que ainda nao chegou no calendario,
     * ou seja, uma data do futuro.
     *
     * @param dataInicio data que sera verificada.
     * @param mensagem mensagem quee sera enviada quando a excecao for lancada.
     *
     * @throws IllegalArgumentException mensagem
     */
    private void validaDataFutura(String dataInicio, String mensagem){
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
        sdf.setLenient(false);
        try {
            Date dataDeInicio = sdf.parse(dataInicio);
            Date dataAtual = new Date();
            if (dataDeInicio.compareTo(dataAtual) > 0) {
                throw new IllegalArgumentException(mensagem);
            }
        } catch (ParseException pe) {
            throw new IllegalArgumentException(mensagem);
        }
    }

    /**
     * Metodo responsavel por verificar se o ano passado como parametro eh um ano que nao eh do futuro.
     *
     * @param dataInicio data que sera valida
     * @param mensagem mensagem que sera mostrada caso a excecao seja lancada.
     */
    private void validaAno(String dataInicio, String mensagem){
        Year dataDeInicio = Year.parse(dataInicio);

        Year dataAtual = Year.now();

        if (dataDeInicio.compareTo(dataAtual) > 0) {
            throw new IllegalArgumentException(mensagem);
        }

    }


    /**
     * Metodo que verifica se a data passada no parametro esta no formato certo, ddMMyyyy, ou seja dia depois mes e depois
     * ano.
     *
     * @param dataInicio data que sera validada.
     * @param mensagem mensagem que sera enviada se a excecao for lancada.
     *
     * @throws IllegalArgumentException mensagem
     */
    private void validaFormatoData(String dataInicio, String mensagem) {
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
        sdf.setLenient(false);
        try {
            sdf.parse(dataInicio);
        } catch (ParseException pe) {
            throw new IllegalArgumentException(mensagem);
        }
    }

    /**
     * Metodo responsavel por verificar se o status governista eh "governista", "oposicao" ou "livre" se nao for nenhum
     * desses 3 tipos uma excecao sera lancada.
     *
     * @param statusGovernista status governista.
     * @param mensagem mensagem de que sera mostrada caso a excecao seja lancada
     *
     * @throws IllegalArgumentException mensagem
     */
    private void validaGovernista(String statusGovernista, String mensagem) {
        if (!"governista".equals(statusGovernista.toLowerCase()) && !"oposicao".equals(statusGovernista.toLowerCase()) && !"livre".equals(statusGovernista.toLowerCase())) {
            throw new IllegalArgumentException(mensagem);
        }
    }

    /**
     * Metodo que valida o cadastro de uma Pessoa, delega as verificacoes para os metodos validaString e validaDni.
     * Recebe Strings com o dni, tema, e estado.
     *
     * @param dni String com o dni.
     * @param estado String com estado.
     *
     * @throws IllegalArgumentException "Erro ao cadastrar pessoa: tema nao pode ser vazio ou nulo".
     * @throws IllegalArgumentException "Erro ao cadastrar pessoa: dni nao pode ser vazio ou nulo".
     * @throws IllegalArgumentException "Erro ao cadastrar pessoa: estado nao pode ser vazio ou nulo".
     *
     * @throws NullPointerException "Erro ao cadastrar pessoa: tema nao pode ser vazio ou nulo".
     * @throws NullPointerException "Erro ao cadastrar pessoa: dni nao pode ser vazio ou nulo".
     * @throws NullPointerException "Erro ao cadastrar pessoa: estado nao pode ser vazio ou nulo".
     *
     * @throws IllegalArgumentException "Erro ao cadastrar pessoa: dni invalido".
     */

    public void validarCadastroPessoa(String dni, String nome, String estado) {
        validaString(nome, "Erro ao cadastrar pessoa: nome nao pode ser vazio ou nulo");
        validaString(dni, "Erro ao cadastrar pessoa: dni nao pode ser vazio ou nulo");
        validaString(estado, "Erro ao cadastrar pessoa: estado nao pode ser vazio ou nulo");
        validaDni(dni, "Erro ao cadastrar pessoa: dni invalido");
    }

    /**
     * Metodo responsavel por validar o dni que eh passado como parametro no metodo cadastraDeputado, se o dni for nulo,
     * composto somente de espacos ou uma string vazia uma excecao sera lancada. se o formato da dni for diferente do exigido
     * uma excecao tambem sera lancada.
     *
     * @param dni dni a ser validada.
     *
     * @throws IllegalArgumentException "Erro ao cadastrar pessoa: dni nao pode ser vazio ou nulo".
     * @throws NullPointerException "Erro ao cadastrar pessoa: dni nao pode ser vazio ou nulo".
     *
     * @throws IllegalArgumentException "Erro ao cadastrar deputado: dni invalido".
     */
    public void validaDniCadastraDeputado(String dni){
        validaString(dni, "Erro ao cadastrar pessoa: dni nao pode ser vazio ou nulo");
        validaDni(dni,"Erro ao cadastrar deputado: dni invalido");
    }

    /**
     * Metodo responsavel por validar a data que eh passada como parametro no metodo cadastraDeputado, se a data for nula,
     * composta somente de espacos ou uma string vazia uma excecao sera lancada.
     * alem disso, se o formato da data for diferente de ddMMyyyy ou a data apresentada ainda nao chegou outra excecao
     * sera lancada.
     *
     * @param dataInicio data que sera validada.
     *
     * @throws IllegalArgumentException "Erro ao cadastrar deputado: data nao pode ser vazio ou nulo".
     * @throws NullPointerException "Erro ao cadastrar deputado: data nao pode ser vazio ou nulo".
     *
     * @throws IllegalArgumentException "Erro ao cadastrar deputado: data invalida".
     * @throws IllegalArgumentException "Erro ao cadastrar deputado: data futura".
     */

    public void validaDataCadastroDeputado(String dataInicio){
        validaString(dataInicio, "Erro ao cadastrar deputado: data nao pode ser vazio ou nulo");
        validaFormatoData(dataInicio, "Erro ao cadastrar deputado: data invalida");
        validaDataFutura(dataInicio, "Erro ao cadastrar deputado: data futura");
    }

    /**
     * Metodo responsavel por validar a data que eh passada como parametro no metodo cadastraDeputado, se a data for nula,
     * composta somente de espacos ou uma string vazia uma excecao sera lancada.
     *
     * @param dataInicio data que sera validada.
     *
     * @throws IllegalArgumentException "Data de inicio da funcao como deputado não pode ser vazia ou nula".
     * @throws NullPointerException "Data de inicio da funcao como deputado não pode ser vazia ou nula".
     */
    public void validaDeputado(String dataInicio){
        validaString(dataInicio, "Data de inicio da funcao como deputado não pode ser vazia ou nula");
    }

    /**
     * Metodo responsavel por validar a string que representa um partido no metodo "cadastrarPartido". Caso a entrada for
     * vazia, somente formada de espacos ou nula uma excecao sera lancada com a mensagem de acordo.
     *
     * @param partido string que representa o partido.
     *
     * @throws NullPointerException "Erro ao cadastrar partido: partido nao pode ser vazio ou nulo".
     * @throws IllegalArgumentException "Erro ao cadastrar partido: partido nao pode ser vazio ou nulo".
     */
    public void validaCadastraPartido(String partido) {
        validaString(partido, "Erro ao cadastrar partido: partido nao pode ser vazio ou nulo");
    }

    /**
     * Metodo que valida o dni que eh passado como parametro no metodo ExibirPessoa, se o dni for nulo, composto somente
     * de espacos ou uma string vazia uma excecao sera lancada. se o formato da dni for diferente do exigido uma excecao
     * tambem sera lancada.
     *
     * @param dni dni a ser validada.
     *
     * @throws IllegalArgumentException "Erro ao exibir pessoa: dni nao pode ser vazio ou nulo".
     * @throws NullPointerException "Erro ao exibir pessoa: dni nao pode ser vazio ou nulo".
     *
     * @throws IllegalArgumentException "Erro ao exibir pessoa: dni invalido".
     */
    public void validaExibirPessoa(String dni) {
        validaString(dni, "Erro ao exibir pessoa: dni nao pode ser vazio ou nulo");
        validaDni(dni, "Erro ao exibir pessoa: dni invalido");
    }

    /**
     * Metodo que valida o cadastro de Comissao, recebe como parametro o tema uma string com os dnis dos politicos da Comissao, se um dos dois
     * atributos for vazio ou nullo, sera lancado excecao. Faz uso do metodo auxiliar validaString.
     *
     * @param tema Sring com o tema a ser avaliado
     * @param politicos String com os dnis dos politicos a ser avaliado.
     *
     * @throws NullPointerException Erro ao cadastrar comissao: tema nao pode ser vazio ou nulo
     * @throws IllegalArgumentException Erro ao cadastrar comissao: tema nao pode ser vazio ou nulo
     * @throws NullPointerException Erro ao cadastrar comissao: lista de politicos nao pode ser vazio ou nulo
     * @throws IllegalArgumentException Erro ao cadastrar comissao: lista de politicos nao pode ser vazio ou nulo
     */
    public void validaCadastrarComissao(String tema, String politicos){
        this.validaString(tema, "Erro ao cadastrar comissao: tema nao pode ser vazio ou nulo");
        this.validaString(politicos, "Erro ao cadastrar comissao: lista de politicos nao pode ser vazio ou nulo");

    }

    /**
     * Metodo que valida os dnis para o cadastro de Comissao, se os dnis forem compostos por algo alem de numeros ou "-",
     * sera lancada excecao. Faz uso do metodo auxiliar validaDni.
     *
     * @param politicos Strins com os dnis dos politicos a ser avaliada.
     */
    public void validaCadastroComissaoDnis(String politicos){
        String[] array = politicos.trim().split(",");

        for (String dni: array){
            this.validaDni(dni, "Erro ao cadastrar comissao: dni invalido");
        }
    }

    /**
     * Metodo responsavel por validar as entradas do metodo cadastrarPL, lancando a excecao apropriada se as entradas
     * forem invalidas. Caso o dni seja vazio, ou apresente letras uma excecao sera lancada, caso o ano represente
     * um ano do futuro uma excecao tambem sera lancada, assim como se tanto a ementa, como os interesses, como a url sejam
     * vazios ou nulos uma excecao sera lancada.
     *
     * @param dni dni do autor do PL.
     * @param ano ano em que o PL foi criada.
     * @param ementa ementa do PL.
     * @param interesses interesses relacionados o PL.
     * @param url url do site em que o PL esta hospedada.
     *
     * @throws NullPointerException "Erro ao cadastrar projeto: autor nao pode ser vazio ou nulo".
     * @throws IllegalArgumentException "Erro ao cadastrar projeto: autor nao pode ser vazio ou nulo".
     *
     * @throws NullPointerException "Erro ao cadastrar projeto: ementa nao pode ser vazia ou nula".
     * @throws IllegalArgumentException "Erro ao cadastrar projeto: ementa nao pode ser vazia ou nula".
     *
     * @throws NullPointerException "Erro ao cadastrar projeto: interesse nao pode ser vazio ou nulo"
     * @throws IllegalArgumentException "Erro ao cadastrar projeto: interesse nao pode ser vazio ou nulo"
     *
     * @throws NullPointerException "Erro ao cadastrar projeto: url nao pode ser vazio ou nulo"
     * @throws IllegalArgumentException "Erro ao cadastrar projeto: url nao pode ser vazio ou nulo"
     *
     * @throws IllegalArgumentException "Erro ao cadastrar projeto: dni invalido"

     */
    public void validaCadastrarPL(String dni, int ano, String ementa, String interesses, String url){
        this.validaString(dni, "Erro ao cadastrar projeto: autor nao pode ser vazio ou nulo");
        this.validaString(ementa, "Erro ao cadastrar projeto: ementa nao pode ser vazia ou nula");
        this.validaString(interesses, "Erro ao cadastrar projeto: interesse nao pode ser vazio ou nulo");
        this.validaString(url, "Erro ao cadastrar projeto: url nao pode ser vazio ou nulo");
        this.validaDni(dni, "Erro ao cadastrar projeto: dni invalido");

        //MUDAR O NEGOCIO DO ANO 2019. TORNAR AUTOMATICO A PARTIR DA BIBLIOTECA JAVA.TIME
        if (ano < 1988) {
            throw new IllegalArgumentException("Erro ao cadastrar projeto: ano anterior a 1988");
        }

        validaAno(ano + "", "Erro ao cadastrar projeto: ano posterior ao ano atual");
    }


    /**
     * Metodo responsavel por validar as entradas do metodo cadastrarPLP, lancando a excecao apropriada se as entradas
     * forem invalidas. Caso o dni seja vazio, ou apresente letras uma excecao sera lancada, caso o ano represente
     * um ano do futuro uma excecao tambem sera lancada, assim como se tanto a ementa, como os interesses, como os artigos
     * da constituicao serem vazios ou nulos uma excecao sera lancada.
     *
     * @param dni dni do autor do PLP.
     * @param ano ano em que o PLP foi criada.
     * @param ementa ementa do PLP.
     * @param interesses interesses relacionados o PLP.
     * @param artigos artigos da constituicao que o PLP se relacionam.
     *
     * @throws NullPointerException "Erro ao cadastrar projeto: autor nao pode ser vazio ou nulo"
     * @throws IllegalArgumentException "Erro ao cadastrar projeto: autor nao pode ser vazio ou nulo"
     *
     * @throws NullPointerException "Erro ao cadastrar projeto: ementa nao pode ser vazia ou nula"
     * @throws IllegalArgumentException "Erro ao cadastrar projeto: ementa nao pode ser vazia ou nula"
     *
     * @throws NullPointerException "Erro ao cadastrar projeto: interesse nao pode ser vazio ou nulo"
     * @throws IllegalArgumentException "Erro ao cadastrar projeto: interesse nao pode ser vazio ou nulo"
     *
     *
     * @throws NullPointerException "Erro ao cadastrar projeto: url nao pode ser vazio ou nulo"
     * @throws IllegalArgumentException "Erro ao cadastrar projeto: url nao pode ser vazio ou nulo"
     *
     * @throws NullPointerException "Erro ao cadastrar projeto: artigo nao pode ser vazio ou nulo"
     * @throws IllegalArgumentException "Erro ao cadastrar projeto: artigo nao pode ser vazio ou nulo"
     *
     * @throws IllegalArgumentException "Erro ao cadastrar projeto: dni invalido"

     */
    public void validaCadastrarPLP(String dni, int ano, String ementa, String interesses, String url, String artigos) {
        this.validaString(dni, "Erro ao cadastrar projeto: autor nao pode ser vazio ou nulo");
        this.validaString(ementa, "Erro ao cadastrar projeto: ementa nao pode ser vazia ou nula");
        this.validaString(interesses, "Erro ao cadastrar projeto: interesse nao pode ser vazio ou nulo");
        this.validaString(url, "Erro ao cadastrar projeto: url nao pode ser vazio ou nulo");
        this.validaString(artigos, "Erro ao cadastrar projeto: artigo nao pode ser vazio ou nulo");
        this.validaDni(dni, "Erro ao cadastrar projeto: dni invalido");

        if (ano < 1988) {
            throw new IllegalArgumentException("Erro ao cadastrar projeto: ano anterior a 1988");
        }

        validaAno(ano + "", "Erro ao cadastrar projeto: ano posterior ao ano atual");
    }

    /**
     * Metodo responsavel por validar as entradas do metodo cadastrarPEC, lancando a excecao apropriada se as entradas
     * forem invalidas. Caso o dni seja vazio, ou apresente letras uma excecao sera lancada, caso o ano represente
     * um ano do futuro uma excecao tambem sera lancada, assim como se tanto a ementa, como os interesses, como os artigos
     * da constituicao serem vazios ou nulos uma excecao sera lancada.
     *
     * @param dni dni do autor do PEC
     * @param ano ano em que o PEC foi criada.
     * @param ementa ementa do PEC.
     * @param interesses interesses relacionados o PEC.
     * @param artigos artigos da constituicao que o PEC se relacionam.
     *
     * @throws NullPointerException "Erro ao cadastrar projeto: autor nao pode ser vazio ou nulo"
     * @throws IllegalArgumentException mensagem
     *
     * @throws NullPointerException "Erro ao cadastrar projeto: ementa nao pode ser vazia ou nula"
     * @throws IllegalArgumentException "Erro ao cadastrar projeto: ementa nao pode ser vazia ou nula"

     * @throws NullPointerException "Erro ao cadastrar projeto: interesse nao pode ser vazio ou nulo"
     * @throws IllegalArgumentException "Erro ao cadastrar projeto: interesse nao pode ser vazio ou nulo"


     * @throws NullPointerException "Erro ao cadastrar projeto: url nao pode ser vazio ou nulo"
     * @throws IllegalArgumentException "Erro ao cadastrar projeto: url nao pode ser vazio ou nulo"

     * @throws IllegalArgumentException "Erro ao cadastrar projeto: ano anterior a 1988"
     *
     * @throws IllegalArgumentException "Erro ao cadastrar projeto: dni invalido"

     */
    public void validaCadastrarPEC(String dni, int ano, String ementa, String interesses, String url, String artigos){
        this.validaString(dni, "Erro ao cadastrar projeto: autor nao pode ser vazio ou nulo");
        this.validaString(ementa, "Erro ao cadastrar projeto: ementa nao pode ser vazia ou nula");
        this.validaString(interesses, "Erro ao cadastrar projeto: interesse nao pode ser vazio ou nulo");
        this.validaString(url, "Erro ao cadastrar projeto: url nao pode ser vazio ou nulo");
        this.validaString(artigos, "Erro ao cadastrar projeto: artigo nao pode ser vazio ou nulo");
        this.validaDni(dni, "Erro ao cadastrar projeto: dni invalido");

        if (ano < 1988) {
            throw new IllegalArgumentException("Erro ao cadastrar projeto: ano anterior a 1988");
        }

        validaAno(ano + "", "Erro ao cadastrar projeto: ano posterior ao ano atual");
    }

    /**
     * metodo responsavel por validar o codigo do projeto passado como parametro no metodo exibeLei, lancando uma excecao
     * caso o codigo for nulo ou vazio.
     *
     * @param codigo codigo do projeto que sera exibido.
     */
    public void validaExibeLei(String codigo){
        this.validaString(codigo, "Ainda nao tem");
    }

    /**
     * Metodo responsavel por validar as entradas do metodo votarComissao, lancando as excecoes adequadas.
     *
     * @param statusGovernista status da lei.
     * @param proximoLocal proximo local que sera votada a lei.
     *
     * @throws NullPointerException "Erro ao votar proposta: status nao pode ser vazio ou nulo".
     * @throws IllegalArgumentException "Erro ao votar proposta: status nao pode ser vazio ou nulo".
     *
     * @throws IllegalArgumentException "Erro ao votar proposta: proximo local vazio"
     *
     *
     * @throws IllegalArgumentException "Erro ao votar proposta: status invalido"
     *
     */
    public void validaVotarComissao(String statusGovernista, String proximoLocal) {
        //validaString(codigoDaLei, "Erro ao votar proposta: codigo nao pode ser vazio ou nulo");
        validaString(statusGovernista, "Erro ao votar proposta: status nao pode ser vazio ou nulo");
        validaString(proximoLocal, "Erro ao votar proposta: proximo local vazio");
        validaGovernista(statusGovernista, "Erro ao votar proposta: status invalido");
    }

    /**
     * Metodo responsavel por validar as entradas do metodo votarComissao, lancando as excecoes adequadas.
     *
     * @param statusGovernista status da lei.
     * @param politicosPresentes politicos presentes na votacao no plenario.
     *
     * @throws NullPointerException "Erro ao votar proposta: status nao pode ser vazio ou nulo".
     * @throws IllegalArgumentException "Erro ao votar proposta: status nao pode ser vazio ou nulo".
     *
     * @throws IllegalArgumentException "Erro ao votar proposta: deputados presentes vazio".
     *
     * @throws IllegalArgumentException "Erro ao votar proposta: status invalido"
     *
     */
    public void validaVotarPlenario(String statusGovernista, String politicosPresentes) {
        validaString(statusGovernista, "Erro ao votar proposta: status nao pode ser vazio ou nulo");
        validaString(politicosPresentes, "Erro ao votar proposta: deputados presentes vazio");
        validaGovernista(statusGovernista, "Erro ao votar proposta: status invalido");
    }
}
