package eCamara;

import eCamara.individuo.Pessoa;
import eCamara.legislativo.Comissao;
import eCamara.legislativo.ProjetoDeLei;

import java.io.Serializable;
import java.util.*;

/***
 * Objeto que faz a Votacao, nao tem atributos.
 */

public class Votacao implements Serializable {

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

        if (votosAFavor >= comissao.tamanhoComissao() / 2 + 1) {
            lei.setTramitacao(true);

            lei.setSituacao(true, proximoLocal);
            lei.setVotante(proximoLocal);
            return true;
        }

        lei.setTramitacao(false);
        lei.setSituacao(false, proximoLocal);
        lei.setVotante(proximoLocal);
        return false;
    }

    /**
     * Metodo responsavel por fazer uma votacao de uma lei, passada como parametro, no plenario a partir do status governista
     * da lei e dos politicos presentes. ao fazer a contagem dos votos, se o tipo da lei for "PLP" ou "PL"e os votosAFavor forem maiores
     * que o tamanho do mapa de deputados /2 + 1 o metodo retorna true, caso o tipo da lei for "PEC" e os votosAFavor forem maiores ou iguais
     * a (3/5 * o mapa de deputados)+ 1 o metodo retorna true. Se nenhum dos casos forem satisfeitos o metodo retorna false.
     *
     * @param lei lei que esta sendo votada.
     * @param statusGovernista status da lei a ser votada.
     * @param politicosPresentes dni dos politicos presetnes
     * @param mapaTotalDeputados mapa com todos os deputados registrados no sistema.
     * @param partidos partidos cadastrados no sistema.
     *
     * @return true se a lei tiver sido aprovada e false se a lei tiver sido rejeitada.
     */
    public boolean votarPlenario(ProjetoDeLei lei, String statusGovernista, String politicosPresentes, HashMap<String, Pessoa> mapaTotalDeputados, Set<String> partidos) {
        HashMap<String, Pessoa> deputadosPresentes = identificarDeputadosPresentes(politicosPresentes, mapaTotalDeputados);

        int votosAFavor = contaVotosAFavor(lei, mapaTotalDeputados, statusGovernista, partidos);

        lei.addVotacaoRealizada();

        if ("PLP".equals(lei.getTipoLei().toUpperCase())) {
            if (votosAFavor >= mapaTotalDeputados.size() / 2 + 1) {
                lei.addTurno();
                lei.setTramitacao(true);
                lei.setSituacao(true, "senado");

                return true;
            }

        } else if ("PEC".equals(lei.getTipoLei().toUpperCase())) {
            if (votosAFavor >= mapaTotalDeputados.size() * 3 / 5 + 1) {
                lei.addTurno();
                lei.setTramitacao(true);
                lei.setSituacao(true, "senado");
                return true;
            }

        } else if ("PL".equals(lei.getTipoLei().toUpperCase())) {
            votosAFavor = contaVotosAFavor(lei, deputadosPresentes, statusGovernista, partidos);

            if (votosAFavor >= deputadosPresentes.size() / 2 + 1) {
                lei.addTurno();
                lei.setTramitacao(true);
                lei.setSituacao(true, "senado");
                return true;
            }
        }
        lei.addTurno();
        lei.setTramitacao(false);
        lei.setSituacao(false, "encerrado");
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
            if (politicoDaComissao.decideVoto(statusGovernista, partidos, lei.getInteresses())){
                votosAFavor++;
            }
        }
        return votosAFavor;
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

    /**
     * Metodo responsavel por identificar os deputados presentes a partir dos dnis dos politicos presentes passados como
     * parametro e um mapa de pessoas, onde sera pego os deputados que tem os dnis iguais aos passados como parametro.
     *
     * @param politicosPresentes dni dos politicos presentes
     * @param mapaPessoas mapa de pessoas.
     * @return o hashMap de deputadosPresentes.
     */
    private HashMap<String, Pessoa> identificarDeputadosPresentes(String politicosPresentes, HashMap<String, Pessoa> mapaPessoas) {
        HashMap<String, Pessoa> deputadosPresentes = new HashMap<>();
        for (String dni : politicosPresentes.trim().split(",")) {
            deputadosPresentes.put(dni, mapaPessoas.get(dni));
        }
        return deputadosPresentes;
    }

}






