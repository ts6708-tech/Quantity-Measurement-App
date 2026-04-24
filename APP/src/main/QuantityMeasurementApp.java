package main;

public class QuantityMeasurementApp {

    // 🔥 ENUM for units
    public enum LengthUnit {
        FEET(1.0),
        INCH(1.0 / 12.0);

        private final double toFeet;

        LengthUnit(double toFeet) {
            this.toFeet = toFeet;
        }

        public double toBase(double value) {
            return value * toFeet;
        }
    }

    // 🔥 Generic Quantity class
    public static class Quantity {
        private final double value;
        private final LengthUnit unit;

        public Quantity(double value, LengthUnit unit) {
            this.value = value;
            this.unit = unit;
        }

        @Override
        public boolean equals(Object obj) {

            // 1. Same reference
            if (this == obj) return true;

            // 2. Null check
            if (obj == null) return false;

            // 3. Type check
            if (this.getClass() != obj.getClass()) return false;

            // 4. Cast
            Quantity other = (Quantity) obj;

            // 5. Convert both to base unit (FEET)
            double thisValueInFeet = this.unit.toBase(this.value);
            double otherValueInFeet = other.unit.toBase(other.value);

            // 6. Compare
            return Double.compare(thisValueInFeet, otherValueInFeet) == 0;
        }
    }

    // Optional main
    public static void main(String[] args) {
        Quantity q1 = new Quantity(1.0, LengthUnit.FEET);
        Quantity q2 = new Quantity(12.0, LengthUnit.INCH);

        System.out.println("Equal: " + q1.equals(q2));
    }
}