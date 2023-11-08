import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Opt {
    public static void main(String[] args) {

        Optional<Optional<String>> anidado = Optional.of(Optional.of("valor 1"));

        Optional<String> simple = anidado.flatMap(innerOptional -> innerOptional);

        if (simple.isPresent()) {
            System.out.println("Valor aplanado: " + simple.get());
        } else {
            System.out.println("Valor aplanado ausente");
        }









        List<Optional<Integer>> optionalList1 = new ArrayList<>();

        optionalList1.add(Optional.of(3));
        optionalList1.add(Optional.of(10));
        optionalList1.add(Optional.of(4));

        for (Optional<Integer> optional : optionalList1) {
            System.out.println(optional.filter(v->v<5).map(g->g*2));
        }










        List<Optional<String>> optionalList = new ArrayList<>();

        optionalList.add(Optional.ofNullable("hola"));
        optionalList.add(Optional.empty());
        optionalList.add(Optional.ofNullable("gente"));

        for (Optional<String> optional : optionalList) {
            Optional<String> s = optional.filter(v -> v.length()>5);
            System.out.println(s);
        }


        for (Optional<String> optional : optionalList) {
            if(optional.isPresent()){
                String valorNoObtenido = optional.get();
                System.out.println("Valor obtenido: " + valorNoObtenido);
            }
        }




        for (Optional<String> optional : optionalList) {
            try {
                String valor = optional.orElseThrow(() -> new IllegalArgumentException("El Optional está vacío"));
                System.out.println("Valor obtenido: " + valor);
            } catch (IllegalArgumentException e) {
                System.err.println("Excepción capturada: " + e.getMessage());
            }
        }

/*
        for (Optional<String> string : optionalList) {
            String s = string.orElseGet(() -> "nuevoValor");
            System.out.println(s);
        }


        for (Optional<String> s : optionalList){
            if(s.isEmpty()) System.out.println("hay vacio");
        }


        for (Optional<String> s : optionalList){
            if(s.isPresent()) System.out.println(s.get());
        }


        for (Optional<String> s : optionalList) {
            String taVacio = s.orElse("ta vacio");
            System.out.println(taVacio);
        }

        optionalList.forEach(r -> r.ifPresent(value -> System.out.println(value)));

*/
    }
}
