package test;

import main.QuantityMeasurementApp;
import main.QuantityMeasurementApp.Quantity;
import main.QuantityMeasurementApp.LengthUnit;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementAppTest {

    // 🔹 YARD TESTS

    @Test
    void givenSameYardValues_shouldReturnTrue() {
        Quantity q1 = new Quantity(1.0, LengthUnit.YARD);
        Quantity q2 = new Quantity(1.0, LengthUnit.YARD);

        assertTrue(q1.equals(q2));
    }

    @Test
    void givenYardToFeetEquivalent_shouldReturnTrue() {
        Quantity q1 = new Quantity(1.0, LengthUnit.YARD);
        Quantity q2 = new Quantity(3.0, LengthUnit.FEET);

        assertTrue(q1.equals(q2));
    }

    @Test
    void givenYardToInchEquivalent_shouldReturnTrue() {
        Quantity q1 = new Quantity(1.0, LengthUnit.YARD);
        Quantity q2 = new Quantity(36.0, LengthUnit.INCH);

        assertTrue(q1.equals(q2));
    }

    @Test
    void givenDifferentYardValues_shouldReturnFalse() {
        Quantity q1 = new Quantity(1.0, LengthUnit.YARD);
        Quantity q2 = new Quantity(2.0, LengthUnit.YARD);

        assertFalse(q1.equals(q2));
    }

    // 🔹 CM TESTS

    @Test
    void givenSameCmValues_shouldReturnTrue() {
        Quantity q1 = new Quantity(2.0, LengthUnit.CM);
        Quantity q2 = new Quantity(2.0, LengthUnit.CM);

        assertTrue(q1.equals(q2));
    }

    @Test
    void givenCmToInchEquivalent_shouldReturnTrue() {
        Quantity q1 = new Quantity(1.0, LengthUnit.CM);
        Quantity q2 = new Quantity(0.393701, LengthUnit.INCH);

        assertTrue(q1.equals(q2));
    }

    @Test
    void givenCmToFeetNotEqual_shouldReturnFalse() {
        Quantity q1 = new Quantity(1.0, LengthUnit.CM);
        Quantity q2 = new Quantity(1.0, LengthUnit.FEET);

        assertFalse(q1.equals(q2));
    }

    // 🔹 TRANSITIVE TEST

    @Test
    void givenYardFeetInchTransitive_shouldReturnTrue() {
        Quantity yard = new Quantity(1.0, LengthUnit.YARD);
        Quantity feet = new Quantity(3.0, LengthUnit.FEET);
        Quantity inch = new Quantity(36.0, LengthUnit.INCH);

        assertTrue(yard.equals(feet));
        assertTrue(feet.equals(inch));
        assertTrue(yard.equals(inch));
    }
}