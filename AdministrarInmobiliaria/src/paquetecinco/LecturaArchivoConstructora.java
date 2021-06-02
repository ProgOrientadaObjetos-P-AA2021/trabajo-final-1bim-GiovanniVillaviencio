package paquetecinco;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class LecturaArchivoConstructora {

    private ObjectInputStream entrada;
    private ArrayList<Constructora> constructoras;
    private String nombreArchivoConstructoras;

    public LecturaArchivoConstructora(String n) {
        nombreArchivoConstructoras = n;
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
        nombreArchivoConstructoras = n;
    }

    public void establecerConstructoras() {

        constructoras = new ArrayList<>();
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {

            while (true) {
                try {
                    Constructora registro = (Constructora) entrada.readObject();
                    constructoras.add(registro);
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

    public ArrayList<Constructora> obtenerConstructoras() {
        return constructoras;
    }

    public String obtenerNombreArchivo() {
        return nombreArchivoConstructoras;
    }

    @Override
    public String toString() {
        String cadena = "Constructoras\n";
        for (int i = 0; i < obtenerConstructoras().size(); i++) {
            Constructora c = obtenerConstructoras().get(i);
            cadena = String.format("%s************ Constructora(%d) ************\n"
                    + "Constructora: %s\n"
                    + "id empresa: %s\n", cadena,
                    i + 1,
                    c.obtenerNConstructora(),
                    c.obtenerIDC());
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
