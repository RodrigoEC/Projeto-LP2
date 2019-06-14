package eCamara.individuo;

/**
 * Interface para generalizar as classes Deputado e Civil, que sao funcoes de uma Pessoa.
 */
public interface Funcao {

    /**
     * Metodo responsavel por retornar uma representacao textual do objeto. Todo objeto que implementa a interface
     * Funcao precisa ter o toString().
     *
     * @return uma representacao textual que representa o objeto.
     */
    String toString(String toString);

    int getQtdLeis();

    void addLei();




}
