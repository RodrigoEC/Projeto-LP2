package eCamara.legislativo.propostaMaisRelacionada;

import eCamara.legislativo.ProjetoDeLei;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Classe que define a estrategia APROVACAO para pegar a proposta mais relacionada com determinada pessoa.
 */
public class Aprovacao extends EstrategiaPropostaAbstract {

    /**
     * Metodo que retorna o codigo da proposta mais relacionada com uma pessoa. Recebe como parametros um HashMap com
     * todas as leis e um set com os interesses de uma pessoa. Nesta estrategia, o criterio utilizado e a quantidade
     * de votacoes aprovadas que uma lei teve.
     *
     * @param leis as leis cadastradas.
     * @param interesses os interesses da pessoa.
     *
     * @return o codigo da proposta de lei mais relacionada com a pessoa.
     */
    @Override
    public String pegarPropostaRelacionada(HashMap<String, ProjetoDeLei> leis, Set<String> interesses) {
        HashMap<String, ProjetoDeLei> propostasRelacionadas;

        propostasRelacionadas = super.filtro(leis, interesses);

        if(propostasRelacionadas.size() == 0){
            return "";
        }

        if(propostasRelacionadas.size() == 1){
            for (String proposta: propostasRelacionadas.keySet()){
                return proposta;
            }
        }

        int qntAprovacoes = 0;
        ArrayList<String> maisAprovacoes = new ArrayList<>();

        for (String proposta: propostasRelacionadas.keySet()){
           if (leis.get(proposta).getQntAprovacoes() > qntAprovacoes){
                qntAprovacoes = leis.get(proposta).getQntAprovacoes();
                maisAprovacoes.clear();
                maisAprovacoes.add(proposta);

            } else if (leis.get(proposta).getQntAprovacoes() == qntAprovacoes){
                maisAprovacoes.add(proposta);
            }
        }

        if (maisAprovacoes.size() == 1){
            return maisAprovacoes.get(0);
        } else {
            return maisAprovacoes.get(super.propostaMaisAntiga(maisAprovacoes, leis));
        }
    }
}
