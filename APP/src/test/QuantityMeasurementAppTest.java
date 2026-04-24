package test;

import main.QuantityMeasurementApp.Quantity;
import main.QuantityMeasurementApp.LengthUnit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementAppTest {

    @Test
    void testAdd_TargetFeet() {
        Quantity q1 = new Quantity(1.0, LengthUnit.FEET);
        Quantity q2 = new Quantity(12.0, LengthUnit.INCH);

        Quantity result = Quantity.add(q1, q2, LengthUnit.FEET);

        assertEquals(2.0, result.getValue(), 1e-6);
    }

    @Test
    void testAdd_TargetInch() {
        Quantity q1 = new Quantity(1.0, LengthUnit.FEET);
        Quantity q2 = new Quantity(12.0, LengthUnit.INCH);

        Quantity result = Quantity.add(q1, q2, LengthUnit.INCH);

        assertEquals(24.0, result.getValue(), 1e-6);
    }

    @Test
    void testAdd_TargetYard() {
        Quantity q1 = new Quantity(1.0, LengthUnit.FEET);
        Quantity q2 = new Quantity(12.0, LengthUnit.INCH);

        Quantity result = Quantity.add(q1, q2, LengthUnit.YARD);

        assertEquals(0.666, result.getValue(), 1e-2);
    }

    @Test
    void testNullTargetThrows() {
        Quantity q1 = new Quantity(1.0, LengthUnit.FEET);
        Quantity q2 = new Quantity(12.0, LengthUnit.INCH);

        assertThrows(IllegalArgumentException.class, () ->
                Quantity.add(q1, q2, null));
    }
}