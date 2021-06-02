package paqueteseis;

import paquetedos.Propietario;
import paquetetres.Ubicacion;
import paquetecuatro.Ciudad;
import paquetecinco.Constructora;
import java.util.ArrayList;
import java.io.Serializable;

public class Casa implements Serializable {

    private Propietario propietario;
    private double preciom2;
    private int numM2;
    private double costoF;
    private Ubicacion ubicacion;
    private Ciudad ciudad;
    private int numCuartos;
    private Constructora constructora;

    public Casa(Propietario p, double pm2, int nm2, Ubicacion u, Ciudad c,
            int nCuar, Constructora cons) {
        propietario = p;
        preciom2 = pm2;
        numM2 = nm2;
        ubicacion = u;
        ciudad = c;
        numCuartos = nCuar;
        constructora = cons;
    }

    public void establecerPropietario(Propietario p) {
        propietario = p;
    }

    public void establecerPrecioMetro2(double pm2) {
        preciom2 = pm2;
    }

    public void establecerNumMetro2(int nm2) {
        numM2 = nm2;
    }

    public void establecerCostoF() {
        costoF = preciom2 * numM2;
    }

    public void establecerUbicacion(Ubicacion u) {
        ubicacion = u;
    }

    public void establecerCiudad(Ciudad c) {
        ciudad = c;
    }

    public void establecerNumCuartos(int nCuar) {
        numCuartos = nCuar;
    }

    public void establecerConstructora(Constructora cons) {
        constructora = cons;
    }

    public Propietario obtenerPropietario() {
        return propietario;
    }

    public double obtenerPrecioMetro2() {
        return preciom2;
    }

    public int obtenerNumMetro2() {
        return numM2;
    }

    public double obtenerCostoF() {
        return costoF;
    }

    public Ubicacion obtenerUbicacion() {
        return ubicacion;
    }

    public Ciudad obtenerCiudad() {
        return ciudad;
    }

    public int obtenerNumCuartos() {
        return numCuartos;
    }

    public Constructora obtenerConstructora() {
        return constructora;
    }
}
