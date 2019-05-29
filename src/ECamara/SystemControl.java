package ECamara;

import ECamara.Pessoa;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class SystemControl {
    private Map<String, Pessoa> mapPessoas;
    private Set<String> partidos;
    private Validacao validaEntradas;

    public SystemControl(){
        this.validaEntradas = new Validacao();
        this.mapPessoas =  new HashMap<>();
        this.partidos = new HashSet<>();
    }

    public void cadastrarPessoaSemPartido(String nome, String dni, String estado, String interesses) {
        this.validaEntradas.validarCadastroPessoa(dni, nome, estado);

        if (this.mapPessoas.containsKey(dni)){
            throw new IllegalArgumentException("Erro ao cadastrar pessoa: dni ja cadastrado");
        }
        else {
            this.mapPessoas.put(dni, new Pessoa(nome, dni, estado, interesses));
        }
    }

    public void cadastrarPessoa(String nome, String dni, String estado, String interesses, String partido) {
        this.validaEntradas.validarCadastroPessoa(dni, nome, estado);

        if (this.mapPessoas.containsKey(dni)){
            throw new IllegalArgumentException("Erro ao cadastrar pessoa: dni ja cadastrado");
        }
        else {
            this.mapPessoas.put(dni, new Pessoa(nome, dni, estado, interesses, partido));
        }
    }

    public void cadastraDeputado(String dni, String dataDeInicio) {

        if (dni == null || dni.equals("")) {
            throw new IllegalArgumentException("Erro ao cadastrar pessoa: dni nao pode ser vazio ou nulo");
        } else if (dataDeInicio == null || dataDeInicio.equals("")) {
            throw new IllegalArgumentException("Erro ao cadastrar deputado: data nao pode ser vazio ou nulo");
        }

        // SimpleDateFormat é classe que faz a formatacao da data.
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
        try {
            Date dataInicio = sdf.parse(dataDeInicio);
            // conversao de data como String para o tipo Date.
            Date dataAtual = new Date();
            if (dataAtual.compareTo(dataInicio) > 1) {
                throw new IllegalArgumentException("Erro ao cadastrar deputado: data futura");
            }
        } catch (ParseException pe) {
            throw new IllegalArgumentException("Erro ao cadastrar deputado: data invalida");
        }

        if (!mapPessoas.containsKey(dni)) {
            throw new IllegalArgumentException("Erro ao cadastrar deputado: pessoa nao encontrada");
        } else if ((mapPessoas.get(dni).getPartido()) == null) {
            throw new IllegalArgumentException("Erro ao cadastrar deputado: pessoa sem partido");
        }
        // nao tem teste no easy accept pra essa excecao
        else if (!(mapPessoas.get(dni).getFuncao() instanceof Deputado)) {
            throw new IllegalArgumentException("Erro ao cadastrar deputado: pessoa ja e deputado");
        }
    }



    //public String exibirPessoa(String dni) {

    public void cadastraPartido(String partido) {
        validaEntradas.validaCadastraPartido(partido);
        this.partidos.add(partido);
    }

    public String exibirBase() {
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
}
