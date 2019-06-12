package eCamara.legislativo;

import eCamara.individuo.Pessoa;

import java.util.Map;
import java.util.Objects;

public class Comissao {

    private String tema;
    private Map<String, Pessoa> mapDeputados;

    public  Comissao(String tema, Map<String, Pessoa> mapDeputados){
        this.mapDeputados = mapDeputados;
        this.tema =  tema;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comissao comissao = (Comissao) o;
        return Objects.equals(tema, comissao.tema);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tema);
    }
}
