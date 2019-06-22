package eCamara;

import java.io.*;

public class GerenciadorArquivos implements Serializable {

    private static void salvarObj(Object objeto, String nomeArquivo) throws FileNotFoundException, IOException {
        ObjectOutputStream arqObjectos = null;
        try{
            arqObjectos = new ObjectOutputStream(new FileOutputStream(nomeArquivo));
            arqObjectos.writeObject(objeto);
        }finally{
            if(arqObjectos != null)
                arqObjectos.close();
        }
    }

    private static Object carregarObj(String nomeArquivo) throws FileNotFoundException, IOException, ClassNotFoundException{
        ObjectInputStream arqObjectos = null;
        try{
            arqObjectos = new ObjectInputStream(new FileInputStream(nomeArquivo));
            return arqObjectos.readObject();
        }finally{
            if(arqObjectos != null)
                arqObjectos.close();
        }
    }

    public static void salvarSistema(Object sistema) {
        try{
            GerenciadorArquivos.salvarObj(sistema, "ArquivosSistema.bin");
        }catch(IOException e){
            System.out.println("Deu erro ai");
            e.printStackTrace();

        }
    }

    public static void carregarSistema(Object sistema) {
        try{
            sistema = (SystemControl) GerenciadorArquivos.carregarObj("ArquivosSistema.bin");
        }catch(FileNotFoundException e){
            sistema = new SystemControl();
        }catch(ClassNotFoundException | IOException e){
            System.out.println(e.getMessage());

        }
    }

    public static SystemControl limparSistema(Object sistema){
      try {
          sistema = new SystemControl();
      // Nao sei qual excecao lancar
      } catch (Exception e){
          System.out.println(e.getMessage());
      }
      return (SystemControl) sistema;
    }
}
