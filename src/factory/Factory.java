package factory;

import model.Circle;

import java.awt.*;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public interface Factory<T> extends Supplier<T> {

    default T newInstance() {
        return get();
    }

    default List<T> get5Circles() {
        return IntStream.range(0, 5).mapToObj(index -> newInstance()).collect(Collectors.toList());
    }

    static <T> Factory<T> getFactory(Supplier<T> supplier) {
        return supplier::get;
    }

    static <T> Factory<T> getSingletonFactory(Supplier<T> supplier) {
        T singleton = supplier.get();
        return () -> singleton;
    }

    //Partial Application - take a funtion and make it a supplier by fixing the parameter taken by this function
    static <R, T> Factory<T> getFactory(Function<R, T> constructor, R r) {
        return () -> constructor.apply(r);
    }
}
