package paqueteuno;

import java.util.Scanner;
import paquetedos.*;
import paquetetres.*;
import paquetecuatro.*;
import paquetecinco.*;
import paqueteseis.*;
import paquetesiete.*;
import paqueteocho.*;
import java.util.ArrayList;

public class Ejecutor {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int optionGeneral;
        int optionSecundaria;
        boolean bandera = true;

        do {
            System.out.println("\n<<<<<<<<<<<<<<<<<<<< Menú de Inmobiliaria >>"
                    + ">>>>>>>>>>>>>>>>>>>>>>>\n");
            System.out.print("*********************");
            System.out.println("\n| 1. Ingresar datos |\n| 2. Imprimir datos |\n| 3. Salir          |");
            System.out.println("*********************");
            optionGeneral = sc.nextInt();
            System.out.println();
            if (optionGeneral == 1) {
                System.out.println("Seleccione una opción:\n");
                System.out.println("1. Ingresar un propietario\n"
                        + "2. Ingresar una ubicacion\n"
                        + "3. Ingresar una ciudad\n"
                        + "4. Ingresar una constructora\n"
                        + "5. Ingresar una casa\n"
                        + "6. Ingresar un departamento");
                optionSecundaria = sc.nextInt();
                switch (optionSecundaria) {
                    case 1:
                        ingresarPropietarios();

                        break;
                    case 2:
                        ingresarUbicaciones();
                        break;
                    case 3:
                        ingresarCiudades();
                        break;
                    case 4:
                        ingresarConstructoras();
                        break;
                    case 5:
                        System.out.println("Antes de proceder a ingresar una "
                                + "casa es ");
                        System.out.println("necesario verificar si sus datos");
                        System.out.println("constan en nuestro sistema,"
                                + " por favor");
                        System.out.println("proceda llenarlos de la forma "
                                + "en que");
                        System.out.println("se pide");

                        System.out.print("Ingrese la identificacion del "
                                + "Propietario: ");
                        String icPropietario = sc.nextLine();
                        sc.nextLine();
                        System.out.print("Ingrese el numero de casa: ");
                        int numCasa = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Ingrese el nombre de la ciudad: ");
                        String nameCity = sc.nextLine();
                        System.out.print("Ingrese ID de la empresa de la "
                                + "constructora: ");
                        String consID = sc.nextLine();
                        //Verificacion general comprueba que los datos del usua
                        //rio se encuentren, de lo contrario despliega 
                        //el formulario correspondiente 
                        verificacionGeneral(icPropietario, numCasa,
                                nameCity, consID);
                        //Se envian datos como parametros a casa para evitar 
                        //volver a preguntar al usuario algo que anteriormente 
                        // ya se lleno, asi tiene una interfaz mas amigable
                        //y se ahorran lineas de codigo. 
                        ingresarCasas(icPropietario, numCasa, nameCity, consID);
                        break;
                    case 6:
                        System.out.println("Antes de proceder a ingresar un "
                                + "departamento es ");
                        System.out.println("necesario verificar si sus datos");
                        System.out.println("constan en nuestro sistema, "
                                + "por favor");
                        System.out.println("proceda llenarlos de la "
                                + "forma en que");
                        System.out.println("se pide");
                        sc.nextLine();
                        System.out.print("Ingrese la identificacion "
                                + "del Propietario: ");
                        String icPropietarioD = sc.nextLine();
                        System.out.print("Ingrese el numero de Departamento: ");
                        int numDepartamento = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Ingrese el nombre de la ciudad: ");
                        String nameCityD = sc.nextLine();
                        System.out.print("Ingres ID de la empresa de la "
                                + "constructora: ");
                        String idConsD = sc.nextLine();
                        //Verificacion general comprueba que los datos del usua
                        //rio se encuentren, de lo contrario despliega 
                        //el formulario correspondiente 
                        verificacionGeneral(icPropietarioD, numDepartamento,
                                nameCityD, idConsD);
                        //Se envian datos como parametros a casa para evitar 
                        //volver a preguntar al usuario algo que anteriormente 
                        // ya se lleno, asi tiene una interfaz mas amigable
                        //y se ahorran lineas de codigo. 
                        ingresarDepartamentos(icPropietarioD, numDepartamento,
                                nameCityD, idConsD);
                        break;
                    default:
                        System.err.println("Escogio una opcion invalida,"
                                + " por favor"
                                + "ingrese una que este dentro del rango(1-6)");
                }
            } else {
                if (optionGeneral == 2) {
                    System.out.println("Que lista desea imprimir:\n");
                    System.out.println("1. Imprimir lista de propietarios\n"
                            + "2. Imprimir lista de ubicaciones\n"
                            + "3. Imprimir lista de ciudades\n"
                            + "4. Imprimir lista de constructoras\n"
                            + "5. Imprimir lista de casas\n"
                            + "6. Imprimir lista de departamentos");
                    optionSecundaria = sc.nextInt();
                    switch (optionSecundaria) {
                        case 1:
                            imprimirPropietarios();
                            break;
                        case 2:
                            imprimirUbicaciones();
                            break;
                        case 3:
                            imprimirCiudades();
                            break;
                        case 4:
                            imprimirConstructoras();
                            break;
                        case 5:
                            imprimirCasas();
                            break;
                        case 6:
                            imprimirDepartamentos();
                            break;
                        default:
                            //Si el usuario exede el rango (1-6) saldra este 
                            // mensaje y el reseteo del menu
                            System.err.println("Escogio una opcion invalida, "
                                    + "por favor"
                                + "ingrese una que este dentro del rango(1-6)");
                    }
                }
                if (optionGeneral == 3) {
                    bandera = false;
                    //El menu se va a seguir repitiendo hasta que el usuario
                    //escoja la opcion de salir 
                }

            }
        } while (bandera);
    }
    //Ingreso de los datos del propietario
    public static void ingresarPropietarios() {
        Scanner sc = new Scanner(System.in);
        //Se ingresan los datos de propietario
        System.out.print("Ingrese sus nombres: ");
        String names = sc.nextLine();
        System.out.print("Ingrese sus apellidos: ");
        String apellido = sc.nextLine();
        System.out.print("Ingrese su identificación(C.I): ");
        String cI = sc.nextLine();
        Propietario propietario = new Propietario(names, apellido, cI);
        //Se escribe el archivo en uno  llamado propietarios.txt
        EscrituraArchivoPropietario archivoPropietario = 
                new EscrituraArchivoPropietario("propietarios.txt");
        //Se envia un objeto de tipo propietario al archivo
        archivoPropietario.establecerRegistroPropietario(propietario);
        archivoPropietario.establecerSalida();
        //Despues de enviar el objeto se cierra el archivo
        archivoPropietario.cerrarArchivo();
    }
    //Ingreso de los datos de ubicaciones
    public static void ingresarUbicaciones() {
        Scanner sc = new Scanner(System.in);
        //Se ingresan los datos de ubicaion
        System.out.print("Ingrese el nombre del barrio: ");
        String nameBarrio = sc.nextLine();
        System.out.print("Ingrese una referencia respecto a su ubicación: ");
        String referencia = sc.nextLine();
        System.out.print("Ingrese el número de la casa/Departamento: ");
        int numCasa = sc.nextInt();
        Ubicacion ubicacion = new Ubicacion(nameBarrio, referencia, numCasa);
        //Se escribe el archivo en uno llamado ubicaciones.txt
        EscrituraArchivoUbicacion archivoUbicacion = 
                new EscrituraArchivoUbicacion("ubicaciones.txt");
        //Se envia un objeto de tipo Ubicacion al archivo
        archivoUbicacion.establecerRegistroUbicacion(ubicacion);
        archivoUbicacion.establecerSalida();
        //Despues de enviar el objeto se cierra el archivo
        archivoUbicacion.cerrarArchivo();
    }
    //Ingreso de los datos de ciudades
    public static void ingresarCiudades() {
        Scanner sc = new Scanner(System.in);
        //Se ingresan los datos de ciudad
        System.out.print("Ingrese el nombre de la ciudad: ");
        String ciudad = sc.nextLine();
        System.out.print("Ingrese el nombre de la provincia: ");
        String provincia = sc.nextLine();
        Ciudad ciu = new Ciudad(ciudad, provincia);
        //Se escribe el archivo en uno llamado ciudades.txt
        EscrituraArchivoCiudad archivoCiudad =
                new EscrituraArchivoCiudad("ciudades.txt");
        //Se envia un objeto de tipo Ciudad al archivo
        archivoCiudad.establecerRegistroCiudad(ciu);
        archivoCiudad.establecerSalida();
        //Despues de enviar el objeto se cierra el archivo
        archivoCiudad.cerrarArchivo();
    }
    //Ingreso de los datos de constructoras
    public static void ingresarConstructoras() {
        Scanner sc = new Scanner(System.in);
        //Se ingresan los datos de la constructora
        System.out.print("Ingrese el nombre de la constructora: ");
        String nameConstructora = sc.nextLine();
        System.out.print("Ingrese el id empresarial de la constructora: ");
        String idConstructora = sc.nextLine();
        Constructora constructora = new Constructora(nameConstructora, 
                idConstructora);
        //Se escribe el archivo en uno llamado constructoras.txt
        EscrituraArchivoConstructora archivoConstructora = 
                new EscrituraArchivoConstructora("constructoras.txt");
        //Se envia un objeto de tipo Constructora al archivo
        archivoConstructora.establecerRegistroConstructora(constructora);
        archivoConstructora.establecerSalida();
        //Despues de enviar el objeto se cierra el archivo
        archivoConstructora.cerrarArchivo();
    }
    //Ingreso de los datos de casas
    public static void ingresarCasas(String icPro, int numCasa, 
            String nameCity, String idCons) {
        Scanner sc = new Scanner(System.in);
        //Declarar ArrayList de objetos de cada clase, para asi recuperar en
        // estos los objetos guardados en los archivos.txt
        ArrayList<Propietario> propietarios;
        ArrayList<Ubicacion> ubicaciones;
        ArrayList<Ciudad> ciudades;
        ArrayList<Constructora> constructoras;
        
        //Se ingresan los datos restantes de casa
        System.out.print("Ingrese el precio por metro cuadrado: ");
        double precioMC = sc.nextDouble();
        System.out.print("Ingrese el número de metros cuadrados: ");
        int numMC = sc.nextInt();
        System.out.print("Ingrese el número de habitaciones de la casa: ");
        int numCuartos = sc.nextInt();
        
        //Propietarios
        //Se lee el archivo de propietarios y sus objetos se recuperan en el 
        // ArrayList propietarios
        LecturaArchivoPropietario lecturaDePropietarios =
                new LecturaArchivoPropietario("propietarios.txt");
        lecturaDePropietarios.establecerPropietarios();
        propietarios = lecturaDePropietarios.obtenerPropietarios();
        String namesPropi = "";
        String apellidosPropietario = "";
        //Se recorre el ArrayList propietarios buscando si el atributo identifi
        // cacion de propietario coincide con el id ingresado por el usuario, 
        // dado el caso se le asigna el nombre y apellido
        for (int i = 0; i < propietarios.size(); i++) {
            if (propietarios.get(i).obtenerIdentificacion().equals(icPro)) {
                namesPropi = propietarios.get(i).obtenerNombre();
                apellidosPropietario = propietarios.get(i).obtenerApellido();
            }
        }
        //Se envian los parametros para el constructor de Propietario a travez
        // de un objeto llamado otPropietario
        Propietario otPropietario = 
                new Propietario(namesPropi, apellidosPropietario, icPro);
        
        //Ubicacion
        //Se lee el archivo de ubicaciones y sus objetos se recuperan en el 
        // ArrayList ubicaciones
        LecturaArchivoUbicacion lecturaDeUbicaciones =
                new LecturaArchivoUbicacion("ubicaciones.txt");
        lecturaDeUbicaciones.establecerUbicaciones();
        ubicaciones = lecturaDeUbicaciones.obtenerUbicaciones();
        //Se declara una variable para el numero de casa y si esta coincide con
        // la ingresada por el usuario se asigna el nombre de barrio y referencia
        String nameBarrio = "";
        String referencia = "";
        for (int i = 0; i < ubicaciones.size(); i++) {
            int numC = ubicaciones.get(i).obtenerNumCasa();
            if (numC == numCasa) {
                nameBarrio = ubicaciones.get(i).obtenerNombreBarrio();
                referencia = ubicaciones.get(i).obtenerReferencia();
            }
        }
        //Se envian los parametros para el constructor de Ubicacion a travez
        // de un objeto llamado otUbicacion
        Ubicacion otUbicacion = new Ubicacion(nameBarrio, referencia, numCasa);

        //Ciudad
        //Se lee el archivo de ciudades y sus objetos se recuperan en el 
        // ArrayList ciudades
        LecturaArchivoCiudad lecturaDeCiudades =
                new LecturaArchivoCiudad("ciudades.txt");
        lecturaDeCiudades.establecerCiudades();
        ciudades = lecturaDeCiudades.obtenerCiudades();
        //Se compara si el nombre de la ciudad es igual al nombre que ingreso 
        //el usuario, de ser asi se asigna el nombre a la provincia
        String nameProvin = "";
        for (int i = 0; i < lecturaDeCiudades.obtenerCiudades().size(); i++) {
            if (ciudades.get(i).obtenerNombreCiudad().equals(nameCity)) {
                nameProvin = ciudades.get(i).obtenerNombreProvincia();
            }
        }
        //Se envian los parametros para el constructor de Ciudad a travez
        // de un objeto llamado otCiudad
        Ciudad otCiudad = new Ciudad(nameCity, nameProvin);

        //Constructoras
        //Se lee el archivo de constructoras y sus objetos se recuperan en el 
        // ArrayList constructoras
        LecturaArchivoConstructora lecturaDeConstructoras = 
                new LecturaArchivoConstructora("constructoras.txt");
        lecturaDeConstructoras.establecerConstructoras();
        constructoras = lecturaDeConstructoras.obtenerConstructoras();
        String nameConstructora = "";
        for (int i = 0; i < lecturaDeConstructoras.obtenerConstructoras()
                .size(); i++) {
            if (constructoras.get(i).obtenerIDC().equals(idCons)) {
                nameConstructora = constructoras.get(i).obtenerNConstructora();
            }
        }
        //Se envian los parametros para el constructor de Constructora a travez
        // de un objeto llamado otConstructora
        Constructora otConstructora = 
                new Constructora(nameConstructora, idCons);
        
        //Casa.
        //Se crea un objeto de tipo casa para enviar a los parametros que 
        //requiere el constructor de casa. 
        Casa casa = new Casa(otPropietario, precioMC, numMC,
                otUbicacion, otCiudad, numCuartos, otConstructora);
        casa.establecerCostoF();
        //Se escribe el archivo en uno llamado casas.txt
        EscrituraArchivoCasa archivoCasa = 
                new EscrituraArchivoCasa("casas.txt");
        //Se envia un objeto de tipo casa al archivo
        archivoCasa.establecerRegistroCasa(casa);
        archivoCasa.establecerSalida();
        //Una vez enviado el objeto se cierra el archivo
        archivoCasa.cerrarArchivo();
    }
    //Ingreso de los datos de departamentos
    public static void ingresarDepartamentos(String icPro, int numCasa, 
            String nameCity, String idCons) {
        Scanner sc = new Scanner(System.in);
        //Declarar ArrayList de objetos de cada clase, para asi recuperar en
        // estos los objetos guardados en los archivos.txt
        ArrayList<Propietario> propietarios;
        ArrayList<Ubicacion> ubicaciones;
        ArrayList<Ciudad> ciudades;
        ArrayList<Constructora> constructoras;
        
        //Se ingresan los datos restantes de casa
        System.out.print("Ingrese el precio por metro cuadrado: ");
        double precioMC = sc.nextDouble();
        System.out.print("Ingrese el número de metros cuadrados: ");
        int numMC = sc.nextInt();
        System.out.print("Ingrese el valor de la alícuota mensual: ");
        double cuotaMensual = sc.nextDouble();
        sc.nextLine();
        System.out.print("Ingrese el nombre del edificio: ");
        String nameEdi = sc.nextLine();
        System.out.print("Ingrese la dirección del edificio: ");
        String ubicacionEdi = sc.nextLine();
        
        //Propietarios
        //Se lee el archivo de propietarios y sus objetos se recuperan en el 
        // ArrayList propietarios
        LecturaArchivoPropietario lecturaDePropietarios = 
                new LecturaArchivoPropietario("propietarios.txt");
        lecturaDePropietarios.establecerPropietarios();
        propietarios = lecturaDePropietarios.obtenerPropietarios();
        //Se recorre el ArrayList propietarios buscando si el atributo identifi
        // cacion de propietario coincide con el id ingresado por el usuario, 
        // dado el caso se le asigna el nombre y apellido
        String namesPropi = "";
        String apellidosPropietario = "";
        for (int i = 0; i < propietarios.size(); i++) {
            if (propietarios.get(i).obtenerIdentificacion().equals(icPro)) {
                namesPropi = propietarios.get(i).obtenerNombre();
                apellidosPropietario = propietarios.get(i).obtenerApellido();
            }
        }
        //Se envian los parametros para el constructor de Propietario a travez
        // de un objeto llamado otPropietario
        Propietario otPropietario =
                new Propietario(namesPropi, apellidosPropietario, icPro);
        
        
        //Ubicacion
        //Se lee el archivo de ubicaciones y sus objetos se recuperan en el 
        // ArrayList ubicaciones
        LecturaArchivoUbicacion lecturaDeUbicaciones = 
                new LecturaArchivoUbicacion("ubicaciones.txt");
        lecturaDeUbicaciones.establecerUbicaciones();
        ubicaciones = lecturaDeUbicaciones.obtenerUbicaciones();
        //Se declara una variable para el numero de departamento y si este
        // coincide con el ingresada por el usuario se asigna el nombre de 
        //barrio y referencia
        String nameBarrio = "";
        String referencia = "";
        for (int i = 0; i < ubicaciones.size(); i++) {
            int numC = ubicaciones.get(i).obtenerNumCasa();
            if (numC == numCasa) {
                nameBarrio = ubicaciones.get(i).obtenerNombreBarrio();
                referencia = ubicaciones.get(i).obtenerReferencia();
            }
        }
        //Se envian los parametros para el constructor de Ubicacion a travez
        // de un objeto llamado otUbicacion
        Ubicacion otUbicacion = new Ubicacion(nameBarrio, referencia, numCasa);

        //Ciudad
        //Se lee el archivo de ciudades y sus objetos se recuperan en el 
        // ArrayList ciudades
        LecturaArchivoCiudad lecturaDeCiudades =
                new LecturaArchivoCiudad("ciudades.txt");
        lecturaDeCiudades.establecerCiudades();
        ciudades = lecturaDeCiudades.obtenerCiudades();
        //Se compara si el nombre de la ciudad es igual al nombre que ingreso 
        //el usuario, de ser asi se asigna el nombre a la provincia
        String nameProvin = "";
        for (int i = 0; i < lecturaDeCiudades.obtenerCiudades().size(); i++) {
            if (ciudades.get(i).obtenerNombreCiudad().equals(nameCity)) {
                nameProvin = ciudades.get(i).obtenerNombreProvincia();
            }
        }
        //Se envian los parametros para el constructor de Ciudad a travez
        // de un objeto llamado otCiudad
        Ciudad otCiudad = new Ciudad(nameCity, nameProvin);

        //Constructoras
        //Se lee el archivo de constructoras y sus objetos se recuperan en el 
        // ArrayList constructoras
        LecturaArchivoConstructora lecturaDeConstructoras = 
                new LecturaArchivoConstructora("constructoras.txt");
        lecturaDeConstructoras.establecerConstructoras();
        constructoras = lecturaDeConstructoras.obtenerConstructoras();
        String nameConstructora = "";
        for (int i = 0; i < lecturaDeConstructoras.obtenerConstructoras()
                .size(); i++) {
            if (constructoras.get(i).obtenerIDC().equals(idCons)) {
                nameConstructora = constructoras.get(i).obtenerNConstructora();
            }
        }
        //Se envian los parametros para el constructor de Constructora a travez
        // de un objeto llamado otConstructora
        Constructora otConstructora = new Constructora(nameConstructora, idCons);
        
        //Departamento
        //Se crea un objeto de tipo casa para enviar a los parametros que 
        //requiere el constructor de casa. 
        Departamento departamento = new Departamento(otPropietario, precioMC,
                numMC, cuotaMensual, otUbicacion, otCiudad, nameEdi,
                ubicacionEdi, otConstructora);
        departamento.establecerPrecio();
        departamento.establecerCosFinal();
        //Se escribe el archivo en uno llamado departamentos.txt
        EscrituraArchivoDepartamento archivoDepartamento = 
                new EscrituraArchivoDepartamento("departamentos.txt");
        //Se envia un objeto de tipo departamento al registro
        archivoDepartamento.establecerRegistroDepartamento(departamento);
        archivoDepartamento.establecerSalida();
        //Una vez enviado el objeto se cierra el archivo
        archivoDepartamento.cerrarArchivo();
    }
    //Se imprime la lista de propietarios
    public static void imprimirPropietarios() {
        LecturaArchivoPropietario lecturaDePropietarios = 
                new LecturaArchivoPropietario("propietarios.txt");
        lecturaDePropietarios.establecerPropietarios();
        System.out.println(lecturaDePropietarios);
    }
    //Se imprime la lista de ubicaciones
    public static void imprimirUbicaciones() {
        LecturaArchivoUbicacion lecturaDeUbicaciones = 
                new LecturaArchivoUbicacion("ubicaciones.txt");
        lecturaDeUbicaciones.establecerUbicaciones();
        System.out.println(lecturaDeUbicaciones);
    }
    //Se imprime la lista de ciudades
    public static void imprimirCiudades() {
        LecturaArchivoCiudad lecturaDeCiudades = 
                new LecturaArchivoCiudad("ciudades.txt");
        lecturaDeCiudades.establecerCiudades();
        System.out.println(lecturaDeCiudades);
    }
    //Se imprime la lista de constructoras
    public static void imprimirConstructoras() {
        LecturaArchivoConstructora lecturaDeConstructoras =
                new LecturaArchivoConstructora("constructoras.txt");
        lecturaDeConstructoras.establecerConstructoras();
        System.out.println(lecturaDeConstructoras);
    }
    //Se imprime la lista de casas
    public static void imprimirCasas() {
        LecturaArchivoCasa lecturaDeCasas = new LecturaArchivoCasa("casas.txt");
        lecturaDeCasas.establecerCasas();
        System.out.println(lecturaDeCasas);
    }
    //Se imprime la lista de departamentos
    public static void imprimirDepartamentos() {
        LecturaArchivoDepartamento lecturaDeDepartamentos =
                new LecturaArchivoDepartamento("departamentos.txt");
        lecturaDeDepartamentos.establecerDepartamentos();
        System.out.println(lecturaDeDepartamentos);
    }
    
    //Se verifica que los datos del propietario, ubicacion, ciudad y constructora
    //se encuentren reistrados, caso contrario se procede a registrar los datos
    public static void verificacionGeneral(String icPro, int numCasa,
            String city, String idCons) {
        Scanner sc = new Scanner(System.in);
        System.out.println("<<<<<<<<<< Verificar registro de Propietario "
                + ">>>>>>>>>>>>");
        if (verificacionDePropietarios(icPro) == false) {
            ingresarPropietarios();
        }
        System.out.println("<<<<<<<<<< Verificar registro de Ubicación"
                + " >>>>>>>>>>>>");
        if (verificacionDeUbicaciones(numCasa) == false) {
            ingresarUbicaciones();
        }//level in the paper
        sc.nextLine();
        System.out.println("<<<<<<<<<< Verificar registro de Ciudad"
                + " >>>>>>>>>>>>");
        if (verificacionDeCiudades(city) == false) {
            ingresarCiudades();
        }
        System.out.println("<<<<<<<<<< Verificar registro de Constructora "
                + ">>>>>>>>>>>>");
        if (verificacionDeConstructoras(idCons) == false) {
            ingresarConstructoras();
        }
    }
    //Se verifica que los datos del propietario se encuentren registrados, caso
    //contrario se procede a registrarlos
    public static boolean verificacionDePropietarios(String icPro) {
        String mensaje = "El propietario ingresado no consta en el sistema";
        boolean verificar = false;
        ArrayList<Propietario> propietarios;
        LecturaArchivoPropietario lecturaDePropietarios = 
                new LecturaArchivoPropietario("propietarios.txt");
        lecturaDePropietarios.establecerPropietarios();
        propietarios = lecturaDePropietarios.obtenerPropietarios();
        for (int i = 0; i < propietarios.size(); i++) {
            if (propietarios.get(i).obtenerIdentificacion().equals(icPro)) {
                mensaje = "El propietario ingresado si consta en el sistema";
                verificar = true;
            }
        }
        System.out.println(mensaje);
        return verificar;
    }
    //Se verifica que los datos de ubicaciones se encuentren registrados, caso
    //contrario se procede a registrarlos
    public static boolean verificacionDeUbicaciones(int numCasa) {
        String mensaje = "La ubicación ingresada no consta en el sistema";
        ArrayList<Ubicacion> ubicaciones;
        boolean verificar = false;
        LecturaArchivoUbicacion lecturaDeUbicaciones = 
                new LecturaArchivoUbicacion("ubicaciones.txt");
        lecturaDeUbicaciones.establecerUbicaciones();
        ubicaciones = lecturaDeUbicaciones.obtenerUbicaciones();
        for (int i = 0; i < ubicaciones.size(); i++) {
            int numC = ubicaciones.get(i).obtenerNumCasa();
            if (numC == numCasa) {
                mensaje = "La ubicación ingresada si consta en el sistema";
                verificar = true;
            }
        }
        System.out.println(mensaje);
        return verificar;
    }
    //Se verifica que los datos de ciudades se encuentren registrados, caso
    //contrario se procede a registrarlos
    public static boolean verificacionDeCiudades(String nameCiudad) {
        String mensaje = "La ciudad ingresada no consta en el sistema";
        ArrayList<Ciudad> ciudades;
        boolean verificar = false;
        LecturaArchivoCiudad lecturaDeCiudades = 
                new LecturaArchivoCiudad("ciudades.txt");
        lecturaDeCiudades.establecerCiudades();
        ciudades = lecturaDeCiudades.obtenerCiudades();
        for (int i = 0; i < lecturaDeCiudades.obtenerCiudades().size(); i++) {
            if (ciudades.get(i).obtenerNombreCiudad().toLowerCase()
                    .equals(nameCiudad.toLowerCase())) {
                mensaje = "La ciudad ingresada si consta en el sistema";
                verificar = true;
            }
        }
        System.out.println(mensaje);
        return verificar;
    }
    //Se verifica que los datos de las constructoras se encuentren registrados, 
    //caso contrario se procede a registrarlos
    public static boolean verificacionDeConstructoras(String idConstructora) {
        String mensaje = "La constructora ingresada no consta en el sistema";
        ArrayList<Constructora> constructoras;
        boolean verificar = false;
        LecturaArchivoConstructora lecturaDeConstructoras = 
                new LecturaArchivoConstructora("constructoras.txt");
        lecturaDeConstructoras.establecerConstructoras();
        constructoras = lecturaDeConstructoras.obtenerConstructoras();
        for (int i = 0; i < lecturaDeConstructoras.obtenerConstructoras().
                size(); i++) {
            if (constructoras.get(i).obtenerIDC().equals(idConstructora)) {
                mensaje = "La constructora ingresada si consta en el sistema";
                verificar = true;
            }
        }
        System.out.println(mensaje);
        return verificar;
    }
}
