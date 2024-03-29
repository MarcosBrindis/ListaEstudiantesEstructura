import models.Estudiante;
import models.Login;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    static Scanner tetlado=new Scanner(System.in);

    public static void main(String[] args) {

        //Holaaaa
        //Intentando otra vez

        boolean finalizar=true;
        int selector;
        ArrayList<Login>lista= new ArrayList<>();
        ArrayList<Estudiante>listaEstudiantes=new ArrayList<>();
        HashMap<String,Estudiante> clonListaEstudiantes =new HashMap<>();

        while (finalizar){
            System.out.println("1) agregar usuario");
            System.out.println("2) iniciar sesion");
            System.out.println("3) finalizar");
            try{
                selector=tetlado.nextInt();
                switch (selector){

                    case 1:
                        System.out.println("ingresa nombre de usuario");
                        String name = tetlado.next();
                        Login name1 =new Login(name);

                        if(!lista.contains(name1)) {
                            System.out.println("ingresa contraseña de 6 digitos xxxxxx y que no empieze con un numero");
                            boolean repetir = true;

                            while (repetir) {
                                String password = tetlado.next();
                                char esnumero = password.charAt(0);

                                if (!Character.isDigit(esnumero) && password.length() == 6) {
                                    while (repetir){
                                        System.out.println("El usuario es correcto: " + name + " "+password +" s/n");
                                        String respuesta = tetlado.next();

                                        if (respuesta.equalsIgnoreCase("s")) {
                                            Login u1 = new Login(name, password);
                                            lista.add(u1);
                                            System.out.println("Usuario agregado correctamente");
                                            repetir = false;
                                        } else if (respuesta.equalsIgnoreCase("n")) {
                                            System.out.println("Usuario no se creó");
                                            repetir = false;
                                        } else {
                                            System.out.println("Opción inválida");
                                        }
                                    }
                                } else {
                                    System.out.println("Contraseña no cumple con el tamaño de 6 caracteres o el primer carácter es un número\n" +
                                            "Intente de nuevo\n" +
                                            "------------------------------------------------------------------------------------------");
                                }
                            }
                        }else{
                            System.out.println("usurario repetido");
                        }
                        break;



                    case 2:
                        boolean existeUsuario = false;
                        System.out.println("Ingrese su usuario:");
                        String usuario = tetlado.next();
                        for (Login u1 : lista) {
                            if (usuario.equals(u1.getName())) {
                                existeUsuario = true;
                                boolean repetir = true;
                                for (int i = 0; i < 3 && repetir; i++) {
                                    System.out.println("Ingrese su contraseña:");
                                    String passwordBusqueda = tetlado.next();
                                    if (passwordBusqueda.equals(u1.getPassword())) {
                                        boolean salirmenu=true;
                                        do {
                                        System.out.println("************************");
                                        System.out.println("***** Bienvenido ********");
                                        System.out.println("************************\n");
                                        System.out.println("1) Agregar alumno a la lista");
                                        System.out.println("2) Eliminar alumno de la lista");
                                        System.out.println("3) Buscar alumno en la lista");
                                        System.out.println("4) Modificar calificaciones");
                                        System.out.println("5) Imprimir alumnos de la lista");
                                        System.out.println("6) Cerrar sesion ");
                                        try{
                                        selector=tetlado.nextInt();
                                        switch (selector){
                                            case 1:
                                                System.out.println("año de ingreso");
                                                int ageIngreso=tetlado.nextInt();
                                                ageIngreso = ageIngreso % 100;
                                                System.out.println("ingrese nombre del estudiante");
                                                String nombre=tetlado.next();
                                                System.out.println("ingrese apellido");
                                                String apellido=tetlado.next();
                                                Estudiante estudiante = new Estudiante();
                                                String matricula= estudiante.generarNumeroMatricula(ageIngreso);
                                                System.out.println("la matricula de "+ nombre+" es:"+matricula);
                                                boolean noEncontrada=true;

                                                if (listaEstudiantes.isEmpty()){
                                                    Estudiante nuevoEstudiante=new Estudiante(ageIngreso,matricula,nombre,apellido,estudiante.getMaterias());
                                                    listaEstudiantes.add(nuevoEstudiante);
                                                }
                                                else{
                                                    for (Estudiante matriculaExiste:listaEstudiantes){
                                                        if (matricula.equals(matriculaExiste.getMatricula())){
                                                            System.out.println("matricula ya existe");
                                                        }
                                                        else {
                                                            noEncontrada=false;
                                                        }
                                                    }
                                                    if (!noEncontrada){
                                                        Estudiante nuevoEstudiante=new Estudiante(ageIngreso,matricula,nombre,apellido,estudiante.getMaterias());
                                                        listaEstudiantes.add(nuevoEstudiante);
                                                    }
                                                }
                                                break;
                                            case 2:
                                                if (!listaEstudiantes.isEmpty()) {
                                                    System.out.println("Ingrese matricula de alumno a eliminar");
                                                    String matriculaEliminar = tetlado.next();
                                                    if (matriculaEliminar.length() == 6) {
                                                        for (Estudiante iterador : listaEstudiantes) {
                                                            clonListaEstudiantes.put(iterador.getMatricula(), iterador);
                                                        }
                                                        if (!(clonListaEstudiantes.get(matriculaEliminar) == null)){
                                                            if (listaEstudiantes.remove(clonListaEstudiantes.get(matriculaEliminar)))
                                                                System.out.println("Estudiante borrado con exito");
                                                        } else {
                                                            System.out.println("Estudiante no encontrado");
                                                        }
                                                    } else {
                                                        System.out.println("La matricula debe llevar 6 caracteres");
                                                    }
                                                }
                                                break;
                                            case 3:
                                                if (!listaEstudiantes.isEmpty()) {
                                                    for (Estudiante iterador : listaEstudiantes) {
                                                        clonListaEstudiantes.put(iterador.getMatricula(), iterador);
                                                    }
                                                    int intentosBusqueda = 0;
                                                    do {
                                                        System.out.println("Ingrese la matricula a buscar");
                                                        String matriculaBusqueda = tetlado.next();
                                                        if (!(clonListaEstudiantes.get(matriculaBusqueda) == null)) {
                                                            System.out.println(clonListaEstudiantes.get(matriculaBusqueda).imprimirDatos());
                                                            intentosBusqueda=3;
                                                        } else {
                                                            System.out.println("Estudiante no encontrado");
                                                        }
                                                        intentosBusqueda++;
                                                    } while (intentosBusqueda < 3);
                                                } else {
                                                    System.out.println("No hay estudiantes en la lista");
                                                }
                                                break;
                                            case 4:
                                                if (!listaEstudiantes.isEmpty()) {
                                                    System.out.println("Ingrese matricula de alumno a editar");
                                                    String matriculaEditar = tetlado.next();
                                                    if (matriculaEditar.length() == 6) {
                                                        for (Estudiante iterador : listaEstudiantes) {
                                                            clonListaEstudiantes.put(iterador.getMatricula(), iterador);
                                                        }
                                                        if (!(clonListaEstudiantes.get(matriculaEditar) == null)) {
                                                            clonListaEstudiantes.get(matriculaEditar).inicializarMaterias();
                                                            System.out.println("Agrege la calificacion de Ingles");
                                                            clonListaEstudiantes.get(matriculaEditar).setMaterias("Inglés",agregarCalificacion());
                                                            System.out.println("Agrege la calificacion de POO");
                                                            clonListaEstudiantes.get(matriculaEditar).setMaterias("POO",agregarCalificacion());
                                                            System.out.println("Agrege la calificacion de Estructura de datos");
                                                            clonListaEstudiantes.get(matriculaEditar).setMaterias("Estructura de datos",agregarCalificacion());
                                                            System.out.println("Agrege la calificacion de Cálculo diferencial");
                                                            clonListaEstudiantes.get(matriculaEditar).setMaterias("Cálculo diferencial",agregarCalificacion());
                                                        } else {
                                                            System.out.println("Estudiante no encontrado");
                                                        }
                                                    } else {
                                                        System.out.println("La matricula debe llevar 6 caracteres");
                                                    }
                                                } else {
                                                    System.out.println("No hay estudiantes en la lista");
                                                }
                                                break;
                                            case 5:
                                                if (!listaEstudiantes.isEmpty()){
                                                    for (Estudiante iterador : listaEstudiantes){
                                                        System.out.println(iterador.imprimirDatos());
                                                    }
                                                } else {
                                                    System.out.println("No hay estudiantes en la lista");
                                                }
                                                break;
                                            case 6:
                                                repetir = false;
                                                salirmenu=false;
                                                break;

                                        }
                                        } catch (InputMismatchException e) {
                                            System.out.println("Error: Ingresa un número válido");
                                            tetlado.next();
                                        }
                                        }while (salirmenu);
                                    } else {
                                        if (i == 2)
                                            finalizar = false;
                                        else
                                            System.out.println("Contraseña incorrecta\n" +
                                                    "Intente de nuevo\n" +
                                                    "--------------------------------");
                                    }
                                }
                            }
                        }
                        if (!existeUsuario)
                            System.out.println("Usuario no encontrado");
                        break;

                    case 3:
                        finalizar=false;
                        System.out.println("programa finalizado");
                        break;
                    default:
                        System.out.println("opcion invalida intente de nuevo");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingresa un número válido");
                tetlado.next();
            }

        }

    }
    public static double agregarCalificacion(){
        double calificacion = 0;
        do {
            System.out.println("Agrege calificacion de 10 a 100");
            calificacion = tetlado.nextDouble();
        } while (calificacion < 10 || calificacion > 100);
        return calificacion;
    }
}