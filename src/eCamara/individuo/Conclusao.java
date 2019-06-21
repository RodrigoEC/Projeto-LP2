package eCamara.individuo;

import eCamara.legislativo.ProjetoDeLei;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Conclusao implements EstrategiaProposta {

    @Override
    public String pegarPropostaRelacionada(Map<String, ProjetoDeLei> leis, Set<String> interesses) {
        HashMap<String, ProjetoDeLei> propostasRelacionadas = new HashMap<>();

        for (String proposta: leis.keySet()){
            if (leis.get(proposta).emTramite() && this.interesseComum(leis.get(proposta), interesses)){
                propostasRelacionadas.put(proposta, leis.get(proposta));
            }
        }

        //Organizando as propostas pelo estado de votação
        ArrayList<String> segundoTurno = new ArrayList<>();
        ArrayList<String> primeiroTurno = new ArrayList<>();
        ArrayList<String> outrasComissoes = new ArrayList<>();
        ArrayList<String> ccjc = new ArrayList<>();

        for (String proposta: propostasRelacionadas.keySet()){
            if (pegaEstado(propostasRelacionadas.get(proposta).getSituacao()).equals("(plenario 2o turno)")){
                segundoTurno.add(proposta);
            }
            if (pegaEstado(propostasRelacionadas.get(proposta).getSituacao()).equals("(plenario 1o turno)")){
                segundoTurno.add(proposta);
            }
            if (pegaEstado(propostasRelacionadas.get(proposta).getSituacao()).equals("(ccjc)")){
                segundoTurno.add(proposta);
            } else{
                outrasComissoes.add(proposta);
            }
        }

        if (segundoTurno.size() > 0){
            if (segundoTurno.size() == 1){
                return segundoTurno.get(0);
            }

            //quando tem mais de uma proposta no segundo turno
        }

        if (primeiroTurno.size() > 0){
            if (primeiroTurno.size() == 1){
                return primeiroTurno.get(0);
            }

            //quando tem mais de uma proposta no primeiro turno
        }

        if (outrasComissoes.size() > 0){
            if (outrasComissoes.size() == 1){
                return outrasComissoes.get(0);
            }

            //quando tem mais de uma proposta em outras comissões
        }

        if (ccjc.size() > 0){
            if (ccjc.size() == 1){
                return ccjc.get(0);
            }

            //quando tem mais de uma proposta na ccjc
        }

        return "";
    }

    private String pegaEstado(String situacaoProposta) {
        String[] array = situacaoProposta.split("[(]");
        return "(" + array[1].toLowerCase();
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
