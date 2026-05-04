package main;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

        // ===== LENGTH (UC8 check) =====
        QuantityLength l1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength l2 = new QuantityLength(12.0, LengthUnit.INCHES);
        System.out.println(l1.add(l2, LengthUnit.FEET));

        // ===== WEIGHT (UC9) =====
        QuantityWeight w1 = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight w2 = new QuantityWeight(1000.0, WeightUnit.GRAM);

        System.out.println(w1.equals(w2)); // true
        System.out.println(w1.add(w2)); // 2 KG
        System.out.println(w1.add(w2, WeightUnit.GRAM)); // 2000 GRAM

        System.out.println(
                new QuantityWeight(2.0, WeightUnit.POUND)
                        .convertTo(WeightUnit.KILOGRAM)
        );
    }
}