package eCamara.individuo;

import eCamara.legislativo.ProjetoDeLei;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Classe abstrata para as Estrategias de pegar proposta (Constitucional, Conclusao, Aprovacao) para reuso de codigo.
 */
public abstract class EstrategiaPropostaAbstract implements  EstrategiaProposta{

    /**
     * Metodo que retorna a proposta de lei que tem mais a ver com os interesses de determinada pessoa. Ela recebe
     * como parâmetro um Map com todas as leis cadastradas e uma String com os interesses da pessoa.
     *
     * @param leis as leis cadastradas.
     * @param interesses os interesses da pessoa.
     *
     * @return a proposta de lei mais relacionada com a pessoa.
     */
    public abstract String pegarPropostaRelacionada(Map<String, ProjetoDeLei> leis, Set<String> interesses);

    /**
     * Metodo que retorna a quantidade de interesses que uma pessoa tem em comum com uma lei.
     *
     * @param lei
     * @param interesses
     *
     * @return
     */
    protected HashMap<String, ProjetoDeLei> interesseComum(Map<String, ProjetoDeLei> leis, Set<String> interesses){
        HashMap<String, ProjetoDeLei> propostasRelacionadas = new HashMap<>();
        int quantidade = 0;

        for (String proposta: leis.keySet()){
            if (quantidadeInteressesComuns(leis.get(proposta), interesses) > quantidade){
                quantidade = quantidadeInteressesComuns(leis.get(proposta), interesses);
                propostasRelacionadas.clear();
                propostasRelacionadas.put(proposta, leis.get(proposta));

            } else if (quantidadeInteressesComuns(leis.get(proposta), interesses) == quantidade){
                propostasRelacionadas.put(proposta, leis.get(proposta));
            }
        }

        return propostasRelacionadas;
    }

    private int quantidadeInteressesComuns(ProjetoDeLei lei, Set<String> interesses){
        int quantidade = 0;
        for (String interesse: lei.getInteresses().trim().split(",")){
            if (interesses.contains(interesse)){
                quantidade += 1;
            }
        }

        return quantidade;
    }

    protected int propostaMaisAntiga(ArrayList<String> propostas) {
        int indiceMaisAntigo = 0;
        int maisAntigo = 0;
        int precedencia = 0;
        for (int i = 0; i < propostas.size(); i++) {
            String[] ano = propostas.get(i).trim().split("/");

            String[] criacaoMaisAntiga = ano[0].split(" ");

            if (maisAntigo == 0) {
                maisAntigo = Integer.parseInt(ano[1]);
                precedencia = Integer.parseInt(criacaoMaisAntiga[1]);
                indiceMaisAntigo = i;

            } else if (Integer.parseInt(ano[1]) < maisAntigo) {
                maisAntigo = Integer.parseInt(ano[1]);
                precedencia = Integer.parseInt(criacaoMaisAntiga[1]);
                indiceMaisAntigo = i;

            } else if (Integer.parseInt(ano[1]) == maisAntigo) {
                if (Integer.parseInt(criacaoMaisAntiga[1]) < precedencia) {
                    precedencia = Integer.parseInt(criacaoMaisAntiga[1]);
                    indiceMaisAntigo = i;
                }
            }

        }

        return indiceMaisAntigo;
    }
}
