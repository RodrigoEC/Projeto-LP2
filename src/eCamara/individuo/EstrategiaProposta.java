package eCamara.individuo;

import eCamara.legislativo.ProjetoDeLei;

import java.util.Map;
import java.util.Set;

public interface EstrategiaProposta {

    String pegarPropostaRelacionada(Map<String, ProjetoDeLei> leis, Set<String> interesses);
}
