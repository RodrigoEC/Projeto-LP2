package eCamara;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SystemControlTest {

    private SystemControl systemControl;

    @BeforeEach
    public void controleGeral() {
        this.systemControl = new SystemControl();
    }

    @Test
    void SystemControlTest() {
        assertTrue(this.systemControl.getMapPessoas().isEmpty());
    }

    @Test
    void cadastraPessoaSemPartidoTest() {
        try {
            this.systemControl.cadastrarPessoaSemPartido(" ","0053-3", "GG", "");
            fail("Era esperado excecao");
        } catch (IllegalArgumentException iae) {
        }
    }

    @Test
    void cadastraPessoaSemPartidoTest2() {
        try {
            this.systemControl.cadastrarPessoaSemPartido(null,"0053-3", "GG", "");
            fail("Era esperado excecao");
        } catch (NullPointerException npe) {
        }
    }

    @Test
    void cadastraPessoaSemPartidoTest3() {
        try {
            this.systemControl.cadastrarPessoaSemPartido("Jao"," ", "GG", "");
            fail("Era esperado excecao");
        } catch (IllegalArgumentException iae) {
        }
    }

    @Test
    void cadastraPessoaSemPartidoTest4() {
        try {
            this.systemControl.cadastrarPessoaSemPartido("Jao",null, "GG", "");
            fail("Era esperado excecao");
        } catch (NullPointerException npe) {
        }
    }

    @Test
    void cadastraPessoaSemPartidoTest5() {
        try {
            this.systemControl.cadastrarPessoaSemPartido("Jao","adaa", "GG", "");
            fail("Era esperado excecao");
        } catch (IllegalArgumentException iae) {
        }
    }

    @Test
    void cadastraPessoaSemPartidoTest6() {
        try {
            this.systemControl.cadastrarPessoaSemPartido("Jao","234-2", " ", "");
            fail("Era esperado excecao");
        } catch (IllegalArgumentException iae) {
        }
    }

    @Test
    void cadastraPessoaSemPartidoTest7() {
        try {
            this.systemControl.cadastrarPessoaSemPartido("Jao","233-2", null, "");
            fail("Era esperado excecao");
        } catch (NullPointerException npe) {
        }
    }

    @Test
    void cadastraPessoaSemPartidoTest8() {
        this.systemControl.cadastrarPessoaSemPartido("Jao","233-2", "gg", "");
        assertFalse(this.systemControl.getMapPessoas().isEmpty());
    }

    @Test
    void cadastraPessoaSemPartidoTest9() {
        this.systemControl.cadastrarPessoaSemPartido("Jao","233-2", "gg", "");
        try{
            this.systemControl.cadastrarPessoaSemPartido("Jao", "233-2", "AM", "");
        } catch (IllegalArgumentException iae){
        }
    }

    @Test
    void cadastraPessoaSemPartidoTest10() {
        this.systemControl.cadastrarPessoa("Jao","233-2", "gg", "", "LRG - Libera Rinha de Galo");
        try{
            this.systemControl.cadastrarPessoaSemPartido("Jao", "233-2", "AM", "");
        } catch (IllegalArgumentException iae){
        }
    }

    @Test
    void cadastraPessoaTest() {
        try {
            this.systemControl.cadastrarPessoa(" ","0053-3", "GG", "", "LRG - Libera Rinha de Galo");
            fail("Era esperado excecao");
        } catch (IllegalArgumentException iae) {
        }
    }

    @Test
    void cadastraPessoaTest2() {
        try {
            this.systemControl.cadastrarPessoa(null,"0053-3", "GG", "", "LRG - Libera Rinha de Galo");
            fail("Era esperado excecao");
        } catch (NullPointerException npe) {
        }
    }

    @Test
    void cadastraPessoaTest3() {
        try {
            this.systemControl.cadastrarPessoa("Jao"," ", "GG", "", "LRG - Libera Rinha de Galo");
            fail("Era esperado excecao");
        } catch (IllegalArgumentException iae) {
        }
    }

    @Test
    void cadastraPessoaTest4() {
        try {
            this.systemControl.cadastrarPessoa("Jao",null, "GG", "", "LRG - Libera Rinha de Galo");
            fail("Era esperado excecao");
        } catch (NullPointerException npe) {
        }
    }

    @Test
    void cadastraPessoaTest5() {
        try {
            this.systemControl.cadastrarPessoa("Jao","adaa", "GG", "", "LRG - Libera Rinha de Galo");
            fail("Era esperado excecao");
        } catch (IllegalArgumentException iae) {
        }
    }

    @Test
    void cadastraPessoaTest6() {
        try {
            this.systemControl.cadastrarPessoa("Jao","234-2", " ", "", "LRG - Libera Rinha de Galo");
            fail("Era esperado excecao");
        } catch (IllegalArgumentException iae) {
        }
    }

    @Test
    void cadastraPessoaTest7() {
        try {
            this.systemControl.cadastrarPessoa("Jao","233-2", null, "", "LRG - Libera Rinha de Galo");
            fail("Era esperado excecao");
        } catch (NullPointerException npe) {
        }
    }

    @Test
    void cadastraPessoaTest8() {
        this.systemControl.cadastrarPessoa("Jao","233-2", "gg", "", "LRG - Libera Rinha de Galo");
        assertFalse(this.systemControl.getMapPessoas().isEmpty());
    }

    @Test
    void cadastraPessoaTest9() {
        this.systemControl.cadastrarPessoa("Jao","233-2", "gg", "", "LRG - Libera Rinha de Galo");
        try{
            this.systemControl.cadastrarPessoa("Jao", "233-2", "AM", "", "LRG - Libera Rinha de Galo");
        } catch (IllegalArgumentException iae){
        }
    }

    @Test
    void cadastraPessoaTest10() {
        this.systemControl.cadastrarPessoaSemPartido("Jao","233-2", "gg", "");
        try{
            this.systemControl.cadastrarPessoa("Jao", "233-2", "AM", "", "LRG - Libera Rinha de Galo");
        } catch (IllegalArgumentException iae){
        }
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
}