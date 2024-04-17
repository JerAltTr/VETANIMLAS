package veterinariaapp;

/**
 *
 * @author HP
 */
public class CPaciente {
    private String nombre;
    private int edad;
    private String raza;
    private double peso;

    public CPaciente(String nombre, int edad, String raza, double peso) {
        this.nombre = nombre;
        this.edad = edad;
        this.raza = raza;
        this.peso = peso;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getRaza() {
        return raza;
    }

    public double getPeso() {
        return peso;
    }
    
}
