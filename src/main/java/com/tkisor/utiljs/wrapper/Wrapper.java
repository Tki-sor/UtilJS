package com.tkisor.utiljs.wrapper;
import dev.latvian.mods.kubejs.typings.Info;

import java.util.function.*;

public class Wrapper<T> {
    private final T value;

    public Wrapper(T value) {
        this.value = value;
    }

    @Info("Executes the given function with the wrapped value and returns the result. Returns null if the value is null.")
    public <R> R let(Function<T, R> block) {
        return value != null ? block.apply(value) : null;
    }

    @Info("Runs the given action with the value and returns the same Wrapper. No effect if the value is null.")
    public Wrapper<T> also(Consumer<T> block) {
        if (value != null) block.accept(value);
        return this;
    }

    @Info("Executes the given block and returns its result. Does not use the wrapped value.")
    public <R> R run(Supplier<R> block) {
        return block.get();
    }

    @Info("Returns this Wrapper if the value matches the predicate, otherwise returns an empty Wrapper.")
    public Wrapper<T> takeIf(Predicate<T> predicate) {
        if (value != null && predicate.test(value)) return this;
        return new Wrapper<>(null);
    }

    @Info("Returns this Wrapper if the value does not match the predicate, otherwise returns an empty Wrapper.")
    public Wrapper<T> takeUnless(Predicate<T> predicate) {
        if (value != null && !predicate.test(value)) return this;
        return new Wrapper<>(null);
    }

    @Info("Runs the given action on the value the specified number of times. Skipped if the value is null.")
    public Wrapper<T> repeat(int count, Consumer<T> block) {
        if (value != null) {
            for (int i = 0; i < count; i++) {
                block.accept(value);
            }
        }
        return this;
    }

    @Info("Returns the wrapped value.")
    public T get() {
        return value;
    }

}
