package com.martinbg.electricityapi;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public interface BigDecimalAssertion {

    default void assertBigDecimalEquals(BigDecimal expected, BigDecimal actual) {
        assertEquals(0, expected.compareTo(actual));
    }
}
