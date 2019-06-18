package eCamara;

import eCamara.legislativo.PEC;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class PECTest {

    private PEC pec1;

    @BeforeEach
    void setUp(){
        this.pec1 = new PEC("061222222-0",2016,"Permite a associacao sindical livre e com estrutura hierarquica","trabalho","https://example.com/sindicato/algo.html","7,8");
    }

    @Test
    void construtorTest(){
        assertEquals("061222222-0", this.pec1.getDniAutor());
        assertEquals(2016, this.pec1.getAno());
        assertEquals("Permite a associacao sindical livre e com estrutura hierarquica", this.pec1.getEmenta());
        assertEquals("trabalho", this.pec1.getInteresses());
        assertEquals("https://example.com/sindicato/algo.html", this.pec1.getUrl());
        assertEquals("7,8", this.pec1.getArtigos());
        assertEquals("PEC", this.pec1.getTipoLei());
    }
    @Test
    void toStringTest(){
        assertEquals("Projeto de Emenda Constitucional - PEC 1/2016 - 061222222-0 - Permite a associacao sindical livre e com estrutura hierarquica - 7, 8 - EM VOTACAO (CCJC)", this.pec1.toString("PEC 1/2016"));
    }

    @Test
    void addTurnoTest(){
        this.pec1.addTurno();
        this.pec1.addTurno();

        try{
            this.pec1.addTurno();
            fail("Era esperada uma excecao!");
        } catch(NullPointerException npe){}
    }

}
