/**package eCamara;

import eCamara.individuo.Pessoa;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Votacao {



    public boolean votarComissao(String codigoDaLei, String statusGovernista, String proximoLocal) {
        int votosAFavor = 0;






    }

    private int contaVotosAFavor(HashMap<String, Pessoa> politicos, String statusGovernista) {


        for (Pessoa politicoDaComissao : politicos.values()) {
            if (ehDaBase(politicoDaComissao) && "governista".equals(statusGovernista)) {
                votosAFavor++;

            } else if (!ehDaBase(politicoDaComissao) && "oposicao".equals(statusGovernista)) {
                votosAFavor++;

            } else {
                String[] arrayInteressesLei = this.leis.get(codigoDaLei).getInteresses().split(",");
                List<String> listaInteressesLei = Arrays.asList(arrayInteressesLei);

                for(String interessePolitico : politicoDaComissao.getInteresses().split(",")) {
                    if(listaInteressesLei.contains(interessePolitico)) {
                        votosAFavor++;
                    }
                }
            }
        }
    }

    public boolean votarComiissao(String codigoDaLei, String statusGovernista, String comissao, String proximoLocal) {
        int votosAFavor = 0;


        for (Pessoa politicoDaComissao : this.comissoes.get(comissao).getMapDeputados().values()) {
            if (ehDaBase(politicoDaComissao) && "governista".equals(statusGovernista)) {
                votosAFavor++;

            } else if (!ehDaBase(politicoDaComissao) && "oposicao".equals(statusGovernista)) {
                votosAFavor++;

            } else {
                String[] arrayInteressesLei = this.leis.get(codigoDaLei).getInteresses().split(",");
                List<String> listaInteressesLei = Arrays.asList(arrayInteressesLei);

                for(String interessePolitico : politicoDaComissao.getInteresses().split(",")) {
                    if(listaInteressesLei.contains(interessePolitico)) {
                        votosAFavor++;
                    }
                }
            }
        }




        if (votosAFavor > this.comissoes.get(comissao).getMapDeputados().size()/2 + 1) {
            this.leis.get(codigoDaLei).setSituacao(String.format("EM VOTACAO(%s)", proximoLocal));

            return true;

        }

        return false;


    }







}
*/