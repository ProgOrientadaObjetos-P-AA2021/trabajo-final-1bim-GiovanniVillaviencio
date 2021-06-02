package paquetecuatro;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class LecturaArchivoCiudad {

    private ObjectInputStream entrada;
    private ArrayList<Ciudad> ciudades;
    private String nombreArchivoCiudades;

    public LecturaArchivoCiudad(String n) {
        nombreArchivoCiudades = n;
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
        nombreArchivoCiudades = n;
    }

    public void establecerCiudades() {

        ciudades = new ArrayList<>();
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {

            while (true) {
                try {
                    Ciudad registro = (Ciudad) entrada.readObject();
                    ciudades.add(registro);
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

    public ArrayList<Ciudad> obtenerCiudades() {
        return ciudades;
    }

    public String obtenerNombreArchivo() {
        return nombreArchivoCiudades;
    }

    @Override
    public String toString() {
        String cadena = "Ciudades\n";
        for (int i = 0; i < obtenerCiudades().size(); i++) {
            Ciudad ci = obtenerCiudades().get(i);
            cadena = String.format("%s************ Ciudad (%d) ************\n"
                    + "Nombre de ciudad: %s\n "
                    + "Nombre de provincia: %s\n", cadena,
                    i + 1,
                    ci.obtenerNombreCiudad(),
                    ci.obtenerNombreProvincia());
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
