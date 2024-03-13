import models.Estudiante;
import models.Login;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        //Holaaaa
        //Intentando otra vez

        boolean finalizar=true;
        int selector;
        Scanner tetlado=new Scanner(System.in);
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
                                                System.out.println("actualizado");
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
                                                        } else {
                                                            System.out.println("Estudiante no encontrado, intente denuevo");
                                                        }
                                                        intentosBusqueda++;
                                                    } while (intentosBusqueda < 3);
                                                } else {
                                                    System.out.println("No hay estudiantes en la lista");
                                                }
                                                break;
                                            case 4:
                                                break;
                                            case 5:
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
}