package main;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

        // ✅ LENGTH
        Quantity<LengthUnit> l1 = new Quantity<>(1, LengthUnit.METER);
        Quantity<LengthUnit> l2 = new Quantity<>(1, LengthUnit.FEET);

        System.out.println("Length Compare: " + l1.compare(l2));
        System.out.println("Length Add (same unit): " + l1.add(l2));
        System.out.println("Length Add (in FEET): " + l1.add(l2, LengthUnit.FEET));

        // ✅ WEIGHT
        Quantity<WeightUnit> w1 = new Quantity<>(1, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> w2 = new Quantity<>(1000, WeightUnit.GRAM);

        System.out.println("Weight Compare: " + w1.compare(w2));
        System.out.println("Weight Add: " + w1.add(w2));
    }
}