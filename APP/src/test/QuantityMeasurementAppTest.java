package test;

import main.QuantityMeasurementApp;
import main.QuantityMeasurementApp.Quantity;
import main.QuantityMeasurementApp.LengthUnit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementAppTest {

    private static final double EPS = 1e-6;

    // 🔹 CONVERSION TESTS (UC5)

    @Test
    void testFeetToInches() {
        assertEquals(12.0,
                QuantityMeasurementApp.convert(1.0, LengthUnit.FEET, LengthUnit.INCH),
                EPS);
    }

    @Test
    void testInchesToFeet() {
        assertEquals(2.0,
                QuantityMeasurementApp.convert(24.0, LengthUnit.INCH, LengthUnit.FEET),
                EPS);
    }

    // 🔹 ADDITION TESTS (UC6)

    @Test
    void testFeetPlusFeet() {
        Quantity q1 = new Quantity(1.0, LengthUnit.FEET);
        Quantity q2 = new Quantity(2.0, LengthUnit.FEET);

        Quantity result = Quantity.add(q1, q2);

        assertEquals(3.0, result.getValue(), EPS);
    }

    @Test
    void testFeetPlusInch() {
        Quantity q1 = new Quantity(1.0, LengthUnit.FEET);
        Quantity q2 = new Quantity(12.0, LengthUnit.INCH);

        Quantity result = Quantity.add(q1, q2);

        assertEquals(2.0, result.getValue(), EPS);
    }

    @Test
    void testInchPlusFeet() {
        Quantity q1 = new Quantity(12.0, LengthUnit.INCH);
        Quantity q2 = new Quantity(1.0, LengthUnit.FEET);

        Quantity result = Quantity.add(q1, q2);

        assertEquals(24.0, result.getValue(), EPS);
    }

    @Test
    void testCommutativity() {
        Quantity a = new Quantity(1.0, LengthUnit.FEET);
        Quantity b = new Quantity(12.0, LengthUnit.INCH);

        Quantity r1 = Quantity.add(a, b);
        Quantity r2 = Quantity.add(b, a);

        assertEquals(r1, r2);
    }

    @Test
    void testNullThrows() {
        Quantity q1 = new Quantity(1.0, LengthUnit.FEET);

        assertThrows(IllegalArgumentException.class, () ->
                Quantity.add(q1, null));
    }
}