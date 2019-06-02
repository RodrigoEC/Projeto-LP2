package eCamara;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
     * Metodo que valida o cadastro de uma Pessoa, delega as verificacoes para os metodos validaString e validaDni.
     * Recebe Strings com o dni, nome, e estado.
     *
     * @param dni String com o dni.
     * @param nome String com nome.
     * @param estado String com estado.
     */

    public void validarCadastroPessoa(String dni, String nome, String estado) {
        validaString(nome, "Erro ao cadastrar pessoa: nome nao pode ser vazio ou nulo");
        validaString(dni, "Erro ao cadastrar pessoa: dni nao pode ser vazio ou nulo");
        validaString(estado, "Erro ao cadastrar pessoa: estado nao pode ser vazio ou nulo");
        validaDni(dni, "Erro ao cadastrar pessoa: dni invalido");
    }

    /**
     * Metodo responsavel por verificar se a data passada como parametro eh uma data que ainda nao chegou no calendario,
     * ou seja, uma data do futuro.
     *
     * @param dataInicio data que sera verificada.
     * @param mensagem mensagem quee sera enviada quando a excecao for lancada.
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
     * Metodo que verifica se a data passada no parametro esta no formato certo, ddMMyyyy, ou seja dia depois mes e depois
     * ano.
     *
     * @param dataInicio data que sera validada.
     * @param mensagem mensagem que sera enviada se a excecao for lancada.
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
     * Metodo responsavel por validar o dni que eh passado como parametro no metodo cadastraDeputado, se o dni for nulo,
     * composto somente de espacos ou uma string vazia uma excecao sera lancada. se o formato da dni for diferente do exigido
     * uma excecao tambem sera lancada.
     *
     * @param dni dni a ser validada.
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
     */
    public void validaDeputado(String dataInicio){
        validaString(dataInicio, "Data de inicio da funcao como deputado não pode ser vazia ou nula");
    }

    /**
     * Metodo responsavel por validar a string que representa um partido no metodo "cadastrarPartido". Caso a entrada for
     * vazia, somente formada de espacos ou nula uma excecao sera lancada com a mensagem de acordo.
     *
     * @param partido string que representa o partido.
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
     */
    public void validaExibirPessoa(String dni) {
        validaString(dni, "Erro ao exibir pessoa: dni nao pode ser vazio ou nulo");
        validaDni(dni, "Erro ao exibir pessoa: dni invalido");
    }
}
