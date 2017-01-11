import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Equipo e1 = new Equipo("Team 1", "Cornella");
        Equipo e2 = new Equipo("Team 2", "Sabadell");
        Equipo e3 = new Equipo("Team 3", "Barcelona");

        Jugador j1 = new Jugador("Player 1", LocalDate.of(1980, 2, 10), 400, e1);
        Jugador j2 = new Jugador("Player 2", LocalDate.of(1976, 7, 21), 600, e1);

        Jugador j3 = new Jugador("Player 3", LocalDate.of(1942, 8, 28), 550, e2);
        Jugador j4 = new Jugador("Player 4", LocalDate.of(1978, 9, 12), 100, e2);

        Jugador j5 = new Jugador("Player 5", LocalDate.of(1999, 1, 24), 999, e3);
        Jugador j6 = new Jugador("Player 6", LocalDate.of(1968, 9, 12), 798, e3);

        List<Jugador> lista = new ArrayList<Jugador>();
        lista.add(j1);
        lista.add(j2);
        lista.add(j3);
        lista.add(j4);
        lista.add(j5);
        lista.add(j6);

        //2.2
        System.out.println("------------->>>>> 2.2");
        lista.stream().filter(j -> j.getCanastas() > 500).forEach(System.out::println);

        //2.3
        System.out.println("------------->>>>> 2.3");
        lista.stream().filter(j -> j.getCanastas() > 200 && j.getCanastas()<500).forEach(System.out::println);

        //2.4
        System.out.println("------------->>>>> 2.4");
        lista.stream().filter(j -> j.getCanastas() > 200 && j.getCanastas()<500).map(Jugador::getNombre).forEach(System.out::println);

        //2.5
        System.out.println("------------->>>>> 2.5");
        lista.stream().sorted(Comparator.comparing(Jugador::getNacimiento)).forEach(System.out::println);

        //2.6
        System.out.println("------------->>>>> 2.6");
        lista.stream().sorted(Comparator.comparing(Jugador::getCanastas)).forEach(System.out::println);

        //2.7
        System.out.println("------------->>>>> 2.7");
        lista.stream().sorted(Comparator.comparing(Jugador::getCanastas)).limit(5).forEach(System.out::println);

        //2.8
        System.out.println("------------->>>>> 2.8");
        lista.stream().filter(j -> j.getCanastas() > 200 && j.getCanastas()<500).sorted(Comparator.comparing(Jugador::getNacimiento)).forEach(System.out::println);

        //2.9
        System.out.println("------------->>>>> 2.9");
        lista.stream().filter(j -> j.getCanastas() > 200 && j.getCanastas()<500).sorted(Comparator.comparing(Jugador::getCanastas).thenComparing(Jugador::getNacimiento)).forEach(System.out::println);

         //2.10
        System.out.println("------------->>>>> 2.10");
        System.out.println(lista.stream().reduce((x,y) -> x.getCanastas() < y.getCanastas() ? x : y));

        //2.11
        System.out.println("------------->>>>> 2.11");
        System.out.println(lista.stream().reduce((x,y) -> x.getCanastas() > y.getCanastas() ? x : y));

        //2.12
        System.out.println("------------->>>>> 2.12");
        System.out.println(lista.stream().collect(Collectors.averagingInt(j -> j.getCanastas())));

        // 2.13
        System.out.println("------------->>>>> 2.13");
        lista.stream().filter(j -> j.getEquipo().getCiudad().toUpperCase().equals("BARCELONA")).forEach(System.out::println);

        // 2.14
        System.out.println("------------->>>>> 2.14");
        System.out.println(lista.stream().anyMatch(j -> j.getCanastas() > 4000));

        // 2.15
        System.out.println("------------->>>>> 2.15");
        System.out.println(lista.stream().allMatch(j -> j.getCanastas() > 50));

        // 2.16
        System.out.println("------------->>>>> 2.16");
        System.out.println(lista.stream().filter(j -> j.getEquipo() == e1).allMatch(j -> j.getCanastas() > 50));

        // 2.17
        System.out.println("------------->>>>> 2.17");
        Map<String, List<Equipo>> map = lista.stream().map(Jugador::getEquipo).collect(Collectors.groupingBy(Equipo::getCiudad));
        System.out.println(map);

        // 2.18
        System.out.println("------------->>>>> 2.18");
        System.out.println(lista.stream().map(Jugador::getCanastas).reduce(0, (a, b) -> a+b));

        // Extra
        System.out.println("------------->>>>> EXTRAAAA");
        lista.stream().filter(j -> j.getEquipo().getNombre().toLowerCase().equals("equipo 1")).forEach(System.out::println);


    }
}
