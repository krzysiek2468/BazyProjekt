package org.example.algoritms;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RailFenceTest {
    private RailFence test;
    @BeforeEach
    void setUp() {
        test = new RailFence();
    }

    @Test
    void checkKey() {
        assertEquals(true,test.checkKey("10"));
    }

    @Test
    void szyfruj() {
        assertEquals("CTARPORPYYGH",test.szyfruj(test.usunSpacje("CRYPTO GRAPHY"),3));
    }

    @Test
    void rozszyfruj() {
        assertEquals("CRYPTOGRAPHY",test.rozszyfruj("CTARPORPYYGH",3));
    }
}