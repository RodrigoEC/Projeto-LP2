package ECamara;

import ECamara.Pessoa;

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

    /*public void cadastraDeputado(String dni, String dataDeInicio) {
    }


    public String exibirPessoa(String dni) {
    }
    */
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
