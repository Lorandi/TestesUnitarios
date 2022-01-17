package br.lorandi.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class AssertTest {

    @Test
    void testTrue(){
        assertTrue(true);
    }

    @Test
    void testFalse(){
        assertFalse(false);
    }

    @Test
    void testEquals(){
        assertEquals(1,1, "Se deu ruim é pq não são iguais");
    }
}
