import java.util.List;

public class Resident implements Comparable {
    private String name;

    public Resident(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Resident{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Object other) {
        Resident otherResident = (Resident) other;
        return this.getName().compareTo(otherResident.getName());
    }
}
