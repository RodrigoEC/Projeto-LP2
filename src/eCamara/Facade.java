package eCamara;

import easyaccept.EasyAccept;

public class Facade {

    private SystemControl systemControl;

    public Facade() {
        this.systemControl = new SystemControl();
    }

    public static void main(String[] args) {
        args = new String[] {"eCamara.Facade", "acceptance_test/use_case_1.txt",
                                               "acceptance_test/use_case_2.txt",
                                               "acceptance_test/use_case_3.txt",
                                               "acceptance_test/use_case_4.txt",
                                               "acceptance_test/use_case_5.txt",
                                               "acceptance_test/use_case_6.txt",
                                               "acceptance_test/use_case_7.txt"};
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

    public void configurarEstrategiaPropostaRelacionada(String dni, String estrategia){
        this.systemControl.configurarEstrategiaPropostaRelacionada(dni, estrategia);
    }

    public String pegarPropostaRelacionada(String dni){
        return this.systemControl.pegarPropostaRelacionada(dni);
    }

    public void carregarSistema(){
        this.systemControl.carregarSistema(this.systemControl);
    }

    public void salvarSistema(){
        this.systemControl.salvarSistema(this.systemControl);
    }

    public void limparSistema() {
        this.systemControl = GerenciadorArquivos.limparSistema(this.systemControl);
    }
}