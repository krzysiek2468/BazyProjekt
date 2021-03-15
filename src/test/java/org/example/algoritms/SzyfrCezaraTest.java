package org.example.algoritms;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SzyfrCezaraTest {
    private SzyfrCezara test;
    @BeforeEach
    void setUp() {
        test = new SzyfrCezara()    ;
    }

    @Test
    void szyfruj() {
        assertEquals("FUBSWRJUDSKB",test.szyfruj(test.usunSpacje("CRYPTOGRAPHY"),"3"));

    }

    @Test
    void odszyfruj() {
        assertEquals("CRYPTOGRAPHY",test.odszyfruj(test.usunSpacje("FUBSWRJUDSKB"),"3"));

    }
}