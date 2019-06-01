package eCamara;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SystemControlTest {

    private SystemControl systemControl;
    private Deputado deputado;

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
    void cadastraDeputadoTest(){
        this.systemControl.cadastrarPessoa("Maria", "159-2", "PB", "ganhar", "PRB");
        this.systemControl.cadastraDeputado("159-2", "13012018");
        assertTrue(this.systemControl.getMapPessoas().get("159-2").getFuncao() != null);
    }
    @Test
    void cadastraDeputadoTest1(){
        this.systemControl.cadastrarPessoa("Joao", "169-2", "PB", "ganhar", "PRB");
        this.systemControl.cadastraDeputado("169-2", "21032019");
        assertFalse(this.systemControl.getMapPessoas().get("169-2").getFuncao() == null);
    }
    @Test
    void cadastraDeputadoTest2(){
        this.systemControl.cadastrarPessoa("Joao", "169-2", "PB", "ganhar", "PRB");
        this.systemControl.cadastraDeputado("169-2", "21032019");
        assertFalse(this.systemControl.getMapPessoas().get("169-2").getFuncao() == deputado);
    }

    @Test
    void cadastraDeputadoTest3(){
        this.systemControl.cadastrarPessoa("Mariana", "168-2", "PB", "ganhar", "PRB");
        this.systemControl.cadastraDeputado("168-2", "13012000");
        assertFalse(this.systemControl.getMapPessoas().get("168-2").getFuncao().equals(""));
    }

    @Test
    void cadastraDeputadoTest4(){
        this.systemControl.cadastrarPessoa("Maria", "1693-2", "PB", "ganhar", "PRB");
        try {
            this.systemControl.cadastraDeputado("12-2", "13012000");
        }catch (IllegalArgumentException iae){

        }
    }
    @Test
    void cadastraDeputadoTest5(){
        this.systemControl.cadastrarPessoa("Juliana", "255-3", "PE", "mudar", "PCdoB");
        try {
            this.systemControl.cadastraDeputado("255-3", "13/01/2000");
        }catch (IllegalArgumentException iae){
        }
    }

    @Test
    void cadastraDeputadoTest6(){
        this.systemControl.cadastrarPessoa("Bruna", "899-4", "PB", "transformar","PSDB");
        try{
            this.systemControl.cadastraDeputado("", "13012010");
        }catch (IllegalArgumentException iae){
        }
    }

    @Test
    void cadastraDeputadoTest7(){
        this.systemControl.cadastrarPessoa("Noemia", "123-4", "PB", "transformar","PSDB");
        try{
            this.systemControl.cadastraDeputado("123-4", "");
        }catch (IllegalArgumentException iae){
        }
    }

    @Test
    void cadastraDeputadoTest8(){
        this.systemControl.cadastrarPessoa("Laura", "563-4", "PB", "debater","PSDB");
        try{
            this.systemControl.cadastraDeputado("", "");
        }catch (IllegalArgumentException iae){
        }
    }

    @Test
    void cadastraDeputadoTest9(){
        this.systemControl.cadastrarPessoa("Lais", "103-4", "PB", "discutir solucoes","PSDB");
        try{
            this.systemControl.cadastraDeputado("103-4", "14062030");
        }catch (IllegalArgumentException iae){
        }
    }

    @Test
    void cadastraDeputadoTest10(){
        this.systemControl.cadastrarPessoa("Ellen", "142-8", "PB", "renovar","PSDB");
        try{
            this.systemControl.cadastraDeputado("103-4", "17082011");
        }catch (IllegalArgumentException iae){
        }
    }

    @Test
    void cadastraDeputadoTest11(){
        this.systemControl.cadastrarPessoa("Ellen", "142-8", "PB", "renovar","PSDB");
        try{
            this.systemControl.cadastraDeputado("103Aa-4", "30062018");
        }catch (IllegalArgumentException iae){
        }
    }

    @Test
    void cadastraDeputadoTest12(){
        this.systemControl.cadastrarPessoa("Ellen", "142-8", "PB", "renovar","");
        try{
            this.systemControl.cadastraDeputado("103-4", "22112014");
        }catch (IllegalArgumentException iae){
        }
    }

    @Test
    void cadastraDeputadoTest13(){
        this.systemControl.cadastrarPessoa("Ellen", "142-8", "PB", "renovar","PSDB");
        try{
            this.systemControl.cadastraDeputado("103-4", "1052019");
        }catch (IllegalArgumentException iae){
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