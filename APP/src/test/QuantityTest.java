package test;

import main.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityTest {

    @Test
    void shouldCompareEqualLengths() {
        Quantity<LengthUnit> q1 = new Quantity<>(1, LengthUnit.METER);
        Quantity<LengthUnit> q2 = new Quantity<>(100, LengthUnit.CENTIMETERS);

        assertTrue(q1.compare(q2));
    }

    @Test
    void shouldAddLengthsInMeters() {
        Quantity<LengthUnit> q1 = new Quantity<>(1, LengthUnit.METER);
        Quantity<LengthUnit> q2 = new Quantity<>(100, LengthUnit.CENTIMETERS);

        Quantity<LengthUnit> result = q1.add(q2);

        assertEquals(2.0, result.getValue(), 0.001);
    }

    @Test
    void shouldAddLengthsInFeet() {
        Quantity<LengthUnit> q1 = new Quantity<>(1, LengthUnit.METER);
        Quantity<LengthUnit> q2 = new Quantity<>(1, LengthUnit.FEET);

        Quantity<LengthUnit> result = q1.add(q2, LengthUnit.FEET);

        assertEquals(4.28, result.getValue(), 0.05);
    }

    @Test
    void shouldCompareWeights() {
        Quantity<WeightUnit> q1 = new Quantity<>(1, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> q2 = new Quantity<>(1000, WeightUnit.GRAM);

        assertTrue(q1.compare(q2));
    }

    @Test
    void shouldAddWeights() {
        Quantity<WeightUnit> q1 = new Quantity<>(1, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> q2 = new Quantity<>(1000, WeightUnit.GRAM);

        Quantity<WeightUnit> result = q1.add(q2);

        assertEquals(2.0, result.getValue(), 0.001);
    }
}