
package paquetedos;

import java.io.Serializable;

public class Propietario implements Serializable {
    private String nombre;
    private String apellido;
    private String identificacion;

    public Propietario(String n, String a, String i) {
        nombre = n;
        apellido = a;
        identificacion = i;
    }

    public void establecerNombre(String n) {
        nombre = n;
    }

    public void establecerApellido(String n) {
        apellido = n;
    }

    public void establecerIdentificacion(String n) {
        identificacion = n;
    }

    public String obtenerNombre() {
        return nombre;
    }

    public String obtenerApellido() {
        return apellido;
    }

    public String obtenerIdentificacion() {
        return identificacion;
    }
}
