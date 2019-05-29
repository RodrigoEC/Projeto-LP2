import java.util.HashSet;

public class Validacao {
    private HashSet<String> caractereDni;

    public Validacao() {
        this.caractereDni = new HashSet<>();
        this.caractereDni.add("1");
        this.caractereDni.add("2");
        this.caractereDni.add("3");
        this.caractereDni.add("4");
        this.caractereDni.add("5");
        this.caractereDni.add("6");
        this.caractereDni.add("7");
        this.caractereDni.add("8");
        this.caractereDni.add("9");
        this.caractereDni.add("0");
        this.caractereDni.add("-");
    }

    private void validaString(String frase, String mensagem) {
        if (frase == null) {
            throw new NullPointerException(mensagem);
        }
        if ("".equals(frase.trim())) {
            throw new IllegalArgumentException(mensagem);
        }
    }

    private void validaDni(String dni, String mensagem) {
        for (int i = 0; i < dni.length(); i++){
            if (! this.caractereDni.contains(dni.charAt(i))){
                throw new IllegalArgumentException(mensagem);
            }
        }
    }
}
