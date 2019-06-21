package eCamara.individuo;

import eCamara.legislativo.ProjetoDeLei;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Aprovacao extends EstrategiaPropostaAbstract {

    @Override
    public String pegarPropostaRelacionada(Map<String, ProjetoDeLei> leis, Set<String> interesses) {
        HashMap<String, ProjetoDeLei> propostasRelacionadas = new HashMap<>();

        for (String proposta: leis.keySet()){
            if (leis.get(proposta).emTramite()){
               propostasRelacionadas = super.interesseComum(leis, interesses);
            }
        }

        if(propostasRelacionadas.size() == 1){
            for (String proposta: propostasRelacionadas.keySet()){
                return proposta;
            }
        }

        int qntAprovacoes = 0;
        ArrayList<String> maisAprovacoes = new ArrayList<>();

        for (String proposta: propostasRelacionadas.keySet()){
            if (qntAprovacoes == 0){
                qntAprovacoes = leis.get(proposta).getQntAprovacoes();
                maisAprovacoes.add(proposta);

            } else if (leis.get(proposta).getQntAprovacoes() > qntAprovacoes){
                qntAprovacoes = leis.get(proposta).getQntAprovacoes();
                maisAprovacoes.clear();
                maisAprovacoes.add(proposta);

            } else if (leis.get(proposta).getQntAprovacoes() == qntAprovacoes){
                qntAprovacoes = leis.get(proposta).getQntAprovacoes();
                maisAprovacoes.add(proposta);
            }
        }

        if (maisAprovacoes.size() == 1){
            return maisAprovacoes.get(0);
        } else {
            return maisAprovacoes.get(super.propostaMaisAntiga(maisAprovacoes));
        }
    }
}
