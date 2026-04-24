package main;

public class QuantityMeasurementApp {

    public enum LengthUnit {

        FEET(1.0),
        INCH(1.0 / 12.0),

        // 🔥 NEW UNITS
        YARD(3.0),                    // 1 yard = 3 feet
        CM(0.393701 / 12.0);         // cm → inch → feet

        private final double toFeet;

        LengthUnit(double toFeet) {
            this.toFeet = toFeet;
        }

        public double toBase(double value) {
            return value * toFeet;
        }
    }

    public static class Quantity {
        private final double value;
        private final LengthUnit unit;

        public Quantity(double value, LengthUnit unit) {
            this.value = value;
            this.unit = unit;
        }

        @Override
        public boolean equals(Object obj) {

            if (this == obj) return true;
            if (obj == null) return false;
            if (this.getClass() != obj.getClass()) return false;

            Quantity other = (Quantity) obj;

            double thisValue = this.unit.toBase(this.value);
            double otherValue = other.unit.toBase(other.value);

            return Double.compare(thisValue, otherValue) == 0;
        }
    }
}