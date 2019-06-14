package eCamara;

import eCamara.individuo.Pessoa;
import eCamara.legislativo.Comissao;
import eCamara.legislativo.ProjetoDeLei;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Votacao {



    public boolean votarComissao(ProjetoDeLei lei, String statusGovernista, String proximoLocal, Comissao comissao, Set<String> partidos) {
        int votosAFavor = contaVotosAFavor(lei, comissao.getMapDeputados() ,statusGovernista, partidos);

        lei.addVotacaoRealizada();
        lei.setVotante(proximoLocal);

        if(votosAFavor >= comissao.tamanhoComissao()/2 + 1) {
            lei.setTramitacao(true);
            lei.setSituacao(true, proximoLocal);
            return true;
        }

        lei.setTramitacao(false);
        lei.setSituacao(false, proximoLocal);
        return false;
    }

    private int contaVotosAFavor(ProjetoDeLei lei, HashMap<String, Pessoa> politicos, String statusGovernista, Set<String> partidos ) {
        int votosAFavor = 0;

        for (Pessoa politicoDaComissao : politicos.values()) {
            if (ehDaBase(politicoDaComissao, partidos) && "governista".equals(statusGovernista.toLowerCase())) {
                votosAFavor++;

            } else if (!ehDaBase(politicoDaComissao, partidos) && "oposicao".equals(statusGovernista.toLowerCase())) {
                votosAFavor++;

            } else if ("livre".equals(statusGovernista.toLowerCase())){
                String[] arrayInteressesLei = lei.getInteresses().split(",");
                List<String> listaInteressesLei = Arrays.asList(arrayInteressesLei);

                for(String interessePolitico : politicoDaComissao.getInteresses().split(",")) {
                    if(listaInteressesLei.contains(interessePolitico)) {
                        votosAFavor++;
                    }
                }
            }
        }
        return votosAFavor;
    }

    private boolean ehDaBase(Pessoa pessoa, Set<String> partidos) {
        if (partidos.contains(pessoa.getPartido())) {
            return true;
        }
        return false;
    }
}
