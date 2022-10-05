package es.upm.miw.iwvg_devops.rest.code;

import es.upm.miw.iwvg_devops.code.Fraction;
import es.upm.miw.iwvg_devops.code.Searches;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SearchesTest {

    @Test
    void testFindUserFamilyNameByUserNameDistinct() {
        assertEquals(List.of("Torres"), new Searches().findUserFamilyNameByUserNameDistinct("Paula")
                .collect(Collectors.toList()));
    }

    @Test
    void testFindUserFractionNumeratorByFamilyName() {
        assertEquals(List.of(2, 4, 0, 1, 1), new Searches().findFractionNumeratorByUserFamilyName("Torres")
                .collect(Collectors.toList()));
    }

    @Test
    void testFindFamilyNameByFractionDenominator() {
        assertEquals(List.of("López", "Torres"), new Searches().findUserFamilyNameByFractionDenominator(2).collect(Collectors.toList()));
    }


    @Test
    void testFindUserFamilyNameInitialBySomeProperFraction() {
        assertEquals(List.of("O.", "A.","O.", "A."), new Searches().findUserFamilyNameInitialBySomeProperFraction().collect(Collectors.toList()));
    }

    @Test
    void testFindUserIdBySomeProperFraction() {
        assertEquals(List.of("1","2","3","5"), new Searches().findUserIdBySomeProperFraction().collect(Collectors.toList()));
    }

    @Test
    void testFindFractionMultiplicationByUserFamilyName() {
        assertEquals(new Fraction(1, -20), new Searches().findFractionMultiplicationByUserFamilyName("López"));
    }

    @Test
    void testFindFractionDivisionByUserId() {
        assertEquals(new Fraction(0, 1), new Searches().findFractionDivisionByUserId("1"));
    }

    @Test
    void testFindFirstDecimalFractionByUserName() {
        assertEquals(2.0, new Searches().findFirstDecimalFractionByUserName("Ana"));
    }

    @Test
    void testFindUserFamilyNameByAllNegativeSignFractionDistinct() {
        assertEquals(List.of("Blanco", "López"), new Searches().findUserFamilyNameByAllNegativeSignFractionDistinct().collect(Collectors.toList()));
    }

    @Test
    void testFindDecimalFractionByNegativeSignFraction() {
        assertEquals(List.of(-0.2, -0.5, -0.0), new Searches().findDecimalFractionByNegativeSignFraction().collect(Collectors.toList()));
    }

    @Test
    void testFindFractionSubtractionByUserName() {
        assertEquals(new Fraction(11, 30), new Searches().findFractionSubtractionByUserName("Ana"));
    }
}
