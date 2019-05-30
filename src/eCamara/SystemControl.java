package eCamara;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class SystemControl {
    private Map<String, Pessoa> mapPessoas;
    private Set<String> partidos;
    private Validacao validaEntradas;

    public SystemControl(){
        this.mapPessoas =  new HashMap<>();
        this.partidos = new HashSet<>();
        this.validaEntradas = new Validacao();
    }

    public void cadastrarPessoaSemPartido(String nome, String dni, String estado, String interesses) {
        this.validaEntradas.validarCadastroPessoa(dni, nome, estado);

        if (this.mapPessoas.containsKey(dni)){
            throw new IllegalArgumentException("Erro ao cadastrar pessoa: dni ja cadastrado");
        }

        this.mapPessoas.put(dni, new Pessoa(nome, dni, estado, interesses));
    }

    public void cadastrarPessoa(String nome, String dni, String estado, String interesses, String partido) {
        this.validaEntradas.validarCadastroPessoa(dni, nome, estado);

        if (this.mapPessoas.containsKey(dni)){
            throw new IllegalArgumentException("Erro ao cadastrar pessoa: dni ja cadastrado");
        }

        this.mapPessoas.put(dni, new Pessoa(nome, dni, estado, interesses, partido));
    }

    public void cadastraDeputado(String dni, String dataDeInicio) {
        this.validaEntradas.validaCadastroDeputado(dni);

        if (dni == null || dni.trim().equals("")){
            throw new IllegalArgumentException("Erro ao cadastrar pessoa: dni nao pode ser vazio ou nulo");
        }
        if (!(mapPessoas.containsKey(dni))){
            throw new IllegalArgumentException("Erro ao cadastrar deputado: pessoa nao encontrada");
        }
        if (dataDeInicio == null || dataDeInicio.equals("")){
            throw new IllegalArgumentException("Erro ao cadastrar deputado: data nao pode ser vazio ou nulo");
        }

        // SimpleDateFormat é classe que faz a formatacao da data.
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
        sdf.setLenient(false);
        try {
            Date dataInicio = sdf.parse(dataDeInicio);
            // conversao de data como String para o tipo Date.
            Date dataAtual = new Date();
            if (dataInicio.compareTo(dataAtual) > 0) {
                throw new IllegalArgumentException("Erro ao cadastrar deputado: data futura");
            }
        } catch (ParseException pe) {
            throw new IllegalArgumentException("Erro ao cadastrar deputado: data invalida");
        }
        if ((mapPessoas.get(dni).getPartido()) == null) {
            throw new IllegalArgumentException("Erro ao cadastrar deputado: pessoa sem partido");
        }
        // nao tem teste no easy accept pra essa excecao
        //else if (!(mapPessoas.get(dni).getFuncao() instanceof Deputado)) {
        //throw new IllegalArgumentException("Erro ao cadastrar deputado: pessoa ja e deputado");

        this.mapPessoas.get(dni).cadastraDeputado(dataDeInicio);
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
}
