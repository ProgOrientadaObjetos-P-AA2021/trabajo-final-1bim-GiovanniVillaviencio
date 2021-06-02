package paquetecinco;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class EscrituraArchivoConstructora {

    private String nombreArchivoConstructoras;
    private ObjectOutputStream salida;
    private Constructora registroConstructora;
    private ArrayList<Constructora> listaConstructora;

    public EscrituraArchivoConstructora(String nombreArc) {
        nombreArchivoConstructoras = nombreArc;
        establecerListaConstructora();

        try {
            salida = new ObjectOutputStream(
                    new FileOutputStream(nombreArchivoConstructoras));

            if (obtenerListaConstructora().size() > 0) {
                for (int i = 0; i < obtenerListaConstructora().size(); i++) {
                    establecerRegistroConstructora(obtenerListaConstructora().get(i));
                    establecerSalida();
                }
            }
        } catch (IOException ioException) {
            System.err.println("Error al abrir el archivo.");
        }
    }

    public void establecerNombreArchivo(String n) {
        nombreArchivoConstructoras = n;
    }

    public void establecerRegistroConstructora(Constructora c) {
        registroConstructora = c;
    }

    public void establecerSalida() {
        try {
            salida.writeObject(registroConstructora);

        } catch (IOException ex) {
            System.err.println("Error al escribir en el archivo.");
        }
    }

    public void establecerListaConstructora() {
        LecturaArchivoConstructora c
                = new LecturaArchivoConstructora(obtenerNombreArchivo());
        c.establecerConstructoras();
        listaConstructora = c.obtenerConstructoras();
    }

    public String obtenerNombreArchivo() {
        return nombreArchivoConstructoras;
    }

    public ArrayList<Constructora> obtenerListaConstructora() {
        return listaConstructora;
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
