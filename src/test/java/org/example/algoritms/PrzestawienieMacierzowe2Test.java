package org.example.algoritms;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrzestawienieMacierzowe2Test {
    PrzestawienieMacierzowe2 test;
    @BeforeEach
    void setUp() {
        test = new PrzestawienieMacierzowe2();
    }

    @Test
    void szyfruj() {
        assertEquals("HECRN CEYI ISEP SGDI RNTO AAES RMPN SSRO EEBT ETIA EEHS ",test.szyfruj(test.usunSpacje("HERE IS A SECRET MESSAGE ENCIPHERED BY TRANSPOSITION"),"convenience"));
    }

    @Test
    void odszyfruj() {
        //assertEquals("HEREISASECRETMESSAGEENCIPHEREDBYTRANSPOSITION",test.odszyfruj(test.usunSpacje("HECRN CEYI ISEP SGDI RNTO AAES RMPN SSRO EEBT ETIA EEHS"),"convenience"));
    }
}