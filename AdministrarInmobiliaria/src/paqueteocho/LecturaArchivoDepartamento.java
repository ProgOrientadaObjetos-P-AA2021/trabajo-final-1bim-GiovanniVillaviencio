package paqueteocho;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import java.util.ArrayList;
import paqueteseis.Departamento;

public class LecturaArchivoDepartamento {

    private ObjectInputStream entrada;
    private ArrayList<Departamento> departamentos;
    private String nombreArchivoDepartamentos;

    public LecturaArchivoDepartamento(String n) {
        nombreArchivoDepartamentos = n;
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
        nombreArchivoDepartamentos = n;
    }

    public void establecerDepartamentos() {
        departamentos = new ArrayList<>();
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {
            while (true) {
                
                try {
                    Departamento registro = (Departamento) entrada.readObject();
                    departamentos.add(registro);
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

    public ArrayList<Departamento> obtenerDepartamentos() {
        return departamentos;
    }

    public String obtenerNombreArchivo() {
        return nombreArchivoDepartamentos;
    }

    @Override
    public String toString() {
        String cadena = "Departamentos\n";
        for (int i = 0; i < obtenerDepartamentos().size(); i++) {
            Departamento d = obtenerDepartamentos().get(i);
            cadena = String.format("%s************* Departamento (%d) ****************\n"
                    + "Propietario:\t\n   -Nombres: %s\n   -Apellidos: %s\n   -Identificación: %s\n"
                    + "Precio por metro cuadrado: %.2f\n"
                    + "Número de metros cuadrados: %d\n"
                    + "Valor alicuota mensual: %.2f\n"
                    + "Precio: %.2f\n"
                    + "Costo Final: %.2f\n"
                    + "Ubicación:\t\n   -Número de departamento: %d\n   -Barrio: %s\n   -Referencia: %s\n"
                    + "Ciudad:\t\n   -Ciudad: %s\n   -Provincia: %s\n"
                    + "Nombre de edificio: %s\n"
                    + "Ubicación de departamento: %s\n"
                    + "Constructora:\t\n   -Nombre: %s\n   -id: %s\n ", cadena,
                    i + 1,
                    d.obtenerPropietario().obtenerNombre(),
                    d.obtenerPropietario().obtenerApellido(),
                    d.obtenerPropietario().obtenerIdentificacion(),
                    d.obtenerPrecioM2(),
                    d.obtenerNumM2(),
                    d.obtenerValMensual(),
                    d.obtenerPrecio(),
                    d.obtenerCosFinal(),
                    d.obtenerUbicacion().obtenerNumCasa(),
                    d.obtenerUbicacion().obtenerNombreBarrio(),
                    d.obtenerUbicacion().obtenerReferencia(),
                    d.obtenerCiudad().obtenerNombreCiudad(),
                    d.obtenerCiudad().obtenerNombreProvincia(),
                    d.obtenerNameEdi(),
                    d.obtenerUbiDepartamento(),
                    d.obtenerConstructora().obtenerNConstructora(),
                    d.obtenerConstructora().obtenerIDC());
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
