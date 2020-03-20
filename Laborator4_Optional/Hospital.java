import java.util.List;

public class Hospital implements Comparable {
    private String name;
    private int capacity;

    public Hospital(String name) {
        this.name = name;
    }

    public Hospital(String name, int capacity) {
        this.capacity = capacity;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public int compareTo(Object other) {
        Hospital otherHospital = (Hospital) other;
        return this.getName().compareTo(otherHospital.getName());
    }

    @Override
    public String toString() {
        return "Hospital{" +
                "name='" + name + '\'' +
                '}';
    }
}
