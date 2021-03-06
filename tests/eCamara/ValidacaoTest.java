package eCamara;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidacaoTest {
    private Validacao validador;

    @BeforeEach
    void setUp() {
        validador = new Validacao();
    }

    @Test
    void testeValidaNomeCadastroPessoa() {
        try {
            validador.validarCadastroPessoa("123456789-0", "", "PB");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
        }

        try {
            validador.validarCadastroPessoa("123456789-0", null, "PB");
            fail("era pra dar ruim");
        } catch (NullPointerException iae) {
        }
    }

    @Test
    void testeValidaDniCadastroPessoa() {
        try {
            validador.validarCadastroPessoa("123456789-a", "rodrigo", "PB");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
        }

        try {
            validador.validarCadastroPessoa("1234567r9-0", "rodrigo", "PB");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
        }

        try {
            validador.validarCadastroPessoa("", "rodrigo", "PB");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
        }

        try {
            validador.validarCadastroPessoa(null, "rodrigo", "PB");
            fail("era pra dar ruim");
        } catch (NullPointerException npe) {
        }
    }

    @Test
    void testeValidaEstadoCadastroPessoa() {
        try {
            validador.validarCadastroPessoa("123456789-0", "rodrigo", "");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
        }

        try {
            validador.validarCadastroPessoa("123456789-0", "rodrigo", null);
            fail("era pra dar ruim");
        } catch (NullPointerException npe) {
        }
    }

    @Test
    void testeValidaDniCadastroDeputado() {
        try {
            validador.validaDniCadastraDeputado("");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
        }

        try {
            validador.validaDniCadastraDeputado(null);
            fail("era pra dar ruim");
        } catch (NullPointerException iae) {
        }

        try {
            validador.validaDniCadastraDeputado("0734548-a1");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
        }

        try {
            validador.validaDniCadastraDeputado("073451a7-1");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
        }
    }

    @Test
    void testeValidaDataCadastroDeputadoDataInvalida() {
        try {
            validador.validaDataCadastroDeputado("12132019");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
        }

        try {
            validador.validaDataCadastroDeputado("31022019");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
        }

        try {
            validador.validaDataCadastroDeputado("29022019");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
        }
    }

    @Test
    void testeValidaDataCadastroDeputadoFormatoInvalido() {
        try {
            validador.validaDataCadastroDeputado("123019");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
        }

        try {
            validador.validaDataCadastroDeputado("");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
        }

        try {
            validador.validaDataCadastroDeputado(" ");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
        }

        try {
            validador.validaDataCadastroDeputado(null);
            fail("era pra dar ruim");
        } catch (NullPointerException iae) {
        }

        try {
            validador.validaDataCadastroDeputado("200");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
        }

        try {
            validador.validaDataCadastroDeputado("diadiamesmesanoanoanoano");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
        }
    }


    @Test
    void testeValidoDataCadastroDeputadoDataFutura() {

        try {
            validador.validaDataCadastroDeputado("12123019");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
        }


        try {
            validador.validaDataCadastroDeputado("21052020");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
        }



    }

    @Test
    void testeEntradaValidaDeputado() {
        try {
            validador.validaDeputado(null);
            fail("era pra dar ruim");
        } catch (NullPointerException npe) {
        }

        try {
            validador.validaDeputado("");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException npe) {
        }

        try {
            validador.validaDeputado("  ");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException npe) {
        }
    }

    @Test
    void testeValidaCadastraPartido() {
        try {
            validador.validaCadastraPartido("");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
        }

        try {
            validador.validaCadastraPartido("  ");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
        }

        try {
            validador.validaCadastraPartido(null);
            fail("era pra dar ruim");
        } catch (NullPointerException iae) {
        }
    }

    @Test
    void testeValidaExibirPessoa() {
        try {
            validador.validaExibirPessoa("");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
        }

        try {
            validador.validaExibirPessoa(null);
            fail("era pra dar ruim");
        } catch (NullPointerException iae) {
        }

        try {
            validador.validaExibirPessoa("0734548-a1");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
        }

        try {
            validador.validaExibirPessoa("073451a7-1");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
        }
    }

    @Test
    void testeValidaCadastrarComissaoTemaInvalido() {
        try {
            validador.validaCadastrarComissao(" ", "123456789-0");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException nope) {
        }

        try {
            validador.validaCadastrarComissao("", "123456789-0");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException nope) {
        }

        try {
            validador.validaCadastrarComissao(null, "123456789-0");
            fail("era pra dar ruim");
        } catch (NullPointerException nope) {
        }
    }

    @Test
    void testeValidaCadastrarComissaoPoliticosInvalidos() {
        try {
            validador.validaCadastrarComissao("vacas", "");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException nope) {
        }

        try {
            validador.validaCadastroComissaoDnis("123456789-0, 14785236a-2");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException nope) {
        }
        try {
            validador.validaCadastroComissaoDnis("12345678c-0");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException nope) {
        }
        try {
            validador.validaCadastroComissaoDnis("124587963-a");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException nope) {
        }

        try {
            validador.validaCadastroComissaoDnis( "159632478-0, 1587423969-c");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException nope) {
        }

        try {
            validador.validaCadastrarComissao("vacas", null);
            fail("era pra dar ruim");
        } catch (NullPointerException nope) {
        }
    }

    @Test
    void testeValidaDniCadastrarPL() {
        try {
            validador.validaCadastrarPL("123456789-c", 2018, "...", "vacas", "sei la meu rapaz");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException nope) {
        }

        try {
            validador.validaCadastrarPL("12345678a-5", 2018, "...", "vacas", "sei la meu rapaz");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException nope) {
        }

        try {
            validador.validaCadastrarPL("", 2018, "...", "vacas", "sei la meu rapaz");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException nope) {
        }

        try {
            validador.validaCadastrarPL(" ", 2018, "...", "vacas", "sei la meu rapaz");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException nope) {
        }

        try {
            validador.validaCadastrarPL(null, 2018, "...", "vacas", "sei la meu rapaz");
            fail("era pra dar ruim");
        } catch (NullPointerException nope) {
        }
    }

    @Test
    void testeValidaAnoCadastrarPL() {
        try {
            validador.validaCadastrarPL("123456789-5", -2018, "...", "vacas", "sei la meu rapaz");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException nope) {
        }

        try {
            validador.validaCadastrarPL("123456789-5", 2020, "...", "vacas", "sei la meu rapaz");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException nope) {
        }

        try {
            validador.validaCadastrarPL("123456789-5", 2025, "...", "vacas", "sei la meu rapaz");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException nope) {
        }

        try {
            validador.validaCadastrarPL("123456789-5", 0, "...", "vacas", "sei la meu rapaz");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException nope) {
        }
    }

    @Test
    void testeValidaEmentaCadastrarPL() {
        try {
            validador.validaCadastrarPL("123456789-5", 2018, "", "vacas", "sei la meu rapaz");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException nope) {
        }

        try {
            validador.validaCadastrarPL("123456789-5", 2018, " ", "vacas", "sei la meu rapaz");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException nope) {
        }

        try {
            validador.validaCadastrarPL("123456789-5", 2018, null, "vacas", "sei la meu rapaz");
            fail("era pra dar ruim");
        } catch (NullPointerException nope) {
        }
    }

    @Test
    void testeValidaInteressesCadastrarPL() {
        try {
            validador.validaCadastrarPL("123456789-5", 2018, "...", "", "sei la meu rapaz");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException nope) {
        }

        try {
            validador.validaCadastrarPL("123456789-5", 2018, "...", "   ", "sei la meu rapaz");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException nope) {
        }

        try {
            validador.validaCadastrarPL("123456789-5", 2018, "...", null, "sei la meu rapaz");
            fail("era pra dar ruim");
        } catch (NullPointerException nope) {
        }
    }

    @Test
    void testeValidaUrlCadatrarPL() {
        try {
            validador.validaCadastrarPL("123456789-5", 2018, "...", "vacas", "");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException nope) {
        }

        try {
            validador.validaCadastrarPL("123456789-5", 2018, "...", "vacas", "  ");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException nope) {
        }

        try {
            validador.validaCadastrarPL("123456789-5", 2018, "...", "vacas", null);
            fail("era pra dar ruim");
        } catch (NullPointerException nope) {
        }
    }

    @Test
    void testeValidaDniCadastrarPLP() {
        try {
            validador.validaCadastrarPLP("123456789-c", 2018, "...", "vacas", "sei la meu rapaz", "1");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException nope) {
        }

        try {
            validador.validaCadastrarPLP("12345678a-5", 2018, "...", "vacas", "sei la meu rapaz", "1");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException nope) {
        }

        try {
            validador.validaCadastrarPLP("", 2018, "...", "vacas", "sei la meu rapaz", "1");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException nope) {
        }

        try {
            validador.validaCadastrarPLP(" ", 2018, "...", "vacas", "sei la meu rapaz", "1");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException nope) {
        }

        try {
            validador.validaCadastrarPLP(null, 2018, "...", "vacas", "sei la meu rapaz", "1");
            fail("era pra dar ruim");
        } catch (NullPointerException nope) {
        }

    }

    @Test
    void testeValidaAnoCadastrarPLP() {
        try {
            validador.validaCadastrarPLP("123456789-5", -2018, "...", "vacas", "sei la meu rapaz", "1");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException nope) {
        }

        try {
            validador.validaCadastrarPLP("123456789-5", 2020, "...", "vacas", "sei la meu rapaz", "1");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException nope) {
        }

        try {
            validador.validaCadastrarPLP("123456789-5", 2025, "...", "vacas", "sei la meu rapaz", "1");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException nope) {
        }

        try {
            validador.validaCadastrarPLP("123456789-5", 0, "...", "vacas", "sei la meu rapaz", "1");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException nope) {
        }
    }

    @Test
    void testeValidaEmentaCadastrarPLP() {
        try {
            validador.validaCadastrarPLP("123456789-5", 2018, "", "vacas", "sei la meu rapaz", "1");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException nope) {
        }

        try {
            validador.validaCadastrarPLP("123456789-5", 2018, " ", "vacas", "sei la meu rapaz", "1");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException nope) {
        }

        try {
            validador.validaCadastrarPLP("123456789-5", 2018, null, "vacas", "sei la meu rapaz", "1");
            fail("era pra dar ruim");
        } catch (NullPointerException nope) {
        }
    }

    @Test
    void testeValidaInteressesCadastrarPLP() {
        try {
            validador.validaCadastrarPLP("123456789-5", 2018, "...", "", "sei la meu rapaz", "1");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException nope) {
        }

        try {
            validador.validaCadastrarPLP("123456789-5", 2018, "...", "   ", "sei la meu rapaz", "1");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException nope) {
        }

        try {
            validador.validaCadastrarPLP("123456789-5", 2018, "...", null, "sei la meu rapaz", "1");
            fail("era pra dar ruim");
        } catch (NullPointerException nope) {
        }
    }

    @Test
    void testeValidaUrlCadastrarPLP() {
        try {
            validador.validaCadastrarPLP("123456789-5", 2018, "...", "vacas", "", "1");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException nope) {
        }

        try {
            validador.validaCadastrarPLP("123456789-5", 2018, "...", "vacas", "  ", "1");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException nope) {
        }

        try {
            validador.validaCadastrarPLP("123456789-5", 2018, "...", "vacas", null, "1");
            fail("era pra dar ruim");
        } catch (NullPointerException nope) {
        }
    }

    @Test
    void testeValidaArtigosCadastrarPLP() {
        try {
            validador.validaCadastrarPLP("123456789-5", 2018, "...", "vacas", "http/lalal", "");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException nope) {
        }

        try {
            validador.validaCadastrarPLP("123456789-5", 2018, "...", "vacas", "http/lalal", " ");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException nope) {
        }

        try {
            validador.validaCadastrarPLP("123456789-5", 2018, "...", "vacas", "http/lalal", null);
            fail("era pra dar ruim");
        } catch (NullPointerException nope) {
        }

    }

    @Test
    void testeValidaDniCadastrarPEC() {
        try {
            validador.validaCadastrarPEC("123456789-c", 2018, "...", "vacas", "sei la meu rapaz", "1");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException nope) {
        }

        try {
            validador.validaCadastrarPEC("12345678a-5", 2018, "...", "vacas", "sei la meu rapaz", "1");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException nope) {
        }

        try {
            validador.validaCadastrarPEC("", 2018, "...", "vacas", "sei la meu rapaz", "1");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException nope) {
        }

        try {
            validador.validaCadastrarPEC(" ", 2018, "...", "vacas", "sei la meu rapaz", "1");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException nope) {
        }

        try {
            validador.validaCadastrarPEC(null, 2018, "...", "vacas", "sei la meu rapaz", "1");
            fail("era pra dar ruim");
        } catch (NullPointerException nope) {
        }

    }

    @Test
    void testeValidaAnoCadastrarPEC() {
        try {
            validador.validaCadastrarPEC("123456789-5", -2018, "...", "vacas", "sei la meu rapaz", "1");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException nope) {
        }

        try {
            validador.validaCadastrarPEC("123456789-5", 2020, "...", "vacas", "sei la meu rapaz", "1");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException nope) {
        }

        try {
            validador.validaCadastrarPEC("123456789-5", 2025, "...", "vacas", "sei la meu rapaz", "1");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException nope) {
        }

        try {
            validador.validaCadastrarPEC("123456789-5", 0, "...", "vacas", "sei la meu rapaz", "1");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException nope) {
        }
    }

    @Test
    void testeValidaEmentaCadastrarPEC() {
        try {
            validador.validaCadastrarPEC("123456789-5", 2018, "", "vacas", "sei la meu rapaz", "1");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException nope) {
        }

        try {
            validador.validaCadastrarPEC("123456789-5", 2018, " ", "vacas", "sei la meu rapaz", "1");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException nope) {
        }

        try {
            validador.validaCadastrarPEC("123456789-5", 2018, null, "vacas", "sei la meu rapaz", "1");
            fail("era pra dar ruim");
        } catch (NullPointerException nope) {
        }
    }

    @Test
    void testeValidaInteressesCadastrarPEC() {
        try {
            validador.validaCadastrarPEC("123456789-5", 2018, "...", "", "sei la meu rapaz", "1");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException nope) {
        }

        try {
            validador.validaCadastrarPEC("123456789-5", 2018, "...", "   ", "sei la meu rapaz", "1");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException nope) {
        }

        try {
            validador.validaCadastrarPEC("123456789-5", 2018, "...", null, "sei la meu rapaz", "1");
            fail("era pra dar ruim");
        } catch (NullPointerException nope) {
        }
    }

    @Test
    void testeValidaUrlCadastrarPEC() {
        try {
            validador.validaCadastrarPEC("123456789-5", 2018, "...", "vacas", "", "1");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException nope) {
        }

        try {
            validador.validaCadastrarPEC("123456789-5", 2018, "...", "vacas", "  ", "1");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException nope) {
        }

        try {
            validador.validaCadastrarPEC("123456789-5", 2018, "...", "vacas", null, "1");
            fail("era pra dar ruim");
        } catch (NullPointerException nope) {
        }
    }

    @Test
    void testeValidaArtigosCadastrarPEC() {
        try {
            validador.validaCadastrarPEC("123456789-5", 2018, "...", "vacas", "http/lalal", "");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException nope) {
        }

        try {
            validador.validaCadastrarPEC("123456789-5", 2018, "...", "vacas", "http/lalal", " ");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException nope) {
        }

        try {
            validador.validaCadastrarPEC("123456789-5", 2018, "...", "vacas", "http/lalal", null);
            fail("era pra dar ruim");
        } catch (NullPointerException nope) {
        }

    }

    @Test
    void testeValidaEntradasExibeLei() {
        try {
            validador.validaExibeLei("");
            fail("erapra dar ruim");
        } catch (IllegalArgumentException nope) {
        }

        try {
            validador.validaExibeLei("  ");
            fail("erapra dar ruim");
        } catch (IllegalArgumentException nope) {
        }

        try {
            validador.validaExibeLei(null);
            fail("erapra dar ruim");
        } catch (NullPointerException nope) {
        }
    }

    @Test
    void validaVotarComissaoStatusGovernista() {
        try {
            validador.validaVotarComissao(null, "ACULA");
            fail("Era esperada uma excecao!");
        } catch(NullPointerException npe) {}

        try {
            validador.validaVotarComissao("", "Ali");
            fail("Era esperada uma exceção!");
        } catch(IllegalArgumentException iae) {}
    }

    @Test
    void validaVotarComissaoProximoLocal() {
        try {
            validador.validaVotarComissao("governista", null);
            fail("Era esperada uma excecao!");
        } catch(NullPointerException npe) {}

        try {
            validador.validaVotarComissao("governista", "");
            fail("Era esperada uma exceção!");
        } catch(IllegalArgumentException iae) {}
    }

    @Test
    void validaVotarComissaoStatusGovernistaInvalido() {
        try {
            validador.validaVotarComissao("sei nao", "Ali");
            fail("Era esperada uma exceção!");
        } catch(IllegalArgumentException iae) {}
    }

    @Test
    void validaVotarComissaoCondicoesNormais() {
        validador.validaVotarComissao("oposicao", "acula");
        validador.validaVotarComissao("livre", "acula");
        validador.validaVotarComissao("governista", "acula");
    }

    @Test
    void validaVotarPlenarioStatusGovernista() {
        try {
            validador.validaVotarPlenario(null, "123, 456, 789");
            fail("Era esperada uma excecao!");
        } catch(NullPointerException npe) {}

        try {
            validador.validaVotarPlenario("", "123, 456, 789");
            fail("Era esperada uma exceção!");
        } catch(IllegalArgumentException iae) {}
    }

    @Test
    void validaVotarPlenarioPoliticosPresentes() {
        try {
            validador.validaVotarPlenario("governista", null);
            fail("Era esperada uma excecao!");
        } catch(NullPointerException npe) {}

        try {
            validador.validaVotarPlenario("governista", "");
            fail("Era esperada uma exceção!");
        } catch(IllegalArgumentException iae) {}
    }

    @Test
    void validaVotarPlenarioStatusGovernistaInvalido() {
        try {
            validador.validaVotarPlenario("nao me faca perguntas dificeis", "123, 456, 789");
            fail("Era esperada uma exceção!");
        } catch(IllegalArgumentException iae) {}
    }

    @Test
    void validaVotarPlenarioCondicoesNormais() {
        validador.validaVotarPlenario("oposicao", "123, 456, 789");
        validador.validaVotarPlenario("livre", "123, 456, 789");
        validador.validaVotarPlenario("governista", "123, 456, 789");
    }

    @Test
    void validaconfigurarEstrategiaPropostaRelacionadaPessoaVazia(){
        try{
            validador.validaconfigurarEstrategiaPropostaRelacionada("", "conclusao");
            fail("Era esperada uma exceção!");
        }catch (IllegalArgumentException iae){}

    }

    @Test
    void validaconfigurarEstrategiaPropostaRelacionadaPessoaNula(){
        try{
            validador.validaconfigurarEstrategiaPropostaRelacionada(null, "conclusao");
            fail("Era esperada uma exceção!");
        }catch (NullPointerException npe){}

    }


    @Test
    void validaconfigurarEstrategiaPropostaRelacionadaEstrategiaVazia(){
        try{
            validador.validaconfigurarEstrategiaPropostaRelacionada("123456-8", "");
            fail("Era esperada uma exceção!");
        }catch (IllegalArgumentException iae){}

    }

    @Test
    void validaconfigurarEstrategiaPropostaRelacionadaEstrategiaNula(){
        try{
            validador.validaconfigurarEstrategiaPropostaRelacionada("123456-2", null);
            fail("Era esperada uma exceção!");
        }catch (NullPointerException iae){}

    }


    @Test
    void validaconfigurarEstrategiaPropostaRelacionadaDniInvalido(){
        try{
            validador.validaconfigurarEstrategiaPropostaRelacionada("123456Abc", "conclusao");
            fail("Era esperada uma exceção!");
        }catch (IllegalArgumentException iae){}

    }
    @Test
    void validaconfigurarEstrategiaPropostaRelacionadaDniVazio(){
        try{
            validador.validaconfigurarEstrategiaPropostaRelacionada("", "conclusao");
            fail("Era esperada uma exceção!");
        }catch (IllegalArgumentException iae){}

    }

    @Test
    void validaconfigurarEstrategiaPropostaRelacionadaDniNulo(){
        try{
            validador.validaconfigurarEstrategiaPropostaRelacionada(null, "conclusao");
            fail("Era esperada uma exceção!");
        }catch (NullPointerException npe){}

    }


    @Test
    void validaconfigurarEstrategiaPropostaRelacionadaEstrategiaInvalida(){
        try{
            validador.validaconfigurarEstrategiaPropostaRelacionada("963258-1", "vencer");
            fail("Era esperada uma exceção!");
        }catch (IllegalArgumentException iae){}

    }

    @Test
    void validaPegarPropostaRelacionadaPessoaVazia(){
        try{
            validador.validaPegarPropostaRelacionada("");
            fail("Era esperada uma exceção!");
        }catch (IllegalArgumentException iae){}

    }

    @Test
    void validaPegarPropostaRelacionadaPessoaNula(){
        try{
            validador.validaPegarPropostaRelacionada(null);
            fail("Era esperada uma exceção!");
        }catch (NullPointerException npe){}

    }

    @Test
    void validaPegarPropostaRelacionadaDniInvalido(){
        try{
            validador.validaPegarPropostaRelacionada("125478Abc");
            fail("Era esperada uma exceção!");
        }catch (IllegalArgumentException iae){}

    }


}
