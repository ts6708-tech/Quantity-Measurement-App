package main;

public class QuantityMeasurementApp {

    // Inner class representing Feet measurement
    public static class Feet {
        private final double value;

        // Constructor
        public Feet(double value) {
            this.value = value;
        }

        // Override equals method
        @Override
        public boolean equals(Object obj) {

            // 1. Same reference (Reflexive)
            if (this == obj) {
                return true;
            }

            // 2. Null check
            if (obj == null) {
                return false;
            }

            // 3. Type check
            if (this.getClass() != obj.getClass()) {
                return false;
            }

            // 4. Cast to Feet
            Feet other = (Feet) obj;

            // 5. Compare values safely
            return Double.compare(this.value, other.value) == 0;
        }
    }

    // Main method (optional demo)
    public static void main(String[] args) {
        Feet f1 = new Feet(1.0);
        Feet f2 = new Feet(1.0);

        System.out.println("Equal: " + f1.equals(f2));
    }
}