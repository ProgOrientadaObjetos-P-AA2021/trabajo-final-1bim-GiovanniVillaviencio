
package paquetecinco;

import java.io.Serializable;

public class Constructora implements Serializable {
    private String nConstructora;
    private String idC;

    public Constructora(String nC, String id) {
        nConstructora = nC;
        idC = id;
    }

    public void establecerNConstructora(String nC) {
        nConstructora = nC;
    }

    public void establecerIDC(String id) {
        idC = id;
    }

    public String obtenerNConstructora() {
        return nConstructora;
    }

    public String obtenerIDC() {
        return idC;
    }
}
