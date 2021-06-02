package paquetetres;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class EscrituraArchivoUbicacion {

    private String nombreArchivoUbicaciones;
    private ObjectOutputStream salida;
    private Ubicacion registroUbicacion;
    private ArrayList<Ubicacion> listaUbicacion;

    public EscrituraArchivoUbicacion(String nombreArc) {
        nombreArchivoUbicaciones = nombreArc;
        establecerListaUbicacion();

        try {
            salida = new ObjectOutputStream(
                    new FileOutputStream(nombreArchivoUbicaciones));

            if (obtenerListaUbicacion().size() > 0) {
                for (int i = 0; i < obtenerListaUbicacion().size(); i++) {
                    establecerRegistroUbicacion(obtenerListaUbicacion().get(i));
                    establecerSalida();
                }
            }
        } catch (IOException ioException) {
            System.err.println("Error al abrir el archivo.");
        }
    }

    public void establecerNombreArchivo(String n) {
        nombreArchivoUbicaciones = n;
    }

    public void establecerRegistroUbicacion(Ubicacion u) {
        registroUbicacion = u;
    }

    public void establecerSalida() {
        try {
            salida.writeObject(registroUbicacion);

        } catch (IOException ex) {
            System.err.println("Error al escribir en el archivo.");
        }
    }

    public void establecerListaUbicacion() {
        LecturaArchivoUbicacion u
                = new LecturaArchivoUbicacion(obtenerNombreArchivo());
        u.establecerUbicaciones();
        listaUbicacion = u.obtenerUbicaciones();
    }

    public String obtenerNombreArchivo() {
        return nombreArchivoUbicaciones;
    }

    public ArrayList<Ubicacion> obtenerListaUbicacion() {
        return listaUbicacion;
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
