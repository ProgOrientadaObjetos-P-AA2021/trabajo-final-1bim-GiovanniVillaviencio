
package paquetecuatro;

import java.io.Serializable;

public class Ciudad implements Serializable {
    private String nCiudad;
    private String nProvincia;

    public Ciudad(String nC, String nP) {
        nCiudad = nC;
        nProvincia = nP;
    }

    public void establecerNombreCiudad(String nC) {
        nCiudad = nC;
    }

    public void establecerNombreProvincia(String nP) {
        nProvincia = nP;
    }

    public String obtenerNombreCiudad() {
        return nCiudad;
    }

    public String obtenerNombreProvincia() {
        return nProvincia;
    }
}
