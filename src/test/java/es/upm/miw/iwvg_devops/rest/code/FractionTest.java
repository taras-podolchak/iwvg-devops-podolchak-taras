package es.upm.miw.iwvg_devops.rest.code;

import es.upm.miw.iwvg_devops.code.Fraction;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class FractionTest {
    private static Fraction f1, f2, f3, f4;
    private static Fraction oneFifth, twoFifths, threeFifths;
    private static Fraction oneHalf, twoFourths, threeSixths;
    private Fraction isImproper;

    @BeforeEach
    void before() {
        f1 = new Fraction(1, 2);
        f2 = new Fraction(1, 2);
        f3 = new Fraction(1, 2);
        f4 = new Fraction(3, 7);
        oneFifth = new Fraction(1, 5);
        twoFifths = new Fraction(2, 5);
        threeFifths = new Fraction(3, 5);
        oneHalf = new Fraction(1, 2);
        twoFourths = new Fraction(2, 4);
        threeSixths = new Fraction(3, 6);
        isImproper = new Fraction(2, 1);
    }

    @Test
    public void testisProper() {
        assertTrue(oneFifth.isProper(oneHalf));
        assertFalse(oneFifth.isProper(isImproper));
    }

    @Test
    public void testisImproper() {
        assertTrue(oneFifth.isImproper(isImproper));
        assertFalse(oneFifth.isImproper(oneHalf));
    }

    @Test
    public void testConstructor() {
        new Fraction(1, 3);
        new Fraction(3, 2);
        new Fraction(1, 1);
    }

    @Test
    public void testAccessors() {
        assertEquals(1, f1.getNumerator());
        assertEquals(2, f1.getDenominator());
    }

    @Test
    public void testReduce() {
        assertEquals(oneHalf, twoFourths.reduce());
        assertEquals(oneHalf, threeSixths.reduce());
    }

    @Test
    public void testEquivalent() {
        assertTrue(oneHalf.isEquivalent(f1));
        assertTrue(oneHalf.isEquivalent(twoFourths));
        assertFalse(oneHalf.isEquivalent(threeFifths));
    }

    @Test
    public void testNullBehaviorOfEquals() {
        assertNotNull(f1);
    }

    @Test
    public void testReflexiveBehaviorOfEquals() {
        assertEquals(f1, f1);
    }

    @Test
    public void testUnequalValuesOfEqual() {
        assertNotEquals(f1, f4);
    }

    @Test
    public void testSymmetricalBehaviorOfEquals() {
        assertEquals(f1, f2);
    }

    @Test
    public void testTransitiveBehaviorOfEquals() {
        assertEquals(f1, f2);
        assertEquals(f2, f3);
        assertEquals(f3, f1);
    }

    @Test
    public void testEqualObjectsHaveEqualHashCodes() {
        assertEquals(f1.hashCode(), f2.hashCode());
    }

    @Test
    public void testSameObjectAlwaysSameHashCode() {
        int h1 = f1.hashCode();
        int h2 = f1.hashCode();
        assertEquals(h1, h2);
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
        assertEquals(oneHalf.divide(oneHalf), new Fraction(1, 1));
    }
}