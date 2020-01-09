package tc.fautiladopterlombok;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LivreTest {

    @Test
    public void testGetter() {
        Livre livre = new Livre("Clean Code");
        assertEquals("Clean Code", livre.getName());
    }

    @Test
    public void testSetter() {
        Livre livre = new Livre("Clean Code");
        livre.setName("Clean Architecture");

        assertEquals("Clean Architecture", livre.getName());
    }

    @Test
    public void testToString() {
        Livre livre = new Livre("Clean Code");

        assertEquals("Livre(name=Clean Code)", livre.toString());
    }

    @Test
    public void testNotEquals() {
        Livre cleanCode = new Livre("Clean Code");
        Livre otherBook = new Livre("Clean Architecture");

        assertFalse(cleanCode.equals(otherBook));
    }

    @Test
    public void testEquals() {
        Livre cleanCode = new Livre("Clean Code");
        Livre otherBook = new Livre("Clean Code");

        assertTrue(cleanCode.equals(otherBook));
    }
}