package eCamara.propostaMaisRelacionada;

import eCamara.legislativo.ProjetoDeLei;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Classe abstrata para as Estrategias de pegar proposta (Constitucional, Conclusao, Aprovacao) para reuso de codigo.
 */
public abstract class EstrategiaPropostaAbstract implements EstrategiaProposta, Serializable {

    /**
     * Metodo que retorna a proposta de lei que tem mais a ver com os inter0000000000000000esses de determinada pessoa. Ela recebe
     * como parâmetro um Map com todas as leis cadastradas e uma String com os interesses da pessoa.
     *
     * @param leis as leis cadastradas.
     * @param interesses os interesses da pessoa.
     *
     * @return a proposta de lei mais relacionada com a pessoa.
     */
    public abstract String pegarPropostaRelacionada(Map<String, ProjetoDeLei> leis, Set<String> interesses);

    /**
     * Metodo que retorna um HashMap com as leis que possuem interesses mais em comum com a Pessoa. Recebe como
     * parâmetros um Map com todas as leis cadastradas e um Set com todos os interesses de determinada pessoa.
     *
     * @param leis as leis cadastradas.
     * @param interesses os interesses de uma pessoa.
     *
     * @return HashMap com as leis mais proximas dos interesses da pessoa.
     */
    protected HashMap<String, ProjetoDeLei> interesseComum(Map<String, ProjetoDeLei> leis, Set<String> interesses){
        HashMap<String, ProjetoDeLei> propostasRelacionadas = new HashMap<>();
        int quantidade = 0;

        for (String proposta: leis.keySet()){
            if (quantidadeInteressesComuns(leis.get(proposta), interesses) > 0){
                if (quantidadeInteressesComuns(leis.get(proposta), interesses) > quantidade){
                    quantidade = quantidadeInteressesComuns(leis.get(proposta), interesses);
                    propostasRelacionadas.clear();
                    propostasRelacionadas.put(proposta, leis.get(proposta));

                } else if (quantidadeInteressesComuns(leis.get(proposta), interesses) == quantidade){
                    propostasRelacionadas.put(proposta, leis.get(proposta));
                }
            }

        }

        return propostasRelacionadas;
    }

    /**
     * Metodo que retorna a quantidade de interesses em comum que uma pessoa tem com determinada lei.
     *
     * @param lei uma lei.
     * @param interesses os interesses de uma pessoa.
     *
     * @return a quantidade de interesses em comum entre lei e pessoa.
     */
    private int quantidadeInteressesComuns(ProjetoDeLei lei, Set<String> interesses){
        int quantidade = 0;

        if (lei.getInteresses().contains(",")){
            for (String interesse: lei.getInteresses().trim().split(",")){
                if (interesses.contains(interesse)){
                    quantidade += 1;
                }
            }
        } else{
            if (interesses.contains(lei.getInteresses())){
                quantidade += 1;
            }
        }

        return quantidade;
    }

    /**
     * Metodo que define a proposta mais antiga cadastrada a partir de um array de propostas recebido como parâmetro.
     *
     * @param propostas um ArrayList com o codigo de algumas propostas de lei.
     *
     * @return o indice da proposta mais antiga.
     */
    protected int propostaMaisAntiga(ArrayList<String> propostas, Map<String, ProjetoDeLei> leis) {
        int indiceMaisAntigo = 0;
        int anoMaisAntigo = 0;
        int precedencia = 0;
        String tipoMaisAntigo = "";
        int numeroLei = 0;

        for (int i = 0; i < propostas.size(); i++) {
            String[] ano = propostas.get(i).trim().split("/");

            String[] criacaoMaisAntiga = ano[0].split(" ");

            if (anoMaisAntigo == 0) {
                anoMaisAntigo = Integer.parseInt(ano[1]);
                precedencia = Integer.parseInt(criacaoMaisAntiga[1]);
                tipoMaisAntigo = leis.get(propostas.get(i)).getTipoLei();
                indiceMaisAntigo = i;
                numeroLei = leis.get(propostas.get(i)).getNumeroLei();

            } else if (Integer.parseInt(ano[1]) < anoMaisAntigo) {
                anoMaisAntigo = Integer.parseInt(ano[1]);
                precedencia = Integer.parseInt(criacaoMaisAntiga[1]);
                tipoMaisAntigo = leis.get(propostas.get(i)).getTipoLei();
                indiceMaisAntigo = i;
                numeroLei = leis.get(propostas.get(i)).getNumeroLei();

            } else if (Integer.parseInt(ano[1]) == anoMaisAntigo) {
                if (propostas.get(i).trim().split(" ")[0].equals(tipoMaisAntigo)){
                    if (Integer.parseInt(criacaoMaisAntiga[1]) < precedencia) {
                        precedencia = Integer.parseInt(criacaoMaisAntiga[1]);
                        indiceMaisAntigo = i;
                        numeroLei = leis.get(propostas.get(i)).getNumeroLei();
                    }
                } else{
                    if (leis.get(propostas.get(i)).getNumeroLei() < numeroLei){
                        precedencia = Integer.parseInt(criacaoMaisAntiga[1]);
                        tipoMaisAntigo = leis.get(propostas.get(i)).getTipoLei();
                        indiceMaisAntigo = i;
                        numeroLei = leis.get(propostas.get(i)).getNumeroLei();
                    }
                }

            }

        }

        return indiceMaisAntigo;
    }
}
