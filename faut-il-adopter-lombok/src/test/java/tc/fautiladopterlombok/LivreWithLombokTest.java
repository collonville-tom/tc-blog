package tc.fautiladopterlombok;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LivreWithLombokTest {
    @Test
    public void testGetter() {
        LivreWithLombok livre = new LivreWithLombok("Clean Code");
        assertEquals("Clean Code", livre.getName());
    }

    @Test
    public void testSetter() {
        LivreWithLombok livre = new LivreWithLombok("Clean Code");
        livre.setName("Clean Architecture");

        assertEquals("Clean Architecture", livre.getName());
    }

    @Test
    public void testToString() {
        LivreWithLombok livre = new LivreWithLombok("Clean Code");

        assertEquals("LivreWithLombok(name=Clean Code)", livre.toString());
    }

    @Test
    public void testNotEquals() {
        LivreWithLombok cleanCode = new LivreWithLombok("Clean Code");
        LivreWithLombok otherBook = new LivreWithLombok("Clean Architecture");

        assertFalse(cleanCode.equals(otherBook));
    }

    @Test
    public void testEquals() {
        LivreWithLombok cleanCode = new LivreWithLombok("Clean Code");
        LivreWithLombok otherBook = new LivreWithLombok("Clean Code");

        assertTrue(cleanCode.equals(otherBook));
    }
}