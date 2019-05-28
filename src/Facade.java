import easyaccept.EasyAccept;

public class Facade {

    private SystemControl systemControl;

    public Facade(SystemControl systemControl) {
        this.systemControl = systemControl;
    }

    public static void main(String[] args) {
        args = new String[] {"saga.Facade", "acceptance_test/use_case_1.txt", "acceptance_test/use_case_2.txt",
                "acceptance_test/use_case_3.txt", "acceptance_test/use_case_4.txt"};
        EasyAccept.main(args);
    }

    public void cadastrarPessoa(String nome, String dni, String estado, String interesses) {
        this.systemControl.cadastrarPessoaSemPartido(nome, dni, estado, interesses);
    }

    public void cadastrarPessoa(String nome, String dni, String estado, String interesses, String partido) {
        this.systemControl.cadastrarPessoa(nome, dni, estado, interesses, partido);
    }

    public void cadastrarDeputado(String dni, String dataDeInicio) {
        this.systemControl.cadastraDeputado(dni, dataDeInicio);
    }

    public String exibirPessoa(String dni) {
        return this.systemControl.exibirPessoa(dni);
    }

    public String exibirBase() {
        return this.systemControl.exibirBase();
    }

}