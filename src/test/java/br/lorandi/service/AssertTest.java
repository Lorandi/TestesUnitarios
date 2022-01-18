package br.lorandi.service;

import br.lorandi.entidades.Usuario;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class AssertTest {
    Usuario u1 = new Usuario("Rodrigo");
    Usuario u2 = new Usuario("Rodrigo");
    Usuario u3 = u2;
    Usuario u4 = null;

    String s1 = "boLa";
    String s2 = "Bola";
    String s3 = "Bolas";

    int i = 5;
    Integer j = 5;

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
        assertEquals(u1,u2);
        // verdadeiro quando adicionado o equals na classe Usuario
    }

    @Test
    void testSame(){
        //mesma instância
        assertSame(u3,u2);
        assertNotSame(u3,u1);
    }

    @Test
    void testNull(){
        assertNull(u4);
        assertNotNull(u1);
    }

    @Test
    void testThat(){
        assertThat(i, CoreMatchers.is(j));
        assertThat(i, CoreMatchers.not(7));
    }

    @Test
    void testDouble(){
        assertEquals(Math.PI, 3.14, 0.01);
        // double precisa dos valores e do delta da margem de erro
    }

    @Test
    void testInteger(){
        assertEquals(i,j);
        assertEquals(Integer.valueOf(i),j);
        assertEquals(i,j.intValue());
    }

    @Test
    void testString(){
        assertEquals(s1.toUpperCase(Locale.ROOT),s2.toUpperCase(Locale.ROOT));
        assertNotEquals(s1,s3);

        assertTrue(s1.equalsIgnoreCase(s2));
        assertEquals(true, s1.equalsIgnoreCase(s2));
    }
}
