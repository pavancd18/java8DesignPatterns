package comparing;

import comparing.function.Comparator;
import model.Person;

import java.util.List;

public class TestComparator {

    public static void main(String[] args) {
        Person p1 = new Person("pavan", 29);
        Person p2 = new Person("Sunil", 29);
        Person p3 = new Person("Sharat", 32);
        Person p4 = new Person("Prasad", 31);
        Person p5 = new Person("pavan", 30);

        List<Person> list = List.of(p1, p2, p3, p4);
        System.out.println(list);

        Comparator<Person> nameComparator = Comparator.comparing(Person::getName);
        Comparator<Person> ageComparator = Comparator.comparing(Person::getAge);
        System.out.println(nameComparator.compare(p1, p2));
        System.out.println(nameComparator.compare(p2, p3));
        System.out.println(nameComparator.compare(p3, p4));

        Comparator<Person> nameComparatorReversed = nameComparator.reverse();
        System.out.println(nameComparatorReversed.compare(p1, p2));
        System.out.println(nameComparatorReversed.compare(p2, p3));
        System.out.println(nameComparatorReversed.compare(p3, p4));

        Comparator<Person> nameAgeComparator = nameComparator.thenCompare(ageComparator);
        System.out.println(nameAgeComparator.compare(p1, p5));

        Comparator<Person> nameAgeComparator2 = nameComparator.thenCompare(Person::getAge);
        System.out.println(nameAgeComparator2.compare(p1, p5));
    }
}
