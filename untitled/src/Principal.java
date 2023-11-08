import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Principal {
    public static void main(String[] args) {

        List<EstudianteUniversitario> estuUni = new ArrayList<>();
        estuUni.add(new EstudianteUniversitario("Juan", "Pérez", "Ingeniería", 20));
        estuUni.add(new EstudianteUniversitario("María", "Gómez", "Medicina", 22));
        estuUni.add(new EstudianteUniversitario("Carlos", "Sánchez", "Derecho", 21));
        estuUni.add(new EstudianteUniversitario("Luisa", "Martínez", "Arquitectura", 23));
        estuUni.add(new EstudianteUniversitario("Rafael", "Rodríguez", "Ciencias de la Computación", 19));
        estuUni.add(new EstudianteUniversitario("Ana", "López", "Psicología", 20));
        estuUni.add(new EstudianteUniversitario("Eduardo", "García", "Administración de Empresas", 22));
        estuUni.add(new EstudianteUniversitario("Laura", "Torres", "Biología", 21));
        estuUni.add(new EstudianteUniversitario("Ruth", "Fernández", "Economía", 24));
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
                    .collect(Collectors.toList());
                    suce.add(new NumeroCelular("912314675"));
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
        List<EstudianteUniversitario> asd= estuUni.stream().filter(e-> e.getCelulares().stream().anyMatch(c -> c.getNumero().equals("912314675"))).toList();
        for (EstudianteUniversitario c: asd
             ) {
            System.out.println(c.getNombre());
        }
        //d
        List<EstudianteUniversitario> dosNum= estuUni.stream().filter(e-> e.getCelulares().stream().anyMatch(c -> c.getNumero().equals("912314675") || c.getNumero().equals("946633271"))).toList();
        for (EstudianteUniversitario c: dosNum
        ) {
            System.out.println(c.getNombre());
        }
        //5 **************************************
        List<EstudianteTemporal> estuTemp = new ArrayList<>();
        //a
        for (int i=0;i<estuUni.size();i++){
            EstudianteTemporal temp = new EstudianteTemporal();
            temp.setNombre(estuUni.get(i).getNombre());
            temp.setEdad(estuUni.get(i).getEdad());
            temp.setDireccion(estuUni.get(i).getDireccion());
            temp.setCelulares(estuUni.get(i).getCelulares());
            estuTemp.add(temp);
        }
        //b
        List<String> strTemp = estuTemp.stream().map(r->r.getNombre()).toList();
        System.out.println(strTemp);
        //c
        List<String> representacionesComoCadenas = estuTemp.stream()
                .map(estudiante -> String.format("EstudianteUniversitario{nombre='%s', edad=%d, direccion=%s, numerosDeTelefono=[%s]}",
                        estudiante.getNombre(), estudiante.getEdad(),estudiante.getDireccion().getProvincia() ,estudiante.getCelulares().stream()
                                .map(celular -> celular.getNumero())
                                .collect(Collectors.joining(", "))))
                .collect(Collectors.toList());

        representacionesComoCadenas.forEach(System.out::println);
        //d
        List<String> strTempMay = strTemp.stream().map(s->s.toUpperCase()).toList();
        System.out.println(strTempMay);
        //e
        List<String> orden = strTempMay.stream().sorted((o1, o2) -> o1.compareTo(o2)).toList();
        System.out.println(orden);
        //f
        List<String> rOrden = orden.stream().filter(s -> s.startsWith("R")).sorted((o1, o2) -> o1.compareTo(o2)).toList();
        System.out.println(rOrden);


    }

    public static int generarNumeroAleatorio(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("El valor mínimo debe ser menor que el valor máximo.");
        }

        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
}