import com.github.javafaker.Faker;

import java.util.*;
import java.util.stream.IntStream;

public class Problem {
    List<Resident> residentList = new ArrayList<>();
    List<Hospital> hospitalList = new ArrayList<>();
    Map<Resident, List<Hospital>> residentPrefMap;
    Map<Hospital, List<Resident>> hospitalPrefMap;

    public Problem() {
    }

    public void generateProblem(int residentNumber, int hospitalNumber) {
        Faker faker = new Faker();
        var residents = IntStream.rangeClosed(0, residentNumber)
                .mapToObj(i -> new Resident(faker.name().fullName()))
                .toArray(Resident[]::new);
        var hospitals = IntStream.rangeClosed(0, hospitalNumber)
                .mapToObj(i -> new Hospital(faker.medical().hospitalName(),(int) (Math.random() * (residentNumber - 1) + 1)))
                .toArray(Hospital[]::new);
        residentList.addAll(Arrays.asList(residents));
        hospitalList.addAll(Arrays.asList(hospitals));
        residentPrefMap = new HashMap<>();
        hospitalPrefMap = new HashMap<>();
        for (Resident resident : residents) {
            int prefNumber = (int) (Math.random() * (hospitalNumber - 1) + 1);
            Random random = new Random();
            List hospitalRandList = new ArrayList();
            for (int i = 0; i < prefNumber; i++) {
                int hospitalPoz = random.nextInt(hospitalNumber);
                hospitalRandList.add(hospitals[hospitalPoz]);
            }
            residentPrefMap.put(resident, hospitalRandList);
        }
        for (Hospital hospital : hospitals) {
            int prefNumber = (int) (Math.random() * (residentNumber - 1) + 1);
            Random random = new Random();
            List residentRandList = new ArrayList();
            for (int i = 0; i < prefNumber; i++) {
                int residentPoz = random.nextInt(residentNumber);
                residentRandList.add(residents[residentPoz]);
            }
            hospitalPrefMap.put(hospital, residentRandList);
        }
    }

    public List<Resident> getResidentList() {
        return residentList;
    }

    public List<Hospital> getHospitalList() {
        return hospitalList;
    }

    public Map<Resident, List<Hospital>> getResidentPrefMap() {
        return residentPrefMap;
    }

    public Map<Hospital, List<Resident>> getHospitalPrefMap() {
        return hospitalPrefMap;
    }
}
