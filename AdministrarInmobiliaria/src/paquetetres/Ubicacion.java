
package paquetetres;

import java.io.Serializable;

public class Ubicacion implements Serializable {
    private String nombreBarrio;
    private String referencia;
    private int numCasa;
    public Ubicacion(String n, String r, int nc) {
        nombreBarrio = n;
        referencia = r;
        numCasa = nc;    
    }

    public void establecerNombreBarrio(String n) {
        nombreBarrio = n;
    }

    public void establecerReferencia(String r) {
        referencia = r;
    }
    public void establecerNumCasa(int nc){
        numCasa = nc;
    }

    public String obtenerNombreBarrio() {
        return nombreBarrio;
    }

    public String obtenerReferencia() {
        return referencia;
    }
    public int obtenerNumCasa(){
        return numCasa;
    }
}
