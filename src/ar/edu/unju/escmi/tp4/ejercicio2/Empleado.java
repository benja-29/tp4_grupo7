package ar.edu.unju.escmi.tp4.ejercicio2;

public class Empleado {
    private int dni;
    private String nombre;
    private String apellido;
    private double sueldo;
    private char categoria;

    public Empleado(int dni, String nombre, String apellido, double sueldo, char categoria) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.sueldo = sueldo;
        this.categoria = categoria;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public char getCategoria() {
        return categoria;
    }

    public void setCategoria(char categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "DNI: " + dni + " | Nombre: " + nombre + " " + apellido + 
               " | Sueldo: $" + sueldo + " | Categoría: " + categoria;
    }
}