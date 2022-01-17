package br.lorandi.service;

import br.lorandi.entidades.Usuario;
import org.junit.jupiter.api.Test;

import java.util.Locale;


import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class AssertTest {
    Usuario u1 = new Usuario("Rodrigo");
    Usuario u2 = new Usuario("Rodrigo");
    Usuario u3 = u2;
    Usuario u4 = null;

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

    @Test
    void testDouble(){
        assertEquals(Math.PI, 3.14, 0.01);
        // double precisa dos valores e do delta da margem de erro
    }

    @Test
    void testInteger(){
        int i = 5;
        Integer j = 5;
        assertEquals(i,j);
        assertEquals(Integer.valueOf(i),j);
        assertEquals(i,j.intValue());
    }

    @Test
    void testString(){
        String s1 = "Bola";
        String s2 = "boLa";

        assertEquals(s1.toUpperCase(Locale.ROOT),s2.toUpperCase(Locale.ROOT));
        assertTrue(s1.equalsIgnoreCase(s2));
        assertEquals(true, s1.equalsIgnoreCase(s2));
    }

    @Test
    void testUsuario(){

        assertEquals(u1,u2);
        // verdadeiro quando adicionado o equals na classe Usuario

        assertSame(u3,u2);
    }

    @Test
    void testNull(){
        assertNull(u4);
    }
}
