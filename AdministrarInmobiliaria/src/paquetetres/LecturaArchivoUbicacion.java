package paquetetres;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class LecturaArchivoUbicacion {

    private ObjectInputStream entrada;
    private ArrayList<Ubicacion> ubicaciones;
    private String nombreArchivoUbicaciones;

    public LecturaArchivoUbicacion(String n) {
        nombreArchivoUbicaciones = n;
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {
            try {
                entrada = new ObjectInputStream(
                        new FileInputStream(n));
            } catch (IOException ioException) {
                System.err.println("Error al abrir el archivo." + ioException);
            }
        }
    }

    public void establecerNombreArchivo(String n) {
        nombreArchivoUbicaciones = n;
    }

    public void establecerUbicaciones() {

        ubicaciones = new ArrayList<>();
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {

            while (true) {
                try {
                    Ubicacion registro = (Ubicacion) entrada.readObject();
                    ubicaciones.add(registro);
                } catch (EOFException endOfFileException) {

                    return;

                } catch (IOException ex) {
                    System.err.println("Error al leer el archivo: " + ex);
                } catch (ClassNotFoundException ex) {
                    System.err.println("No se pudo crear el objeto: " + ex);
                } catch (Exception ex) {
                    System.err.println("No hay datos en el archivo: " + ex);

                }
            }
        }
    }

    public ArrayList<Ubicacion> obtenerUbicaciones() {
        return ubicaciones;
    }

    public String obtenerNombreArchivo() {
        return nombreArchivoUbicaciones;
    }

    @Override
    public String toString() {
        String cadena = "Ubicaciones\n";
        for (int i = 0; i < obtenerUbicaciones().size(); i++) {
            Ubicacion u = obtenerUbicaciones().get(i);
            cadena = String.format("%s************ Ubicacion(%d) ************\n"
                    + "Barrio: %s\nReferencia: %s\n"
                    + "Número de Casa: %d\n", cadena,
                    i + 1,
                    u.obtenerNombreBarrio(),
                    u.obtenerReferencia(),
                    u.obtenerNumCasa());
        }
        return cadena;
    }
    
    public void cerrarArchivo() {
        try {
            if (entrada != null) {
                entrada.close();
            }
            System.exit(0);
        } catch (IOException ioException) {
            System.err.println("Error al cerrar el archivo.");
            System.exit(1);
        }
    }
}
