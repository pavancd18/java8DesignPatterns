package comparing.function;

import chaining.function.Function;

import java.util.Objects;

@FunctionalInterface
public interface Comparator<T> {

    int compare(T t1, T t2);


    default Comparator<T> reverse() {
        return (t1, t2) -> this.compare(t2, t1);
    }

    default Comparator<T> thenCompare(Comparator<T> other) {
        Objects.requireNonNull(other);

        return (t1, t2) -> {
            int result = this.compare(t1, t2);
            return result != 0 ? result : other.compare(t1, t2);
        };
    }

    default <R extends Comparable<R>> Comparator<T> thenCompare(Function<T, R> keyExtractor) {
        Objects.requireNonNull(keyExtractor);
        return this.thenCompare(comparing(keyExtractor));
    }


    static <T, R extends Comparable<R>> Comparator<T> comparing(Function<T, R> keyExtractor) {
        Objects.requireNonNull(keyExtractor);

        return (T t1, T t2) -> keyExtractor.apply(t1).compareTo(keyExtractor.apply(t2));
    }
}
