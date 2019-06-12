package eCamara;

import eCamara.individuo.Deputado;
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
    void construtorTest() {
        assertEquals("13012000", this.deputado.getDataInicio());

    }

    @Test
    void construtorTestCondicoesInvalidas() {
        try {
            Deputado deputado2 = new Deputado("");
            fail("Era esperado uma excecao");
        } catch (IllegalArgumentException iae) {
        }

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
        assertTrue(this.deputado.equals(this.deputado4));
        assertFalse(this.deputado3.equals(this.deputado));
    }

    @Test
    void toStringTest(){
        assertEquals("POL:  - 13/01/2000 - 0 Leis", this.deputado.toString(""));
    }
}