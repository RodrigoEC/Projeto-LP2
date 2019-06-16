package eCamara;

import eCamara.individuo.Pessoa;
import eCamara.legislativo.Comissao;
import eCamara.legislativo.ProjetoDeLei;

import java.util.*;

/***
 * Objeto que faz a Votacao, nao tem atributos.
 */


public class Votacao {

    private int contadorDeputados;

    public Votacao(int contadorDeputados) {
        this.contadorDeputados = 0;
    }

    /**
     * Metodo que simula a votacao de uma lei pela Comissao. Recebe a lei a ser votada, o status governista, o proximo local, a Comissao
     * e Set de partidos. Soma mais 1 na quantidade de votacoes daquela lei e muda o votante da lei.
     * Faz uso do metodo contaVotosAFavor de Votacao. Se os votos a favor forem maior que a metade do tamanho da comissao
     * vai ser alterado a tramitacao da lei e a sua situacao e o retorno sera true. Se os votos nao forem suficientes para
     * a aprovacao da lei, vai ser alterado a tramitacao da lei e a sua situacao e o retorno sera false.
     *
     * @param lei              ProjetoDeLei a ser votada.
     * @param statusGovernista String com o status governista da lei.
     * @param proximoLocal     String com o proximo local.
     * @param comissao         Comissao de votacao.
     * @param partidos         Set de partidos (String).
     * @return boolean true se a lei for aprovada e false se nao for.
     */
    public boolean votarComissao(ProjetoDeLei lei, String statusGovernista, String proximoLocal, Comissao comissao, Set<String> partidos) {
        int votosAFavor = contaVotosAFavor(lei, comissao.getMapDeputados(), statusGovernista, partidos);

        lei.addVotacaoRealizada();
        lei.setVotante(proximoLocal);

        if (votosAFavor >= comissao.tamanhoComissao() / 2 + 1) {
            lei.setTramitacao(true);
            lei.setSituacao(true, proximoLocal);
            return true;
        }

        lei.setTramitacao(false);
        lei.setSituacao(false, proximoLocal);
        return false;
    }


    /**
     * Metodo que conta os votos a favor, recebe a lei, os Politicos que irao votar, o status governista e a base governista (Set).
     * So sera contado voto se o statusGovernista for governista e o politico for da base governista, ou se o statusGovernista for
     * oposicao e o politico for da oposicao ou se o status for livre e se pelo menos 1 interesse do politico estiver tambem nos
     * interesses da lei. Retorna a quantidade de votos a favor.
     *
     * @param lei              ProjetoDeLei a ser votada.
     * @param politicos        Map dos politicos que irao votar.
     * @param statusGovernista String com o status governista da lei.
     * @param partidos         Set de partidos(String);
     * @return quantidade de votos a favor;
     */

    private int contaVotosAFavor(ProjetoDeLei lei, HashMap<String, Pessoa> politicos, String statusGovernista, Set<String> partidos) {
        int votosAFavor = 0;

        for (Pessoa politicoDaComissao : politicos.values()) {
            if (ehDaBase(politicoDaComissao, partidos) && "governista".equals(statusGovernista.toLowerCase())) {
                votosAFavor++;

            } else if (!ehDaBase(politicoDaComissao, partidos) && "oposicao".equals(statusGovernista.toLowerCase())) {
                votosAFavor++;

            } else if ("livre".equals(statusGovernista.toLowerCase())) {
                String[] arrayInteressesLei = lei.getInteresses().split(",");
                List<String> listaInteressesLei = Arrays.asList(arrayInteressesLei);

                for (String interessePolitico : politicoDaComissao.getInteresses().split(",")) {
                    if (listaInteressesLei.contains(interessePolitico)) {
                        votosAFavor++;
                    }
                }
            }
        }
        return votosAFavor;
    }

    private HashMap<String, Pessoa> filtraDeputados(HashMap<String, Pessoa> mapPessoas) {
        HashMap<String, Pessoa> mapDeputados = new HashMap<>();
        for (Pessoa pessoa : mapPessoas.values()) {
            String dni = pessoa.getDni();
            if (pessoa.ehDeputado()) {
                mapDeputados.put(dni, pessoa);
            }
        }
        return mapDeputados;
    }

    //private HashMap<String, Pessoa> filtraDeputadosPresentes(HashMap<String, Pessoa> mapDeputados, String[] politicosPresentesArray) {
       // HashMap<String, Pessoa> mapDeputadosPresentes = new HashMap<>();
       // for (Pessoa pessoa : mapDeputados.values()) {
           // String dni = pessoa.getDni();
           // if (politicosPresentesArray.(pessoa.getDni())) {
               // mapDeputadosPresentes.put(dni, pessoa);

           // }
        //}
       // return mapDeputadosPresentes;
    //}

    public boolean votarPlenario(ProjetoDeLei lei, HashMap<String, Pessoa> mapPessoas, String statusGovernista, Set partidos, HashMap<String, Pessoa> politicosPresentesMap) {

        int votosAFavor = contaVotosAFavor(lei, mapPessoas, statusGovernista, partidos);

        lei.addVotacaoRealizada();

        if (lei.getTipoLei().toLowerCase().equals("plp")) {
            if (votosAFavor >= filtraDeputados(mapPessoas).size() / 2 + 1) {
                lei.setTramitacao(true);
                return true;
            }
            lei.setTramitacao(false);
            return false;

        } else if (lei.getTipoLei().toLowerCase().equals("pec")) {
            if (votosAFavor >= filtraDeputados(mapPessoas).size() * 3 / 5 + 1) {
                lei.setTramitacao(true);
                return true;
            }
            lei.setTramitacao(false);
            return false;

        } else if (lei.getTipoLei().toUpperCase().equals("pl")) {
            if (votosAFavor >= politicosPresentesMap.size() / 2 + 1) ;
            {
                lei.setTramitacao(true);
                return true;
            }
        }
        lei.setTramitacao(false);
        return false;
    }

    /**
     * Metodo que verifica se a Pessoa eh da base governista. Recebe a Pessoa e o Set de partidos (Strings).
     *
     * @param pessoa   Pessoa a ser verificada.
     * @param partidos Set de partidos.
     * @return boolean true se a Pessoa for da base e false se nao for.
     */

    private boolean ehDaBase(Pessoa pessoa, Set<String> partidos) {
        if (partidos.contains(pessoa.getPartido())) {
            return true;
        }
        return false;
    }



}






