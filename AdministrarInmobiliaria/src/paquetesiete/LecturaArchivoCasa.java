
package paquetesiete;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import java.util.ArrayList;
import paqueteseis.Casa;

public class LecturaArchivoCasa {

    private ObjectInputStream entrada;
    private ArrayList<Casa> casas;
    private String nombreArchivoCasa;

    public LecturaArchivoCasa(String n) {
        nombreArchivoCasa = n;
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {
            try // abre el archivo
            {
                entrada = new ObjectInputStream(
                        new FileInputStream(n));
            } // fin de try
            catch (IOException ioException) {
                System.err.println("Error al abrir el archivo." + ioException);
            } // fin de catch
        }
    }

    public void establecerNombreArchivo(String n) {
        nombreArchivoCasa = n;
    }

    public void establecerCasas() {
        casas = new ArrayList<>();
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {
            while (true) {
                try {
                    Casa registro = (Casa) entrada.readObject();
                    casas.add(registro);
                } catch (EOFException endOfFileException) {
                    return; // se llegó al fin del archivo
                    // System.err.println("Fin de archivo: " + endOfFileException);

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

    public ArrayList<Casa> obtenerCasas() {
        return casas;
    }

    public String obtenerNombreArchivo() {
        return nombreArchivoCasa;
    }

    @Override
    public String toString() {
        String cadena = "Casas \n";
        for (int i = 0; i < obtenerCasas().size(); i++) {
            Casa c = obtenerCasas().get(i);
            cadena = String.format("%s************* Casa (%d) ************* \n"
                    + "Propietario:\t\t\n   -Nombres: %s\n   -Apellidos: %s\n   -Identificación: %s\n"
                    + "Precio por metro cuadrado: %.2f\n"
                    + "Número de metros cuadrados: %d\n"
                    + "Costo Final: %.2f\n"
                    + "Ubicación:\t\t\n   -Barrio: %s\n   -Referencia: %s\n"
                    + "Ciudad:\t\t\n   -Ciudad: %s\n   -Provincia: %s\n"
                    + "Número de cuartos: %d\n"
                    + "Constructora:\t\t\n   -Nombre: %s\n   -id: %s\n  ", cadena,
                    i + 1,
                    c.obtenerPropietario().obtenerNombre(),
                    c.obtenerPropietario().obtenerApellido(),
                    c.obtenerPropietario().obtenerIdentificacion(),
                    c.obtenerPrecioMetro2(),
                    c.obtenerNumMetro2(),
                    c.obtenerCostoF(),
                    c.obtenerUbicacion().obtenerNombreBarrio(),
                    c.obtenerUbicacion().obtenerReferencia(),
                    c.obtenerCiudad().obtenerNombreCiudad(),
                    c.obtenerCiudad().obtenerNombreProvincia(),
                    c.obtenerNumCuartos(),
                    c.obtenerConstructora().obtenerNConstructora(),
                    c.obtenerConstructora().obtenerIDC());
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
