package ECamara;

import ECamara.Pessoa;

import java.util.HashMap;
import java.util.Map;

public class SystemControl {
    private Map<String, Pessoa> mapPessoas;
    private ECamara.Validacao validaEntradas;

    public SystemControl(){
        this.validaEntradas = new ECamara.Validacao();
        this.mapPessoas =  new HashMap<>();
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

    public String exibirBase() {
    } */
}
