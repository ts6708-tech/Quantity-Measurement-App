package test;

import main.QuantityMeasurementApp;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementAppTest {

    // 🔹 FEET TESTS

    @Test
    void givenSameFeetValues_whenCompared_shouldReturnTrue() {
        QuantityMeasurementApp.Feet f1 = new QuantityMeasurementApp.Feet(1.0);
        QuantityMeasurementApp.Feet f2 = new QuantityMeasurementApp.Feet(1.0);

        assertTrue(f1.equals(f2));
    }

    @Test
    void givenDifferentFeetValues_whenCompared_shouldReturnFalse() {
        QuantityMeasurementApp.Feet f1 = new QuantityMeasurementApp.Feet(1.0);
        QuantityMeasurementApp.Feet f2 = new QuantityMeasurementApp.Feet(2.0);

        assertFalse(f1.equals(f2));
    }

    @Test
    void givenFeetValue_whenComparedWithNull_shouldReturnFalse() {
        QuantityMeasurementApp.Feet f1 = new QuantityMeasurementApp.Feet(1.0);

        assertFalse(f1.equals(null));
    }

    @Test
    void givenSameFeetReference_whenCompared_shouldReturnTrue() {
        QuantityMeasurementApp.Feet f1 = new QuantityMeasurementApp.Feet(1.0);

        assertTrue(f1.equals(f1));
    }

    @Test
    void givenFeetValue_whenComparedWithDifferentType_shouldReturnFalse() {
        QuantityMeasurementApp.Feet f1 = new QuantityMeasurementApp.Feet(1.0);

        assertFalse(f1.equals("1.0"));
    }

    // 🔥 INCH TESTS

    @Test
    void givenSameInchValues_whenCompared_shouldReturnTrue() {
        QuantityMeasurementApp.Inch i1 = new QuantityMeasurementApp.Inch(1.0);
        QuantityMeasurementApp.Inch i2 = new QuantityMeasurementApp.Inch(1.0);

        assertTrue(i1.equals(i2));
    }

    @Test
    void givenDifferentInchValues_whenCompared_shouldReturnFalse() {
        QuantityMeasurementApp.Inch i1 = new QuantityMeasurementApp.Inch(1.0);
        QuantityMeasurementApp.Inch i2 = new QuantityMeasurementApp.Inch(2.0);

        assertFalse(i1.equals(i2));
    }

    @Test
    void givenInchValue_whenComparedWithNull_shouldReturnFalse() {
        QuantityMeasurementApp.Inch i1 = new QuantityMeasurementApp.Inch(1.0);

        assertFalse(i1.equals(null));
    }

    @Test
    void givenSameInchReference_whenCompared_shouldReturnTrue() {
        QuantityMeasurementApp.Inch i1 = new QuantityMeasurementApp.Inch(1.0);

        assertTrue(i1.equals(i1));
    }

    @Test
    void givenInchValue_whenComparedWithDifferentType_shouldReturnFalse() {
        QuantityMeasurementApp.Inch i1 = new QuantityMeasurementApp.Inch(1.0);

        assertFalse(i1.equals("1.0"));
    }
}