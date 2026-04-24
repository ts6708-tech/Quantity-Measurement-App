package test;

import main.LengthUnit;
import main.QuantityLength;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuantityLengthTest {

    private static final double EPSILON = 1e-6;

    // 🔹 Equality Tests
    @Test
    void testEquality_FeetToInches() {
        QuantityLength f = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength i = new QuantityLength(12.0, LengthUnit.INCHES);
        assertTrue(f.equals(i));
    }

    @Test
    void testEquality_YardsToFeet() {
        QuantityLength y = new QuantityLength(1.0, LengthUnit.YARDS);
        QuantityLength f = new QuantityLength(3.0, LengthUnit.FEET);
        assertTrue(y.equals(f));
    }

    @Test
    void testEquality_NotEqual() {
        QuantityLength f1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength f2 = new QuantityLength(2.0, LengthUnit.FEET);
        assertFalse(f1.equals(f2));
    }

    @Test
    void testEquality_Null() {
        QuantityLength f = new QuantityLength(1.0, LengthUnit.FEET);
        assertFalse(f.equals(null));
    }

    // 🔹 Conversion Tests
    @Test
    void testConvert_FeetToInches() {
        double result = QuantityLength.convert(1.0, LengthUnit.FEET, LengthUnit.INCHES);
        assertEquals(12.0, result, EPSILON);
    }

    @Test
    void testConvert_YardsToFeet() {
        double result = QuantityLength.convert(1.0, LengthUnit.YARDS, LengthUnit.FEET);
        assertEquals(3.0, result, EPSILON);
    }

    @Test
    void testConvert_CmToInches() {
        double result = QuantityLength.convert(2.54, LengthUnit.CENTIMETERS, LengthUnit.INCHES);
        assertEquals(1.0, result, EPSILON);
    }

    // 🔹 Instance Conversion
    @Test
    void testInstanceConvert() {
        QuantityLength q = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength result = q.convertTo(LengthUnit.INCHES);

        assertEquals(12.0, result.getValue(), EPSILON);
        assertEquals(LengthUnit.INCHES, result.getUnit());
    }

    // 🔹 Addition Tests
    @Test
    void testAdd_FeetAndInches_ToFeet() {
        QuantityLength f = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength i = new QuantityLength(12.0, LengthUnit.INCHES);

        QuantityLength result = f.add(i, LengthUnit.FEET);

        assertEquals(2.0, result.getValue(), EPSILON);
        assertEquals(LengthUnit.FEET, result.getUnit());
    }

    @Test
    void testAdd_InchesAndFeet_ToInches() {
        QuantityLength i = new QuantityLength(12.0, LengthUnit.INCHES);
        QuantityLength f = new QuantityLength(1.0, LengthUnit.FEET);

        QuantityLength result = i.add(f, LengthUnit.INCHES);

        assertEquals(24.0, result.getValue(), EPSILON);
    }

    @Test
    void testAdd_ToYards() {
        QuantityLength f = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength i = new QuantityLength(12.0, LengthUnit.INCHES);

        QuantityLength result = f.add(i, LengthUnit.YARDS);

        assertEquals(0.666666, result.getValue(), 1e-3);
    }

    // 🔹 Edge Cases
    @Test
    void testZeroAddition() {
        QuantityLength f = new QuantityLength(5.0, LengthUnit.FEET);
        QuantityLength zero = new QuantityLength(0.0, LengthUnit.INCHES);

        QuantityLength result = f.add(zero, LengthUnit.FEET);

        assertEquals(5.0, result.getValue(), EPSILON);
    }

    @Test
    void testNegativeValues() {
        QuantityLength f1 = new QuantityLength(5.0, LengthUnit.FEET);
        QuantityLength f2 = new QuantityLength(-2.0, LengthUnit.FEET);

        QuantityLength result = f1.add(f2, LengthUnit.FEET);

        assertEquals(3.0, result.getValue(), EPSILON);
    }
}