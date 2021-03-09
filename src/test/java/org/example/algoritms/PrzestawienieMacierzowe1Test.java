package org.example.algoritms;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrzestawienieMacierzowe1Test {
    private PrzestawienieMacierzowe1 test;
    @BeforeEach
    void setUp() {
        test = new PrzestawienieMacierzowe1();
    }

    @Test
    void checkKey() {

        assertEquals(true,test.checkKey("1-2-4-3"));
        assertEquals(false,test.checkKey("2-1-2-3"));
    }

    @Test
    void prepereString() {
        assertEquals("1243",test.prepereString("1-2-4-3"));
        assertNotEquals("123",test.prepereString("1-3-2"));
    }

    @Test
    void szyfroj() {
        assertEquals("YCPRGTROHAYPAOS",test.szyfroj("CRYPTOGRAPHYOSA","3142"));
    }

    @Test
    void odszyfroj() {
        assertEquals("CRYPTOGRAPHYOSA",test.odszyfroj("YCPRGTROHAYPAOS","3142"));
    }
}