package eCamara;

import eCamara.legislativo.PL;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PLTest {

    private PL pl1;

    @BeforeEach
    void setUp(){
        this.pl1 = new PL("061222222-0",2016,"Institui a semana da nutricao nas escolas","saude,educacao basica","http://example.com/semana_saude",true);
    }

    @Test
    void construtorTest(){
        assertEquals("061222222-0", this.pl1.getDniAutor());
        assertEquals(2016, this.pl1.getAno());
        assertEquals("Institui a semana da nutricao nas escolas", this.pl1.getEmenta());
        assertEquals("saude,educacao basica", this.pl1.getInteresses());
        assertEquals("http://example.com/semana_saude", this.pl1.getUrl());
        assertTrue(this.pl1.isConclusivo());
        assertEquals("PL", this.pl1.getTipoLei());
    }

    @Test
    void toStringTest(){
        assertEquals("Projeto de Lei - PL 1/2016 - 061222222-0 - Institui a semana da nutricao nas escolas - Conclusiva - EM VOTACAO (CCJC)", this.pl1.toString("PL 1/2016"));

        PL pl2 = new PL("061222222-0",2016,"Institui a semana do carinho nas escolas","cidadania,educacao basica","http://example.com/semana_cidadania",false);
        assertEquals("Projeto de Lei - PL 2/2016 - 061222222-0 - Institui a semana do carinho nas escolas - EM VOTACAO (CCJC)", pl2.toString("PL 2/2016"));
    }

    @Test
    void testeAddVotacaoRealizadasExcessao() {
        PL pl = new PL("061222222-0",2016,"Institui a semana da nutricao nas escolas","saude,educacao basica","http://example.com/semana_saude",true);

        pl.addVotacaoRealizada();
        pl.addVotacaoRealizada();


        try {
            pl.addVotacaoRealizada();
            fail("era pra dar ruim");
        } catch (IllegalArgumentException IAE) {
        }
    }

}