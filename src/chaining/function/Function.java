package chaining.function;

import org.jetbrains.annotations.Nullable;

import java.util.Objects;

@FunctionalInterface
public interface Function<T, R> {
    R apply(T t);

    default <U> Function<T, U> thenApply(@Nullable Function<R, U> other) {
        Objects.requireNonNull(other);

        return (T t) -> {
            R r = this.apply(t);
            return other.apply(r);
        };
    }

    default <U> Function<U, R> composing(@Nullable Function<U, T> other) {
        Objects.requireNonNull(other);

        return (U u) -> {
            T t = other.apply(u);
            return this.apply(t);
        };
    }

    static <T> Function<T, T> indentity() {
        return t -> t;
    }
}
