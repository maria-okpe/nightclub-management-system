package com.nightclub.nightclub_management;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SampleTest {
    @Test
    void testAddition() {
        assertEquals(5, 2 + 3); // should pass
    }

    @Test
    void testAdditionShouldFail() {
        int result = 2 + 3;
        assertEquals(6, result); // ❌ Intentionally wrong expected value
    }
}
