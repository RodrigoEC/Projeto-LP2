import java.util.HashSet;

public class Validacao {
    private HashSet<String> caractereDni;

    public Validacao() {
        this.caractereDni = new HashSet<>();
        this.caractereDni.add("1");
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
            if (! this.caractereDni.contains(dni[i])){
                throw new IllegalArgumentException(mensagem);
            }
        }
    }
}
