package eCamara;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


/**
 * Classe responsavel por genrenciar os arquivos do Sistema, persistir os dados do sistema.
 * Faz uso da interface da biblioteca BufferedReader e implementa a interface Serializable que per mite a serializacao do objeto.
 */
public class GerenciadorArquivos implements Serializable {

    /**
     * Metodo auxiliar para salvar Objetos, recebe o objeto a ser salvo e o nome do arquivo.
     * Primeiramente ele inicia uma varivel null do tipo ObjectOutputStream que serve pra "converter" o objeto em uma "saida" de bytes,
     * ou seja, serve pra fazer a serializacao, que eh justamente a conversao do objeto para uma sequencia de bytes, apos isso, sera
     * instanciado o ObjectOutputStream e sera criado e aberto o arquivo para salvar os dados, com o nome passado como parametro, depois sera chamada o metodo
     * writeObject para escrever objeto no arquivo e por fim fechara o arquivo.
     *
     * @param objeto Object que se quer salvar.
     * @param nomeArquivo String com o nome do arquivo que ira ser salvo os bytes.
     * @throws FileNotFoundException
     * @throws IOException
     */
    private static void salvarObj(Object objeto, String nomeArquivo) throws FileNotFoundException, IOException {
        ObjectOutputStream arqObjectos = null;
        try{
            arqObjectos = new ObjectOutputStream(new FileOutputStream("arquivos" + File.separator + nomeArquivo));
            arqObjectos.writeObject(objeto);
        }finally{
            if(arqObjectos != null)
                arqObjectos.close();
        }
    }

    /**
     * Metodo auxiliar para ler Objetos, recebe o nome do arquivo.
     * Primeiramente ele inicia uma varivel null do tipo ObjectOutputStream que serve pra "converter" o arquivo que contem a sequencia de bytes em uma "entrada",
     * ou seja, serve pra fazer a desserializacao, que eh justamente a conversao do sequencia de bytes para uma especie de "entrada", apos isso, sera
     * instanciado o ObjectOutputStream e sera aberto um arquivo com nome passado como parametro, depois sera chamada o metodo
     * readObject para ler o arquivo de bytes e converter em objeto e isso sera o retorno, por fim fechara o arquivo.
     *
     * @param nomeArquivo String com o nome do arquivo a ser lido.
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ClassNotFoundException
     */
    private static Object carregarObj(String nomeArquivo) throws FileNotFoundException, IOException, ClassNotFoundException{
        ObjectInputStream arqObjectos = null;
        try{
            arqObjectos = new ObjectInputStream(new FileInputStream("arquivos" + File.separator + nomeArquivo));
            return arqObjectos.readObject();
        }finally{
            if(arqObjectos != null)
                arqObjectos.close();
        }
    }

    /**
     * Metodo que salva o sistem em um arquivo de bytes (Serializacao), sera usado o metodo auxiliar salvarObj.
     * Caso uma execao IOException seja lancada por esse metodo, sera capturada a excecao e mostrara a mensagem "Deu erro ai".
     * Recebe o objeto a ser salvo.
     */
    public static void salvarSistema(HashMap pessoas, HashMap leis, Set partidos, Map comissoes) {
        try{
            GerenciadorArquivos.salvarObj(pessoas, "ArquivoSistemaPessoa.bin");
            GerenciadorArquivos.salvarObj(leis, "ArquivoSistemaLeis.bin");
            GerenciadorArquivos.salvarObj(partidos, "ArquivoSistemaPartidos.bin");
            GerenciadorArquivos.salvarObj(comissoes, "ArquivoSistemaComicoes.bin");
        }catch(IOException e){
            System.out.println("Deu erro ai");
            e.printStackTrace();

        }
    }


    /**
     * Metodo que carregara o sistema salvo. Recebe o o objeto a ser carregado com os dados (especie de entradas).
     * Primeiramente sera tentado instaciar o objeto passado como parametro para o objeto salvo no arquivo de bytes, fara uso
     * do metodo carregarObj, caso esse metodo lance um FileNotFoundException sera iniciado o objeto "limpo", do tipo SystemController, pois nada foi salvo,
     * caso a excecao lancada seja ClassNotFoundException ou IOException sera printada a mensagem de erro da excecao.
     *
     * @param sistema Object a ser carregado com os dados.
     */
    public static void carregarSistema(SystemController sistema) {
        try{
            sistema.getControllerPessoas().setMap((HashMap) GerenciadorArquivos.carregarObj("ArquivoSistemaPessoa.bin"));
            sistema.getControllerLeis().setMap((HashMap) GerenciadorArquivos.carregarObj("ArquivoSistemaLeis.bin"));
            sistema.setPartidos((Set) GerenciadorArquivos.carregarObj("ArquivoSistemaPartidos.bin"));
            sistema.setComissoes((Map) GerenciadorArquivos.carregarObj("ArquivoSistemaComicoes.bin"));
        }catch(FileNotFoundException e){
            sistema = new SystemController();
        }catch(ClassNotFoundException | IOException e){
            System.out.println(e.getMessage());

        }
    }

    /**
     * Metodo que limpa o sistema, recebe o objeto a ser limpo. Primeiramente sera tentado instancia o objeto passado como parametro
     * para o tipo SystemController, caso uma excecao seja capturada, sera lancada excecao.
     * o retorno sera o SystemController novo, limpo, sem dados se nenhum erro ocorrer.
     *
     * @param sistema Object a ser limpo.
     * @return SystemControll limpo.
     */
    public static void limparSistema(SystemController sistema){
        sistema.getControllerPessoas().getMapPessoas().clear();
        sistema.getControllerLeis().getLeis().clear();
        sistema.getPartidos().clear();
        sistema.getComissoes().clear();
        GerenciadorArquivos.salvarSistema(sistema.getControllerPessoas().getMapPessoas(), sistema.getControllerLeis().getLeis(), sistema.getPartidos(), sistema.getComissoes());
    }
}
