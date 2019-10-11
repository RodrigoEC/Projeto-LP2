package eCamara;

import easyaccept.EasyAccept;

public class Facade {

    private SystemController systemController;

    public Facade() {
        this.systemController = new SystemController();
    }

    public static void main(String[] args) {
        args = new String[] {"eCamara.Facade", "acceptance_test/use_case_1.txt",
                                               "acceptance_test/use_case_2.txt",
                                               "acceptance_test/use_case_3.txt",
                                               "acceptance_test/use_case_4.txt",
                                               "acceptance_test/use_case_5.txt",
                                               "acceptance_test/use_case_6.txt",
                                               "acceptance_test/use_case_7.txt",
                                               "acceptance_test/use_case_8.txt",
                                               "acceptance_test/use_case_9.txt"};
        EasyAccept.main(args);
    }

    /**
     * testing how to use the brnach thing on github for hacktoberfest2019, let's see how it goes
     */
    public void cadastrarPessoa(String nome, String dni, String estado, String interesses) {
        this.systemController.cadastrarPessoaSemPartido(nome, dni, estado, interesses);
    }

    public void cadastrarPessoa(String nome, String dni, String estado, String interesses, String partido) {
        this.systemController.cadastrarPessoa(nome, dni, estado, interesses, partido);
    }

    public void cadastrarDeputado(String dni, String dataDeInicio) {
        this.systemController.cadastraDeputado(dni, dataDeInicio);
    }


    public String exibirPessoa(String dni) {
        return this.systemController.exibirPessoa(dni);
    }


    public void cadastrarPartido(String partido) {
        this.systemController.cadastraPartido(partido);
    }

    public String exibirBase() {
        return this.systemController.exibirBase();
    }

    //
    public void cadastrarComissao(String tema, String politicos) {
        this.systemController.cadastrarComissao(tema, politicos);
    }

    public String cadastrarPL(String dni, int ano, String ementa, String interesses, String url, boolean conclusivo) {
        return this.systemController.cadastrarPL(dni, ano, ementa, interesses, url, conclusivo);
    }

    public String cadastrarPLP(String dni, int ano, String ementa, String interesses, String url, String artigos) {
        return this.systemController.cadastrarPLP(dni, ano, ementa, interesses, url, artigos);
    }

    public String cadastrarPEC(String dni, int ano, String ementa, String interesses, String url, String artigos) {
        return this.systemController.cadastrarPEC(dni, ano, ementa, interesses, url, artigos);
    }

    public String exibirProjeto(String codigo){
        return  this.systemController.exibirProjeto(codigo);
    }


    public boolean votarComissao(String codigo, String statusGovernista, String proximoLocal) {
        return this.systemController.votarComissao(codigo, statusGovernista, proximoLocal);
    }

    public boolean votarPlenario(String codigo, String governista, String presentes) {
        return this.systemController.votarPlenario(codigo, governista, presentes);
    }

    public String exibirTramitacao(String codigo) {
        return this.systemController.exibirTramitacao(codigo);
    }

    public void configurarEstrategiaPropostaRelacionada(String dni, String estrategia){
        this.systemController.configurarEstrategiaPropostaRelacionada(dni, estrategia);
    }

    public String pegarPropostaRelacionada(String dni){
        return this.systemController.pegarPropostaRelacionada(dni);
    }

    public void carregarSistema(){
        this.systemController.carregarSistema(this.systemController);
    }

    public void salvarSistema(){
        this.systemController.salvarSistema();
    }

    public void limparSistema() {
        this.systemController.limparSistema(this.systemController);
    }
}