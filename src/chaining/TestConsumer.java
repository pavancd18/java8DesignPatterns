package chaining;

import chaining.function.Consumer;

public class TestConsumer {

    public static void main(String[] args) {
        Consumer<String> c1 = System.out::println;
        Consumer<String> c2 = System.out::println;
        String name = "pavan";

        System.out.println(c1);
        System.out.println(c2);

//        c1.accept(name);
//        c2.accept(name);

//        Consumer<String> c3 = s ->  {
//            c1.accept(s);
//            c2.accept(s);
//        };

//        c3.accept(name);

        Consumer<String> c4 = c1.andThen(c2);
        c4.accept(name);
    }
}
