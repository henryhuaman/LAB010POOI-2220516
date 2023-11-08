import java.util.List;

public class EstudianteTemporal {
        private String nombre;
        private int edad;
        private Direccion direccion;
    List<NumeroCelular> celulares;

    public EstudianteTemporal(String nombre, int edad, Direccion direccion, List<NumeroCelular> celulares) {
        this.nombre = nombre;
        this.edad = edad;
        this.direccion = direccion;
        this.celulares = celulares;
    }
    public EstudianteTemporal(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public EstudianteTemporal() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public List<NumeroCelular> getCelulares() {
        return celulares;
    }

    public void setCelulares(List<NumeroCelular> celulares) {
        this.celulares = celulares;
    }

}
