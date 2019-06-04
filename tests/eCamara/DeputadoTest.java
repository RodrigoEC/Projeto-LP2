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
        this.deputado = new Deputado("13012000");
        this.deputado2 = new Deputado("17122018");
        this.deputado3 = new Deputado("29022017");
        this.deputado4 = new Deputado("13012000");
    }

    @Test
    void DeputadoTest() {
        assertEquals("13012000", this.deputado.getDataInicio());

    }

    @Test
    void DeputadoTest2() {
        try {
            Deputado deputado2 = new Deputado("");
            fail("Era esperado uma excecao");
        } catch (IllegalArgumentException iae) {
        }
    }
    @Test
    void DeputadoTest3(){
        try {
            Deputado deputado3 = new Deputado(null);
            fail("Era esperado uma excecao");
        }catch (NullPointerException npe){
        }
    }


    @Test
    void hashCodeTest() {
        assertEquals(this.deputado.hashCode(), this.deputado4.hashCode());
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
        assertTrue(this.deputado3.equals(this.deputado3));
    }

    @Test
    void equalsTest4() {
        assertFalse(this.deputado3.equals(this.deputado));
    }

    @Test
    void equalsTest5() {
        assertFalse(this.deputado2.equals(this.deputado3));
    }

    @Test
    void equalsTest6() {
        assertTrue(this.deputado.equals(this.deputado4));
    }




    @Test
    void toStringTest(){
        assertEquals(" - 13/01/2000 - 0 Leis", this.deputado.toString());
    }
}

