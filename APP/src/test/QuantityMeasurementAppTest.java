package test;

import main.QuantityMeasurementApp;
import main.QuantityMeasurementApp.LengthUnit;
import main.QuantityMeasurementApp.Quantity;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementAppTest {

    @Test
    void givenSameFeetValues_whenCompared_shouldReturnTrue() {
        Quantity q1 = new Quantity(1.0, LengthUnit.FEET);
        Quantity q2 = new Quantity(1.0, LengthUnit.FEET);

        assertTrue(q1.equals(q2));
    }

    @Test
    void givenSameInchValues_whenCompared_shouldReturnTrue() {
        Quantity q1 = new Quantity(1.0, LengthUnit.INCH);
        Quantity q2 = new Quantity(1.0, LengthUnit.INCH);

        assertTrue(q1.equals(q2));
    }

    @Test
    void givenFeetAndInchEquivalent_whenCompared_shouldReturnTrue() {
        Quantity q1 = new Quantity(1.0, LengthUnit.FEET);
        Quantity q2 = new Quantity(12.0, LengthUnit.INCH);

        assertTrue(q1.equals(q2));
    }

    @Test
    void givenInchAndFeetEquivalent_whenCompared_shouldReturnTrue() {
        Quantity q1 = new Quantity(12.0, LengthUnit.INCH);
        Quantity q2 = new Quantity(1.0, LengthUnit.FEET);

        assertTrue(q1.equals(q2));
    }

    @Test
    void givenDifferentFeetValues_whenCompared_shouldReturnFalse() {
        Quantity q1 = new Quantity(1.0, LengthUnit.FEET);
        Quantity q2 = new Quantity(2.0, LengthUnit.FEET);

        assertFalse(q1.equals(q2));
    }

    @Test
    void givenDifferentInchValues_whenCompared_shouldReturnFalse() {
        Quantity q1 = new Quantity(1.0, LengthUnit.INCH);
        Quantity q2 = new Quantity(2.0, LengthUnit.INCH);

        assertFalse(q1.equals(q2));
    }

    @Test
    void givenNullComparison_shouldReturnFalse() {
        Quantity q1 = new Quantity(1.0, LengthUnit.FEET);

        assertFalse(q1.equals(null));
    }

    @Test
    void givenSameReference_shouldReturnTrue() {
        Quantity q1 = new Quantity(1.0, LengthUnit.FEET);

        assertTrue(q1.equals(q1));
    }
}