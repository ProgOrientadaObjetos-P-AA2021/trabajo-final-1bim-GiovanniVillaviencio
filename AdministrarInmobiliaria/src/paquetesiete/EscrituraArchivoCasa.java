package paquetesiete;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import paqueteseis.Casa;

public class EscrituraArchivoCasa {

    private String nombreArchivoCasa;
    private ObjectOutputStream salida;
    private Casa registroCasa;
    private ArrayList<Casa> listaCasas;

    public EscrituraArchivoCasa(String nombreArc) {
        nombreArchivoCasa = nombreArc;
        establecerListaCasas();

        try {
            salida = new ObjectOutputStream(
                    new FileOutputStream(nombreArchivoCasa));

            if (obtenerListaCasas().size() > 0) {
                for (int i = 0; i < obtenerListaCasas().size(); i++) {
                    establecerRegistroCasa(obtenerListaCasas().get(i));
                    establecerSalida();

                }
            }
        } catch (IOException ioException) {
            System.err.println("Error al abrir el archivo.");
        }
    }

    public void establecerNombreArchivo(String n) {
        nombreArchivoCasa = n;
    }

    public void establecerRegistroCasa(Casa rc) {
        registroCasa = rc;
    }

    public void establecerSalida() {
        try {
            salida.writeObject(registroCasa);
        } catch (IOException ex) {
            System.err.println("Error al escribir en el archivo.");
        }
    }

    public void establecerListaCasas() {
        LecturaArchivoCasa l = new LecturaArchivoCasa(obtenerNombreArchivo());
        l.establecerCasas();
        listaCasas = l.obtenerCasas();
    }

    public String obtenerNombreArchivo() {
        return nombreArchivoCasa;
    }

    public ArrayList<Casa> obtenerListaCasas() {
        return listaCasas;
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
