import com.github.javafaker.Faker;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        /* COMPULSORY
        var r = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Resident("R" + i))
                .toArray(Resident[]::new);

        //Create a list of residents, using an ArrayList implementation. Sort the residents, using a comparator.
        List<Resident> residentList = new ArrayList<>();
        residentList.addAll(Arrays.asList(r));
        residentList.sort(Comparator.comparing(Resident::getName));

        //Create a set of hospitals, using a TreeSet implementation. Make sure that Hospital objects are comparable.
        var h = IntStream.rangeClosed(0, 2)
                .mapToObj(i -> new Hospital("H" + i))
                .toArray(Hospital[]::new);
        Set<Hospital> hospitalList = new TreeSet<>(Arrays.asList(h));

        //Create two maps (having different implementations) describing the residents and the hospital preferences and print them on the screen.
        Map<Resident, List<Hospital>> residentPrefMap = new HashMap<>();
        residentPrefMap.put(r[0], Arrays.asList(h[0], h[1], h[2]));
        residentPrefMap.put(r[1], Arrays.asList(h[0], h[1], h[2]));
        residentPrefMap.put(r[2], Arrays.asList(h[0], h[1]));
        residentPrefMap.put(r[3], Arrays.asList(h[0], h[2]));

        Map<Hospital, List<Resident>> hospitalPrefMap = new TreeMap<>();
        hospitalPrefMap.put(h[0], Arrays.asList(r[3], r[0], r[1], r[2]));
        hospitalPrefMap.put(h[1], Arrays.asList(r[0], r[2], r[1]));
        hospitalPrefMap.put(h[2], Arrays.asList(r[0], r[1], r[3]));

        //display the residents who find acceptable H0 and H2
        List<Hospital> target = Arrays.asList(h[0], h[2]);
        List<Resident> result = residentList.stream()
                .filter(res -> residentPrefMap.get(res).containsAll(target))
                .collect(Collectors.toList());
        System.out.println(result);

        //the hospitals that have R0 as their top preference
        System.out.println("Hospitals that have R0 as their top preference: ");
        hospitalList.stream()
                .filter(rez -> hospitalPrefMap.get(rez).get(0) == r[0])
                .forEach(System.out::println);
        */
        //OPTIONAL
        Problem problem = new Problem();
        problem.generateProblem(10, 15);
        Matching matching = new Matching();
        //generate a matching - First come, first served
        matching.algorithm(problem);
        //verify if it's stable
        if (matching.verifyStable(problem)) {
           System.out.println("The matching is stable!");
        } else {
            System.out.println("The matching is not stable!");
        }
    }

}
