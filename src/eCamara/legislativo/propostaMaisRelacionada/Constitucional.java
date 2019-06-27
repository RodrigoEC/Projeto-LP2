package eCamara.legislativo.propostaMaisRelacionada;

import eCamara.legislativo.ProjetoDeLei;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Classe que define a estrategia CONSTITUCIONAL para pegar a proposta mais relacionada com determinada pessoa.
 */
public class Constitucional extends EstrategiaPropostaAbstract {

    /**
     * Metodo que retorna o codigo da proposta mais relacionada com uma pessoa. Recebe como parametros um HashMap com
     * todas as leis e um set com os interesses de uma pessoa. Nesta estrategia, o criterio utilizado e a proximidade
     * que determinada lei esta de alterar a constituicao, na ordem crescente: PL - PLP - PEC.
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

        if(propostasRelacionadas.size() == 1){
            for (String proposta: propostasRelacionadas.keySet()){
                return proposta;
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

            return propostasPec.get(super.propostaMaisAntiga(propostasPec, leis));

        } else if (propostasPlp.size() > 0){
            if (propostasPlp.size() == 1){
                return propostasPlp.get(0);
            }

            return propostasPlp.get(super.propostaMaisAntiga(propostasPlp, leis));

        } else if (propostasPl.size() > 0){
            if (propostasPl.size() == 1){
                return propostasPl.get(0);
            }

            return propostasPl.get(super.propostaMaisAntiga(propostasPl, leis));
        }

        return "";
    }

}
