package chaining.function;

import org.jetbrains.annotations.Nullable;

import java.util.Objects;

@FunctionalInterface
public interface Consumer<T> {

    void accept(T t);

    default Consumer<T> andThen(@Nullable Consumer<T> another) {
        Objects.requireNonNull(another);

        return (T t) ->  {
            this.accept(t);
            another.accept(t);
        };

//        return new Consumer<T>() {
//            @Override
//            public void accept(T t) {
//                this.accept(t);
//                another.accept(t);
//            }
//        };
    }
}
