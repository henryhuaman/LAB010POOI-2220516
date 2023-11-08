import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Principal {
    public static void main(String[] args) {
        /*
        List<EstudianteTemporal> lstET = new ArrayList<>();
        lstET.add(new EstudianteTemporal("Juan Pérez", 20));
        lstET.add(new EstudianteTemporal("María Rodríguez", 21));
        lstET.add( new EstudianteTemporal("Carlos González", 22));
        lstET.add( new EstudianteTemporal("Ana López", 23));
        lstET.add( new EstudianteTemporal("Luis Martínez", 24));
        lstET.add( new EstudianteTemporal("Laura Sánchez", 25));
        lstET.add( new EstudianteTemporal("Pedro Fernández", 26));
        lstET.add( new EstudianteTemporal("Sofía Jiménez", 27));
        lstET.add( new EstudianteTemporal("Diego Torres", 28));
        lstET.add( new EstudianteTemporal("Elena Ramírez", 29));
        lstET.add( new EstudianteTemporal("Andrés Vargas", 30));
        lstET.add( new EstudianteTemporal("Isabel Díaz", 31));
        lstET.add( new EstudianteTemporal("Javier Herrera", 32));
        lstET.add( new EstudianteTemporal("Carmen Ortega", 33));
        lstET.add( new EstudianteTemporal("Roberto Castro", 34));
        List<String> numbers = Arrays.asList("0","1","2","3","4","5","6","7","8","9");

        for(int i=0;i<lstET.size();i++){
            Direccion a = new Direccion("zipCode"+i, "calle"+i, "distrito"+i, "provincia"+i);

            EstudianteTemporal estET=lstET.get(i);

            List<NumeroCelular> suce =Stream.generate(() -> {
                        NumeroCelular umu = new NumeroCelular("9"+ Stream.generate(() -> {
                                    String cha = numbers.get(generarNumeroAleatorio(0,9));
                                    return cha;
                                }).limit(8)
                                .map(Objects::toString)
                                .collect(Collectors.joining())
                        );
                        return umu;
                    }).limit(generarNumeroAleatorio(1,6))
                    .toList();
            estET.setCelulares(suce);


            estET.setDireccion(a);
            lstET.set(i,estET);
        }

        Optional<EstudianteTemporal> estu = lstET.stream().filter(e->e.getNombre()=="Henry").
    */

        List<EstudianteUniversitario> estuUni = new ArrayList<>();
        estuUni.add(new EstudianteUniversitario("Juan", "Pérez", "Ingeniería", 20));
        estuUni.add(new EstudianteUniversitario("María", "Gómez", "Medicina", 22));
        estuUni.add(new EstudianteUniversitario("Carlos", "Sánchez", "Derecho", 21));
        estuUni.add(new EstudianteUniversitario("Luisa", "Martínez", "Arquitectura", 23));
        estuUni.add(new EstudianteUniversitario("Pedro", "Rodríguez", "Ciencias de la Computación", 19));
        estuUni.add(new EstudianteUniversitario("Ana", "López", "Psicología", 20));
        estuUni.add(new EstudianteUniversitario("Eduardo", "García", "Administración de Empresas", 22));
        estuUni.add(new EstudianteUniversitario("Laura", "Torres", "Biología", 21));
        estuUni.add(new EstudianteUniversitario("Andrés", "Fernández", "Economía", 24));
        estuUni.add(new EstudianteUniversitario("Sofía", "Hernández", "Historia", 20));
        estuUni.add(new EstudianteUniversitario("Miguel", "Ramírez", "Matemáticas", 22));
        estuUni.add(new EstudianteUniversitario("Isabel", "Díaz", "Física", 21));
        estuUni.add(new EstudianteUniversitario("Roberto", "Pérez", "Química", 23));
        estuUni.add(new EstudianteUniversitario("Silvia", "González", "Música", 20));
        estuUni.add(new EstudianteUniversitario("Javier", "Soto", "Idiomas", 22));
        List<String> numbers = Arrays.asList("0","1","2","3","4","5","6","7","8","9");

        for(int i=0;i<estuUni.size();i++){
            Direccion a = new Direccion("zipCode"+i, "calle"+i, "distrito"+i, "provincia"+i);

            EstudianteUniversitario estET=estuUni.get(i);

            List<NumeroCelular> suce =Stream.generate(() -> {
                        NumeroCelular umu = new NumeroCelular("9"+ Stream.generate(() -> {
                                    String cha = numbers.get(generarNumeroAleatorio(0,9));
                                    return cha;
                                }).limit(8)
                                .map(Objects::toString)
                                .collect(Collectors.joining())
                        );
                        return umu;
                    }).limit(generarNumeroAleatorio(1,6))
                    .toList();
            estET.setCelulares(suce);
            estET.setDireccion(a);
            estuUni.set(i,estET);
        }
        //a
        estuUni.stream().filter(e -> e.getNombre().equals("María")).findFirst().ifPresent(val-> System.out.println(val.getDireccion().getCalle()));
        //b
        Direccion d = new Direccion("zipCode1", "calle1", "distrito1", "provincia1");
        estuUni.stream().filter(e -> e.getDireccion().getZipCode().equals(d.getZipCode())).findFirst().ifPresent(val-> System.out.println(val.getNombre()));
        // c

    }

    public static int generarNumeroAleatorio(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("El valor mínimo debe ser menor que el valor máximo.");
        }

        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
}