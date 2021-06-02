package paqueteseis;

import paquetedos.Propietario;
import paquetetres.Ubicacion;
import paquetecuatro.Ciudad;
import paquetecinco.Constructora;
import java.io.Serializable;

public class Departamento implements Serializable {

    private Propietario propietario;
    private double precioM2;
    private int numM2;
    private double valMensual;
    private double cosFinal;
    private double precio;
    private Ubicacion ubicacion;
    private Ciudad ciudad;
    private String nameEdi;
    private String ubiDepartamento;
    private Constructora constructora;

    public Departamento(Propietario prp, double pm2, int nm2, double vlM,
            Ubicacion ubi, Ciudad ciu, String nedi,
            String uDp, Constructora cons) {
        propietario = prp;
        precioM2 = pm2;
        numM2 = nm2;
        valMensual = vlM;
        ubicacion = ubi;
        ciudad = ciu;
        nameEdi = nedi;
        ubiDepartamento = uDp;
        constructora = cons;
    }

    public void establecerPropietario(Propietario prp) {
        propietario = prp;
    }

    public void establecerPrecioM2(double pm2) {
        precioM2 = pm2;
    }

    public void establecerNumM2(int nm2) {
        numM2 = nm2;
    }

    public void establecerValMensual(double vlM) {
        valMensual = vlM;
    }

    public void establecerPrecio() {
        precio = precioM2 * numM2;
    }

    public void establecerCosFinal() {
        cosFinal = (valMensual * 12) + (precio);
    }

    public void establecerUbicacion(Ubicacion ubi) {
        ubicacion = ubi;
    }

    public void establecerCiudad(Ciudad ciu) {
        ciudad = ciu;
    }

    public void establecerNameEdi(String nedi) {
        nameEdi = nedi;
    }

    public void establecerUbiDepartamento(String uDp) {
        ubiDepartamento = uDp;
    }

    public void establecerConstructora(Constructora cons) {
        constructora = cons;
    }

    public Propietario obtenerPropietario() {
        return propietario;
    }

    public double obtenerPrecioM2() {
        return precioM2;
    }

    public int obtenerNumM2() {
        return numM2;
    }

    public double obtenerValMensual() {
        return valMensual;
    }

    public double obtenerCosFinal() {
        return cosFinal;
    }

    public double obtenerPrecio() {
        return precio;
    }

    public Ubicacion obtenerUbicacion() {
        return ubicacion;
    }

    public Ciudad obtenerCiudad() {
        return ciudad;
    }

    public String obtenerNameEdi() {
        return nameEdi;
    }

    public String obtenerUbiDepartamento() {
        return ubiDepartamento;
    }

    public Constructora obtenerConstructora() {
        return constructora;
    }

}
