package test;

import main.QuantityMeasurementApp;
import main.QuantityMeasurementApp.LengthUnit;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementAppTest {

    private static final double EPS = 1e-6;

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

    @Test
    void testYardsToInches() {
        assertEquals(36.0,
                QuantityMeasurementApp.convert(1.0, LengthUnit.YARD, LengthUnit.INCH),
                EPS);
    }

    @Test
    void testInchesToYards() {
        assertEquals(2.0,
                QuantityMeasurementApp.convert(72.0, LengthUnit.INCH, LengthUnit.YARD),
                EPS);
    }

    @Test
    void testCentimeterToInch() {
        assertEquals(1.0,
                QuantityMeasurementApp.convert(2.54, LengthUnit.CM, LengthUnit.INCH),
                EPS);
    }

    @Test
    void testFeetToYard() {
        assertEquals(2.0,
                QuantityMeasurementApp.convert(6.0, LengthUnit.FEET, LengthUnit.YARD),
                EPS);
    }

    @Test
    void testZeroConversion() {
        assertEquals(0.0,
                QuantityMeasurementApp.convert(0.0, LengthUnit.FEET, LengthUnit.INCH),
                EPS);
    }

    @Test
    void testNegativeConversion() {
        assertEquals(-12.0,
                QuantityMeasurementApp.convert(-1.0, LengthUnit.FEET, LengthUnit.INCH),
                EPS);
    }

    @Test
    void testRoundTrip() {
        double value = 5.0;
        double converted = QuantityMeasurementApp.convert(value, LengthUnit.FEET, LengthUnit.INCH);
        double back = QuantityMeasurementApp.convert(converted, LengthUnit.INCH, LengthUnit.FEET);

        assertEquals(value, back, EPS);
    }

    @Test
    void testInvalidUnitThrows() {
        assertThrows(IllegalArgumentException.class, () ->
                QuantityMeasurementApp.convert(1.0, null, LengthUnit.FEET));
    }

    @Test
    void testNaNThrows() {
        assertThrows(IllegalArgumentException.class, () ->
                QuantityMeasurementApp.convert(Double.NaN, LengthUnit.FEET, LengthUnit.INCH));
    }
}