import models.Estudiante;
import models.Login;

import java.util.HashMap;
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
                                                String apellido=

                                                break;
                                            case 2:
                                                System.out.println("actualizado");
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                            case 5:
                                                break;
                                            case 6:
                                                repetir = false;
                                                break;

                                        }
                                        } catch (java.util.InputMismatchException e) {
                                            System.out.println("Error: Ingresa un número válido");
                                            tetlado.next();
                                        }
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
            } catch (java.util.InputMismatchException e) {
                System.out.println("Error: Ingresa un número válido");
                tetlado.next();
            }

        }

    }
}