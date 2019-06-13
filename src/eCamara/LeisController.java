package eCamara;

import eCamara.legislativo.PEC;
import eCamara.legislativo.PL;
import eCamara.legislativo.PLP;
import eCamara.legislativo.ProjetoDeLei;

import java.util.HashMap;
import java.util.Map;

public class LeisController {

    private Map<String, ProjetoDeLei> leis;
    private int contadorPL;
    private int contadorPLP;
    private int contadorPEC;

    public LeisController() {
        this.leis = new HashMap<>();
        this.contadorPL = 0;
        this.contadorPLP = 0;
        this.contadorPEC = 0;
    }

    /**
     * Metodo responsavel por cadastrar um projeto de legislativo no sistema, o metodo recebe o dni do deputado que criou o projeto
     * de legislativo, o que o projeto propoe(ementa), os interesses relacionados ao projeto, a url do site em que o projeto esta
     * hospedado, e um boolean que indica se o projeto eh ou nao conclusivo.
     *
     * @param dni dni do autor do projeto.
     * @param ano ano em que o projeto foi criado.
     * @param ementa ementa do projeto.
     * @param interesses interesses relacionados ao projeto de legislativo.
     * @param url url do site em que o projeto esta hospedado.
     * @param conclusivo boolean que mostra se o projeto eh conclusivo ou nao.
     * @return A key do projeto no mapa de projetos.
     */
    public String cadastrarPL(String dni, int ano, String ementa, String interesses, String url, boolean conclusivo) {
        this.contadorPL++;
        String key = "PL " + this.contadorPL + "/" + ano;

        this.leis.put(key, new PL(dni, ano, ementa, interesses, url, conclusivo));
        return key;

    }

    /**
     * Metodo responsavel por cadastrar um projeto de legislativo complementar no sistema, o metodo recebe o dni do deputado que criou o projeto
     * de legislativo, o que o projeto propoe(ementa), os interesses relacionados ao projeto, a url do site em que o projeto esta
     * hospedado, e uma string com os artigos da constituicao que estao relacionados ao projeto..
     *
     * @param dni dni do autor do projeto.
     * @param ano ano em que o projeto foi criado.
     * @param ementa ementa do projeto.
     * @param interesses interesses relacionados ao projeto de legislativo.
     * @param url url do site em que o projeto esta hospedado.
     * @param artigos string que representa os artigos da constituicao relacionados a plp.
     * @return A key do projeto no mapa de projetos.
     */
    public String cadastrarPLP(String dni, int ano, String ementa, String interesses, String url, String artigos) {
        this.contadorPLP++;
        String key = "PLP " + this.contadorPLP + "/" + ano;

        this.leis.put(key, new PLP(dni, ano, ementa, interesses, url, artigos));
        return key;

    }

    /**
     * Metodo responsavel por cadastrar um projeto de ementa constitucional no sistema, o metodo recebe o dni do deputado que criou o projeto
     * de legislativo, o que o projeto propoe(ementa), os interesses relacionados ao projeto, a url do site em que o projeto esta
     * hospedado, e uma string com os artigos da constituicao que estao relacionados ao projeto..
     *
     * @param dni dni do autor do projeto.
     * @param ano ano em que o projeto foi criado.
     * @param ementa ementa do projeto.
     * @param interesses interesses relacionados ao projeto de legislativo.
     * @param url url do site em que o projeto esta hospedado.
     * @param artigos string que representa os artigos da constituicao relacionados a plp.
     * @return A key do projeto no mapa de projetos.
     */
    public String cadastrarPEC(String dni, int ano, String ementa, String interesses, String url, String artigos) {
        this.contadorPEC++;
        String key = "PEC " + this.contadorPEC + "/" + ano;

        this.leis.put(key, new PEC(dni, ano, ementa, interesses, url, artigos));
        return key;

    }

    /**
     * Metodo responsavel por criar e retornar uma representacao textual do projeto que tem o codigo que eh passado como
     * parametro.
     *
     * @param codigo codigo do projeto no mapa.
     * @return uma string que representa os dados relevantes do projeto.
     */
    public String exibirProjeto(String codigo) {
        if (!this.leis.containsKey(codigo)){
            throw new NullPointerException("Nao contem esse codigo");
        }

        return this.leis.get(codigo).toString(codigo);
    }

    public void temLei(String codigoDaLei, String mensagem) {
        if(!this.leis.containsKey(codigoDaLei)) {
            throw new NullPointerException(mensagem);
        }
    }

    public HashMap<String, ProjetoDeLei> getLeis() {
        return (HashMap<String, ProjetoDeLei>) leis;
    }

    public ProjetoDeLei getLei(String codigoDaLei) {
        return this.leis.get(codigoDaLei);
    }

    public String exibirTramitacao(String codigo) {
        return this.leis.get(codigo).getTramitacao() + this.leis.get(codigo).getSituacao();
    }
}
