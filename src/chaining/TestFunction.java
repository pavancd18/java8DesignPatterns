package chaining;

import chaining.function.Function;
import model.Meteo;

public class TestFunction {
    public static void main(String[] args) {

        Function<Meteo, Integer> f1 = Meteo::getTemperature;
        Function<Integer, Double> f2 = temp -> (temp * 9d / 5d) + 32d;
        Function<Double, String> f6 = temp -> temp + " c";
        Meteo m = new Meteo(10);

        Function<Meteo, Double> f3 = meteo -> {
            int temp = f1.apply(meteo);
            return f2.apply(temp);
        };

        System.out.println(f3.apply(m));

        Function<Meteo, String> f4 = f1.thenApply(f2).thenApply(f6);

        System.out.println(f4.apply(m));

        Function<Meteo, Double> f5 = f2.composing(f1);

        System.out.println(f5.apply(m));
        Function<String, String> f8 = Function.indentity();
        System.out.println(f8.apply("pavan"));
    }
}
