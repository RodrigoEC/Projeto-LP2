import java.util.HashMap;
import java.util.Map;

public class SystemControl {
    private Map<String, Pessoa> mapPessoas;
    private Validacao v;

    public SystemControl(){
        this.v = new Validacao();
        this.mapPessoas =  new HashMap<>();
    }

    public void cadastrarPessoaSemPartido(String nome, String dni, String estado, String interesses) {
        if (this.mapPessoas.containsKey(dni)){
            throw new IllegalArgumentException("Erro ao cadastrar pessoa: dni ja cadastrado");
        }
        else {
            this.v.validarCadastroPessoa(dni, nome, estado);
            this.mapPessoas.put(dni, new Pessoa(nome, dni, estado, interesses));
        }
    }

    public void cadastrarPessoa(String nome, String dni, String estado, String interesses, String partido) {
        if (this.mapPessoas.containsKey(dni)){
            throw new IllegalArgumentException("Erro ao cadastrar pessoa: dni ja cadastrado");
        }
        else {
            this.v.validarCadastroPessoa(dni, nome, estado);
            this.mapPessoas.put(dni, new Pessoa(nome, dni, estado, interesses, partido));
        }
    }

    public void cadastraDeputado(String dni, String dataDeInicio) {
    }


    public String exibirPessoa(String dni) {
    }

    public String exibirBase() {
    }
}
