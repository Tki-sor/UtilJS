package com.tkisor.utiljs;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public interface ScopeOps<T> {

    @SuppressWarnings("unchecked")
    default <R> R let(Function<T, R> block) {
        return block.apply((T) this);
    }

    @SuppressWarnings("unchecked")
    default T also(Consumer<T> block) {
        block.accept((T) this);
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    default T apply(Consumer<T> block) {
        block.accept((T) this);
        return (T) this;
    }

    default <R> R run(Supplier<R> block) {
        return block.get();
    }

    @SuppressWarnings("unchecked")
    default T takeIf(Predicate<T> predicate) {
        return predicate.test((T) this) ? (T) this : null;
    }

    @SuppressWarnings("unchecked")
    default T takeUnless(Predicate<T> predicate) {
        return !predicate.test((T) this) ? (T) this : null;
    }
}
