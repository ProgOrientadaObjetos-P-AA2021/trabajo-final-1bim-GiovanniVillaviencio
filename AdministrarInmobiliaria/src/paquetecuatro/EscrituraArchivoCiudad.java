package paquetecuatro;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class EscrituraArchivoCiudad {

    private String nombreArchivoCiudades;
    private ObjectOutputStream salida;
    private Ciudad registroCiudad;
    private ArrayList<Ciudad> listaCiudad;

    public EscrituraArchivoCiudad(String nombreArc) {
        nombreArchivoCiudades = nombreArc;
        establecerListaCiudad();

        try {
            salida = new ObjectOutputStream(
                    new FileOutputStream(nombreArchivoCiudades));

            if (obtenerListaCiudad().size() > 0) {
                for (int i = 0; i < obtenerListaCiudad().size(); i++) {
                    establecerRegistroCiudad(obtenerListaCiudad().get(i));
                    establecerSalida();
                }
            }
        } catch (IOException ioException) {
            System.err.println("Error al abrir el archivo.");
        }
    }

    public void establecerNombreArchivo(String n) {
        nombreArchivoCiudades = n;
    }

    public void establecerRegistroCiudad(Ciudad c) {
        registroCiudad = c;
    }

    public void establecerSalida() {
        try {
            salida.writeObject(registroCiudad);

        } catch (IOException ex) {
            System.err.println("Error al escribir en el archivo.");
        }
    }

    public void establecerListaCiudad() {
        LecturaArchivoCiudad c
                = new LecturaArchivoCiudad(obtenerNombreArchivo());
        c.establecerCiudades();
        listaCiudad = c.obtenerCiudades();
    }

    public String obtenerNombreArchivo() {
        return nombreArchivoCiudades;
    }

    public ArrayList<Ciudad> obtenerListaCiudad() {
        return listaCiudad;
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
