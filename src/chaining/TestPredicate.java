package chaining;

import chaining.function.Predicate;

public class TestPredicate {

    public static void main(String[] args) {
        Predicate<String> p1 = s -> s != null;
        Predicate<String> p2 = s -> !(s.length() == 0);
        String name = "pavan";

        Predicate<String> p3 = s -> p1.test(s) && p2.test(s);

        System.out.println(p3.test(name));

        Predicate<String> p4 = p2.and(p1);

        System.out.println(p4.test(name));

        Predicate<String> p6 = p1.and(p2.negate());
        System.out.println(p6.test(name));

    }
}
