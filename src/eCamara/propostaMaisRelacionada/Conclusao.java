package eCamara.propostaMaisRelacionada;

import eCamara.legislativo.ProjetoDeLei;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Classe que define a estrategia CONCLUSAO para pegar a proposta mais relacionada com determinada pessoa.
 */
public class Conclusao extends EstrategiaPropostaAbstract {

    /**
     * Metodo que retorna o codigo da proposta mais relacionada com uma pessoa. Recebe como parametros um map com
     * todas as leis e um set com os interesses de uma pessoa. Nesta estrategia, o criterio utilizado e a proximidade
     * que determinada lei esta de sua conclusao.
     *
     * @param leis as leis cadastradas.
     * @param interesses os interesses da pessoa.
     *
     * @return o codigo da proposta de lei mais relacionada com a pessoa.
     */
    @Override
    public String pegarPropostaRelacionada(Map<String, ProjetoDeLei> leis, Set<String> interesses) {
        HashMap<String, ProjetoDeLei> propostasEmTramite = new HashMap<>();
        HashMap<String, ProjetoDeLei> propostasRelacionadas;

        for (String proposta: leis.keySet()){
            if (leis.get(proposta).emTramite()){
                propostasEmTramite.put(proposta, leis.get(proposta));
            }
        }

        propostasRelacionadas = super.interesseComum(propostasEmTramite, interesses);

        if(propostasRelacionadas.size() == 0){
            return "";
        }

        if(propostasRelacionadas.size() == 1){
            for (String proposta: propostasRelacionadas.keySet()){
                return proposta;
            }
        }

        //Organizando as propostas pelo estado de votação
        ArrayList<String> segundoTurno = new ArrayList<>();
        ArrayList<String> primeiroTurno = new ArrayList<>();
        ArrayList<String> outrasComissoes = new ArrayList<>();
        ArrayList<String> ccjc = new ArrayList<>();

        for (String proposta: propostasRelacionadas.keySet()){
            if (pegaEstado(propostasRelacionadas.get(proposta).getSituacao()).equals("(plenario 2o turno)") || pegaEstado(propostasRelacionadas.get(proposta).getSituacao()).equals("(plenario)")){
                segundoTurno.add(proposta);
            }
            if (pegaEstado(propostasRelacionadas.get(proposta).getSituacao()).equals("(plenario 1o turno)")){
                primeiroTurno.add(proposta);
            }
            if (pegaEstado(propostasRelacionadas.get(proposta).getSituacao()).equals("(ccjc)")){
                ccjc.add(proposta);
            } else{
                outrasComissoes.add(proposta);
            }
        }

        if (segundoTurno.size() > 0){
            if (segundoTurno.size() == 1){
                return segundoTurno.get(0);
            }

            return segundoTurno.get(super.propostaMaisAntiga(segundoTurno, leis));
        }

        if (primeiroTurno.size() > 0){
            if (primeiroTurno.size() == 1){
                return primeiroTurno.get(0);
            }

            return primeiroTurno.get(super.propostaMaisAntiga(primeiroTurno, leis));
        }

        if (outrasComissoes.size() > 0){
            if (outrasComissoes.size() == 1){
                return outrasComissoes.get(0);
            }
            //return "sei de nada";
            return outrasComissoes.get(this.maisComissoes(leis, outrasComissoes));
        }

        if (ccjc.size() > 0){
            if (ccjc.size() == 1){
                return ccjc.get(0);
            }

            return ccjc.get(super.propostaMaisAntiga(ccjc, leis));
        }

        return "";
    }

    /**
     * Metodo que retorna o estado atual de uma lei.
     *
     * @param situacaoProposta a situacao atual da proposta de lei.
     *
     * @return o estado da proposta de lei.
     */
    public String pegaEstado(String situacaoProposta) {
        if (situacaoProposta.contains("(")){
            String[] array = situacaoProposta.split("[(]");
            return "(" + array[1].toLowerCase();
        }

        return "";
    }

    /**
     * Metodo que retorna o indice da proposta de lei que passou por mais comissoes.
     *
     * @param leis as leis cadastradas.
     * @param outrasComissoes as comissoes que ja passaram pela ccjc mas nao chegaram ao plenario
     *
     * @return o indice da proposta de lei que passou por mais comissoes.
     */
    private int maisComissoes(Map<String, ProjetoDeLei> leis, ArrayList<String> outrasComissoes){
        int qntComissoes = 0;
        String maisComissoes = "";
        HashMap<String, Integer> mapa = new HashMap<>();

        for (String p: outrasComissoes){
            ArrayList<String> array = leis.get(p).getTramitacao();
            mapa.put(p, array.size());
        }

        for (String p: mapa.keySet()){
            if (qntComissoes == 0){
                qntComissoes = mapa.get(p);
                maisComissoes = p;

            } else if (mapa.get(p) > qntComissoes){
                qntComissoes = mapa.get(p);
                maisComissoes = p;

            } else if (mapa.get(p) == qntComissoes){
                ArrayList<String> iguais = new ArrayList<>();
                iguais.add(maisComissoes);
                iguais.add(p);

                return super.propostaMaisAntiga(iguais, leis);
            }
        }

        return outrasComissoes.indexOf(maisComissoes);
    }

}
