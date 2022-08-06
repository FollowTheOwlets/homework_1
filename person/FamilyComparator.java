import java.util.Comparator;
import java.util.Objects;

public class FamilyComparator implements Comparator<Person> {

    @Override
    public int compare(Person obj1, Person obj2) {
        if (Objects.equals(obj1.getFamily(), obj2.getFamily())) {
            return 0;
        }
        return obj1.getFamily().compareTo(obj2.getFamily());
    }
}
