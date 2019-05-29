package ECamara;

import java.util.Objects;

public class Pessoa {
    private String dni;
    private String nome;
    private String estado;
    private String partido;
    private String interesses;
    private Funcao funcao;
    private Validacao validaEntrada;

    public Pessoa(String nome, String dni, String estado, String interesses){
        this.validaEntrada = new Validacao();
        this.validaEntrada.validarCadastroPessoa(dni, nome, estado);
        this.dni = dni;
        this.nome =  nome;
        this.estado = estado;
        this.interesses = interesses;
    }

    public Pessoa(String nome, String dni, String estado, String interesses, String partido){
        this(nome, dni, estado, interesses);
        this.partido = partido;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(dni, pessoa.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni);
    }
}
