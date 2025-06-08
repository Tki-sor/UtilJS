package com.tkisor.utiljs.kubejs;

import java.util.Objects;
import java.util.function.Supplier;

public class Assert {
    public <T> T assertNotNull(T value) {
        return assertNotNull(value, "Expected value to be non-null");
    }

    public <T> T assertNotNull(T value, String message) {
        if (value == null) throw new NullPointerException(message);
        return value;
    }

    public <T> T requireNotNull(T value) {
        return requireNotNull(value, "Required value was null");
    }

    public <T> T requireNotNull(T value, String message) {
        if (value == null) throw new NullPointerException(message);
        return value;
    }

    public <T> T requireNotNull(T value, Supplier<String> lazyMessage) {
        if (value == null) throw new NullPointerException(lazyMessage.get());
        return value;
    }

    public void assertTrue(boolean condition) {
        if (!condition) throw new AssertionError("Expected condition to be true");
    }

    public void assertTrue(boolean condition, String message) {
        if (!condition) throw new AssertionError(message);
    }

    public void assertFalse(boolean condition) {
        if (condition) throw new AssertionError("Expected condition to be false");
    }

    public void assertFalse(boolean condition, String message) {
        if (condition) throw new AssertionError(message);
    }

    public <T> void assertEquals(T expected, T actual) {
        if (!Objects.equals(expected, actual)) {
            throw new AssertionError("Expected: " + expected + ", but was: " + actual);
        }
    }

    public <T> void assertNotEquals(T unexpected, T actual) {
        if (Objects.equals(unexpected, actual)) {
            throw new AssertionError("Did not expect: " + actual);
        }
    }

    public void assertNull(Object obj) {
        if (obj != null) throw new AssertionError("Expected null, but was: " + obj);
    }

    public void fail() {
        throw new AssertionError("Test failed");
    }

    public void fail(String message) {
        throw new AssertionError(message);
    }
}
