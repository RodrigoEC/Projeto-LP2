package eCamara;

import eCamara.individuo.Pessoa;
import eCamara.legislativo.Comissao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

public class ComissaoTest {

    private Comissao comissao1;
    private Comissao comissao2;
    private HashMap<String, Pessoa> mapDeputados1;

    @BeforeEach
    void setUp(){
        this.mapDeputados1 = new HashMap<>();
        this.mapDeputados1.put("123", new Pessoa("Jose", "123-2", "GG", ""));
        this.comissao1 = new Comissao("CCJC", mapDeputados1);
        this.comissao2 = new Comissao("CCJC", mapDeputados1);
    }

    @Test
    void construtorTest(){
        assertEquals(this.mapDeputados1 ,this.comissao1.getMapDeputados());
        assertEquals(this.mapDeputados1.size() ,this.comissao1.tamanhoComissao());
    }

    @Test
    void equalsTest(){
        assertTrue(this.comissao1.equals(this.comissao2));
    }

    @Test
    void hashcodeTest(){
        assertEquals(this.comissao1.hashCode(), this.comissao2.hashCode());
    }
}
