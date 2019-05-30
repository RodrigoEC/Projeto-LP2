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