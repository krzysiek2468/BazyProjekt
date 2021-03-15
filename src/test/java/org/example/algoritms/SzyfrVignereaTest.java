package org.example.algoritms;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class SzyfrVignereaTest {
    private SzyfrVigenerea test;
    @BeforeEach
    void setUp() {
        test = new SzyfrVigenerea();
    }

    @Test
    void checkKey() {

        assertEquals(true,test.checkKey("breakbreakbr"));
        assertEquals(false,test.checkKey("brea3kb32"));
    }
    @Test
    void decryption(){
        assertEquals("cryptography",test.decryptionText("dicpdpxvazip","breakbreakbr"));
    }


    @Test
    void szyfruj() {
        assertEquals("dicpdpxvazip",test.szyfruj("cryptography","breakbreakbr"));
    }

    @Test
    void odszyfruj() {
        assertEquals("cryptography",test.odszyfruj("dicpdpxvazip","breakbreakbr"));
    }
}