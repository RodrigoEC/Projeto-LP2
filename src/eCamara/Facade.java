package eCamara;

import easyaccept.EasyAccept;

public class Facade {

    private SystemControl systemControl;

    public Facade() {
        this.systemControl = new SystemControl();
    }

    public static void main(String[] args) {
        args = new String[] {"eCamara.Facade", "C:/Users/rodri/Documents/lp2/Projeto-LP2/acceptance_test/use_case_1.txt",
                                               "C:/Users/rodri/Documents/lp2/Projeto-LP2/acceptance_test/use_case_2.txt",
                                               "C:/Users/rodri/Documents/lp2/Projeto-LP2/acceptance_test/use_case_3.txt",
                                               "C:/Users/rodri/Documents/lp2/Projeto-LP2/acceptance_test/use_case_4.txt",
                                               "C:/Users/rodri/Documents/lp2/Projeto-LP2/acceptance_test/use_case_5.txt",
                                               "C:/Users/rodri/Documents/lp2/Projeto-LP2/acceptance_test/use_case_6.txt",
                                               "C:/Users/rodri/Documents/lp2/Projeto-LP2/acceptance_test/use_case_7.txt"};
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


    public void cadastrarPartido(String partido) {
        this.systemControl.cadastraPartido(partido);
    }

    public String exibirBase() {
        return this.systemControl.exibirBase();
    }

    //
    public void cadastrarComissao(String tema, String politicos) {
        this.systemControl.cadastrarComissao(tema, politicos);
    }

    public String cadastrarPL(String dni, int ano, String ementa, String interesses, String url, boolean conclusivo) {
        return this.systemControl.cadastrarPL(dni, ano, ementa, interesses, url, conclusivo);
    }

    public String cadastrarPLP(String dni, int ano, String ementa, String interesses, String url, String artigos) {
        return this.systemControl.cadastrarPLP(dni, ano, ementa, interesses, url, artigos);
    }

    public String cadastrarPEC(String dni, int ano, String ementa, String interesses, String url, String artigos) {
        return this.systemControl.cadastrarPEC(dni, ano, ementa, interesses, url, artigos);
    }

    public String exibirProjeto(String codigo){
        return  this.systemControl.exibirProjeto(codigo);
    }


    public boolean votarComissao(String codigo, String statusGovernista, String proximoLocal) {
        return this.systemControl.votarComissao(codigo, statusGovernista, proximoLocal);
    }

    public boolean votarPlenario(String codigo, String governista, String presentes) {
        return this.systemControl.votarPlenario(codigo, governista, presentes);
    }

    public String exibirTramitacao(String codigo) {
        return this.systemControl.exibirTramitacao(codigo);
    }

    public void carregarSistema(){

    }

    public void salvarSistema(){

    }

    public void limparSistema(){

    }

}