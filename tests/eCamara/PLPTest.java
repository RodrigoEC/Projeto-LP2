package eCamara;

import eCamara.legislativo.PLP;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PLPTest {

    private PLP plp1;

    @BeforeEach
    void setUp(){
        this.plp1 = new PLP("061444444-0",2016,"Regulamenta a tributacao de apostas eletronicas","fiscal,jogos","https://example.net/jogos%40aposta","153");
    }

    @Test
    void construtorTest(){
        assertEquals("061444444-0", this.plp1.getDniAutor());
        assertEquals(2016, this.plp1.getAno());
        assertEquals("Regulamenta a tributacao de apostas eletronicas", this.plp1.getEmenta());
        assertEquals("fiscal,jogos", this.plp1.getInteresses());
        assertEquals("https://example.net/jogos%40aposta", this.plp1.getUrl());
        assertEquals("153", this.plp1.getArtigos());
        assertEquals("PLP", this.plp1.getTipoLei());
    }

    @Test
    void toStringTest(){
        assertEquals("Projeto de Lei Complementar - PLP 1/2016 - 061444444-0 - Regulamenta a tributacao de apostas eletronicas - 153 - EM VOTACAO (CCJC)", this.plp1.toString("PLP 1/2016"));
    }

}