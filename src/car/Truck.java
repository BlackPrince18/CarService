package car;

import java.time.LocalDate;

public final class Truck extends Car {
    private final double weight;

    public Truck(int ID, int odometer, int year, char indicator, double weight) {
        super(ID, odometer, year, indicator);
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Truck:\nID: " + ID + "\nOdometer: " + odometer
                + "\nYear: " + year + "\nIndicator: " + indicator +
                "\nWeight: " + weight + '\n';
    }

    public double calculateTruckInsurance() {
        int result;
        LocalDate now = LocalDate.now();

        result = (now.getYear() - year != 0) ?
                (now.getYear() - year) * 300 : 300;
        if (odometer > 800_000) result += 700;

        return result;
    }
}
