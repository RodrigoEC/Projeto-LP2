package eCamara;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PessoaTest {

    private Pessoa p;
    private Pessoa p2;
    private Pessoa p3;

    @BeforeEach
    void setUp() {
        this.p = new Pessoa("Carlos", "0028490850-4", "PB", "sem interesse");
        this.p2 = new Pessoa("Joao", "0034240-234", "PB", "Rinha de galo", "LRG - LIBERA RINHA DE GALO");
        this.p3 = new Pessoa("CarlosCarlos", "0028490850-4", "PB", "sem interesse");
    }

    @Test
    void pessoaTest() {
        assertEquals("Joao", this.p2.getNome());
        assertEquals("PB", this.p2.getEstado());
        assertEquals("0034240-234", this.p2.getDni());
        assertEquals("LRG - LIBERA RINHA DE GALO", this.p2.getPartido());
        assertEquals("Rinha de galo", this.p2.getInteresses());
    }

    @Test
    void pessoaTest2() {
        try {
            Pessoa p = new Pessoa(" ","0053-3", "GG", "");
            fail("Era esperado excecao");
        } catch (IllegalArgumentException iae) {
        }
    }

    @Test
    void pessoaTest3() {
        try {
            Pessoa p = new Pessoa(null,"0053-3", "GG", "");
            fail("Era esperado excecao");
        } catch (NullPointerException npe) {
        }
    }

    @Test
    void pessoaTest4() {
        try {
            Pessoa p = new Pessoa("Jose"," ", "GG", "");
            fail("Era esperado excecao");
        } catch (IllegalArgumentException iae) {
        }
    }

    @Test
    void pessoaTest5() {
        try {
            Pessoa p = new Pessoa("Jose", null, "GG", "");
            fail("Era esperado excecao");
        } catch (NullPointerException npe) {
        }
    }

    @Test
    void pessoaTest6() {
        try {
            Pessoa p = new Pessoa("Jose", "hshags-234", "GG", "");
            fail("Era esperado excecao");
        } catch (IllegalArgumentException iae) {
        }
    }

    @Test
    void pessoaTest7() {
        try {
            Pessoa p = new Pessoa("Jose","4456-4", " ", "");
            fail("Era esperado excecao");
        } catch (IllegalArgumentException iae) {
        }
    }

    @Test
    void pessoaTest8() {
        try {
            Pessoa p = new Pessoa("Jose", "563-3", null, "");
            fail("Era esperado excecao");
        } catch (NullPointerException npe) {
        }
    }

    @Test
    void equalsTest() {
        assertTrue(this.p.equals(this.p));
    }

    @Test
    void equalsTest2() {
        assertTrue(this.p.equals(this.p3));
    }

    @Test
    void equalsTest3() {
        assertFalse(this.p.equals(null));
    }

    @Test
    void equalsTest4() {
        assertFalse(this.p.equals(this.p2));
    }

    @Test
    void equalsTest5() {
        assertFalse(this.p.equals("Pessoa"));
    }

    @Test
    void hashCodeTest() {
        assertEquals(this.p.hashCode(), this.p3.hashCode());
    }
}