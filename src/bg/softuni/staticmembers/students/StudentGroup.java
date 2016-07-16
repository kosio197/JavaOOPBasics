package bg.softuni.staticmembers.students;

import java.util.HashSet;
import java.util.Set;

public class StudentGroup {

    private Set<String> set;

    public StudentGroup() {
        this.set = new HashSet<>();
    }

    public Set<String> getSet() {
        return set;
    }

}
