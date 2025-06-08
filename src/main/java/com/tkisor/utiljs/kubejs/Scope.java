package com.tkisor.utiljs.kubejs;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Scope {
    public <T, R> R let(T receiver, Function<T, R> block) {
        return block.apply(receiver);
    }

    public <T> T also(T receiver, Consumer<T> block) {
        block.accept(receiver);
        return receiver;
    }

    public <T> T takeIf(T receiver, Predicate<T> predicate) {
        return predicate.test(receiver) ? receiver : null;
    }

    public <T> T takeUnless(T receiver, Predicate<T> predicate) {
        return !predicate.test(receiver) ? receiver : null;
    }

    public <T, R> R with(T receiver, Function<T, R> block) {
        return block.apply(receiver);
    }
}
