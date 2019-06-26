package eCamara;

import eCamara.individuo.Deputado;
import eCamara.SystemController;
import eCamara.individuo.Pessoa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class SystemControlTest {

    private SystemController systemControl;
    private SystemController systemControl2;

    @BeforeEach
    public void controleGeral() {
        this.systemControl = new SystemController();
        this.systemControl2 = new SystemController();
        this.systemControl2.cadastrarPessoa("Daniel", "34-3", "PB", "Rinha de Galo","lrg");
        this.systemControl2.cadastraDeputado("34-3", "12102001");
        this.systemControl2.cadastrarComissao("Bla", "34-3");
        this.systemControl2.salvarSistema();
    }

    @Test
    void SystemControlTest() {
        assertTrue(this.systemControl.getControllerPessoas().getMapPessoas().isEmpty());
    }

    @Test
    void cadastraPessoaSemPartidoNomeVazio() {
        try {
            this.systemControl.cadastrarPessoaSemPartido(" ", "0053-3", "GG", "");
            fail("Era esperado excecao");
        } catch (IllegalArgumentException iae) {
        }
    }

    @Test
    void cadastraPessoaSemPartidoNomeNull() {
        try {
            this.systemControl.cadastrarPessoaSemPartido(null, "0053-3", "GG", "");
            fail("Era esperado excecao");
        } catch (NullPointerException npe) {
        }
    }

    @Test
    void cadastraPessoaSemPartidoDniVazio() {
        try {
            this.systemControl.cadastrarPessoaSemPartido("Jao", " ", "GG", "");
            fail("Era esperado excecao");
        } catch (IllegalArgumentException iae) {
        }
    }

    @Test
    void cadastraPessoaSemPartidoDniNull() {
        try {
            this.systemControl.cadastrarPessoaSemPartido("Jao", null, "GG", "");
            fail("Era esperado excecao");
        } catch (NullPointerException npe) {
        }
    }

    @Test
    void cadastraPessoaSemPartidoDniInvalido() {
        try {
            this.systemControl.cadastrarPessoaSemPartido("Jao", "adaa", "GG", "");
            fail("Era esperado excecao");
        } catch (IllegalArgumentException iae) {
        }
    }

    @Test
    void cadastraPessoaSemPartidoEstadoVazio() {
        try {
            this.systemControl.cadastrarPessoaSemPartido("Jao", "234-2", " ", "");
            fail("Era esperado excecao");
        } catch (IllegalArgumentException iae) {
        }
    }

    @Test
    void cadastraPessoaSemPartidoEstadoNull() {
        try {
            this.systemControl.cadastrarPessoaSemPartido("Jao", "233-2", null, "");
            fail("Era esperado excecao");
        } catch (NullPointerException npe) {
        }
    }

    @Test
    void cadastraPessoaSemPartidoValida() {
        this.systemControl.cadastrarPessoaSemPartido("Jao", "233-2", "gg", "");
        assertFalse(this.systemControl.getControllerPessoas().getMapPessoas().isEmpty());
    }

    @Test
    void cadastraPessoaSemPartidoPessoaJaCadastrada() {
        this.systemControl.cadastrarPessoaSemPartido("Jao", "233-2", "gg", "");
        try {
            this.systemControl.cadastrarPessoaSemPartido("Jao", "233-2", "AM", "");
        } catch (IllegalArgumentException iae) {
        }
    }

    @Test
    void cadastraPessoaSemPartidoPessoaJaCadastradaComPartido() {
        this.systemControl.cadastrarPessoa("Jao", "233-2", "gg", "", "LRG - Libera Rinha de Galo");
        try {
            this.systemControl.cadastrarPessoaSemPartido("Jao", "233-2", "AM", "");
        } catch (IllegalArgumentException iae) {
        }
    }

    @Test
    void cadastraPessoaComPartidoNomeVazio() {
        try {
            this.systemControl.cadastrarPessoa(" ", "0053-3", "GG", "", "LRG - Libera Rinha de Galo");
            fail("Era esperado excecao");
        } catch (IllegalArgumentException iae) {
        }
    }

    @Test
    void cadastraPessoaComPartidoNomeNull() {
        try {
            this.systemControl.cadastrarPessoa(null, "0053-3", "GG", "", "LRG - Libera Rinha de Galo");
            fail("Era esperado excecao");
        } catch (NullPointerException npe) {
        }
    }

    @Test
    void cadastraPessoaComPartidoDniVazio() {
        try {
            this.systemControl.cadastrarPessoa("Jao", " ", "GG", "", "LRG - Libera Rinha de Galo");
            fail("Era esperado excecao");
        } catch (IllegalArgumentException iae) {
        }
    }

    @Test
    void cadastraPessoaComPartidoDniNull() {
        try {
            this.systemControl.cadastrarPessoa("Jao", null, "GG", "", "LRG - Libera Rinha de Galo");
            fail("Era esperado excecao");
        } catch (NullPointerException npe) {
        }
    }

    @Test
    void cadastraPessoaComPartidoDniInvalido() {
        try {
            this.systemControl.cadastrarPessoa("Jao", "adaa", "GG", "", "LRG - Libera Rinha de Galo");
            fail("Era esperado excecao");
        } catch (IllegalArgumentException iae) {
        }
    }

    @Test
    void cadastraPessoaComPartidoEstadoVazio() {
        try {
            this.systemControl.cadastrarPessoa("Jao", "234-2", " ", "", "LRG - Libera Rinha de Galo");
            fail("Era esperado excecao");
        } catch (IllegalArgumentException iae) {
        }
    }

    @Test
    void cadastraPessoaEstadoNUll() {
        try {
            this.systemControl.cadastrarPessoa("Jao", "233-2", null, "", "LRG - Libera Rinha de Galo");
            fail("Era esperado excecao");
        } catch (NullPointerException npe) {
        }
    }

    @Test
    void cadastraPessoaComPartidoValida() {
        this.systemControl.cadastrarPessoa("Jao", "233-2", "gg", "", "LRG - Libera Rinha de Galo");
        assertFalse(this.systemControl.getControllerPessoas().getMapPessoas().isEmpty());
    }

    @Test
    void cadastraPessoaJaCadastrada() {
        this.systemControl.cadastrarPessoa("Jao", "233-2", "gg", "", "LRG - Libera Rinha de Galo");
        try {
            this.systemControl.cadastrarPessoa("Jao", "233-2", "AM", "", "LRG - Libera Rinha de Galo");
        } catch (IllegalArgumentException iae) {
        }
    }

    @Test
    void cadastraPessoaJaCadastradaSemPartido() {
        this.systemControl.cadastrarPessoaSemPartido("Jao", "233-2", "gg", "");
        try {
            this.systemControl.cadastrarPessoa("Jao", "233-2", "AM", "", "LRG - Libera Rinha de Galo");
        } catch (IllegalArgumentException iae) {
        }
    }

    @Test
    void cadastraDeputadoTest() {
        this.systemControl.cadastrarPessoa("Maria", "159-2", "PB", "ganhar", "PRB");
        this.systemControl.cadastraDeputado("159-2", "13012018");
        assertTrue(this.systemControl.getControllerPessoas().getMapPessoas().get("159-2").getFuncao() != null);
    }

    @Test
    void cadastraDeputadoFuncaoNula() {
        this.systemControl.cadastrarPessoa("Joao", "169-2", "PB", "ganhar", "PRB");
        this.systemControl.cadastraDeputado("169-2", "21032019");
        assertFalse(this.systemControl.getControllerPessoas().getMapPessoas().get("169-2").getFuncao() == null);
    }

    @Test
    void cadastraDeputadoJaDeputado() {
        this.systemControl.cadastrarPessoa("Joao", "169-2", "PB", "ganhar", "PRB");
        this.systemControl.cadastraDeputado("169-2", "21032019");
        try {
            this.systemControl.cadastraDeputado("169-2", "21032019");
        } catch (IllegalArgumentException iae) {
        }
    }

    @Test
    void cadastraDeputadoFuncaoVazia() {
        this.systemControl.cadastrarPessoa("Mariana", "168-2", "PB", "ganhar", "PRB");
        this.systemControl.cadastraDeputado("168-2", "13012000");
        assertFalse(this.systemControl.getControllerPessoas().getMapPessoas().get("168-2").getFuncao().equals(""));
    }

    @Test
    void cadastraDeputadoPessoaNaoCadastrada() {
        this.systemControl.cadastrarPessoa("Maria", "1693-2", "PB", "ganhar", "PRB");
        try {
            this.systemControl.cadastraDeputado("12-2", "13012000");
        } catch (IllegalArgumentException iae) {
        }
    }

    @Test
    void cadastraDeputadoDataFormatoInvalido() {
        this.systemControl.cadastrarPessoa("Juliana", "255-3", "PE", "mudar", "PCdoB");
        try {
            this.systemControl.cadastraDeputado("255-3", "13/01/2000");
        } catch (IllegalArgumentException iae) {
        }
    }

    @Test
    void cadastraDeputadoDniVazio() {
        this.systemControl.cadastrarPessoa("Bruna", "899-4", "PB", "transformar", "PSDB");
        try {
            this.systemControl.cadastraDeputado("", "13012010");
        } catch (IllegalArgumentException iae) {
        }
    }

    @Test
    void cadastraDeputadoDataInicioVazia() {
        this.systemControl.cadastrarPessoa("Noemia", "123-4", "PB", "transformar", "PSDB");
        try {
            this.systemControl.cadastraDeputado("123-4", "");
        } catch (IllegalArgumentException iae) {
        }
    }

    @Test
    void cadastraDeputadoDniNulo() {
        this.systemControl.cadastrarPessoa("Bruna", "899-4", "PB", "transformar", "PSDB");
        try {
            this.systemControl.cadastraDeputado(null, "13012010");
        } catch (NullPointerException npe) {
        }
    }

    @Test
    void cadastraDeputadoDataInicioNula() {
        this.systemControl.cadastrarPessoa("Noemia", "123-4", "PB", "transformar", "PSDB");
        try {
            this.systemControl.cadastraDeputado("123-4", null);
        } catch (NullPointerException npe) {
        }
    }

    @Test
    void cadastraDeputadoParametrosVazios() {
        this.systemControl.cadastrarPessoa("Laura", "563-4", "PB", "debater", "PSDB");
        try {
            this.systemControl.cadastraDeputado("", "");
        } catch (IllegalArgumentException iae) {
        }
    }

    @Test
    void cadastraDeputadoDataFutura() {
        this.systemControl.cadastrarPessoa("Lais", "103-4", "PB", "discutir solucoes", "PSDB");
        try {
            this.systemControl.cadastraDeputado("103-4", "14062030");
        } catch (IllegalArgumentException iae) {
        }
    }

    @Test
    void cadastraDeputadoDniInvalido() {
        this.systemControl.cadastrarPessoa("Ellen", "103-4", "PB", "renovar", "PSDB");
        try {
            this.systemControl.cadastraDeputado("103Aa-4", "30062018");
        } catch (IllegalArgumentException iae) {
        }
    }

    @Test
    void cadastraDeputadoPartidoVazio() {
        this.systemControl.cadastrarPessoa("Ellen", "142-8", "PB", "renovar", "");
        try {
            this.systemControl.cadastraDeputado("142-8", "22112014");
        } catch (IllegalArgumentException iae) {
        }
    }

    @Test
    void cadastraDeputadoPartidoNulo() {
        this.systemControl.cadastrarPessoa("Ellen", "142-8", "PB", "renovar", null);
        try {
            this.systemControl.cadastraDeputado("142-8", "22112014");
        } catch (IllegalArgumentException iae) {
        }
    }

    @Test
    void cadastraDeputadoDataForaFormato() {
        this.systemControl.cadastrarPessoa("Ellen", "142-8", "PB", "renovar", "PSDB");
        try {
            this.systemControl.cadastraDeputado("142-8", "1052019");
        } catch (IllegalArgumentException iae) {
        }
    }

    @Test
    void cadastraComissaoTemaVazio() {
        try {
            this.systemControl.cadastrarComissao("", "123456789-0,222222222-2,333333333-3");
        } catch (IllegalArgumentException iae) {

        }
    }

    @Test
    void cadastraComissaoPoliticosVazio() {
        try {
            this.systemControl.cadastrarComissao("Educacao", "");
        } catch (IllegalArgumentException iae) {

        }
    }

    @Test
    void cadastraComissaoTemaNulo() {
        try {
            this.systemControl.cadastrarComissao(null, "123456789-0,222222222-2,333333333-3");
        } catch (NullPointerException npe) {

        }
    }

    @Test
    void cadastraComissaoPoliticosNulo() {
        try {
            this.systemControl.cadastrarComissao("Educacao", null);
        } catch (NullPointerException npe) {

        }
    }

    @Test
    void cadastrarComissaoPessoaInexistente() {
        this.systemControl.cadastrarPessoa("Jurema", "051444444-0", "RO", "Educacao", "DEF");
        this.systemControl.cadastraDeputado("051444444-0", "12012000");
        try {

            this.systemControl.cadastrarComissao("CCJCC", "051222222-0");
            fail("Era esperada uma excecao");
        } catch (NullPointerException npe) {

        }
    }

    @Test
    void cadastrarComissaoPessoaTemaRepetido() {
        this.systemControl.cadastrarPessoa("Paulo", "051444444-0", "RO", "Educacao", "DEF");
        this.systemControl.cadastrarPessoa("Leticia", "051222222-0", "RO", "Saude", "DEF");
        this.systemControl.cadastraDeputado("051444444-0", "12012000");
        this.systemControl.cadastraDeputado("051222222-0", "25072010");
        this.systemControl.cadastrarComissao("CCJCC", "051222222-0,051444444-0");
        try {
            this.systemControl.cadastrarComissao("CCJCC", "051444444-0");
            fail("Era esperada uma excecao");
        } catch (IllegalArgumentException iae) {

        }
    }

    @Test
    void cadastrarComissaoDniInvalido() {
        this.systemControl.cadastrarPessoa("Gabriel", "051444444-0", "RO", "Educacao", "DEF");
        this.systemControl.cadastrarPessoa("Ana", "051222222-0", "RO", "Educacao", "DEF");
        this.systemControl.cadastraDeputado("051444444-0", "12012000");
        this.systemControl.cadastraDeputado("051222222-0", "25072010");
        try {
            this.systemControl.cadastrarComissao("CCJCC", "051444444AA");
            fail("Era esperada uma excecao");
        } catch (IllegalArgumentException iae) {

        }
    }

    @Test
    void cadastraComissaoPessoaNaoPolitica() {
        this.systemControl.cadastrarPessoa("Claudia", "051444444-0", "RO", "Educacao", "DEF");
        this.systemControl.cadastrarPessoa("Gilberto", "051222222-0", "RO", "Educacao", "DEF");
        this.systemControl.cadastrarPessoa("Mariana", "051111111-0", "RO", "Educacao", "DEF");
        this.systemControl.cadastrarPessoa("Patricia", "051333333-0", "RO", "Educacao", "DEF");
        this.systemControl.cadastraDeputado("051444444-0", "12012000");
        this.systemControl.cadastraDeputado("051222222-0", "25072010");
        this.systemControl.cadastrarComissao("CCJCC", "051222222-0,051444444-0");
        try {
            this.systemControl.cadastrarComissao("CCJCC", "051333333-0");
            fail("Era esperada uma excecao");
        } catch (IllegalArgumentException iae) {

        }
    }

    @Test
    void exibirPessoaArgumentosInvalidos() {
        try {
            this.systemControl.exibirPessoa(null);
            fail("Era esperada uma excecao");
        } catch (NullPointerException npe) {
        }

        try {
            this.systemControl.exibirPessoa("");
            fail("Era esperada uma excecao");
        } catch (IllegalArgumentException iae) {
        }

    }

    @Test
    void exibirPessoaNaoCadastrada() {
        try {
            this.systemControl.exibirPessoa("1234-567");
            fail("Era esperada uma excecao");
        } catch (IllegalArgumentException iae) {
        }
    }

    @Test
    void exibirPessoaSemFuncao() {
        this.systemControl.cadastrarPessoa("Joao", "0034240-234", "PB", "Rinha de galo", "LRG - LIBERA RINHA DE GALO");
        assertEquals("Joao - 0034240-234 (PB) - LRG - LIBERA RINHA DE GALO - Interesses: Rinha de galo", this.systemControl.exibirPessoa("0034240-234"));
    }

    @Test
    void exibirPessoaComFuncao() {
        this.systemControl.cadastrarPessoa("Joao", "0034240-234", "PB", "Rinha de galo", "LRG - LIBERA RINHA DE GALO");
        this.systemControl.cadastraDeputado("0034240-234", "01022018");
        assertEquals("POL: Joao - 0034240-234 (PB) - LRG - LIBERA RINHA DE GALO - Interesses: Rinha de galo - 01/02/2018 - 0 Leis", this.systemControl.exibirPessoa("0034240-234"));
    }

    @Test
    void cadastraPartidoPadrao() {
        this.systemControl.cadastraPartido("PT");
        assertTrue(systemControl.getPartidos().contains("PT"));
    }

    @Test
    void cadastraPartidoInvalido() {
        try {
            this.systemControl.cadastraPartido("");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
        }
    }

    @Test
    void cadastraPartidoNulo() {
        try {
            this.systemControl.cadastraPartido(null);
            fail("era pra dar ruim");
        } catch (NullPointerException npe) {
        }
    }

    @Test
    void exibePartidosPadrao() {
        this.systemControl.cadastraPartido("PT");
        this.systemControl.cadastraPartido("PSL");
        this.systemControl.cadastraPartido("PSDB");
        this.systemControl.cadastraPartido("PSOL");

        assertEquals("PSDB,PSL,PSOL,PT", this.systemControl.exibirBase());
    }

    @Test
    void exibePartidosVazio() {
        assertEquals("", this.systemControl.exibirBase());
    }

    @Test
    void cadastrarPLPessoaNaoExiste() {
        try {
            this.systemControl.cadastrarPL("061222222-0", 2016, "Institui a semana da nutricao nas escolas", "saude,educacao basica", "http://example.com/semana_saude", true);
        } catch (NullPointerException npe) {
        }
    }

    @Test
    void cadastrarPLNaoDeputado() {
        this.systemControl.cadastrarPessoa("Jao", "061222222-0", "gg", "", "LRG - Libera Rinha de Galo");

        try {
            this.systemControl.cadastrarPL("061222222-0", 2016, "Institui a semana da nutricao nas escolas", "saude,educacao basica", "http://example.com/semana_saude", true);
        } catch (NullPointerException npe) {
        }
    }

    @Test
    void cadastrarPLCondicoesNormais() {
        this.systemControl.cadastrarPessoa("Jao", "061222222-0", "gg", "", "LRG - Libera Rinha de Galo");
        this.systemControl.cadastraDeputado("061222222-0", "29022016");

        assertEquals("PL 1/2016", this.systemControl.cadastrarPL("061222222-0", 2016, "Institui a semana da nutricao nas escolas", "saude,educacao basica", "http://example.com/semana_saude", true));
    }

    @Test
    void cadastrarPLPPessoaNaoExiste() {
        try {
            this.systemControl.cadastrarPLP("061222222-0", 2016, "Institui a semana da nutricao nas escolas", "saude,educacao basica", "http://example.com/semana_saude", "153");
        } catch (NullPointerException npe) {
        }
    }

    @Test
    void cadastrarPLPNaoDeputado() {
        this.systemControl.cadastrarPessoa("Jao", "061222222-0", "gg", "", "LRG - Libera Rinha de Galo");

        try {
            this.systemControl.cadastrarPLP("061222222-0", 2016, "Institui a semana da nutricao nas escolas", "saude,educacao basica", "http://example.com/semana_saude", "153");
        } catch (NullPointerException npe) {
        }
    }

    @Test
    void cadastrarPLPCondicoesNormais() {
        this.systemControl.cadastrarPessoa("Jao", "061222222-0", "gg", "", "LRG - Libera Rinha de Galo");
        this.systemControl.cadastraDeputado("061222222-0", "29022016");

        assertEquals("PLP 1/2016", this.systemControl.cadastrarPLP("061222222-0", 2016, "Institui a semana da nutricao nas escolas", "saude,educacao basica", "http://example.com/semana_saude", "153"));
    }

    @Test
    void cadastrarPECPessoaNaoExiste() {
        try {
            this.systemControl.cadastrarPEC("061222222-0", 2016, "Institui a semana da nutricao nas escolas", "saude,educacao basica", "http://example.com/semana_saude", "153");
        } catch (NullPointerException npe) {
        }
    }

    @Test
    void cadastrarPECNaoDeputado() {
        this.systemControl.cadastrarPessoa("Jao", "061222222-0", "gg", "", "LRG - Libera Rinha de Galo");

        try {
            this.systemControl.cadastrarPEC("061222222-0", 2016, "Institui a semana da nutricao nas escolas", "saude,educacao basica", "http://example.com/semana_saude", "153");
        } catch (NullPointerException npe) {
        }
    }

    @Test
    void cadastrarPECCondicoesNormais() {
        this.systemControl.cadastrarPessoa("Jao", "061222222-0", "gg", "", "LRG - Libera Rinha de Galo");
        this.systemControl.cadastraDeputado("061222222-0", "29022016");

        assertEquals("PEC 1/2016", this.systemControl.cadastrarPEC("061222222-0", 2016, "Institui a semana da nutricao nas escolas", "saude,educacao basica", "http://example.com/semana_saude", "153"));
    }

    @Test
    void exibirProjetoInexistente() {
        try {
            this.systemControl.exibirProjeto("PL 1/2016");
        } catch (NullPointerException npe) {
        }
    }

    @Test
    void exibirProjetoCondicoesNormais() {
        this.systemControl.cadastrarPessoa("Jao", "061222222-0", "gg", "", "LRG - Libera Rinha de Galo");
        this.systemControl.cadastraDeputado("061222222-0", "29022016");
        this.systemControl.cadastrarPL("061222222-0", 2016, "Institui a semana da nutricao nas escolas", "saude,educacao basica", "http://example.com/semana_saude", true);
        this.systemControl.cadastrarPLP("061222222-0", 2016, "Regulamenta a tributacao de apostas eletronicas", "fiscal,jogos", "https://example.net/jogos%40aposta", "153");
        this.systemControl.cadastrarPEC("061222222-0", 2016, "Permite a associacao sindical livre e com estrutura hierarquica", "trabalho", "https://example.com/sindicato/algo.html", "7,8");

        assertEquals("Projeto de Lei - PL 1/2016 - 061222222-0 - Institui a semana da nutricao nas escolas - Conclusiva - EM VOTACAO (CCJC)", this.systemControl.exibirProjeto("PL 1/2016"));
        assertEquals("Projeto de Lei Complementar - PLP 1/2016 - 061222222-0 - Regulamenta a tributacao de apostas eletronicas - 153 - EM VOTACAO (CCJC)", this.systemControl.exibirProjeto("PLP 1/2016"));
        assertEquals("Projeto de Emenda Constitucional - PEC 1/2016 - 061222222-0 - Permite a associacao sindical livre e com estrutura hierarquica - 7, 8 - EM VOTACAO (CCJC)", this.systemControl.exibirProjeto("PEC 1/2016"));
    }

    @Test
    void votarComissaoArgumentosInvalidos() {
        try {
            this.systemControl.votarComissao("PL 1/2016", null, "acula");
            fail("Era esperada uma excecao!");
        } catch (NullPointerException npe) {
        }

        try {
            this.systemControl.votarComissao("PL 1/2016", "", "acula");
            fail("Era esperada uma excecao!");
        } catch (IllegalArgumentException npe) {
        }

        try {
            this.systemControl.votarComissao("PL 1/2016", "sei nao", "acula");
            fail("Era esperada uma excecao!");
        } catch (IllegalArgumentException npe) {
        }

        try {
            this.systemControl.votarComissao("PL 1/2016", "governista", null);
            fail("Era esperada uma excecao!");
        } catch (NullPointerException npe) {
        }

        try {
            this.systemControl.votarComissao("PL 1/2016", "governista", "");
            fail("Era esperada uma excecao!");
        } catch (IllegalArgumentException npe) {
        }

    }

    @Test
    void votarComissaoCCJCNaoCadastrada() {
        try {
            this.systemControl.votarComissao("PL 1/2016", "governista", "Ali");
            fail("Era esperada uma excecao!");
        } catch (NullPointerException npe) {
        }
    }

    @Test
    void votarComissaoProjetoInexistente() {
        this.systemControl.cadastrarPessoa("Jurema", "051444444-0", "RO", "Educacao", "DEF");
        this.systemControl.cadastraDeputado("051444444-0", "12012000");
        this.systemControl.cadastrarComissao("CCJC", "051444444-0");

        try {
            this.systemControl.votarComissao("PL 1/2016", "governista", "Ali");
            fail("Era esperada uma excecao!");
        } catch (NullPointerException npe) {
        }
    }

    //---------------------Votar Comissao - PLP--------------------------------
    @Test
    void votarComissaoEncaminhadaAoPlenario() {
        this.systemControl.cadastraPartido("DEF");
        this.systemControl.cadastraPartido("ABC");

        this.systemControl.cadastrarPessoa("Jurema", "051444444-0", "RO", "Educacao", "DEF");
        this.systemControl.cadastraDeputado("051444444-0", "12012000");

        this.systemControl.cadastrarPessoa("Mateus Matia", "051222222-0", "PE", "", "ABC");
        this.systemControl.cadastraDeputado("051222222-0", "29022016");

        this.systemControl.cadastrarComissao("CCJC", "051222222-0,051444444-0");
        this.systemControl.cadastrarPLP("051444444-0", 2016, "Institui a semana da nutricao nas escolas", "saude,educacao basica", "http://example.com/semana_saude", "1, 2, 3");

        this.systemControl.votarComissao("PLP 1/2016", "governista", "num tem");

        //Plenario nao cadastrado
        try {
            this.systemControl.votarComissao("PLP 1/2016", "governista", "plenario");
            fail("Era esperada uma excecao!");
        } catch (NullPointerException npe) {
        }

        //Votar no plenario lei que nao foi encaminhada
        try {
            this.systemControl.votarPlenario("PLP 1/2016", "governista", "051444444-0, 052444444-0, 053444444-0");
            fail("Era esperada uma excecao!");
        } catch (IllegalArgumentException iae) {
        }

        //votar lei que ja foi aprovada
        this.systemControl.cadastrarPLP("051444444-0", 2016, "Institui a semana da nutricao nas escolas", "saude,educacao basica", "http://example.com/semana_saude", "1, 2, 3");
        this.systemControl.cadastrarComissao("abc", "051444444-0");
        this.systemControl.votarComissao("PLP 2/2016", "governista", "plenario");
        this.systemControl.votarPlenario("PLP 2/2016", "governista", "051444444-0, 052444444-0, 053444444-0");
        this.systemControl.votarPlenario("PLP 2/2016", "governista", "051444444-0, 052444444-0, 053444444-0");

        //assertEquals("", this.systemControl.exibirTramitacao("PLP 2/2016"));

        try {
            this.systemControl.votarComissao("PLP 2/2016", "governista", "plenario");
            fail("Era esperada uma excecao!");
        } catch (NullPointerException npe) {
        }
    }

    @Test
    void votarPlenarioProjetoNaoDirecionado() {
        this.systemControl.cadastrarPessoa("Jurema", "051444444-0", "RO", "Educacao", "DEF");
        this.systemControl.cadastraDeputado("051444444-0", "12012000");
        this.systemControl.cadastrarComissao("CCJC", "051444444-0");
        this.systemControl.cadastrarPLP("051444444-0", 2016, "Institui a semana da nutricao nas escolas", "saude,educacao basica", "http://example.com/semana_saude", "1, 2, 3");

        this.systemControl.votarComissao("PLP 1/2016", "governista", "idd");

        try {
            this.systemControl.votarPlenario("PLP 1/2016", "governista", "051444444-0");
            fail("Era esperada uma excecao!");
        } catch (IllegalArgumentException iae) {
        }
    }

    @Test
    void votarPlenarioCondicoesNormais() {

        this.systemControl.cadastrarPessoa("Jurema", "051444444-0", "RO", "Educacao", "DEF");
        this.systemControl.cadastraDeputado("051444444-0", "12012000");

        this.systemControl.cadastrarPessoa("Mateus Matia", "051222222-0", "PE", "", "ABC");
        this.systemControl.cadastraDeputado("051222222-0", "29022016");

        this.systemControl.cadastrarPessoa("Lucivania", "051111111-0", "RO", "Educacao", "DEF");
        this.systemControl.cadastraDeputado("051111111-0", "12012000");

        this.systemControl.cadastrarPessoa("Maurileide", "051555555-0", "PE", "", "ABC");
        this.systemControl.cadastraDeputado("051555555-0", "29022016");

        this.systemControl.cadastrarComissao("CCJC", "051222222-0,051444444-0");
        this.systemControl.cadastrarPLP("051444444-0", 2016, "Institui a semana da nutricao nas escolas", "saude,educacao basica", "http://example.com/semana_saude", "1, 2, 3");

        this.systemControl.votarComissao("PLP 1/2016", "oposicao", "plenario");
        this.systemControl.votarPlenario("PLP 1/2016", "oposicao", "051222222-0,051444444-0,051111111-0,051555555-0");
        this.systemControl.votarPlenario("PLP 1/2016", "oposicao", "051222222-0,051444444-0,051111111-0,051555555-0");

        try {
            this.systemControl.votarPlenario("PLP 1/2016", "oposicao", "051222222-0,051444444-0,051111111-0,051555555-0");
            fail("Era esperada uma excecao!");
        } catch (IllegalArgumentException iae) {
        }
    }

    @Test
    void votarPlenarioReprovadoPrimeiroTurno() {
        this.systemControl.cadastraPartido("DEF");

        this.systemControl.cadastrarPessoa("Jurema", "051444444-0", "RO", "Educacao", "DEF");
        this.systemControl.cadastraDeputado("051444444-0", "12012000");

        this.systemControl.cadastrarPessoa("Mateus Matia", "051222222-0", "PE", "", "ABC");
        this.systemControl.cadastraDeputado("051222222-0", "29022016");

        this.systemControl.cadastrarPessoa("Lucivania", "051111111-0", "RO", "Educacao", "DEF");
        this.systemControl.cadastraDeputado("051111111-0", "12012000");

        this.systemControl.cadastrarPessoa("Maurileide", "051555555-0", "PE", "", "ABC");
        this.systemControl.cadastraDeputado("051555555-0", "29022016");

        this.systemControl.cadastrarComissao("CCJC", "051444444-0,051111111-0");
        this.systemControl.cadastrarPLP("051444444-0", 2016, "Institui a semana da nutricao nas escolas", "saude,educacao basica", "http://example.com/semana_saude", "1, 2, 3");

        this.systemControl.votarComissao("PLP 1/2016", "governista", "plenario");
        this.systemControl.votarPlenario("PLP 1/2016", "governista", "051222222-0,051444444-0,051111111-0,051555555-0");

        //votar projeto encerrado(ARQUIVADO)
        try {
            this.systemControl.votarComissao("PLP 1/2016", "governista", "plenario");
            fail("Era esperada uma excecao!");
        } catch (NullPointerException iae) {
        }
    }

    //---------------------Votar Comissao - PEC------------------------------
    @Test
    void votarComissaoEncaminhadaAoPlenarioPEC() {
        this.systemControl.cadastraPartido("DEF");
        this.systemControl.cadastraPartido("ABC");

        this.systemControl.cadastrarPessoa("Jurema", "051444444-0", "RO", "Educacao", "DEF");
        this.systemControl.cadastraDeputado("051444444-0", "12012000");

        this.systemControl.cadastrarPessoa("Mateus Matia", "051222222-0", "PE", "", "ABC");
        this.systemControl.cadastraDeputado("051222222-0", "29022016");

        this.systemControl.cadastrarComissao("CCJC", "051222222-0,051444444-0");
        this.systemControl.cadastrarPEC("051444444-0", 2016, "Institui a semana da nutricao nas escolas", "saude,educacao basica", "http://example.com/semana_saude", "1, 2, 3");

        this.systemControl.votarComissao("PEC 1/2016", "governista", "num tem");

        //Plenario nao cadastrado
        try {
            this.systemControl.votarComissao("PEC 1/2016", "governista", "plenario");
            fail("Era esperada uma excecao!");
        } catch (NullPointerException npe) {
        }

        //Votar no plenario lei que nao foi encaminhada
        try {
            this.systemControl.votarPlenario("PEC 1/2016", "governista", "051444444-0, 052444444-0, 053444444-0");
            fail("Era esperada uma excecao!");
        } catch (IllegalArgumentException iae) {
        }

        //votar lei que ja foi aprovada
        this.systemControl.cadastrarPEC("051444444-0", 2016, "Institui a semana da nutricao nas escolas", "saude,educacao basica", "http://example.com/semana_saude", "1, 2, 3");
        this.systemControl.cadastrarComissao("abc", "051444444-0");
        this.systemControl.votarComissao("PEC 2/2016", "governista", "plenario");
        this.systemControl.votarPlenario("PEC 2/2016", "governista", "051444444-0, 052444444-0, 053444444-0");
        this.systemControl.votarPlenario("PEC 2/2016", "governista", "051444444-0, 052444444-0, 053444444-0");

        try {
            this.systemControl.votarComissao("PEC 2/2016", "governista", "plenario");
            fail("Era esperada uma excecao!");
        } catch (NullPointerException npe) {
        }
    }

    @Test
    void votarPlenarioProjetoNaoDirecionadoPEC() {
        this.systemControl.cadastrarPessoa("Jurema", "051444444-0", "RO", "Educacao", "DEF");
        this.systemControl.cadastraDeputado("051444444-0", "12012000");
        this.systemControl.cadastrarComissao("CCJC", "051444444-0");
        this.systemControl.cadastrarPEC("051444444-0", 2016, "Institui a semana da nutricao nas escolas", "saude,educacao basica", "http://example.com/semana_saude", "1, 2, 3");

        this.systemControl.votarComissao("PEC 1/2016", "governista", "idd");

        try {
            this.systemControl.votarPlenario("PEC 1/2016", "governista", "051444444-0");
            fail("Era esperada uma excecao!");
        } catch (IllegalArgumentException iae) {
        }
    }

    @Test
    void votarPlenarioCondicoesNormaisPEC() {

        this.systemControl.cadastrarPessoa("Jurema", "051444444-0", "RO", "Educacao", "DEF");
        this.systemControl.cadastraDeputado("051444444-0", "12012000");

        this.systemControl.cadastrarPessoa("Mateus Matia", "051222222-0", "PE", "Educacao", "ABC");
        this.systemControl.cadastraDeputado("051222222-0", "29022016");

        this.systemControl.cadastrarPessoa("Lucivania", "051111111-0", "RO", "Educacao", "DEF");
        this.systemControl.cadastraDeputado("051111111-0", "12012000");

        this.systemControl.cadastrarPessoa("Maurileide", "051555555-0", "PE", "saude", "ABC");
        this.systemControl.cadastraDeputado("051555555-0", "29022016");

        this.systemControl.cadastrarPessoa("Carlucia", "05777777-0", "RO", "Educacao", "DEF");
        this.systemControl.cadastraDeputado("05777777-0", "12012000");

        this.systemControl.cadastrarComissao("CCJC", "051222222-0,051444444-0,051111111-0,051555555-0,05777777-0");
        this.systemControl.cadastrarPEC("051444444-0", 2016, "Institui a semana da nutricao nas escolas", "Educacao", "http://example.com/semana_saude", "1, 2, 3");

        this.systemControl.votarComissao("PEC 1/2016", "livre", "plenario");
        this.systemControl.votarPlenario("PEC 1/2016", "livre", "051222222-0,051444444-0,051111111-0,051555555-0,05777777-0");
        this.systemControl.votarPlenario("PEC 1/2016", "livre", "051222222-0,051444444-0,051111111-0,051555555-0,05777777-0");
    }

    @Test
    void votarPlenarioReprovadoPrimeiroTurnoPEC() {
        this.systemControl.cadastraPartido("DEF");

        this.systemControl.cadastrarPessoa("Jurema", "051444444-0", "RO", "Educacao", "DEF");
        this.systemControl.cadastraDeputado("051444444-0", "12012000");

        this.systemControl.cadastrarPessoa("Mateus Matia", "051222222-0", "PE", "", "ABC");
        this.systemControl.cadastraDeputado("051222222-0", "29022016");

        this.systemControl.cadastrarPessoa("Lucivania", "051111111-0", "RO", "Educacao", "DEF");
        this.systemControl.cadastraDeputado("051111111-0", "12012000");

        this.systemControl.cadastrarPessoa("Maurileide", "051555555-0", "PE", "", "ABC");
        this.systemControl.cadastraDeputado("051555555-0", "29022016");

        this.systemControl.cadastrarComissao("CCJC", "051444444-0,051111111-0");
        this.systemControl.cadastrarPEC("051444444-0", 2016, "Institui a semana da nutricao nas escolas", "saude,educacao basica", "http://example.com/semana_saude", "1, 2, 3");

        this.systemControl.votarComissao("PEC 1/2016", "governista", "plenario");
        this.systemControl.votarPlenario("PEC 1/2016", "governista", "051222222-0,051444444-0,051111111-0,051555555-0");

        //votar projeto encerrado(ARQUIVADO)
        try {
            this.systemControl.votarComissao("PEC 1/2016", "governista", "plenario");
            fail("Era esperada uma excecao!");
        } catch (NullPointerException iae) {
        }
    }

    @Test
    void testVotarProjetoJaTerminado() {
        this.systemControl.cadastraPartido("ABC");

        this.systemControl.cadastrarPessoa("Maurileide", "051444444-0", "PE", "", "ABC");
        this.systemControl.cadastraDeputado("051444444-0", "29022016");


        this.systemControl.cadastrarPessoa("Maurileide", "051444445-0", "PE", "", "ABC");
        this.systemControl.cadastraDeputado("051444445-0", "29022016");


        this.systemControl.cadastrarPessoa("Maurileide", "051444446-0", "PE", "", "ABC");
        this.systemControl.cadastraDeputado("051444446-0", "29022016");

        this.systemControl.cadastrarPessoa("Maurileide", "051444447-0", "PE", "", "AdBC");
        this.systemControl.cadastraDeputado("051444447-0", "29022016");


        this.systemControl.cadastrarPessoa("Maurileide", "051444448-0", "PE", "", "CABC");
        this.systemControl.cadastraDeputado("051444448-0", "29022016");


        this.systemControl.cadastrarPessoa("Maurileide", "051444449-0", "PE", "", "ABRC");
        this.systemControl.cadastraDeputado("051444449-0", "29022016");


        this.systemControl.cadastrarPessoa("Maurileide", "051444440-0", "PE", "", "ABWC");
        this.systemControl.cadastraDeputado("051444440-0", "29022016");

        this.systemControl.cadastrarComissao("CCJC", "051444444-0");
        this.systemControl.cadastrarPL("051444444-0", 2016, "Institui a semana da nutricao nas escolas", "saude,educacao basica", "http://example.com/semana_saude",false);

        this.systemControl.votarComissao("PL 1/2016", "governista", "plenario");
        this.systemControl.votarPlenario("PL 1/2016", "governista", "051444448-0,051444449-0,051444440-0,051444447-0");

        try {
            this.systemControl.votarComissao("PL 1/2016", "governista", "plenario");
            fail("era pra dar ruim");
        } catch (NullPointerException iae) {
        }
    }


    //---------------------Votar Comissao - PL------------------------------
    @Test
    void votarComissaoEncaminhadaAoPlenarioPL() {
        this.systemControl.cadastraPartido("DEF");
        this.systemControl.cadastraPartido("ABC");

        this.systemControl.cadastrarPessoa("Jurema", "051444444-0", "RO", "Educacao", "DEF");
        this.systemControl.cadastraDeputado("051444444-0", "12012000");

        this.systemControl.cadastrarPessoa("Mateus Matia", "051222222-0", "PE", "", "ABC");
        this.systemControl.cadastraDeputado("051222222-0", "29022016");

        this.systemControl.cadastrarComissao("CCJC", "051222222-0,051444444-0");
        this.systemControl.cadastrarPL("051444444-0", 2016, "Institui a semana da nutricao nas escolas", "saude,educacao basica", "http://example.com/semana_saude", true);

        this.systemControl.votarComissao("PL 1/2016", "governista", "num tem");

        //Plenario nao cadastrado
        try {
            this.systemControl.votarComissao("PL 1/2016", "governista", "plenario");
            fail("Era esperada uma excecao!");
        } catch (NullPointerException npe) {
        }

        //Votar no plenario lei que nao foi encaminhada
        try {
            this.systemControl.votarPlenario("PL 1/2016", "governista", "051444444-0, 052444444-0, 053444444-0");
            fail("Era esperada uma excecao!");
        } catch (IllegalArgumentException iae) {
        }

        //votar lei que ja foi aprovada
        this.systemControl.cadastrarPL("051444444-0", 2016, "Institui a semana da nutricao nas escolas", "saude,educacao basica", "http://example.com/semana_saude", true);
        this.systemControl.cadastrarComissao("abc", "051444444-0");
        this.systemControl.votarComissao("PL 2/2016", "governista", "plenario");

        //assertEquals("", this.systemControl.exibirTramitacao("PLP 2/2016"));

        try {
            this.systemControl.votarComissao("PL 2/2016", "governista", "plenario");
            fail("Era esperada uma excecao!");
        } catch (NullPointerException npe) {
        }
    }




    @Test
    void votarPlenarioProjetoNaoDirecionadoPL() {
        this.systemControl.cadastrarPessoa("Jurema", "051444444-0", "RO", "Educacao", "DEF");
        this.systemControl.cadastraDeputado("051444444-0", "12012000");
        this.systemControl.cadastrarComissao("CCJC", "051444444-0");
        this.systemControl.cadastrarPL("051444444-0", 2016, "Institui a semana da nutricao nas escolas", "saude,educacao basica", "http://example.com/semana_saude", true);

        this.systemControl.votarComissao("PL 1/2016", "governista", "idd");

        try {
            this.systemControl.votarPlenario("PL 1/2016", "governista", "051444444-0");
            fail("Era esperada uma excecao!");
        } catch (IllegalArgumentException iae) {
        }
    }

    @Test
    void votarPlenarioCondicoesNormaisPL() {
        this.systemControl.cadastraPartido("DEF");
        this.systemControl.cadastraPartido("ABC");

        this.systemControl.cadastrarPessoa("Jurema", "051444444-0", "RO", "Educacao", "DEF");
        this.systemControl.cadastraDeputado("051444444-0", "12012000");

        this.systemControl.cadastrarPessoa("Mateus Matia", "051222222-0", "PE", "", "ABC");
        this.systemControl.cadastraDeputado("051222222-0", "29022016");

        this.systemControl.cadastrarPessoa("Lucivania", "051111111-0", "RO", "Educacao", "DEF");
        this.systemControl.cadastraDeputado("051111111-0", "12012000");

        this.systemControl.cadastrarPessoa("Maurileide", "051555555-0", "PE", "", "ABC");
        this.systemControl.cadastraDeputado("051555555-0", "29022016");

        this.systemControl.cadastrarComissao("CCJC", "051222222-0,051444444-0");
        this.systemControl.cadastrarPL("051444444-0", 2016, "Institui a semana da nutricao nas escolas", "saude,educacao basica", "http://example.com/semana_saude", true);

        this.systemControl.votarComissao("PL 1/2016", "governista", "plenario");
        this.systemControl.votarPlenario("PL 1/2016", "governista", "051222222-0,051444444-0,051111111-0,051555555-0");
    }

    @Test
    void votarPlenarioReprovadoPrimeiroTurnoPL() {
        this.systemControl.cadastraPartido("DEF");

        this.systemControl.cadastrarPessoa("Jurema", "051444444-0", "RO", "Educacao", "DEF");
        this.systemControl.cadastraDeputado("051444444-0", "12012000");

        this.systemControl.cadastrarPessoa("Mateus Matia", "051222222-0", "PE", "", "ABC");
        this.systemControl.cadastraDeputado("051222222-0", "29022016");

        this.systemControl.cadastrarPessoa("Lucivania", "051111111-0", "RO", "Educacao", "DEF");
        this.systemControl.cadastraDeputado("051111111-0", "12012000");

        this.systemControl.cadastrarPessoa("Maurileide", "051555555-0", "PE", "", "ABC");
        this.systemControl.cadastraDeputado("051555555-0", "29022016");

        this.systemControl.cadastrarComissao("CCJC", "051444444-0,051111111-0");
        this.systemControl.cadastrarPL("051444444-0", 2016, "Institui a semana da nutricao nas escolas", "saude,educacao basica", "http://example.com/semana_saude", true);

        this.systemControl.votarComissao("PL 1/2016", "governista", "plenario");
        this.systemControl.votarPlenario("PL 1/2016", "governista", "051222222-0,051444444-0,051111111-0,051555555-0");

        //votar projeto encerrado(ARQUIVADO)
        try {
            this.systemControl.votarComissao("PL 1/2016", "governista", "plenario");
            fail("Era esperada uma excecao!");
        } catch (NullPointerException iae) {
        }
    }

    @Test
    void ExibirTramitacaoTest() {
        this.systemControl.cadastraPartido("ABC");

        this.systemControl.cadastrarPessoa("Maurileide", "051444444-0", "PE", "", "ABC");
        this.systemControl.cadastraDeputado("051444444-0", "29022016");

        this.systemControl.cadastrarComissao("CCJC", "051444444-0");
        this.systemControl.cadastrarPLP("051444444-0", 2016, "Institui a semana da nutricao nas escolas", "saude,educacao basica", "http://example.com/semana_saude", "1, 2, 3");

        this.systemControl.votarComissao("PLP 1/2016", "governista", "plenario");

        assertEquals("APROVADO (CCJC), EM VOTACAO (Plenario - 1o turno)", this.systemControl.exibirTramitacao("PLP 1/2016"));
    }

    //--------Testes Estrategia Constitucional-------------
    @Test
    void pegarPropostaRelacionadaConstitucional() {
        this.systemControl.cadastraPartido("DEF");
        this.systemControl.cadastraPartido("ABC");

        this.systemControl.cadastrarPessoa("Jurema", "051444444-0", "RO", "Educacao", "DEF");
        this.systemControl.cadastraDeputado("051444444-0", "12012000");

        this.systemControl.cadastrarPessoa("Mateus Matia", "051222222-0", "PE", "saude", "ABC");
        this.systemControl.cadastraDeputado("051222222-0", "29022016");

        this.systemControl.cadastrarPessoa("Lucivania", "051111111-0", "RO", "Educacao", "DEF");
        this.systemControl.cadastraDeputado("051111111-0", "12012000");

        this.systemControl.cadastrarPessoa("Maurileide", "051555555-0", "PE", "", "ABC");
        this.systemControl.cadastraDeputado("051555555-0", "29022016");

        this.systemControl.cadastrarComissao("CCJC", "051222222-0,051444444-0");

        this.systemControl.cadastrarPL("051444444-0", 2016, "Institui a semana da nutricao nas escolas", "saude,educacao basica", "http://example.com/semana_saude", true);
        this.systemControl.cadastrarPEC("051444444-0", 2017, "ementa da Pec", "saude", "http://example.com/semana_saude", "12,36");
        this.systemControl.cadastrarPLP("051444444-0", 2015, "ementa da plp", "seguranca,saude", "http://example.com/semana_da_seguranca", "15,18");

        assertEquals("PEC 1/2017", this.systemControl.pegarPropostaRelacionada("051222222-0"));

    }

    @Test
    void pegarPropostaRelacionadaConstitucionalSemInteresse() {
        this.systemControl.cadastraPartido("DEF");
        this.systemControl.cadastraPartido("ABC");

        this.systemControl.cadastrarPessoa("Jurema", "051444444-0", "RO", "Educacao", "DEF");
        this.systemControl.cadastraDeputado("051444444-0", "12012000");

        this.systemControl.cadastrarPessoa("Mateus Matia", "051222222-0", "PE", "saude", "ABC");
        this.systemControl.cadastraDeputado("051222222-0", "29022016");

        this.systemControl.cadastrarPessoa("Lucivania", "051111111-0", "RO", "Educacao", "DEF");
        this.systemControl.cadastraDeputado("051111111-0", "12012000");

        this.systemControl.cadastrarPessoa("Maurileide", "051555555-0", "PE", "", "ABC");
        this.systemControl.cadastraDeputado("051555555-0", "29022016");

        this.systemControl.cadastrarComissao("CCJC", "051222222-0,051444444-0");

        this.systemControl.cadastrarPL("051444444-0", 2016, "Institui a semana da nutricao nas escolas", "saude,educacao basica", "http://example.com/semana_saude", true);
        this.systemControl.cadastrarPEC("051444444-0", 2017, "ementa da Pec", "saude", "http://example.com/semana_saude", "12,36");
        this.systemControl.cadastrarPLP("051444444-0", 2015, "ementa da plp", "seguranca,saude", "http://example.com/semana_da_seguranca", "15,18");


        assertEquals("", this.systemControl.pegarPropostaRelacionada("051444444-0"));

    }

    @Test
    void pegarPropostaRelacionadaConstitucionalEmpatePEC() {
        this.systemControl.cadastraPartido("DEF");
        this.systemControl.cadastraPartido("ABC");

        this.systemControl.cadastrarPessoa("Jurema", "051444444-0", "RO", "Educacao", "DEF");
        this.systemControl.cadastraDeputado("051444444-0", "12012000");

        this.systemControl.cadastrarPessoa("Mateus Matia", "051222222-0", "PE", "saude", "ABC");
        this.systemControl.cadastraDeputado("051222222-0", "29022016");

        this.systemControl.cadastrarPessoa("Lucivania", "051111111-0", "RO", "Educacao", "DEF");
        this.systemControl.cadastraDeputado("051111111-0", "12012000");

        this.systemControl.cadastrarPessoa("Maurileide", "051555555-0", "PE", "", "ABC");
        this.systemControl.cadastraDeputado("051555555-0", "29022016");

        this.systemControl.cadastrarComissao("CCJC", "051222222-0,051444444-0");

        this.systemControl.cadastrarPL("051444444-0", 2016, "Institui a semana da nutricao nas escolas", "saude,educacao basica", "http://example.com/semana_saude", true);
        this.systemControl.cadastrarPEC("051444444-0", 2017, "ementa da Pec", "saude", "http://example.com/semana_saude", "12,36");
        this.systemControl.cadastrarPEC("051444444-0", 2017, "ementa da Pec", "saude", "http://example.com/semana_saude", "12,36");
        this.systemControl.cadastrarPLP("051444444-0", 2015, "ementa da plp", "seguranca,saude", "http://example.com/semana_da_seguranca", "15,18");


        assertEquals("PEC 1/2017", this.systemControl.pegarPropostaRelacionada("051222222-0"));

    }

    @Test
    void pegarPropostaRelacionadaConstitucionalEmpatePLP() {
        this.systemControl.cadastraPartido("DEF");
        this.systemControl.cadastraPartido("ABC");

        this.systemControl.cadastrarPessoa("Jurema", "051444444-0", "RO", "saude", "DEF");
        this.systemControl.cadastraDeputado("051444444-0", "12012000");

        this.systemControl.cadastrarPessoa("Mateus Matia", "051222222-0", "PE", "educacao", "ABC");
        this.systemControl.cadastraDeputado("051222222-0", "29022016");

        this.systemControl.cadastrarPessoa("Lucivania", "051111111-0", "RO", "saude", "DEF");
        this.systemControl.cadastraDeputado("051111111-0", "12012000");

        this.systemControl.cadastrarPessoa("Maurileide", "051555555-0", "PE", "", "ABC");
        this.systemControl.cadastraDeputado("051555555-0", "29022016");

        this.systemControl.cadastrarComissao("CCJC", "051222222-0,051444444-0");

        this.systemControl.cadastrarPL("051444444-0", 2016, "Institui a semana da nutricao nas escolas", "saude,educacao basica", "http://example.com/semana_saude", true);
        this.systemControl.cadastrarPLP("051444444-0", 2015, "ementa da plp", "educacao,saude", "http://example.com/semana_da_seguranca", "15,18");
        this.systemControl.cadastrarPLP("051444444-0", 2015, "ementa da plp", "educacao,saude", "http://example.com/semana_da_seguranca", "15,18");


        assertEquals("PLP 1/2015", this.systemControl.pegarPropostaRelacionada("051222222-0"));

    }

    @Test
    void pegarPropostaRelacionadaConstitucionalEmpatePL() {
        this.systemControl.cadastraPartido("DEF");
        this.systemControl.cadastraPartido("ABC");

        this.systemControl.cadastrarPessoa("Jurema", "051444444-0", "RO", "saude", "DEF");
        this.systemControl.cadastraDeputado("051444444-0", "12012000");

        this.systemControl.cadastrarPessoa("Mateus Matia", "051222222-0", "PE", "educacao basica", "ABC");
        this.systemControl.cadastraDeputado("051222222-0", "29022016");

        this.systemControl.cadastrarPessoa("Lucivania", "051111111-0", "RO", "saude", "DEF");
        this.systemControl.cadastraDeputado("051111111-0", "12012000");

        this.systemControl.cadastrarPessoa("Maurileide", "051555555-0", "PE", "", "ABC");
        this.systemControl.cadastraDeputado("051555555-0", "29022016");

        this.systemControl.cadastrarComissao("CCJC", "051222222-0,051444444-0");

        this.systemControl.cadastrarPL("051444444-0", 2016, "Institui a semana da nutricao nas escolas", "saude,educacao basica", "http://example.com/semana_saude", true);

        assertEquals("PL 1/2016", this.systemControl.pegarPropostaRelacionada("051222222-0"));
    }

    @Test
    void pegarPropostaRelacionadaConstitucionalPL() {
        this.systemControl.cadastraPartido("DEF");
        this.systemControl.cadastraPartido("ABC");

        this.systemControl.cadastrarPessoa("Jurema", "051444444-0", "RO", "saude", "DEF");
        this.systemControl.cadastraDeputado("051444444-0", "12012000");

        this.systemControl.cadastrarPessoa("Mateus Matia", "051222222-0", "PE", "educacao basica", "ABC");
        this.systemControl.cadastraDeputado("051222222-0", "29022016");

        this.systemControl.cadastrarPessoa("Lucivania", "051111111-0", "RO", "saude", "DEF");
        this.systemControl.cadastraDeputado("051111111-0", "12012000");

        this.systemControl.cadastrarPessoa("Maurileide", "051555555-0", "PE", "", "ABC");
        this.systemControl.cadastraDeputado("051555555-0", "29022016");

        this.systemControl.cadastrarComissao("CCJC", "051222222-0,051444444-0");

        this.systemControl.cadastrarPL("051444444-0", 2016, "Institui a semana da nutricao nas escolas", "saude,educacao basica", "http://example.com/semana_saude", true);
        this.systemControl.cadastrarPL("051444444-0", 2016, "Institui a semana da nutricao nas escolas", "saude", "http://example.com/semana_saude", true);

        assertEquals("PL 1/2016", this.systemControl.pegarPropostaRelacionada("051222222-0"));
    }

    //--------Testes Estrategia Conclusao-------------
    @Test
    void pegarPropostaRelacionadaConclusao() {
        this.systemControl.cadastraPartido("DEF");
        this.systemControl.cadastraPartido("ABC");

        this.systemControl.cadastrarPessoa("Jurema", "051444444-0", "RO", "saude", "DEF");
        this.systemControl.cadastraDeputado("051444444-0", "12012000");

        this.systemControl.cadastrarPessoa("Mateus Matia", "051222222-0", "PE", "saude", "ABC");
        this.systemControl.cadastraDeputado("051222222-0", "29022016");

        this.systemControl.cadastrarPessoa("Lucivania", "051111111-0", "RO", "saude", "DEF");
        this.systemControl.cadastraDeputado("051111111-0", "12012000");

        this.systemControl.cadastrarPessoa("Maurileide", "051555555-0", "PE", "", "ABC");
        this.systemControl.cadastraDeputado("051555555-0", "29022016");

        this.systemControl.cadastrarComissao("CCJC", "051222222-0,051444444-0");

        this.systemControl.cadastrarPL("051444444-0", 2016, "Institui a semana da nutricao nas escolas", "saude,educacao basica", "http://example.com/semana_saude", true);
        this.systemControl.cadastrarPEC("051444444-0", 2017, "ementa da Pec", "saude", "http://example.com/semana_saude", "12,36");
        this.systemControl.cadastrarPEC("051555555-0", 2017, "ementa da Pec", "saude", "http://example.com/semana_saude", "15,36");
        this.systemControl.cadastrarPLP("051444444-0", 2015, "ementa da plp", "seguranca,saude", "http://example.com/semana_da_seguranca", "15,18");

        this.systemControl.votarComissao("PLP 1/2015", "livre", "plenario");
        this.systemControl.votarPlenario("PLP 1/2015", "livre", "051222222-0,051444444-0,051111111-0,051555555-0,05777777-0");

        this.systemControl.configurarEstrategiaPropostaRelacionada("051444444-0", "conclusao");

        assertEquals("PLP 1/2015", this.systemControl.pegarPropostaRelacionada("051444444-0"));

    }

    @Test
    void pegarPropostaRelacionadaConclusaoEmpatePEC() {
        this.systemControl.cadastraPartido("DEF");
        this.systemControl.cadastraPartido("ABC");

        this.systemControl.cadastrarPessoa("Jurema", "051444444-0", "RO", "saude", "DEF");
        this.systemControl.cadastraDeputado("051444444-0", "12012000");

        this.systemControl.cadastrarPessoa("Mateus Matia", "051222222-0", "PE", "saude", "ABC");
        this.systemControl.cadastraDeputado("051222222-0", "29022016");

        this.systemControl.cadastrarPessoa("Lucivania", "051111111-0", "RO", "saude", "DEF");
        this.systemControl.cadastraDeputado("051111111-0", "12012000");

        this.systemControl.cadastrarPessoa("Maurileide", "051555555-0", "PE", "", "ABC");
        this.systemControl.cadastraDeputado("051555555-0", "29022016");

        this.systemControl.cadastrarComissao("CCJC", "051222222-0,051444444-0");

        this.systemControl.cadastrarPL("051444444-0", 2016, "Institui a semana da nutricao nas escolas", "saude,educacao basica", "http://example.com/semana_saude", true);
        this.systemControl.cadastrarPEC("051444444-0", 2017, "ementa da Pec", "saude", "http://example.com/semana_saude", "12,36");
        this.systemControl.cadastrarPEC("051555555-0", 2017, "ementa da Pec", "saude", "http://example.com/semana_saude", "15,36");
        this.systemControl.cadastrarPLP("051444444-0", 2015, "ementa da plp", "seguranca,saude", "http://example.com/semana_da_seguranca", "15,18");

        this.systemControl.votarComissao("PLP 1/2015", "livre", "plenario");
        this.systemControl.votarPlenario("PLP 1/2015", "livre", "051222222-0,051444444-0,051111111-0,051555555-0,05777777-0");

        this.systemControl.configurarEstrategiaPropostaRelacionada("051444444-0", "conclusao");

        assertEquals("PLP 1/2015", this.systemControl.pegarPropostaRelacionada("051444444-0"));

    }

    @Test
    void pegarPropostaRelacionadaConclusaoEmpatePLP() {
        this.systemControl.cadastraPartido("DEF");
        this.systemControl.cadastraPartido("ABC");

        this.systemControl.cadastrarPessoa("Jurema", "051444444-0", "RO", "saude", "DEF");
        this.systemControl.cadastraDeputado("051444444-0", "12012000");

        this.systemControl.cadastrarPessoa("Mateus Matia", "051222222-0", "PE", "saude", "ABC");
        this.systemControl.cadastraDeputado("051222222-0", "29022016");

        this.systemControl.cadastrarPessoa("Lucivania", "051111111-0", "RO", "saude", "DEF");
        this.systemControl.cadastraDeputado("051111111-0", "12012000");

        this.systemControl.cadastrarPessoa("Maurileide", "051555555-0", "PE", "", "ABC");
        this.systemControl.cadastraDeputado("051555555-0", "29022016");

        this.systemControl.cadastrarComissao("CCJC", "051222222-0,051444444-0");

        this.systemControl.cadastrarPL("051444444-0", 2016, "Institui a semana da nutricao nas escolas", "saude,educacao basica", "http://example.com/semana_saude", true);
        this.systemControl.cadastrarPEC("051444444-0", 2017, "ementa da Pec", "saude", "http://example.com/semana_saude", "12,36");
        this.systemControl.cadastrarPEC("051555555-0", 2017, "ementa da Pec", "saude", "http://example.com/semana_saude", "15,36");
        this.systemControl.cadastrarPLP("051444444-0", 2015, "ementa da plp", "seguranca,saude", "http://example.com/semana_da_seguranca", "15,18");

        this.systemControl.votarComissao("PLP 1/2015", "livre", "plenario");
        this.systemControl.votarPlenario("PLP 1/2015", "livre", "051222222-0,051444444-0,051111111-0,051555555-0,05777777-0");

        this.systemControl.configurarEstrategiaPropostaRelacionada("051444444-0", "conclusao");

        assertEquals("PLP 1/2015", this.systemControl.pegarPropostaRelacionada("051444444-0"));

    }

    @Test
    void pegarPropostaRelacionadaConclusaoEmpatePL() {
        this.systemControl.cadastraPartido("DEF");
        this.systemControl.cadastraPartido("ABC");

        this.systemControl.cadastrarPessoa("Jurema", "051444444-0", "RO", "Educacao", "DEF");
        this.systemControl.cadastraDeputado("051444444-0", "12012000");

        this.systemControl.cadastrarPessoa("Mateus Matia", "051222222-0", "PE", "saude", "ABC");
        this.systemControl.cadastraDeputado("051222222-0", "29022016");

        this.systemControl.cadastrarPessoa("Lucivania", "051111111-0", "RO", "Educacao", "DEF");
        this.systemControl.cadastraDeputado("051111111-0", "12012000");

        this.systemControl.cadastrarPessoa("Maurileide", "051555555-0", "PE", "", "ABC");
        this.systemControl.cadastraDeputado("051555555-0", "29022016");

        this.systemControl.cadastrarComissao("CCJC", "051222222-0,051444444-0");

        this.systemControl.cadastrarPL("051444444-0", 2016, "Institui a semana da nutricao nas escolas", "saude,educacao basica", "http://example.com/semana_saude", true);
        this.systemControl.cadastrarPEC("051444444-0", 2017, "ementa da Pec", "saude", "http://example.com/semana_saude", "12,36");
        this.systemControl.cadastrarPLP("051444444-0", 2015, "ementa da plp", "seguranca,saude", "http://example.com/semana_da_seguranca", "15,18");

        this.systemControl.votarComissao("PEC 1/2017", "livre", "plenario");
        this.systemControl.votarPlenario("PEC 1/2017", "livre", "051222222-0,051444444-0,051111111-0,051555555-0,05777777-0");

        this.systemControl.configurarEstrategiaPropostaRelacionada("051444444-0", "conclusao");

        assertEquals("PLP 1/2015", this.systemControl.pegarPropostaRelacionada("051222222-0"));

    }


    @Test
    void pegarPropostaRelacionadaConclusaoSemInteresse() {
        this.systemControl.cadastraPartido("DEF");
        this.systemControl.cadastraPartido("ABC");

        this.systemControl.cadastrarPessoa("Jurema", "051444444-0", "RO", "Educacao", "DEF");
        this.systemControl.cadastraDeputado("051444444-0", "12012000");

        this.systemControl.cadastrarPessoa("Mateus Matia", "051222222-0", "PE", "saude", "ABC");
        this.systemControl.cadastraDeputado("051222222-0", "29022016");

        this.systemControl.cadastrarPessoa("Lucivania", "051111111-0", "RO", "Educacao", "DEF");
        this.systemControl.cadastraDeputado("051111111-0", "12012000");

        this.systemControl.cadastrarPessoa("Maurileide", "051555555-0", "PE", "", "ABC");
        this.systemControl.cadastraDeputado("051555555-0", "29022016");

        this.systemControl.cadastrarComissao("CCJC", "051222222-0,051444444-0");

        this.systemControl.cadastrarPL("051444444-0", 2016, "Institui a semana da nutricao nas escolas", "saude,educacao basica", "http://example.com/semana_saude", true);
        this.systemControl.cadastrarPEC("051444444-0", 2017, "ementa da Pec", "saude", "http://example.com/semana_saude", "12,36");
        this.systemControl.cadastrarPLP("051444444-0", 2015, "ementa da plp", "seguranca,saude", "http://example.com/semana_da_seguranca", "15,18");

        this.systemControl.votarComissao("PEC 1/2017", "livre", "plenario");
        this.systemControl.votarPlenario("PEC 1/2017", "livre", "051222222-0,051444444-0,051111111-0,051555555-0,05777777-0");

        this.systemControl.configurarEstrategiaPropostaRelacionada("051444444-0", "conclusao");

        assertEquals("", this.systemControl.pegarPropostaRelacionada("051444444-0"));

    }


    //--------Testes Estrategia Aprovacao-------------


    @Test

    void pegarPropostaRelacionadaAprovacao(){

        this.systemControl.cadastraPartido("DEF");
        this.systemControl.cadastraPartido("ABC");

        this.systemControl.cadastrarPessoa("Jurema", "051444444-0", "RO", "Educacao", "DEF");
        this.systemControl.cadastraDeputado("051444444-0", "12012000");

        this.systemControl.cadastrarPessoa("Mateus Matia", "051222222-0", "PE", "saude", "ABC");
        this.systemControl.cadastraDeputado("051222222-0", "29022016");

        this.systemControl.cadastrarPessoa("Lucivania", "051111111-0", "RO", "Educacao", "DEF");
        this.systemControl.cadastraDeputado("051111111-0", "12012000");

        this.systemControl.cadastrarPessoa("Maurileide", "051555555-0", "PE", "", "ABC");
        this.systemControl.cadastraDeputado("051555555-0", "29022016");

        this.systemControl.cadastrarComissao("CCJC", "051222222-0,051444444-0");

        this.systemControl.cadastrarPL("051444444-0", 2016, "Institui a semana da nutricao nas escolas", "saude", "http://example.com/semana_saude", true);
        this.systemControl.cadastrarPEC("051444444-0", 2017, "ementa da Pec", "saude", "http://example.com/semana_saude", "12,36");
        this.systemControl.cadastrarPLP("051444444-0", 2015, "ementa da plp", "seguranca", "http://example.com/semana_da_seguranca", "15,18");

        this.systemControl.votarComissao("PL 1/2016", "governista", "plenario");

        this.systemControl.configurarEstrategiaPropostaRelacionada("051222222-0", "aprovacao");

        assertEquals("PL 1/2016", this.systemControl.pegarPropostaRelacionada("051222222-0"));

    }

    @Test
    void pegarPropostaRelacionadaAprovacaoSemInteresse() {
        this.systemControl.cadastraPartido("DEF");
        this.systemControl.cadastraPartido("ABC");

        this.systemControl.cadastrarPessoa("Jurema", "051444444-0", "RO", "Educacao", "DEF");
        this.systemControl.cadastraDeputado("051444444-0", "12012000");

        this.systemControl.cadastrarPessoa("Mateus Matia", "051222222-0", "PE", "saude", "ABC");
        this.systemControl.cadastraDeputado("051222222-0", "29022016");

        this.systemControl.cadastrarPessoa("Lucivania", "051111111-0", "RO", "Educacao", "DEF");
        this.systemControl.cadastraDeputado("051111111-0", "12012000");

        this.systemControl.cadastrarPessoa("Maurileide", "051555555-0", "PE", "", "ABC");
        this.systemControl.cadastraDeputado("051555555-0", "29022016");

        this.systemControl.cadastrarComissao("CCJC", "051222222-0,051444444-0");

        this.systemControl.cadastrarPL("051444444-0", 2016, "Institui a semana da nutricao nas escolas", "saude", "http://example.com/semana_saude", true);
        this.systemControl.cadastrarPEC("051444444-0", 2017, "ementa da Pec", "saude", "http://example.com/semana_saude", "12,36");
        this.systemControl.cadastrarPLP("051444444-0", 2015, "ementa da plp", "seguranca", "http://example.com/semana_da_seguranca", "15,18");

        this.systemControl.configurarEstrategiaPropostaRelacionada("051444444-0", "aprovacao");

        assertEquals("", this.systemControl.pegarPropostaRelacionada("051444444-0"));

    }

    @Test
    void pegarPropostaRelacionadaAprovacaoPL() {
        this.systemControl.cadastraPartido("DEF");
        this.systemControl.cadastraPartido("ABC");

        this.systemControl.cadastrarPessoa("Jurema", "051444444-0", "RO", "saude", "DEF");
        this.systemControl.cadastraDeputado("051444444-0", "12012000");

        this.systemControl.cadastrarPessoa("Mateus Matia", "051222222-0", "PE", "educacao basica", "ABC");
        this.systemControl.cadastraDeputado("051222222-0", "29022016");

        this.systemControl.cadastrarPessoa("Lucivania", "051111111-0", "RO", "saude", "DEF");
        this.systemControl.cadastraDeputado("051111111-0", "12012000");

        this.systemControl.cadastrarPessoa("Maurileide", "051555555-0", "PE", "", "ABC");
        this.systemControl.cadastraDeputado("051555555-0", "29022016");

        this.systemControl.cadastrarComissao("CCJC", "051222222-0,051444444-0");

        this.systemControl.cadastrarPL("051444444-0", 2016, "Institui a semana da nutricao nas escolas", "saude,educacao basica", "http://example.com/semana_saude", true);
        this.systemControl.cadastrarPL("051444444-0", 2016, "Institui a semana da nutricao nas escolas", "saude", "http://example.com/semana_saude", true);

        this.systemControl.configurarEstrategiaPropostaRelacionada("051444444-0", "aprovacao");

        assertEquals("PL 1/2016", this.systemControl.pegarPropostaRelacionada("051222222-0"));
    }

    @Test
    void setControllerPessoa(){
        HashMap<String, Pessoa> mapVazio = new HashMap<>();
        this.systemControl.getControllerPessoas().setMap(mapVazio);
        assertTrue(this.systemControl.getControllerPessoas().getMapPessoas().isEmpty());
    }

    @Test
    void carregarSistemaTest(){
        this.systemControl2.carregarSistema(this.systemControl2);
        assertFalse(this.systemControl2.getComissoes().isEmpty());
    }

    @Test
    void limparSistema(){
        this.systemControl2.limparSistema(this.systemControl2);
        assertTrue(this.systemControl2.getComissoes().isEmpty());
    }

    // TESTES EXIBIR TRAMITACAO

    @Test
    void testExibirTramitacao() {
        try {
            this.systemControl.exibirTramitacao("PL 1/2016");
            fail("era pra dar ruim");
        } catch (NullPointerException npe) {
        }
    }

    @Test
    void exibirTramitacaoTestPadrao() {
        this.systemControl.cadastraPartido("ABC");

        this.systemControl.cadastrarPessoa("Maurileide", "051444444-0", "PE", "", "ABC");
        this.systemControl.cadastraDeputado("051444444-0", "29022016");

        this.systemControl.cadastrarComissao("CCJC", "051444444-0");

        this.systemControl.cadastrarPLP("051444444-0", 2016, "Institui a semana da nutricao nas escolas", "saude,educacao basica", "http://example.com/semana_saude", "1, 2, 3");
        this.systemControl.votarComissao("PLP 1/2016", "governista", "plenario");

        assertEquals("APROVADO (CCJC), EM VOTACAO (Plenario - 1o turno)", this.systemControl.exibirTramitacao("PLP 1/2016"));
    }

    @Test
    void testExibirTramitacaoEntradaInvalidaOuNula() {
        this.systemControl.cadastraPartido("ABC");

        this.systemControl.cadastrarPessoa("Maurileide", "051444444-0", "PE", "", "ABC");
        this.systemControl.cadastraDeputado("051444444-0", "29022016");

        this.systemControl.cadastrarComissao("CCJC", "051444444-0");
        this.systemControl.cadastrarPLP("051444444-0", 2016, "Institui a semana da nutricao nas escolas", "saude,educacao basica", "http://example.com/semana_saude", "1, 2, 3");


        try {
            this.systemControl.exibirTramitacao(null);
            fail("era pra dar ruim");
        } catch (NullPointerException npe) {
        }


        try {
            this.systemControl.exibirTramitacao("  ");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
        }
    }

    // EXIBIR TRAMITACAO DA PLP

    @Test
    void testExibirTramitacaoPLPNenhumaVotacaoRealizada() {
        this.systemControl.cadastraPartido("ABC");

        this.systemControl.cadastrarPessoa("Maurileide", "051444444-0", "PE", "", "ABC");
        this.systemControl.cadastraDeputado("051444444-0", "29022016");

        this.systemControl.cadastrarComissao("CCJC", "051444444-0");
        this.systemControl.cadastrarPLP("051444444-0", 2016, "Institui a semana da nutricao nas escolas", "saude,educacao basica", "http://example.com/semana_saude", "1, 2, 3");


        assertEquals("EM VOTACAO (CCJC)", this.systemControl.exibirTramitacao("PLP 1/2016"));
    }

    @Test
    void testeExibirTramitacaoVotacaoPLPEncerrada() {
        this.systemControl.cadastraPartido("ABC");

        this.systemControl.cadastrarPessoa("Maurileide", "051444444-0", "PE", "", "ABC");
        this.systemControl.cadastraDeputado("051444444-0", "29022016");


        this.systemControl.cadastrarPessoa("Maurileide", "051444445-0", "PE", "", "ABC");
        this.systemControl.cadastraDeputado("051444445-0", "29022016");


        this.systemControl.cadastrarPessoa("Maurileide", "051444446-0", "PE", "", "ABC");
        this.systemControl.cadastraDeputado("051444446-0", "29022016");

        this.systemControl.cadastrarPessoa("Maurileide", "051444447-0", "PE", "", "ABC");
        this.systemControl.cadastraDeputado("051444447-0", "29022016");

        this.systemControl.cadastrarComissao("CCJC", "051444444-0");
        this.systemControl.cadastrarPLP("051444444-0", 2016, "Institui a semana da nutricao nas escolas", "saude,educacao basica", "http://example.com/semana_saude","artigos");

        this.systemControl.votarComissao("PLP 1/2016", "governista", "plenario");
        this.systemControl.votarPlenario("PLP 1/2016", "governista", "051444444-0,051444445-0,051444446-0,051444447-0");
        this.systemControl.votarPlenario("PLP 1/2016", "governista", "051444444-0,051444445-0,051444446-0,051444447-0");


        assertEquals("APROVADO (CCJC), APROVADO (Plenario - 1o turno), APROVADO (Plenario - 2o turno)", this.systemControl.exibirTramitacao("PLP 1/2016"));
    }

    @Test
    void testeExibirTramitacaoVotacaoPLPrejeitadaNoPlenario() {
        this.systemControl.cadastraPartido("ABC");

        this.systemControl.cadastrarPessoa("Maurileide", "051444444-0", "PE", "", "ABC");
        this.systemControl.cadastraDeputado("051444444-0", "29022016");


        this.systemControl.cadastrarPessoa("Maurileide", "051444445-0", "PE", "", "ABC");
        this.systemControl.cadastraDeputado("051444445-0", "29022016");


        this.systemControl.cadastrarPessoa("Maurileide", "051444446-0", "PE", "", "ABC");
        this.systemControl.cadastraDeputado("051444446-0", "29022016");

        this.systemControl.cadastrarPessoa("Maurileide", "051444447-0", "PE", "", "ADBC");
        this.systemControl.cadastraDeputado("051444447-0", "29022016");


        this.systemControl.cadastrarPessoa("Maurileide", "051444448-0", "PE", "", "CABC");
        this.systemControl.cadastraDeputado("051444448-0", "29022016");


        this.systemControl.cadastrarPessoa("Maurileide", "051444449-0", "PE", "", "ABRC");
        this.systemControl.cadastraDeputado("051444449-0", "29022016");


        this.systemControl.cadastrarPessoa("Maurileide", "051444440-0", "PE", "", "ABWC");
        this.systemControl.cadastraDeputado("051444440-0", "29022016");

        this.systemControl.cadastrarComissao("CCJC", "051444444-0");
        this.systemControl.cadastrarPLP("051444444-0", 2016, "Institui a semana da nutricao nas escolas", "saude,educacao basica", "http://example.com/semana_saude","artigos");

        this.systemControl.votarComissao("PLP 1/2016", "governista", "plenario");
        this.systemControl.votarPlenario("PLP 1/2016", "governista", "051444448-0,051444449-0,051444440-0,051444447-0");

        assertEquals("APROVADO (CCJC), REJEITADO (Plenario - 1o turno)", this.systemControl.exibirTramitacao("PLP 1/2016"));

    }

    @Test
    void testeExibirTramitacaoVotacaoPLPaCaminho() {
        this.systemControl.cadastraPartido("ABC");

        this.systemControl.cadastrarPessoa("Maurileide", "051444444-0", "PE", "", "ABC");
        this.systemControl.cadastraDeputado("051444444-0", "29022016");


        this.systemControl.cadastrarPessoa("Maurileide", "051444445-0", "PE", "", "ABC");
        this.systemControl.cadastraDeputado("051444445-0", "29022016");


        this.systemControl.cadastrarPessoa("Maurileide", "051444446-0", "PE", "", "ABC");
        this.systemControl.cadastraDeputado("051444446-0", "29022016");

        this.systemControl.cadastrarPessoa("Maurileide", "051444447-0", "PE", "", "ABC");
        this.systemControl.cadastraDeputado("051444447-0", "29022016");

        this.systemControl.cadastrarComissao("CCJC", "051444444-0");
        this.systemControl.cadastrarPLP("051444444-0", 2016, "Institui a semana da nutricao nas escolas", "saude,educacao basica", "http://example.com/semana_saude","artigos");

        this.systemControl.votarComissao("PLP 1/2016", "governista", "plenario");
        this.systemControl.votarPlenario("PLP 1/2016", "governista", "051444444-0,051444445-0,051444446-0,051444447-0");

        assertEquals("APROVADO (CCJC), APROVADO (Plenario - 1o turno), EM VOTACAO (Plenario - 2o turno)", this.systemControl.exibirTramitacao("PLP 1/2016"));

    }




    @Test
    void testeExibirTramitacaoVotacaoPLPVotadoNaComissao() {
        this.systemControl.cadastraPartido("ABC");

        this.systemControl.cadastrarPessoa("Maurileide", "051444444-0", "PE", "", "ABC");
        this.systemControl.cadastraDeputado("051444444-0", "29022016");


        this.systemControl.cadastrarPessoa("Maurileide", "051444445-0", "PE", "", "ABC");
        this.systemControl.cadastraDeputado("051444445-0", "29022016");


        this.systemControl.cadastrarPessoa("Maurileide", "051444446-0", "PE", "", "ABC");
        this.systemControl.cadastraDeputado("051444446-0", "29022016");

        this.systemControl.cadastrarPessoa("Maurileide", "051444447-0", "PE", "", "ABC");
        this.systemControl.cadastraDeputado("051444447-0", "29022016");

        this.systemControl.cadastrarComissao("CCJC", "051444444-0");
        this.systemControl.cadastrarPLP("051444444-0", 2016, "Institui a semana da nutricao nas escolas", "saude,educacao basica", "http://example.com/semana_saude","artigos");

        this.systemControl.votarComissao("PLP 1/2016", "governista", "plenario");

        assertEquals("APROVADO (CCJC), EM VOTACAO (Plenario - 1o turno)", this.systemControl.exibirTramitacao("PLP 1/2016"));
    }

    @Test
    void testeExibirTramitacaoVotacaoPLPEncerradaArquivada() {
        this.systemControl.cadastraPartido("ABC");

        this.systemControl.cadastrarPessoa("Maurileide", "051444444-0", "PE", "", "ABC");
        this.systemControl.cadastraDeputado("051444444-0", "29022016");


        this.systemControl.cadastrarPessoa("Maurileide", "051444445-0", "PE", "", "ABC");
        this.systemControl.cadastraDeputado("051444445-0", "29022016");


        this.systemControl.cadastrarPessoa("Maurileide", "051444446-0", "PE", "", "ABC");
        this.systemControl.cadastraDeputado("051444446-0", "29022016");

        this.systemControl.cadastrarPessoa("Maurileide", "051444447-0", "PE", "", "AdBC");
        this.systemControl.cadastraDeputado("051444447-0", "29022016");


        this.systemControl.cadastrarPessoa("Maurileide", "051444448-0", "PE", "", "CABC");
        this.systemControl.cadastraDeputado("051444448-0", "29022016");


        this.systemControl.cadastrarPessoa("Maurileide", "051444449-0", "PE", "", "ABRC");
        this.systemControl.cadastraDeputado("051444449-0", "29022016");


        this.systemControl.cadastrarPessoa("Maurileide", "051444440-0", "PE", "", "ABWC");
        this.systemControl.cadastraDeputado("051444440-0", "29022016");

        this.systemControl.cadastrarComissao("CCJC", "051444444-0");
        this.systemControl.cadastrarPLP("051444444-0", 2016, "Institui a semana da nutricao nas escolas", "saude,educacao basica", "http://example.com/semana_saude","artigos");

        this.systemControl.votarComissao("PLP 1/2016", "governista", "plenario");
        this.systemControl.votarPlenario("PLP 1/2016", "governista", "051444444-0,051444445-0,051444446-0,051444447-0");


        assertEquals("APROVADO (CCJC), REJEITADO (Plenario - 1o turno)", this.systemControl.exibirTramitacao("PLP 1/2016"));
    }

    @Test
    void testeExibirTramitacaoVotacaoPLPEncerradaTestSituacao() {
        this.systemControl.cadastraPartido("ABC");

        this.systemControl.cadastrarPessoa("Maurileide", "051444444-0", "PE", "", "ABC");
        this.systemControl.cadastraDeputado("051444444-0", "29022016");


        this.systemControl.cadastrarPessoa("Maurileide", "051444445-0", "PE", "", "ABC");
        this.systemControl.cadastraDeputado("051444445-0", "29022016");


        this.systemControl.cadastrarPessoa("Maurileide", "051444446-0", "PE", "", "ABC");
        this.systemControl.cadastraDeputado("051444446-0", "29022016");

        this.systemControl.cadastrarPessoa("Maurileide", "051444447-0", "PE", "", "ABC");
        this.systemControl.cadastraDeputado("051444447-0", "29022016");


        this.systemControl.cadastrarPessoa("Maurileide", "051444448-0", "PE", "", "ABC");
        this.systemControl.cadastraDeputado("051444448-0", "29022016");


        this.systemControl.cadastrarPessoa("Maurileide", "051444449-0", "PE", "", "ABRC");
        this.systemControl.cadastraDeputado("051444449-0", "29022016");


        this.systemControl.cadastrarPessoa("Maurileide", "051444440-0", "PE", "", "ABWC");
        this.systemControl.cadastraDeputado("051444440-0", "29022016");

        this.systemControl.cadastrarComissao("CCJC", "051444444-0");
        this.systemControl.cadastrarPLP("051444444-0", 2016, "Institui a semana da nutricao nas escolas", "saude,educacao basica", "http://example.com/semana_saude","artigos");

        this.systemControl.votarComissao("PLP 1/2016", "governista", "plenario");
        this.systemControl.votarPlenario("PLP 1/2016", "governista", "051444444-0,051444445-0,051444446-0,051444447-0,051444448-0");
        this.systemControl.votarPlenario("PLP 1/2016", "oposicao", "051444448-0,051444449-0,051444440-0,051444447-0,051444446-0");


        assertEquals("APROVADO (CCJC), APROVADO (Plenario - 1o turno), REJEITADO (Plenario - 2o turno)", this.systemControl.exibirTramitacao("PLP 1/2016"));

    }


    // EXIBIR TRAMITACAO DA PEC

    @Test
    void testExibirTramitacaoPECNenhumaVotacaoRealizada() {
        this.systemControl.cadastraPartido("ABC");

        this.systemControl.cadastrarPessoa("Maurileide", "051444444-0", "PE", "", "ABC");
        this.systemControl.cadastraDeputado("051444444-0", "29022016");

        this.systemControl.cadastrarComissao("CCJC", "051444444-0");
        this.systemControl.cadastrarPEC("051444444-0", 2016, "Institui a semana da nutricao nas escolas", "saude,educacao basica", "http://example.com/semana_saude", "1, 2, 3");


        assertEquals("EM VOTACAO (CCJC)", this.systemControl.exibirTramitacao("PEC 1/2016"));
    }

    @Test
    void testeExibirTramitacaoVotacaoPECrejeitadaNoPlenario() {
        this.systemControl.cadastraPartido("ABC");

        this.systemControl.cadastrarPessoa("Maurileide", "051444444-0", "PE", "", "ABC");
        this.systemControl.cadastraDeputado("051444444-0", "29022016");


        this.systemControl.cadastrarPessoa("Maurileide", "051444445-0", "PE", "", "ABC");
        this.systemControl.cadastraDeputado("051444445-0", "29022016");


        this.systemControl.cadastrarPessoa("Maurileide", "051444446-0", "PE", "", "ABC");
        this.systemControl.cadastraDeputado("051444446-0", "29022016");

        this.systemControl.cadastrarPessoa("Maurileide", "051444447-0", "PE", "", "ABC");
        this.systemControl.cadastraDeputado("051444447-0", "29022016");


        this.systemControl.cadastrarPessoa("Maurileide", "051444448-0", "PE", "", "CABC");
        this.systemControl.cadastraDeputado("051444448-0", "29022016");


        this.systemControl.cadastrarPessoa("Maurileide", "051444449-0", "PE", "", "ABRC");
        this.systemControl.cadastraDeputado("051444449-0", "29022016");


        this.systemControl.cadastrarPessoa("Maurileide", "051444440-0", "PE", "", "ABWC");
        this.systemControl.cadastraDeputado("051444440-0", "29022016");

        this.systemControl.cadastrarComissao("CCJC", "051444444-0");
        this.systemControl.cadastrarPEC("051444444-0", 2016, "Institui a semana da nutricao nas escolas", "saude,educacao basica", "http://example.com/semana_saude","artigos");

        this.systemControl.votarComissao("PEC 1/2016", "governista", "plenario");
        this.systemControl.votarPlenario("PEC 1/2016", "governista", "051444448-0,051444449-0,051444440-0,051444447-0");

        assertEquals("APROVADO (CCJC), REJEITADO (Plenario - 1o turno)", this.systemControl.exibirTramitacao("PEC 1/2016"));

    }

    @Test
    void testeExibirTramitacaoVotacaoPECaCaminho() {
        this.systemControl.cadastraPartido("ABC");

        this.systemControl.cadastrarPessoa("Maurileide", "051444444-0", "PE", "", "ABC");
        this.systemControl.cadastraDeputado("051444444-0", "29022016");


        this.systemControl.cadastrarPessoa("Maurileide", "051444445-0", "PE", "", "ABC");
        this.systemControl.cadastraDeputado("051444445-0", "29022016");


        this.systemControl.cadastrarPessoa("Maurileide", "051444446-0", "PE", "", "ABC");
        this.systemControl.cadastraDeputado("051444446-0", "29022016");

        this.systemControl.cadastrarPessoa("Maurileide", "051444447-0", "PE", "", "ABC");
        this.systemControl.cadastraDeputado("051444447-0", "29022016");

        this.systemControl.cadastrarComissao("CCJC", "051444444-0");
        this.systemControl.cadastrarPEC("051444444-0", 2016, "Institui a semana da nutricao nas escolas", "saude,educacao basica", "http://example.com/semana_saude","artigos");

        this.systemControl.votarComissao("PEC 1/2016", "governista", "plenario");
        this.systemControl.votarPlenario("PEC 1/2016", "governista", "051444444-0,051444445-0,051444446-0,051444447-0");

        assertEquals("APROVADO (CCJC), APROVADO (Plenario - 1o turno), EM VOTACAO (Plenario - 2o turno)", this.systemControl.exibirTramitacao("PEC 1/2016"));

    }

    @Test
    void testeExibirTramitacaoVotacaoPECVotandoNaComissao() {
        this.systemControl.cadastraPartido("ABC");

        this.systemControl.cadastrarPessoa("Maurileide", "051444444-0", "PE", "", "ACBC");
        this.systemControl.cadastraDeputado("051444444-0", "29022016");


        this.systemControl.cadastrarPessoa("Maurileide", "051444445-0", "PE", "", "ABCC");
        this.systemControl.cadastraDeputado("051444445-0", "29022016");


        this.systemControl.cadastrarPessoa("Maurileide", "051444446-0", "PE", "", "ABCC ");
        this.systemControl.cadastraDeputado("051444446-0", "29022016");

        this.systemControl.cadastrarPessoa("Maurileide", "051444447-0", "PE", "", "CABC");
        this.systemControl.cadastraDeputado("051444447-0", "29022016");

        this.systemControl.cadastrarComissao("CCJC", "051444444-0");
        this.systemControl.cadastrarPEC("051444444-0", 2016, "Institui a semana da nutricao nas escolas", "saude,educacao basica", "http://example.com/semana_saude","artigos");

        this.systemControl.votarComissao("PEC 1/2016", "governista", "plenario");

        assertEquals("REJEITADO (CCJC), EM VOTACAO (Plenario - 1o turno)", this.systemControl.exibirTramitacao("PEC 1/2016"));
    }



    @Test
    void testeExibirTramitacaoVotacaoPECEncerrada() {
        this.systemControl.cadastraPartido("ABC");

        this.systemControl.cadastrarPessoa("Maurileide", "051444444-0", "PE", "", "ABC");
        this.systemControl.cadastraDeputado("051444444-0", "29022016");


        this.systemControl.cadastrarPessoa("Maurileide", "051444445-0", "PE", "", "ABC");
        this.systemControl.cadastraDeputado("051444445-0", "29022016");


        this.systemControl.cadastrarPessoa("Maurileide", "051444446-0", "PE", "", "ABC");
        this.systemControl.cadastraDeputado("051444446-0", "29022016");

        this.systemControl.cadastrarPessoa("Maurileide", "051444447-0", "PE", "", "ABC");
        this.systemControl.cadastraDeputado("051444447-0", "29022016");

        this.systemControl.cadastrarComissao("CCJC", "051444444-0");
        this.systemControl.cadastrarPEC("051444444-0", 2016, "Institui a semana da nutricao nas escolas", "saude,educacao basica", "http://example.com/semana_saude","artigos");

        this.systemControl.votarComissao("PEC 1/2016", "governista", "plenario");
        this.systemControl.votarPlenario("PEC 1/2016", "governista", "051444444-0,051444445-0,051444446-0,051444447-0");
        this.systemControl.votarPlenario("PEC 1/2016", "governista", "051444444-0,051444445-0,051444446-0,051444447-0");


        assertEquals("APROVADO (CCJC), APROVADO (Plenario - 1o turno), APROVADO (Plenario - 2o turno)", this.systemControl.exibirTramitacao("PEC 1/2016"));
    }

    @Test
    void testeExibirTramitacaoVotacaoPECEncerradaArquivada() {
        this.systemControl.cadastraPartido("ABC");

        this.systemControl.cadastrarPessoa("Maurileide", "051444444-0", "PE", "", "ABC");
        this.systemControl.cadastraDeputado("051444444-0", "29022016");


        this.systemControl.cadastrarPessoa("Maurileide", "051444445-0", "PE", "", "ABC");
        this.systemControl.cadastraDeputado("051444445-0", "29022016");


        this.systemControl.cadastrarPessoa("Maurileide", "051444446-0", "PE", "", "ABC");
        this.systemControl.cadastraDeputado("051444446-0", "29022016");

        this.systemControl.cadastrarPessoa("Maurileide", "051444447-0", "PE", "", "AdBC");
        this.systemControl.cadastraDeputado("051444447-0", "29022016");


        this.systemControl.cadastrarPessoa("Maurileide", "051444448-0", "PE", "", "CABC");
        this.systemControl.cadastraDeputado("051444448-0", "29022016");


        this.systemControl.cadastrarPessoa("Maurileide", "051444449-0", "PE", "", "ABRC");
        this.systemControl.cadastraDeputado("051444449-0", "29022016");


        this.systemControl.cadastrarPessoa("Maurileide", "051444440-0", "PE", "", "ABWC");
        this.systemControl.cadastraDeputado("051444440-0", "29022016");

        this.systemControl.cadastrarComissao("CCJC", "051444444-0");
        this.systemControl.cadastrarPEC("051444444-0", 2016, "Institui a semana da nutricao nas escolas", "saude,educacao basica", "http://example.com/semana_saude","artigos");

        this.systemControl.votarComissao("PEC 1/2016", "governista", "plenario");
        this.systemControl.votarPlenario("PEC 1/2016", "governista", "051444444-0,051444445-0,051444446-0,051444447-0");


        assertEquals("APROVADO (CCJC), REJEITADO (Plenario - 1o turno)", this.systemControl.exibirTramitacao("PEC 1/2016"));

    }


    @Test
    void testeExibirTramitacaoVotacaoPECEncerradaTestSituacao() {
        this.systemControl.cadastraPartido("ABC");

        this.systemControl.cadastrarPessoa("Maurileide", "051444444-0", "PE", "", "ABC");
        this.systemControl.cadastraDeputado("051444444-0", "29022016");


        this.systemControl.cadastrarPessoa("Maurileide", "051444445-0", "PE", "", "ABC");
        this.systemControl.cadastraDeputado("051444445-0", "29022016");


        this.systemControl.cadastrarPessoa("Maurileide", "051444446-0", "PE", "", "ABC");
        this.systemControl.cadastraDeputado("051444446-0", "29022016");

        this.systemControl.cadastrarPessoa("Maurileide", "051444447-0", "PE", "", "ABC");
        this.systemControl.cadastraDeputado("051444447-0", "29022016");


        this.systemControl.cadastrarPessoa("Maurileide", "051444448-0", "PE", "", "ABC");
        this.systemControl.cadastraDeputado("051444448-0", "29022016");


        this.systemControl.cadastrarPessoa("Maurileide", "051444449-0", "PE", "", "ABRC");
        this.systemControl.cadastraDeputado("051444449-0", "29022016");


        this.systemControl.cadastrarPessoa("Maurileide", "051444440-0", "PE", "", "ABWC");
        this.systemControl.cadastraDeputado("051444440-0", "29022016");

        this.systemControl.cadastrarComissao("CCJC", "051444444-0");
        this.systemControl.cadastrarPEC("051444444-0", 2016, "Institui a semana da nutricao nas escolas", "saude,educacao basica", "http://example.com/semana_saude","artigos");

        this.systemControl.votarComissao("PEC 1/2016", "governista", "plenario");
        this.systemControl.votarPlenario("PEC 1/2016", "governista", "051444444-0,051444445-0,051444446-0,051444447-0,051444448-0");
        this.systemControl.votarPlenario("PEC 1/2016", "oposicao", "051444448-0,051444449-0,051444440-0,051444447-0,051444446-0");


        assertEquals("APROVADO (CCJC), APROVADO (Plenario - 1o turno), REJEITADO (Plenario - 2o turno)", this.systemControl.exibirTramitacao("PEC 1/2016"));

    }


    // TESTES EXIBIR TRAMITACAO PL
    @Test
    void testExibirTramitacaoPLNenhumaVotacaoRealizada() {
        this.systemControl.cadastraPartido("ABC");

        this.systemControl.cadastrarPessoa("Maurileide", "051444444-0", "PE", "", "ABC");
        this.systemControl.cadastraDeputado("051444444-0", "29022016");

        this.systemControl.cadastrarComissao("CCJC", "051444444-0");
        this.systemControl.cadastrarPL("051444444-0", 2016, "Institui a semana da nutricao nas escolas", "saude,educacao basica", "http://example.com/semana_saude", false);


        assertEquals("EM VOTACAO (CCJC)", this.systemControl.exibirTramitacao("PL 1/2016"));
    }

    @Test
    void testeExibirTramitacaoVotacaoPLNaoConclusivaACaminho() {
        this.systemControl.cadastraPartido("ABC");

        this.systemControl.cadastrarPessoa("Maurileide", "051444444-0", "PE", "", "ABC");
        this.systemControl.cadastraDeputado("051444444-0", "29022016");


        this.systemControl.cadastrarPessoa("Maurileide", "051444445-0", "PE", "", "ABC");
        this.systemControl.cadastraDeputado("051444445-0", "29022016");


        this.systemControl.cadastrarPessoa("Maurileide", "051444446-0", "PE", "", "ABC");
        this.systemControl.cadastraDeputado("051444446-0", "29022016");

        this.systemControl.cadastrarPessoa("Maurileide", "051444447-0", "PE", "", "ABC");
        this.systemControl.cadastraDeputado("051444447-0", "29022016");

        this.systemControl.cadastrarComissao("CCJC", "051444444-0");
        this.systemControl.cadastrarPL("051444444-0", 2016, "Institui a semana da nutricao nas escolas", "saude,educacao basica", "http://example.com/semana_saude",false);

        this.systemControl.votarComissao("PL 1/2016", "governista", "plenario");

        assertEquals("APROVADO (CCJC), EM VOTACAO (Plenario)", this.systemControl.exibirTramitacao("PL 1/2016"));
    }


    @Test
    void testeExibirTramitacaoVotacaoPLConclusivaEncerrada() {
        this.systemControl.cadastraPartido("ABC");

        this.systemControl.cadastrarPessoa("Maurileide", "051444444-0", "PE", "", "ABCd");
        this.systemControl.cadastraDeputado("051444444-0", "29022016");

        this.systemControl.cadastrarComissao("CCJC", "051444444-0");
        this.systemControl.cadastrarPL("051444444-0", 2016, "Institui a semana da nutricao nas escolas", "saude,educacao basica", "http://example.com/semana_saude",true);

        this.systemControl.votarComissao("PL 1/2016", "governista", "plenario");
        assertEquals("REJEITADO (CCJC)", this.systemControl.exibirTramitacao("PL 1/2016"));
    }

    @Test
    void testeExibirTramitacaoVotacaoPLNaoConclusivaEncerrada() {
        this.systemControl.cadastraPartido("ABC");

        this.systemControl.cadastrarPessoa("Maurileide", "051444444-0", "PE", "", "ABC");
        this.systemControl.cadastraDeputado("051444444-0", "29022016");


        this.systemControl.cadastrarPessoa("Maurileide", "051444445-0", "PE", "", "ABC");
        this.systemControl.cadastraDeputado("051444445-0", "29022016");


        this.systemControl.cadastrarPessoa("Maurileide", "051444446-0", "PE", "", "ABC");
        this.systemControl.cadastraDeputado("051444446-0", "29022016");

        this.systemControl.cadastrarPessoa("Maurileide", "051444447-0", "PE", "", "ABC");
        this.systemControl.cadastraDeputado("051444447-0", "29022016");

        this.systemControl.cadastrarComissao("CCJC", "051444444-0");
        this.systemControl.cadastrarPL("051444444-0", 2016, "Institui a semana da nutricao nas escolas", "saude,educacao basica", "http://example.com/semana_saude",false);

        this.systemControl.votarComissao("PL 1/2016", "governista", "plenario");
        this.systemControl.votarPlenario("PL 1/2016", "governista", "051444444-0,051444445-0,051444446-0,051444447-0");

        assertEquals("APROVADO (CCJC), APROVADO (Plenario)", this.systemControl.exibirTramitacao("PL 1/2016"));

    }


    @Test
    void testeExibirTramitacaoVotacaoPLNaoConclusivaEncerradaArquivada() {
        this.systemControl.cadastraPartido("ABC");

        this.systemControl.cadastrarPessoa("Maurileide", "051444444-0", "PE", "", "ABC");
        this.systemControl.cadastraDeputado("051444444-0", "29022016");


        this.systemControl.cadastrarPessoa("Maurileide", "051444445-0", "PE", "", "ABC");
        this.systemControl.cadastraDeputado("051444445-0", "29022016");


        this.systemControl.cadastrarPessoa("Maurileide", "051444446-0", "PE", "", "ABC");
        this.systemControl.cadastraDeputado("051444446-0", "29022016");

        this.systemControl.cadastrarPessoa("Maurileide", "051444447-0", "PE", "", "AdBC");
        this.systemControl.cadastraDeputado("051444447-0", "29022016");


        this.systemControl.cadastrarPessoa("Maurileide", "051444448-0", "PE", "", "CABC");
        this.systemControl.cadastraDeputado("051444448-0", "29022016");


        this.systemControl.cadastrarPessoa("Maurileide", "051444449-0", "PE", "", "ABRC");
        this.systemControl.cadastraDeputado("051444449-0", "29022016");


        this.systemControl.cadastrarPessoa("Maurileide", "051444440-0", "PE", "", "ABWC");
        this.systemControl.cadastraDeputado("051444440-0", "29022016");

        this.systemControl.cadastrarComissao("CCJC", "051444444-0");
        this.systemControl.cadastrarPL("051444444-0", 2016, "Institui a semana da nutricao nas escolas", "saude,educacao basica", "http://example.com/semana_saude",false);

        this.systemControl.votarComissao("PL 1/2016", "governista", "plenario");
        this.systemControl.votarPlenario("PL 1/2016", "governista", "051444448-0,051444449-0,051444440-0,051444447-0");


        assertEquals("APROVADO (CCJC), REJEITADO (Plenario)", this.systemControl.exibirTramitacao("PL 1/2016"));

    }

    }


