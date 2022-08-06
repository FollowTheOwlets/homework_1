import enums.Education;
import enums.Sex;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static final List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
    private static final List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
    private static int teenagerCount;
    private static List<String> armyList;
    private static List<Person> workersList;

    public static void main(String[] args) {
        Collection<Person> persons = generate();

        teenagerCount = (int) persons.stream()
                .filter(p -> p.getAge() < 18)
                .count();

        armyList = persons.stream()
                .filter(p -> p.getSex() == Sex.MAN)
                .filter(p -> p.getAge() > 17 && p.getAge() < 28)
                .map(Person::getFamily)
                .collect(Collectors.toList());

        workersList = persons.stream()
                .filter(p -> p.getEducation() == Education.HIGHER)
                .filter(p -> (
                        p.getAge() > 17 && p.getAge() < 60 && p.getSex() == Sex.WOMAN) ||
                        (p.getAge() > 17 && p.getAge() < 65 && p.getSex() == Sex.MAN)
                )
                .sorted(new FamilyComparator())
                .collect(Collectors.toList());

    }

    public static Collection<Person> generate() {
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }
        return persons;
    }
}


