package eCamara.individuo;

import eCamara.legislativo.ProjetoDeLei;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Constitucional extends EstrategiaPropostaAbstract {

    @Override
    public String pegarPropostaRelacionada(Map<String, ProjetoDeLei> leis, Set<String> interesses) {
        HashMap<String, ProjetoDeLei> propostasRelacionadas = new HashMap<>();

        for (String proposta: leis.keySet()){
            if(super.interesseComum(leis.get(proposta), interesses) && leis.get(proposta).emTramite()){
                propostasRelacionadas.put(proposta, leis.get(proposta));
            }
        }

        //Organizando os tipos de propostas
        ArrayList<String> propostasPec = new ArrayList<>();
        ArrayList<String> propostasPlp = new ArrayList<>();
        ArrayList<String> propostasPl = new ArrayList<>();

        for (String proposta: propostasRelacionadas.keySet()){
            if (propostasRelacionadas.get(proposta).getTipoLei().toLowerCase().equals("pec")){
                propostasPec.add(proposta);
            }
            if (propostasRelacionadas.get(proposta).getTipoLei().toLowerCase().equals("plp")){
                propostasPlp.add(proposta);
            }
            if (propostasRelacionadas.get(proposta).getTipoLei().toLowerCase().equals("pl")){
                propostasPl.add(proposta);
            }
        }

        //Verificando a existência das propostas de acordo com seu tipo
        if (propostasPec.size() > 0){
            if (propostasPec.size() == 1){
                return propostasPec.get(0);
            }

            return propostasPec.get(super.propostaMaisAntiga(propostasPec));

        } else if (propostasPlp.size() > 0){
            if (propostasPlp.size() == 1){
                return propostasPlp.get(0);
            }

            return propostasPlp.get(super.propostaMaisAntiga(propostasPlp));

        } else if (propostasPl.size() > 0){
            if (propostasPl.size() == 1){
                return propostasPl.get(0);
            }

            return propostasPl.get(super.propostaMaisAntiga(propostasPl));
        }

        return "";
    }
}
