import java.util.*;

public class Matching {
    private Map<Resident, Hospital> matching;

    public Matching() {
        matching = new HashMap<>();
    }

    public void algorithm(Problem problem) {
        List<Resident> residentList = problem.getResidentList();
        // List<Hospital> hospitalList = problem.getHospitalList();
        Map<Resident, List<Hospital>> residentPrefMap = problem.getResidentPrefMap();
        // Map<Hospital, List<Resident>> hospitalPrefMap = problem.getHospitalPrefMap();

        List<Hospital> assignedHospital = new ArrayList<>();
        for (Resident resident : residentList) {
            List<Hospital> resPref = residentPrefMap.get(resident);
            for (Hospital hospital : resPref) {
                if (Collections.frequency(assignedHospital,hospital) < hospital.getCapacity()) {
                    assignedHospital.add(hospital);
                    matching.put(resident, hospital);
                    break;
                }
            }
        }
    }

    //AM ADAUGAT SI ULTIMA CERINTA DE LA OPTIONAL - Verify if the matching produced by your algorithm is stable.
    public boolean verifyStable(Problem problem) {
        List<Resident> residentList = problem.getResidentList();
        List<Hospital> hospitalList = problem.getHospitalList();
        Map<Resident, List<Hospital>> residentPrefMap = problem.getResidentPrefMap();
        for (Hospital hospital : hospitalList) {
            for (Resident resident : residentList) {
                //verify if the resident prefers other hospital better than the one he was assigned to
                if (residentPrefMap.get(resident).contains(hospital)) {
                    if (residentPrefMap.get(resident).indexOf(hospital) < residentPrefMap.get(resident).indexOf(matching.get(resident))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
