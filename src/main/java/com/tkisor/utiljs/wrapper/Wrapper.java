package com.tkisor.utiljs.wrapper;
import java.util.function.*;

public class Wrapper<T> {
    private final T value;

    public Wrapper(T value) {
        this.value = value;
    }

    public <R> R let(Function<T, R> block) {
        return value != null ? block.apply(value) : null;
    }

    public Wrapper<T> also(Consumer<T> block) {
        if (value != null) block.accept(value);
        return this;
    }

    public Wrapper<T> apply(Consumer<T> block) {
        if (value != null) block.accept(value);
        return this;
    }

    public <R> R run(Supplier<R> block) {
        return block.get();
    }

    public Wrapper<T> takeIf(Predicate<T> predicate) {
        if (value != null && predicate.test(value)) return this;
        return new Wrapper<>(null);
    }

    public Wrapper<T> takeUnless(Predicate<T> predicate) {
        if (value != null && !predicate.test(value)) return this;
        return new Wrapper<>(null);
    }

    public Wrapper<T> alsoIf(Predicate<T> predicate, Consumer<T> block) {
        if (value != null && predicate.test(value)) block.accept(value);
        return this;
    }

    public Wrapper<T> repeat(int count, Consumer<T> block) {
        if (value != null) {
            for (int i = 0; i < count; i++) {
                block.accept(value);
            }
        }
        return this;
    }

    public Wrapper<T> ifElse(Predicate<T> predicate, Consumer<T> ifBlock, Consumer<T> elseBlock) {
        if (value != null) {
            if (predicate.test(value)) {
                ifBlock.accept(value);
            } else {
                elseBlock.accept(value);
            }
        }
        return this;
    }

    public T get() {
        return value;
    }

    public T unwrap() {
        return value;
    }

}
