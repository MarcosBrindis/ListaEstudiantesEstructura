package models;

import java.util.HashMap;
import java.util.Random;

public class Estudiante {
    private int ageIngreso;
    private String matricula;
    private String name;
    private String lastname;
    private HashMap<String,Double> materias =new HashMap<>();

    public Estudiante(int ageIngreso, String matricula, String name, String lastname, HashMap<String, Double> materias) {
        this.ageIngreso = ageIngreso;
        this.matricula = matricula;
        this.name = name;
        this.lastname = lastname;
        this.materias = materias;
    }

    public Estudiante() {
    }


    public int getAgeIngreso() {
        return ageIngreso;
    }

    public void setAgeIngreso(int ageIngreso) {
        this.ageIngreso = ageIngreso;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public HashMap<String, Double> getMaterias() {
        return materias;
    }

    public void setMaterias(HashMap<String, Double> materias) {
        this.materias = materias;
    }

    public String generarNumeroMatricula(int ageIngreso) {
        Random rand = new Random();
        int numeroAleatorio = rand.nextInt(10000);
        return String.format("%02d", ageIngreso) + String.format("%04d", numeroAleatorio);
    }


    public void inicializarMaterias() {
        String[] nombresMaterias = {"Inglés", "POO", "Estructura de datos", "Cálculo diferencial"};
        for (String nombreMateria : nombresMaterias) {
            materias.put(nombreMateria, 0.00);
        }
    }
    public double calcularPromedio() {
        double sumaCalificaciones = 0;
        for (Double calificacion : materias.values()) {
            sumaCalificaciones += calificacion;
        }
        return sumaCalificaciones / 4;
    }

    public String imprimirDatos() {
        String imprimir = "Matrícula: " + matricula + "\n";
        imprimir += "Nombre completo: " + name + " " + lastname + "\n";
        imprimir += "Promedio general: " + calcularPromedio();
        return imprimir;
    }
}
