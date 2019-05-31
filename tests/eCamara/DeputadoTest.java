package eCamara;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeputadoTest {
    private Deputado deputado;
    private Deputado deputado2;
    private Deputado deputado3;
    private Deputado deputado4;

    @BeforeEach
    void setUp() {
        this.deputado = new Deputado("13/01/2000");
        this.deputado2 = new Deputado("17/12/2018");
        this.deputado3 = new Deputado("29/02/2017");
    }

    @Test
    void DeputadoTest() {
        assertEquals("13/01/2000", this.deputado.getDataInicio());

    }

    @Test
    void DeputadoTestExcecoes() {
        try {
            Deputado deputado2 = new Deputado("");
            fail("Era esperado uma excecao");
        } catch (IllegalArgumentException iae) {
        }
    }
    @Test
    void DeputadoTestExcecoes2(){
        try {
            Deputado deputado3 = new Deputado(null);
            fail("Era esperado uma excecao");
        }catch (NullPointerException npe){
        }

    }
    @Test
    void equalsTest() {
        assertTrue(this.deputado.equals(this.deputado));
    }

    @Test
    void equalsTest2() {
        assertTrue(this.deputado2.equals(this.deputado2));
    }

    @Test
    void equalsTest3() {
        assertFalse(this.deputado3.equals(null));
    }

    @Test
    void equalsTest4() {
        assertFalse(this.deputado.equals(null));
    }
    @Test
    void equalsTest5() {
        assertFalse(this.deputado2.equals(null));
    }

    @Test
    void equalsTest6() {
        assertFalse(this.deputado3.equals(this.deputado));
    }
    @Test
    void equalsTest7() {
        assertFalse(this.deputado2.equals(this.deputado));
    }
    
}

