package eCamara.individuo;

import eCamara.legislativo.ProjetoDeLei;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Constitucional implements EstrategiaProposta {

    @Override
    public String pegarPropostaRelacionada(Map<String, ProjetoDeLei> leis, Set<String> interesses) {
        HashMap<String, ProjetoDeLei> propostasRelacionadas = new HashMap<>();

        for (String proposta: leis.keySet()){
            if(interesseComum(leis.get(proposta), interesses) && leis.get(proposta).emTramite()){
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

            return propostasPec.get(propostaMaisAntiga(propostasPec));

        } else if (propostasPlp.size() > 0){
            if (propostasPlp.size() == 1){
                return propostasPlp.get(0);
            }

            return propostasPlp.get(propostaMaisAntiga(propostasPlp));

        } else if (propostasPl.size() > 0){
            if (propostasPl.size() == 1){
                return propostasPl.get(0);
            }

            return propostasPl.get(propostaMaisAntiga(propostasPl));
        }

        return "";
    }

    private int propostaMaisAntiga(ArrayList<String> propostasPec) {
        int indiceMaisAntigo = 0;
        int maisAntigo = 0;
        int precedencia = 0;
        for (int i = 0; i < propostasPec.size(); i++) {
            String[] ano = propostasPec.get(i).trim().split("/");

            String[] criacaoMaisAntiga = ano[0].split(" ");

            if (maisAntigo == 0) {
                maisAntigo = Integer.parseInt(ano[1]);
                precedencia = Integer.parseInt(criacaoMaisAntiga[1]);
                indiceMaisAntigo = i;
            }
            if (Integer.parseInt(ano[1]) < maisAntigo) {
                maisAntigo = Integer.parseInt(ano[1]);
                precedencia = Integer.parseInt(criacaoMaisAntiga[1]);
                indiceMaisAntigo = i;
            }

            if (Integer.parseInt(ano[1]) == maisAntigo) {
                if (Integer.parseInt(criacaoMaisAntiga[1]) < precedencia) {
                    precedencia = Integer.parseInt(criacaoMaisAntiga[1]);
                    indiceMaisAntigo = i;
                }
            }

        }

        return indiceMaisAntigo;
    }

    private boolean interesseComum(ProjetoDeLei lei, Set<String> interesses){
        for (String interesse: lei.getInteresses().trim().split(",")){
            if (interesses.contains(interesse)){
                return true;
            }
        }
        return false;
    }
}
