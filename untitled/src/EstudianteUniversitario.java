import java.util.List;

public class EstudianteUniversitario {
    private String nombre;
    private String apellidos;
    private String carrera;
    private Direccion direccion;
    private int edad;
    List<NumeroCelular> celulares;

    public EstudianteUniversitario(String nombre, String apellidos, String carrera, Direccion direccion, int edad) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.carrera = carrera;
        this.direccion = direccion;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public List<NumeroCelular> getCelulares() {
        return celulares;
    }

    public void setCelulares(List<NumeroCelular> celulares) {
        this.celulares = celulares;
    }
}
