package eCamara.individuo;

import eCamara.legislativo.ProjetoDeLei;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public abstract class EstrategiaPropostaAbstract implements  EstrategiaProposta{

    public abstract String pegarPropostaRelacionada(Map<String, ProjetoDeLei> leis, Set<String> interesses);

    protected boolean interesseComum(ProjetoDeLei lei, Set<String> interesses){
        for (String interesse: lei.getInteresses().trim().split(",")){
            if (interesses.contains(interesse)){
                return true;
            }
        }
        return false;
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
