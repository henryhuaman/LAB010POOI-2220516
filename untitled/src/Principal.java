import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Principal {
    public static void main(String[] args) {
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

            estET.setCelulares( Stream.generate(() -> {
                        NumeroCelular umu = new NumeroCelular("9"+ Stream.generate(() -> {
                                    String cha = numbers.get(generarNumeroAleatorio(0,9));
                                    return cha;
                                }).limit(8)
                                .map(Objects::toString)
                                .collect(Collectors.joining())
                        );
                        return umu;
                    }).limit(generarNumeroAleatorio(1,10))
                    .toList()
            );
            estET.setDireccion(a);
            lstET.add(i,estET);
        }



    }

    public static int generarNumeroAleatorio(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("El valor mínimo debe ser menor que el valor máximo.");
        }

        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
}