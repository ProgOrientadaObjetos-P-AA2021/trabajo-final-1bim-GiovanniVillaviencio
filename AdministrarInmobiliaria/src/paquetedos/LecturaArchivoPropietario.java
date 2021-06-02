package paquetedos;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class LecturaArchivoPropietario {

    private ObjectInputStream entrada;
    private ArrayList<Propietario> propietarios;
    private String nombreArchivoPropietario;

    public LecturaArchivoPropietario(String n) {
        nombreArchivoPropietario = n;
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
        nombreArchivoPropietario = n;
    }

    public void establecerPropietarios() {

        propietarios = new ArrayList<>();
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {

            while (true) {
                try {
                    Propietario registro = (Propietario) entrada.readObject();
                    propietarios.add(registro);
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

    public ArrayList<Propietario> obtenerPropietarios() {
        return propietarios;
    }

    public String obtenerNombreArchivo() {
        return nombreArchivoPropietario;
    }

    @Override
    public String toString() {
        String cadena = "Propietarios\n";
        for (int i = 0; i < obtenerPropietarios().size(); i++) {
            Propietario p = obtenerPropietarios().get(i);
            cadena = String.format("%s************ Propietario(%d) ************\n"
                    + "Nombres: %s\nApellidos: %s\n"
                    + "Identificación: %s\n", cadena,
                    i + 1,
                    p.obtenerNombre(),
                    p.obtenerApellido(),
                    p.obtenerIdentificacion());
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
