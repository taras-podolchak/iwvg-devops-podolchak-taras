package es.upm.miw.iwvg_devops.rest.code;

import es.upm.miw.iwvg_devops.code.Fraction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FractionTest {
    private static final Fraction oneFifth = new Fraction(1, 5);
    private static final Fraction twoFifths = new Fraction(2, 5);
    private static final Fraction threeFifths = new Fraction(3, 5);
    private static final Fraction twoFourths = new Fraction(2, 4);
    private static final Fraction isProper = new Fraction(1, 2);
    private static final Fraction isImproper = new Fraction(2, 1);

    @Test
    public void testisProper() {
        assertTrue(oneFifth.isProper(isProper));
        assertFalse(oneFifth.isProper(isImproper));
    }

    @Test
    public void testisImproper() {
        assertTrue(oneFifth.isImproper(isImproper));
        assertFalse(oneFifth.isImproper(isProper));
    }

    @Test
    public void testConstructorWithGoodValues() {
        new Fraction(1, 3);
        new Fraction(3, 2);
        new Fraction(1, 1);
    }

    @Test
    public void testisEquivalent() {
        assertTrue(isProper.isEquivalent(isProper));
        assertTrue(isProper.isEquivalent(twoFourths));
        assertFalse(isProper.isEquivalent(threeFifths));
    }

    @Test
    public void testAddition() {
        assertEquals(threeFifths, oneFifth.add(twoFifths));
    }

    @Test
    public void testMultiplication() {
        assertEquals(threeFifths.multiply(twoFifths), new Fraction(6, 25));
    }

    @Test
    public void testDivision() {
        assertEquals(threeFifths.divide(twoFifths), new Fraction(3, 2));
        assertEquals(isProper.divide(isProper), new Fraction(1, 1));
    }
}