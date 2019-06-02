package eCamara;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidacaoTest {
    private Validacao validador;

    @BeforeEach
    void setUp() {
        validador = new Validacao();
    }

    @Test
    void testeValidaNomeCadastroPessoa() {
        try {
            validador.validarCadastroPessoa("123456789-0", "", "PB");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
        }

        try {
            validador.validarCadastroPessoa("123456789-0", null, "PB");
            fail("era pra dar ruim");
        } catch (NullPointerException iae) {
        }
    }

    @Test
    void testeValidaDniCadastroPessoa() {
        try {
            validador.validarCadastroPessoa("123456789-a", "rodrigo", "PB");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
        }

        try {
            validador.validarCadastroPessoa("1234567r9-0", "rodrigo", "PB");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
        }

        try {
            validador.validarCadastroPessoa("", "rodrigo", "PB");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
        }

        try {
            validador.validarCadastroPessoa(null, "rodrigo", "PB");
            fail("era pra dar ruim");
        } catch (NullPointerException npe) {
        }
    }

    @Test
    void testeValidaEstadoCadastroPessoa() {
        try {
            validador.validarCadastroPessoa("123456789-0", "rodrigo", "");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
        }

        try {
            validador.validarCadastroPessoa("123456789-0", "rodrigo", null);
            fail("era pra dar ruim");
        } catch (NullPointerException npe) {
        }
    }

    @Test
    void testeValidaDniCadastroDeputado() {
        try {
            validador.validaDniCadastraDeputado("");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
        }

        try {
            validador.validaDniCadastraDeputado(null);
            fail("era pra dar ruim");
        } catch (NullPointerException iae) {
        }

        try {
            validador.validaDniCadastraDeputado("0734548-a1");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
        }

        try {
            validador.validaDniCadastraDeputado("073451a7-1");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
        }
    }

    @Test
    void testeValidoDataCadastroDeputado() {
        try {
            validador.validaDataCadastroDeputado("12132019");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
        }

        try {
            validador.validaDataCadastroDeputado("31022019");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
        }

        try {
            validador.validaDataCadastroDeputado("12123019");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
        }
        try {
            validador.validaDataCadastroDeputado("12123019");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
        }

        try {
            validador.validaDataCadastroDeputado("29022019");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
        }

        try {
            validador.validaDataCadastroDeputado("123019");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
        }

        try {
            validador.validaDataCadastroDeputado("");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
        }

        try {
            validador.validaDataCadastroDeputado(" ");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
        }

        try {
            validador.validaDataCadastroDeputado(null);
            fail("era pra dar ruim");
        } catch (NullPointerException iae) {
        }

        try {
            validador.validaDataCadastroDeputado("21052020");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
        }
    }

    @Test
    void testeEntradaValidaDeputado() {
        try {
            validador.validaDeputado(null);
            fail("era pra dar ruim");
        } catch (NullPointerException npe) {
        }

        try {
            validador.validaDeputado("");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException npe) {
        }

        try {
            validador.validaDeputado("  ");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException npe) {
        }
    }

    @Test
    void testeValidaCadastraPartido() {
        try {
            validador.validaCadastraPartido("");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
        }

        try {
            validador.validaCadastraPartido("  ");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
        }

        try {
            validador.validaCadastraPartido(null);
            fail("era pra dar ruim");
        } catch (NullPointerException iae) {
        }
    }

    @Test
    void testeValidaExibirPessoa() {
        try {
            validador.validaExibirPessoa("");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
        }

        try {
            validador.validaExibirPessoa(null);
            fail("era pra dar ruim");
        } catch (NullPointerException iae) {
        }

        try {
            validador.validaExibirPessoa("0734548-a1");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
        }

        try {
            validador.validaExibirPessoa("073451a7-1");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
        }
    }
}