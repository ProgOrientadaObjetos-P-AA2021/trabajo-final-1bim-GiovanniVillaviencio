package paqueteocho;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import paqueteseis.Departamento;

public class EscrituraArchivoDepartamento {

    private String nombreArchivoDepartamentos;
    private ObjectOutputStream salida;
    private Departamento registroDepartamento;
    private ArrayList<Departamento> listaDepartamentos;

    public EscrituraArchivoDepartamento(String nombreArc) {
        nombreArchivoDepartamentos = nombreArc;
        establecerListaDepartamentos();

        try {
            salida = new ObjectOutputStream(
                    new FileOutputStream(nombreArchivoDepartamentos));

            if (obtenerListaDepartamentos().size() > 0) {
                for (int i = 0; i < obtenerListaDepartamentos().size(); i++) {
                    establecerRegistroDepartamento(obtenerListaDepartamentos().get(i));
                    establecerSalida();
                }
            }
        } catch (IOException ioException) {
            System.err.println("Error al abrir el archivo.");
        }
    }

    public void establecerNombreArchivo(String n) {
        nombreArchivoDepartamentos = n;
    }

    public void establecerRegistroDepartamento(Departamento rdp) {
        registroDepartamento = rdp;
    }

    public void establecerSalida() {
        try {
            salida.writeObject(registroDepartamento);
        } catch (IOException ex) {
            System.err.println("Error al escribir en el archivo.");
        }
    }

    public void establecerListaDepartamentos() {
        LecturaArchivoDepartamento l
                = new LecturaArchivoDepartamento(obtenerNombreArchivo());
        l.establecerDepartamentos();
        listaDepartamentos = l.obtenerDepartamentos();

    }

    public String obtenerNombreArchivo() {
        return nombreArchivoDepartamentos;
    }

    public ArrayList<Departamento> obtenerListaDepartamentos() {
        return listaDepartamentos;
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
