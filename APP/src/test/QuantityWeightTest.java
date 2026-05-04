package main;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuantityWeightTest {

    @Test
    void testEquality_KgToKg() {
        QuantityWeight w1 = new QuantityWeight(1, WeightUnit.KILOGRAM);
        QuantityWeight w2 = new QuantityWeight(1, WeightUnit.KILOGRAM);

        assertTrue(w1.equals(w2));
    }

    @Test
    void testEquality_KgToGram() {
        QuantityWeight w1 = new QuantityWeight(1, WeightUnit.KILOGRAM);
        QuantityWeight w2 = new QuantityWeight(1000, WeightUnit.GRAM);

        assertTrue(w1.equals(w2));
    }

    @Test
    void testAddition() {
        QuantityWeight result = new QuantityWeight(1, WeightUnit.KILOGRAM)
                .add(new QuantityWeight(1000, WeightUnit.GRAM));

        assertTrue(result.equals(new QuantityWeight(2, WeightUnit.KILOGRAM)));
    }
}