package paquetedos;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class EscrituraArchivoPropietario {

    private String nombreArchivoPropietario;
    private ObjectOutputStream salida;
    private Propietario registroPropietario;
    private ArrayList<Propietario> listaPropietario;

    public EscrituraArchivoPropietario(String nombreArc) {
        nombreArchivoPropietario = nombreArc;
        establecerListaPropietario();

        try {
            salida = new ObjectOutputStream(
                    new FileOutputStream(nombreArchivoPropietario));

            if (obtenerListaPropietario().size() > 0) {
                for (int i = 0; i < obtenerListaPropietario().size(); i++) {
                    establecerRegistroPropietario(obtenerListaPropietario().get(i));
                    establecerSalida();
                }
            }
        } catch (IOException ioException) {
            System.err.println("Error al abrir el archivo.");
        }
    }

    public void establecerNombreArchivo(String n) {
        nombreArchivoPropietario = n;
    }

    public void establecerRegistroPropietario(Propietario p) {
        registroPropietario = p;
    }

    public void establecerSalida() {
        try {
            salida.writeObject(registroPropietario);

        } catch (IOException ex) {
            System.err.println("Error al escribir en el archivo.");
        }
    }

    public void establecerListaPropietario() {
        LecturaArchivoPropietario p
                = new LecturaArchivoPropietario(obtenerNombreArchivo());
        p.establecerPropietarios();
        listaPropietario = p.obtenerPropietarios();
    }

    public String obtenerNombreArchivo() {
        return nombreArchivoPropietario;
    }

    public ArrayList<Propietario> obtenerListaPropietario() {
        return listaPropietario;
    }

    public ObjectOutputStream obtenerSalida() {
        return salida;
    }

    public void cerrarArchivo() {
        try {
            if (salida != null) {
                salida.close();
            }
        } catch (IOException ioException) {
            System.err.println("Error al cerrar el archivo.");

        }
    }
}
