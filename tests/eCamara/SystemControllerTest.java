package eCamara;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SystemControllerTest {

    private SystemController systemController;

    @BeforeEach
    public void controleGeral() {
        this.systemController = new SystemController();
    }

    @Test
    void SystemControlTest() {
        assertTrue(this.systemController.getControllerDeputados().getMapPessoas().isEmpty());
    }

    @Test
    void cadastraPessoaSemPartidoTest() {
        try {
            this.systemController.cadastrarPessoaSemPartido(" ", "0053-3", "GG", "");
            fail("Era esperado excecao");
        } catch (IllegalArgumentException iae) {
        }
    }

    @Test
    void cadastraPessoaSemPartidoTest2() {
        try {
            this.systemController.cadastrarPessoaSemPartido(null, "0053-3", "GG", "");
            fail("Era esperado excecao");
        } catch (NullPointerException npe) {
        }
    }

    @Test
    void cadastraPessoaSemPartidoTest3() {
        try {
            this.systemController.cadastrarPessoaSemPartido("Jao", " ", "GG", "");
            fail("Era esperado excecao");
        } catch (IllegalArgumentException iae) {
        }
    }

    @Test
    void cadastraPessoaSemPartidoTest4() {
        try {
            this.systemController.cadastrarPessoaSemPartido("Jao", null, "GG", "");
            fail("Era esperado excecao");
        } catch (NullPointerException npe) {
        }
    }

    @Test
    void cadastraPessoaSemPartidoTest5() {
        try {
            this.systemController.cadastrarPessoaSemPartido("Jao", "adaa", "GG", "");
            fail("Era esperado excecao");
        } catch (IllegalArgumentException iae) {
        }
    }

    @Test
    void cadastraPessoaSemPartidoTest6() {
        try {
            this.systemController.cadastrarPessoaSemPartido("Jao", "234-2", " ", "");
            fail("Era esperado excecao");
        } catch (IllegalArgumentException iae) {
        }
    }

    @Test
    void cadastraPessoaSemPartidoTest7() {
        try {
            this.systemController.cadastrarPessoaSemPartido("Jao", "233-2", null, "");
            fail("Era esperado excecao");
        } catch (NullPointerException npe) {
        }
    }

    @Test
    void cadastraPessoaSemPartidoTest8() {
        this.systemController.cadastrarPessoaSemPartido("Jao", "233-2", "gg", "");
        assertFalse(this.systemController.getControllerDeputados().getMapPessoas().isEmpty());
    }

    @Test
    void cadastraPessoaSemPartidoTest9() {
        this.systemController.cadastrarPessoaSemPartido("Jao", "233-2", "gg", "");
        try {
            this.systemController.cadastrarPessoaSemPartido("Jao", "233-2", "AM", "");
        } catch (IllegalArgumentException iae) {
        }
    }

    @Test
    void cadastraPessoaSemPartidoTest10() {
        this.systemController.cadastrarPessoa("Jao", "233-2", "gg", "", "LRG - Libera Rinha de Galo");
        try {
            this.systemController.cadastrarPessoaSemPartido("Jao", "233-2", "AM", "");
        } catch (IllegalArgumentException iae) {
        }
    }

    @Test
    void cadastraPessoaTest() {
        try {
            this.systemController.cadastrarPessoa(" ", "0053-3", "GG", "", "LRG - Libera Rinha de Galo");
            fail("Era esperado excecao");
        } catch (IllegalArgumentException iae) {
        }
    }

    @Test
    void cadastraPessoaTest2() {
        try {
            this.systemController.cadastrarPessoa(null, "0053-3", "GG", "", "LRG - Libera Rinha de Galo");
            fail("Era esperado excecao");
        } catch (NullPointerException npe) {
        }
    }

    @Test
    void cadastraPessoaTest3() {
        try {
            this.systemController.cadastrarPessoa("Jao", " ", "GG", "", "LRG - Libera Rinha de Galo");
            fail("Era esperado excecao");
        } catch (IllegalArgumentException iae) {
        }
    }

    @Test
    void cadastraPessoaTest4() {
        try {
            this.systemController.cadastrarPessoa("Jao", null, "GG", "", "LRG - Libera Rinha de Galo");
            fail("Era esperado excecao");
        } catch (NullPointerException npe) {
        }
    }

    @Test
    void cadastraPessoaTest5() {
        try {
            this.systemController.cadastrarPessoa("Jao", "adaa", "GG", "", "LRG - Libera Rinha de Galo");
            fail("Era esperado excecao");
        } catch (IllegalArgumentException iae) {
        }
    }

    @Test
    void cadastraPessoaTest6() {
        try {
            this.systemController.cadastrarPessoa("Jao", "234-2", " ", "", "LRG - Libera Rinha de Galo");
            fail("Era esperado excecao");
        } catch (IllegalArgumentException iae) {
        }
    }

    @Test
    void cadastraPessoaTest7() {
        try {
            this.systemController.cadastrarPessoa("Jao", "233-2", null, "", "LRG - Libera Rinha de Galo");
            fail("Era esperado excecao");
        } catch (NullPointerException npe) {
        }
    }

    @Test
    void cadastraPessoaTest8() {
        this.systemController.cadastrarPessoa("Jao", "233-2", "gg", "", "LRG - Libera Rinha de Galo");
        assertFalse(this.systemController.getControllerDeputados().getMapPessoas().isEmpty());
    }

    @Test
    void cadastraPessoaTest9() {
        this.systemController.cadastrarPessoa("Jao", "233-2", "gg", "", "LRG - Libera Rinha de Galo");
        try {
            this.systemController.cadastrarPessoa("Jao", "233-2", "AM", "", "LRG - Libera Rinha de Galo");
        } catch (IllegalArgumentException iae) {
        }
    }

    @Test
    void cadastraPessoaTest10() {
        this.systemController.cadastrarPessoaSemPartido("Jao", "233-2", "gg", "");
        try {
            this.systemController.cadastrarPessoa("Jao", "233-2", "AM", "", "LRG - Libera Rinha de Galo");
        } catch (IllegalArgumentException iae) {
        }
    }

    @Test
    void cadastraDeputadoTest() {
        this.systemController.cadastrarPessoa("Maria", "159-2", "PB", "ganhar", "PRB");
        this.systemController.cadastraDeputado("159-2", "13012018");
        assertTrue(this.systemController.getControllerDeputados().getMapPessoas().get("159-2").getFuncao() != null);
    }

    @Test
    void cadastraDeputadoFuncaoNula() {
        this.systemController.cadastrarPessoa("Joao", "169-2", "PB", "ganhar", "PRB");
        this.systemController.cadastraDeputado("169-2", "21032019");
        assertFalse(this.systemController.getControllerDeputados().getMapPessoas().get("169-2").getFuncao() == null);
    }

    @Test
    void cadastraDeputadoJaDeputado() {
        this.systemController.cadastrarPessoa("Joao", "169-2", "PB", "ganhar", "PRB");
        this.systemController.cadastraDeputado("169-2", "21032019");
        try {
            this.systemController.cadastraDeputado("169-2", "21032019");
        } catch (IllegalArgumentException iae) {
        }
    }

    @Test
    void cadastraDeputadoFuncaoVazia() {
        this.systemController.cadastrarPessoa("Mariana", "168-2", "PB", "ganhar", "PRB");
        this.systemController.cadastraDeputado("168-2", "13012000");
        assertFalse(this.systemController.getControllerDeputados().getMapPessoas().get("168-2").getFuncao().equals(""));
    }

    @Test
    void cadastraDeputadoPessoaNaoCadastrada() {
        this.systemController.cadastrarPessoa("Maria", "1693-2", "PB", "ganhar", "PRB");
        try {
            this.systemController.cadastraDeputado("12-2", "13012000");
        } catch (IllegalArgumentException iae) {
        }
    }

    @Test
    void cadastraDeputadoDataFormatoInvalido() {
        this.systemController.cadastrarPessoa("Juliana", "255-3", "PE", "mudar", "PCdoB");
        try {
            this.systemController.cadastraDeputado("255-3", "13/01/2000");
        } catch (IllegalArgumentException iae) {
        }
    }

    @Test
    void cadastraDeputadoDniVazio() {
        this.systemController.cadastrarPessoa("Bruna", "899-4", "PB", "transformar", "PSDB");
        try {
            this.systemController.cadastraDeputado("", "13012010");
        } catch (IllegalArgumentException iae) {
        }
    }

    @Test
    void cadastraDeputadoDataInicioVazia() {
        this.systemController.cadastrarPessoa("Noemia", "123-4", "PB", "transformar", "PSDB");
        try {
            this.systemController.cadastraDeputado("123-4", "");
        } catch (IllegalArgumentException iae) {
        }
    }

    @Test
    void cadastraDeputadoDniNulo() {
        this.systemController.cadastrarPessoa("Bruna", "899-4", "PB", "transformar", "PSDB");
        try {
            this.systemController.cadastraDeputado(null, "13012010");
        } catch (NullPointerException npe) {
        }
    }

    @Test
    void cadastraDeputadoDataInicioNula() {
        this.systemController.cadastrarPessoa("Noemia", "123-4", "PB", "transformar", "PSDB");
        try {
            this.systemController.cadastraDeputado("123-4", null);
        } catch (NullPointerException npe) {
        }
    }

    @Test
    void cadastraDeputadoParametrosVazios() {
        this.systemController.cadastrarPessoa("Laura", "563-4", "PB", "debater", "PSDB");
        try {
            this.systemController.cadastraDeputado("", "");
        } catch (IllegalArgumentException iae) {
        }
    }

    @Test
    void cadastraDeputadoDataFutura() {
        this.systemController.cadastrarPessoa("Lais", "103-4", "PB", "discutir solucoes", "PSDB");
        try {
            this.systemController.cadastraDeputado("103-4", "14062030");
        } catch (IllegalArgumentException iae) {
        }
    }

    @Test
    void cadastraDeputadoDniInvalido() {
        this.systemController.cadastrarPessoa("Ellen", "103-4", "PB", "renovar", "PSDB");
        try {
            this.systemController.cadastraDeputado("103Aa-4", "30062018");
        } catch (IllegalArgumentException iae) {
        }
    }

    @Test
    void cadastraDeputadoPartidoVazio() {
        this.systemController.cadastrarPessoa("Ellen", "142-8", "PB", "renovar", "");
        try {
            this.systemController.cadastraDeputado("142-8", "22112014");
        } catch (IllegalArgumentException iae) {
        }
    }

    @Test
    void cadastraDeputadoPartidoNulo() {
        this.systemController.cadastrarPessoa("Ellen", "142-8", "PB", "renovar", null);
        try {
            this.systemController.cadastraDeputado("142-8", "22112014");
        } catch (IllegalArgumentException iae) {
        }
    }

    @Test
    void cadastraDeputadoDataForaFormato() {
        this.systemController.cadastrarPessoa("Ellen", "142-8", "PB", "renovar", "PSDB");
        try {
            this.systemController.cadastraDeputado("142-8", "1052019");
        } catch (IllegalArgumentException iae) {
        }
    }

    @Test
    void cadastraComissaoTemaVazio() {
        try {
            this.systemController.cadastrarComissao("", "123456789-0,222222222-2,333333333-3");
        } catch (IllegalArgumentException iae) {

        }
    }

    @Test
    void cadastraComissaoPoliticosVazio() {
        try {
            this.systemController.cadastrarComissao("Educacao", "");
        } catch (IllegalArgumentException iae) {

        }
    }

    @Test
    void cadastraComissaoTemaNulo() {
        try {
            this.systemController.cadastrarComissao(null, "123456789-0,222222222-2,333333333-3");
        } catch (NullPointerException npe) {

        }
    }

    @Test
    void cadastraComissaoPoliticosNulo() {
        try {
            this.systemController.cadastrarComissao("Educacao", null);
        } catch (NullPointerException npe) {

        }
    }

    @Test
    void cadastrarComissaoPessoaInexistente() {
        this.systemController.cadastrarPessoa("Jurema", "051444444-0", "RO", "Educacao", "DEF");
        this.systemController.cadastraDeputado("051444444-0", "12012000");
        try {

            this.systemController.cadastrarComissao("CCJCC", "051222222-0");
            fail("Era esperada uma excecao");
        } catch (NullPointerException npe) {

        }
    }

    @Test
    void cadastrarComissaoPessoaTemaRepetido() {
        this.systemController.cadastrarPessoa("Paulo", "051444444-0", "RO", "Educacao", "DEF");
        this.systemController.cadastrarPessoa("Leticia", "051222222-0", "RO", "Saude", "DEF");
        this.systemController.cadastraDeputado("051444444-0", "12012000");
        this.systemController.cadastraDeputado("051222222-0", "25072010");
        this.systemController.cadastrarComissao("CCJCC", "051222222-0,051444444-0");
        try {
            this.systemController.cadastrarComissao("CCJCC", "051444444-0");
            fail("Era esperada uma excecao");
        } catch (IllegalArgumentException iae) {

        }
    }

    @Test
    void cadastrarComissaoDniInvalido() {
        this.systemController.cadastrarPessoa("Gabriel", "051444444-0", "RO", "Educacao", "DEF");
        this.systemController.cadastrarPessoa("Ana", "051222222-0", "RO", "Educacao", "DEF");
        this.systemController.cadastraDeputado("051444444-0", "12012000");
        this.systemController.cadastraDeputado("051222222-0", "25072010");
        try {
            this.systemController.cadastrarComissao("CCJCC", "051444444AA");
            fail("Era esperada uma excecao");
        } catch (IllegalArgumentException iae) {

        }
    }

    @Test
    void cadastraComissaoPessoaNaoPolitica() {
        this.systemController.cadastrarPessoa("Claudia", "051444444-0", "RO", "Educacao", "DEF");
        this.systemController.cadastrarPessoa("Gilberto", "051222222-0", "RO", "Educacao", "DEF");
        this.systemController.cadastrarPessoa("Mariana", "051111111-0", "RO", "Educacao", "DEF");
        this.systemController.cadastrarPessoa("Patricia", "051333333-0", "RO", "Educacao", "DEF");
        this.systemController.cadastraDeputado("051444444-0", "12012000");
        this.systemController.cadastraDeputado("051222222-0", "25072010");
        this.systemController.cadastrarComissao("CCJCC", "051222222-0,051444444-0");
        try {
            this.systemController.cadastrarComissao("CCJCC", "051333333-0");
            fail("Era esperada uma excecao");
        } catch (IllegalArgumentException iae) {

        }
    }

    @Test
    void exibirPessoaArgumentosInvalidos() {
        try {
            this.systemController.exibirPessoa(null);
            fail("Era esperada uma excecao");
        } catch (NullPointerException npe) {
        }

        try {
            this.systemController.exibirPessoa("");
            fail("Era esperada uma excecao");
        } catch (IllegalArgumentException iae) {
        }

    }

    @Test
    void exibirPessoaNaoCadastrada() {
        try {
            this.systemController.exibirPessoa("1234-567");
            fail("Era esperada uma excecao");
        } catch (IllegalArgumentException iae) {
        }
    }

    @Test
    void exibirPessoaSemFuncao() {
        this.systemController.cadastrarPessoa("Joao", "0034240-234", "PB", "Rinha de galo", "LRG - LIBERA RINHA DE GALO");
        assertEquals("Joao - 0034240-234 (PB) - LRG - LIBERA RINHA DE GALO - Interesses: Rinha de galo", this.systemController.exibirPessoa("0034240-234"));
    }

    @Test
    void exibirPessoaComFuncao() {
        this.systemController.cadastrarPessoa("Joao", "0034240-234", "PB", "Rinha de galo", "LRG - LIBERA RINHA DE GALO");
        this.systemController.cadastraDeputado("0034240-234", "01022018");
        assertEquals("POL: Joao - 0034240-234 (PB) - LRG - LIBERA RINHA DE GALO - Interesses: Rinha de galo - 01/02/2018 - 0 Leis", this.systemController.exibirPessoa("0034240-234"));
    }

    @Test
    void cadastraPartidoPadrao() {
        this.systemController.cadastraPartido("PT");
        assertTrue(systemController.getPartidos().contains("PT"));
    }

    @Test
    void cadastraPartidoInvalido() {
        try {
            this.systemController.cadastraPartido("");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
        }
    }

    @Test
    void cadastraPartidoNulo() {
        try {
            this.systemController.cadastraPartido(null);
            fail("era pra dar ruim");
        } catch (NullPointerException npe) {
        }
    }

    @Test
    void exibePartidosPadrao() {
        this.systemController.cadastraPartido("PT");
        this.systemController.cadastraPartido("PSL");
        this.systemController.cadastraPartido("PSDB");
        this.systemController.cadastraPartido("PSOL");

        assertEquals("PSDB,PSL,PSOL,PT", this.systemController.exibirBase());
    }

    @Test
    void exibePartidosVazio() {
        assertEquals("", this.systemController.exibirBase());
    }

    @Test
    void cadastrarPLPessoaNaoExiste() {
        try {
            this.systemController.cadastrarPL("061222222-0", 2016, "Institui a semana da nutricao nas escolas", "saude,educacao basica", "http://example.com/semana_saude", true);
        } catch (NullPointerException npe) {
        }
    }

    @Test
    void cadastrarPLNaoDeputado() {
        this.systemController.cadastrarPessoa("Jao", "061222222-0", "gg", "", "LRG - Libera Rinha de Galo");

        try {
            this.systemController.cadastrarPL("061222222-0", 2016, "Institui a semana da nutricao nas escolas", "saude,educacao basica", "http://example.com/semana_saude", true);
        } catch (NullPointerException npe) {
        }
    }

    @Test
    void cadastrarPLCondicoesNormais() {
        this.systemController.cadastrarPessoa("Jao", "061222222-0", "gg", "", "LRG - Libera Rinha de Galo");
        this.systemController.cadastraDeputado("061222222-0", "29022016");

        assertEquals("PL 1/2016", this.systemController.cadastrarPL("061222222-0", 2016, "Institui a semana da nutricao nas escolas", "saude,educacao basica", "http://example.com/semana_saude", true));
    }

    @Test
    void cadastrarPLPPessoaNaoExiste() {
        try {
            this.systemController.cadastrarPLP("061222222-0", 2016, "Institui a semana da nutricao nas escolas", "saude,educacao basica", "http://example.com/semana_saude", "153");
        } catch (NullPointerException npe) {
        }
    }

    @Test
    void cadastrarPLPNaoDeputado() {
        this.systemController.cadastrarPessoa("Jao", "061222222-0", "gg", "", "LRG - Libera Rinha de Galo");

        try {
            this.systemController.cadastrarPLP("061222222-0", 2016, "Institui a semana da nutricao nas escolas", "saude,educacao basica", "http://example.com/semana_saude", "153");
        } catch (NullPointerException npe) {
        }
    }

    @Test
    void cadastrarPLPCondicoesNormais() {
        this.systemController.cadastrarPessoa("Jao", "061222222-0", "gg", "", "LRG - Libera Rinha de Galo");
        this.systemController.cadastraDeputado("061222222-0", "29022016");

        assertEquals("PLP 1/2016", this.systemController.cadastrarPLP("061222222-0", 2016, "Institui a semana da nutricao nas escolas", "saude,educacao basica", "http://example.com/semana_saude", "153"));
    }

    @Test
    void cadastrarPECPessoaNaoExiste() {
        try {
            this.systemController.cadastrarPEC("061222222-0", 2016, "Institui a semana da nutricao nas escolas", "saude,educacao basica", "http://example.com/semana_saude", "153");
        } catch (NullPointerException npe) {
        }
    }

    @Test
    void cadastrarPECNaoDeputado() {
        this.systemController.cadastrarPessoa("Jao", "061222222-0", "gg", "", "LRG - Libera Rinha de Galo");

        try {
            this.systemController.cadastrarPEC("061222222-0", 2016, "Institui a semana da nutricao nas escolas", "saude,educacao basica", "http://example.com/semana_saude", "153");
        } catch (NullPointerException npe) {
        }
    }

    @Test
    void cadastrarPECCondicoesNormais() {
        this.systemController.cadastrarPessoa("Jao", "061222222-0", "gg", "", "LRG - Libera Rinha de Galo");
        this.systemController.cadastraDeputado("061222222-0", "29022016");

        assertEquals("PEC 1/2016", this.systemController.cadastrarPEC("061222222-0", 2016, "Institui a semana da nutricao nas escolas", "saude,educacao basica", "http://example.com/semana_saude", "153"));
    }

    @Test
    void exibirProjetoInexistente() {
        try {
            this.systemController.exibirProjeto("PL 1/2016");
        } catch (NullPointerException npe) {
        }
    }

    @Test
    void exibirProjetoCondicoesNormais() {
        this.systemController.cadastrarPessoa("Jao", "061222222-0", "gg", "", "LRG - Libera Rinha de Galo");
        this.systemController.cadastraDeputado("061222222-0", "29022016");
        this.systemController.cadastrarPL("061222222-0", 2016, "Institui a semana da nutricao nas escolas", "saude,educacao basica", "http://example.com/semana_saude", true);
        this.systemController.cadastrarPLP("061222222-0", 2016, "Regulamenta a tributacao de apostas eletronicas", "fiscal,jogos", "https://example.net/jogos%40aposta", "153");
        this.systemController.cadastrarPEC("061222222-0", 2016, "Permite a associacao sindical livre e com estrutura hierarquica", "trabalho", "https://example.com/sindicato/algo.html", "7,8");

        assertEquals("Projeto de Lei - PL 1/2016 - 061222222-0 - Institui a semana da nutricao nas escolas - Conclusiva - EM VOTACAO (CCJC)", this.systemController.exibirProjeto("PL 1/2016"));
        assertEquals("Projeto de Lei Complementar - PLP 1/2016 - 061222222-0 - Regulamenta a tributacao de apostas eletronicas - 153 - EM VOTACAO (CCJC)", this.systemController.exibirProjeto("PLP 1/2016"));
        assertEquals("Projeto de Emenda Constitucional - PEC 1/2016 - 061222222-0 - Permite a associacao sindical livre e com estrutura hierarquica - 7, 8 - EM VOTACAO (CCJC)", this.systemController.exibirProjeto("PEC 1/2016"));
    }

    @Test
    void votarComissaoArgumentosInvalidos() {
        try {
            this.systemController.votarComissao("PL 1/2016", null, "acula");
            fail("Era esperada uma excecao!");
        } catch (NullPointerException npe) {
        }

        try {
            this.systemController.votarComissao("PL 1/2016", "", "acula");
            fail("Era esperada uma excecao!");
        } catch (IllegalArgumentException npe) {
        }

        try {
            this.systemController.votarComissao("PL 1/2016", "sei nao", "acula");
            fail("Era esperada uma excecao!");
        } catch (IllegalArgumentException npe) {
        }

        try {
            this.systemController.votarComissao("PL 1/2016", "governista", null);
            fail("Era esperada uma excecao!");
        } catch (NullPointerException npe) {
        }

        try {
            this.systemController.votarComissao("PL 1/2016", "governista", "");
            fail("Era esperada uma excecao!");
        } catch (IllegalArgumentException npe) {
        }

    }

    @Test
    void votarComissaoCCJCNaoCadastrada() {
        try {
            this.systemController.votarComissao("PL 1/2016", "governista", "Ali");
            fail("Era esperada uma excecao!");
        } catch (NullPointerException npe) {
        }
    }

    @Test
    void votarComissaoProjetoInexistente() {
        this.systemController.cadastrarPessoa("Jurema", "051444444-0", "RO", "Educacao", "DEF");
        this.systemController.cadastraDeputado("051444444-0", "12012000");
        this.systemController.cadastrarComissao("CCJC", "051444444-0");

        try {
            this.systemController.votarComissao("PL 1/2016", "governista", "Ali");
            fail("Era esperada uma excecao!");
        } catch (NullPointerException npe) {
        }
    }

    //---------------------Votar Comissao - PLP--------------------------------
    @Test
    void votarComissaoEncaminhadaAoPlenario() {
        this.systemController.cadastraPartido("DEF");
        this.systemController.cadastraPartido("ABC");

        this.systemController.cadastrarPessoa("Jurema", "051444444-0", "RO", "Educacao", "DEF");
        this.systemController.cadastraDeputado("051444444-0", "12012000");

        this.systemController.cadastrarPessoa("Mateus Matia", "051222222-0", "PE", "", "ABC");
        this.systemController.cadastraDeputado("051222222-0", "29022016");

        this.systemController.cadastrarComissao("CCJC", "051222222-0,051444444-0");
        this.systemController.cadastrarPLP("051444444-0", 2016, "Institui a semana da nutricao nas escolas", "saude,educacao basica", "http://example.com/semana_saude", "1, 2, 3");

        this.systemController.votarComissao("PLP 1/2016", "governista", "num tem");

        //Plenario nao cadastrado
        try {
            this.systemController.votarComissao("PLP 1/2016", "governista", "plenario");
            fail("Era esperada uma excecao!");
        } catch (NullPointerException npe) {
        }

        //Votar no plenario lei que nao foi encaminhada
        try {
            this.systemController.votarPlenario("PLP 1/2016", "governista", "051444444-0, 052444444-0, 053444444-0");
            fail("Era esperada uma excecao!");
        } catch (IllegalArgumentException iae) {
        }

        //votar lei que ja foi aprovada
        this.systemController.cadastrarPLP("051444444-0", 2016, "Institui a semana da nutricao nas escolas", "saude,educacao basica", "http://example.com/semana_saude", "1, 2, 3");
        this.systemController.cadastrarComissao("abc", "051444444-0");
        this.systemController.votarComissao("PLP 2/2016", "governista", "plenario");
        this.systemController.votarPlenario("PLP 2/2016", "governista", "051444444-0, 052444444-0, 053444444-0");
        this.systemController.votarPlenario("PLP 2/2016", "governista", "051444444-0, 052444444-0, 053444444-0");

        //assertEquals("", this.systemController.exibirTramitacao("PLP 2/2016"));

        try {
            this.systemController.votarComissao("PLP 2/2016", "governista", "plenario");
            fail("Era esperada uma excecao!");
        } catch (NullPointerException npe) {
        }
    }

    @Test
    void votarPlenarioProjetoNaoDirecionado() {
        this.systemController.cadastrarPessoa("Jurema", "051444444-0", "RO", "Educacao", "DEF");
        this.systemController.cadastraDeputado("051444444-0", "12012000");
        this.systemController.cadastrarComissao("CCJC", "051444444-0");
        this.systemController.cadastrarPLP("051444444-0", 2016, "Institui a semana da nutricao nas escolas", "saude,educacao basica", "http://example.com/semana_saude", "1, 2, 3");

        this.systemController.votarComissao("PLP 1/2016", "governista", "idd");

        try {
            this.systemController.votarPlenario("PLP 1/2016", "governista", "051444444-0");
            fail("Era esperada uma excecao!");
        } catch (IllegalArgumentException iae) {
        }
    }

    @Test
    void votarPlenarioCondicoesNormais() {

        this.systemController.cadastrarPessoa("Jurema", "051444444-0", "RO", "Educacao", "DEF");
        this.systemController.cadastraDeputado("051444444-0", "12012000");

        this.systemController.cadastrarPessoa("Mateus Matia", "051222222-0", "PE", "", "ABC");
        this.systemController.cadastraDeputado("051222222-0", "29022016");

        this.systemController.cadastrarPessoa("Lucivania", "051111111-0", "RO", "Educacao", "DEF");
        this.systemController.cadastraDeputado("051111111-0", "12012000");

        this.systemController.cadastrarPessoa("Maurileide", "051555555-0", "PE", "", "ABC");
        this.systemController.cadastraDeputado("051555555-0", "29022016");

        this.systemController.cadastrarComissao("CCJC", "051222222-0,051444444-0");
        this.systemController.cadastrarPLP("051444444-0", 2016, "Institui a semana da nutricao nas escolas", "saude,educacao basica", "http://example.com/semana_saude", "1, 2, 3");

        this.systemController.votarComissao("PLP 1/2016", "oposicao", "plenario");
        this.systemController.votarPlenario("PLP 1/2016", "oposicao", "051222222-0,051444444-0,051111111-0,051555555-0");
        this.systemController.votarPlenario("PLP 1/2016", "oposicao", "051222222-0,051444444-0,051111111-0,051555555-0");

        try {
            this.systemController.votarPlenario("PLP 1/2016", "oposicao", "051222222-0,051444444-0,051111111-0,051555555-0");
            fail("Era esperada uma excecao!");
        } catch (IllegalArgumentException iae) {
        }
    }

    @Test
    void votarPlenarioReprovadoPrimeiroTurno() {
        this.systemController.cadastraPartido("DEF");

        this.systemController.cadastrarPessoa("Jurema", "051444444-0", "RO", "Educacao", "DEF");
        this.systemController.cadastraDeputado("051444444-0", "12012000");

        this.systemController.cadastrarPessoa("Mateus Matia", "051222222-0", "PE", "", "ABC");
        this.systemController.cadastraDeputado("051222222-0", "29022016");

        this.systemController.cadastrarPessoa("Lucivania", "051111111-0", "RO", "Educacao", "DEF");
        this.systemController.cadastraDeputado("051111111-0", "12012000");

        this.systemController.cadastrarPessoa("Maurileide", "051555555-0", "PE", "", "ABC");
        this.systemController.cadastraDeputado("051555555-0", "29022016");

        this.systemController.cadastrarComissao("CCJC", "051444444-0,051111111-0");
        this.systemController.cadastrarPLP("051444444-0", 2016, "Institui a semana da nutricao nas escolas", "saude,educacao basica", "http://example.com/semana_saude", "1, 2, 3");

        this.systemController.votarComissao("PLP 1/2016", "governista", "plenario");
        this.systemController.votarPlenario("PLP 1/2016", "governista", "051222222-0,051444444-0,051111111-0,051555555-0");

        //votar projeto encerrado(ARQUIVADO)
        try {
            this.systemController.votarComissao("PLP 1/2016", "governista", "plenario");
            fail("Era esperada uma excecao!");
        } catch (NullPointerException iae) {
        }
    }

    //---------------------Votar Comissao - PEC------------------------------
    @Test
    void votarComissaoEncaminhadaAoPlenarioPEC() {
        this.systemController.cadastraPartido("DEF");
        this.systemController.cadastraPartido("ABC");

        this.systemController.cadastrarPessoa("Jurema", "051444444-0", "RO", "Educacao", "DEF");
        this.systemController.cadastraDeputado("051444444-0", "12012000");

        this.systemController.cadastrarPessoa("Mateus Matia", "051222222-0", "PE", "", "ABC");
        this.systemController.cadastraDeputado("051222222-0", "29022016");

        this.systemController.cadastrarComissao("CCJC", "051222222-0,051444444-0");
        this.systemController.cadastrarPEC("051444444-0", 2016, "Institui a semana da nutricao nas escolas", "saude,educacao basica", "http://example.com/semana_saude", "1, 2, 3");

        this.systemController.votarComissao("PEC 1/2016", "governista", "num tem");

        //Plenario nao cadastrado
        try {
            this.systemController.votarComissao("PEC 1/2016", "governista", "plenario");
            fail("Era esperada uma excecao!");
        } catch (NullPointerException npe) {
        }

        //Votar no plenario lei que nao foi encaminhada
        try {
            this.systemController.votarPlenario("PEC 1/2016", "governista", "051444444-0, 052444444-0, 053444444-0");
            fail("Era esperada uma excecao!");
        } catch (IllegalArgumentException iae) {
        }

        //votar lei que ja foi aprovada
        this.systemController.cadastrarPEC("051444444-0", 2016, "Institui a semana da nutricao nas escolas", "saude,educacao basica", "http://example.com/semana_saude", "1, 2, 3");
        this.systemController.cadastrarComissao("abc", "051444444-0");
        this.systemController.votarComissao("PEC 2/2016", "governista", "plenario");
        this.systemController.votarPlenario("PEC 2/2016", "governista", "051444444-0, 052444444-0, 053444444-0");
        this.systemController.votarPlenario("PEC 2/2016", "governista", "051444444-0, 052444444-0, 053444444-0");

        try {
            this.systemController.votarComissao("PEC 2/2016", "governista", "plenario");
            fail("Era esperada uma excecao!");
        } catch (NullPointerException npe) {
        }
    }

    @Test
    void votarPlenarioProjetoNaoDirecionadoPEC() {
        this.systemController.cadastrarPessoa("Jurema", "051444444-0", "RO", "Educacao", "DEF");
        this.systemController.cadastraDeputado("051444444-0", "12012000");
        this.systemController.cadastrarComissao("CCJC", "051444444-0");
        this.systemController.cadastrarPEC("051444444-0", 2016, "Institui a semana da nutricao nas escolas", "saude,educacao basica", "http://example.com/semana_saude", "1, 2, 3");

        this.systemController.votarComissao("PEC 1/2016", "governista", "idd");

        try {
            this.systemController.votarPlenario("PEC 1/2016", "governista", "051444444-0");
            fail("Era esperada uma excecao!");
        } catch (IllegalArgumentException iae) {
        }
    }

    @Test
    void votarPlenarioCondicoesNormaisPEC() {

        this.systemController.cadastrarPessoa("Jurema", "051444444-0", "RO", "Educacao", "DEF");
        this.systemController.cadastraDeputado("051444444-0", "12012000");

        this.systemController.cadastrarPessoa("Mateus Matia", "051222222-0", "PE", "Educacao", "ABC");
        this.systemController.cadastraDeputado("051222222-0", "29022016");

        this.systemController.cadastrarPessoa("Lucivania", "051111111-0", "RO", "Educacao", "DEF");
        this.systemController.cadastraDeputado("051111111-0", "12012000");

        this.systemController.cadastrarPessoa("Maurileide", "051555555-0", "PE", "saude", "ABC");
        this.systemController.cadastraDeputado("051555555-0", "29022016");

        this.systemController.cadastrarPessoa("Carlucia", "05777777-0", "RO", "Educacao", "DEF");
        this.systemController.cadastraDeputado("05777777-0", "12012000");

        this.systemController.cadastrarComissao("CCJC", "051222222-0,051444444-0,051111111-0,051555555-0,05777777-0");
        this.systemController.cadastrarPEC("051444444-0", 2016, "Institui a semana da nutricao nas escolas", "Educacao", "http://example.com/semana_saude", "1, 2, 3");

        this.systemController.votarComissao("PEC 1/2016", "livre", "plenario");
        this.systemController.votarPlenario("PEC 1/2016", "livre", "051222222-0,051444444-0,051111111-0,051555555-0,05777777-0");
        this.systemController.votarPlenario("PEC 1/2016", "livre", "051222222-0,051444444-0,051111111-0,051555555-0,05777777-0");
    }

    @Test
    void votarPlenarioReprovadoPrimeiroTurnoPEC() {
        this.systemController.cadastraPartido("DEF");

        this.systemController.cadastrarPessoa("Jurema", "051444444-0", "RO", "Educacao", "DEF");
        this.systemController.cadastraDeputado("051444444-0", "12012000");

        this.systemController.cadastrarPessoa("Mateus Matia", "051222222-0", "PE", "", "ABC");
        this.systemController.cadastraDeputado("051222222-0", "29022016");

        this.systemController.cadastrarPessoa("Lucivania", "051111111-0", "RO", "Educacao", "DEF");
        this.systemController.cadastraDeputado("051111111-0", "12012000");

        this.systemController.cadastrarPessoa("Maurileide", "051555555-0", "PE", "", "ABC");
        this.systemController.cadastraDeputado("051555555-0", "29022016");

        this.systemController.cadastrarComissao("CCJC", "051444444-0,051111111-0");
        this.systemController.cadastrarPEC("051444444-0", 2016, "Institui a semana da nutricao nas escolas", "saude,educacao basica", "http://example.com/semana_saude", "1, 2, 3");

        this.systemController.votarComissao("PEC 1/2016", "governista", "plenario");
        this.systemController.votarPlenario("PEC 1/2016", "governista", "051222222-0,051444444-0,051111111-0,051555555-0");

        //votar projeto encerrado(ARQUIVADO)
        try {
            this.systemController.votarComissao("PEC 1/2016", "governista", "plenario");
            fail("Era esperada uma excecao!");
        } catch (NullPointerException iae) {
        }
    }

    //---------------------Votar Comissao - PL------------------------------
    @Test
    void votarComissaoEncaminhadaAoPlenarioPL() {
        this.systemController.cadastraPartido("DEF");
        this.systemController.cadastraPartido("ABC");

        this.systemController.cadastrarPessoa("Jurema", "051444444-0", "RO", "Educacao", "DEF");
        this.systemController.cadastraDeputado("051444444-0", "12012000");

        this.systemController.cadastrarPessoa("Mateus Matia", "051222222-0", "PE", "", "ABC");
        this.systemController.cadastraDeputado("051222222-0", "29022016");

        this.systemController.cadastrarComissao("CCJC", "051222222-0,051444444-0");
        this.systemController.cadastrarPL("051444444-0", 2016, "Institui a semana da nutricao nas escolas", "saude,educacao basica", "http://example.com/semana_saude", true);

        this.systemController.votarComissao("PL 1/2016", "governista", "num tem");

        //Plenario nao cadastrado
        try {
            this.systemController.votarComissao("PL 1/2016", "governista", "plenario");
            fail("Era esperada uma excecao!");
        } catch (NullPointerException npe) {
        }

        //Votar no plenario lei que nao foi encaminhada
        try {
            this.systemController.votarPlenario("PL 1/2016", "governista", "051444444-0, 052444444-0, 053444444-0");
            fail("Era esperada uma excecao!");
        } catch (IllegalArgumentException iae) {
        }

        //votar lei que ja foi aprovada
        this.systemController.cadastrarPL("051444444-0", 2016, "Institui a semana da nutricao nas escolas", "saude,educacao basica", "http://example.com/semana_saude", true);
        this.systemController.cadastrarComissao("abc", "051444444-0");
        this.systemController.votarComissao("PL 2/2016", "governista", "plenario");

        //assertEquals("", this.systemController.exibirTramitacao("PLP 2/2016"));

        try {
            this.systemController.votarComissao("PL 2/2016", "governista", "plenario");
            fail("Era esperada uma excecao!");
        } catch (NullPointerException npe) {
        }
    }

    @Test
    void votarPlenarioProjetoNaoDirecionadoPL() {
        this.systemController.cadastrarPessoa("Jurema", "051444444-0", "RO", "Educacao", "DEF");
        this.systemController.cadastraDeputado("051444444-0", "12012000");
        this.systemController.cadastrarComissao("CCJC", "051444444-0");
        this.systemController.cadastrarPL("051444444-0", 2016, "Institui a semana da nutricao nas escolas", "saude,educacao basica", "http://example.com/semana_saude", true);

        this.systemController.votarComissao("PL 1/2016", "governista", "idd");

        try {
            this.systemController.votarPlenario("PL 1/2016", "governista", "051444444-0");
            fail("Era esperada uma excecao!");
        } catch (IllegalArgumentException iae) {
        }
    }

    @Test
    void votarPlenarioCondicoesNormaisPL() {
        this.systemController.cadastraPartido("DEF");
        this.systemController.cadastraPartido("ABC");

        this.systemController.cadastrarPessoa("Jurema", "051444444-0", "RO", "Educacao", "DEF");
        this.systemController.cadastraDeputado("051444444-0", "12012000");

        this.systemController.cadastrarPessoa("Mateus Matia", "051222222-0", "PE", "", "ABC");
        this.systemController.cadastraDeputado("051222222-0", "29022016");

        this.systemController.cadastrarPessoa("Lucivania", "051111111-0", "RO", "Educacao", "DEF");
        this.systemController.cadastraDeputado("051111111-0", "12012000");

        this.systemController.cadastrarPessoa("Maurileide", "051555555-0", "PE", "", "ABC");
        this.systemController.cadastraDeputado("051555555-0", "29022016");

        this.systemController.cadastrarComissao("CCJC", "051222222-0,051444444-0");
        this.systemController.cadastrarPL("051444444-0", 2016, "Institui a semana da nutricao nas escolas", "saude,educacao basica", "http://example.com/semana_saude", true);

        this.systemController.votarComissao("PL 1/2016", "governista", "plenario");
        this.systemController.votarPlenario("PL 1/2016", "governista", "051222222-0,051444444-0,051111111-0,051555555-0");
    }

    @Test
    void votarPlenarioReprovadoPrimeiroTurnoPL() {
        this.systemController.cadastraPartido("DEF");

        this.systemController.cadastrarPessoa("Jurema", "051444444-0", "RO", "Educacao", "DEF");
        this.systemController.cadastraDeputado("051444444-0", "12012000");

        this.systemController.cadastrarPessoa("Mateus Matia", "051222222-0", "PE", "", "ABC");
        this.systemController.cadastraDeputado("051222222-0", "29022016");

        this.systemController.cadastrarPessoa("Lucivania", "051111111-0", "RO", "Educacao", "DEF");
        this.systemController.cadastraDeputado("051111111-0", "12012000");

        this.systemController.cadastrarPessoa("Maurileide", "051555555-0", "PE", "", "ABC");
        this.systemController.cadastraDeputado("051555555-0", "29022016");

        this.systemController.cadastrarComissao("CCJC", "051444444-0,051111111-0");
        this.systemController.cadastrarPL("051444444-0", 2016, "Institui a semana da nutricao nas escolas", "saude,educacao basica", "http://example.com/semana_saude", true);

        this.systemController.votarComissao("PL 1/2016", "governista", "plenario");
        this.systemController.votarPlenario("PL 1/2016", "governista", "051222222-0,051444444-0,051111111-0,051555555-0");

        //votar projeto encerrado(ARQUIVADO)
        try {
            this.systemController.votarComissao("PL 1/2016", "governista", "plenario");
            fail("Era esperada uma excecao!");
        } catch (NullPointerException iae) {
        }
    }

    @Test
    void ExibirTramitacaoTest() {
        this.systemController.cadastraPartido("ABC");

        this.systemController.cadastrarPessoa("Maurileide", "051444444-0", "PE", "", "ABC");
        this.systemController.cadastraDeputado("051444444-0", "29022016");

        this.systemController.cadastrarComissao("CCJC", "051444444-0");
        this.systemController.cadastrarPLP("051444444-0", 2016, "Institui a semana da nutricao nas escolas", "saude,educacao basica", "http://example.com/semana_saude", "1, 2, 3");

        this.systemController.votarComissao("PLP 1/2016", "governista", "plenario");

        assertEquals("APROVADO (CCJC), EM VOTACAO (Plenario - 1o turno)", this.systemController.exibirTramitacao("PLP 1/2016"));
    }

    @Test
    void pegarPropostaRelacionadaSemInteresseEmComum() {
        this.systemController.cadastrarPessoa("Roberta", "4002-8", "PB", "saude", "PRB");
        this.systemController.cadastraDeputado("4002-8", "12052001");
        this.systemController.cadastrarPL("4002-8", 2019, "Ementa PL conc", "educacao", "http://example.com/semana_saude", false);
        try {
            this.systemController.pegarPropostaRelacionada("8523-6");
            fail("Era esperada uma excecao");
        } catch (IllegalArgumentException iae) {}
    }
    

}