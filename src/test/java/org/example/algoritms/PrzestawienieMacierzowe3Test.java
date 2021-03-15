package org.example.algoritms;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrzestawienieMacierzowe3Test {

    PrzestawienieMacierzowe3 test;
    @BeforeEach
    void setUp() {
        test = new PrzestawienieMacierzowe3();
    }

    @Test
    void checkKey() {
    }

    @Test
    void szyfruj() {

        assertEquals("HEESPNI RR SSEES EIY A SCBT EMGEPN ANDI CT RTAHSO IEERO ",test.szyfruj(test.usunSpacje("HERE IS A SECRET MESSAGE ENCIPHERED BY TRANSPOSITION"),"convenience"));

    }

    @Test
    void odszyfruj() {
        assertEquals("HEREISASECRETMESSAGEENCIPHEREDBYTRANSPOSITION",test.odszyfruj(test.usunSpacje("HEESPNI RR SSEES EIY A SCBT EMGEPN ANDI CT RTAHSO IEERO"),"convenience"));

    }
}