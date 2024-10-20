package car;

import java.time.LocalDate;

public final class Bus extends Car {
    private final int places;

    public Bus(int ID, int odometer, int year, char indicator, int places) {
        super(ID, odometer, year, indicator);
        this.places = places;
    }

    @Override
    public String toString() {
        return "Bus\nID: " + ID + "\nOdometer: " + odometer
                + "\nYear: " + year + "\nIndicator: " + indicator +
                "\nPlaces: " + places + '\n';
    }

    public double calculateBusInsurance() {
        int result;
        LocalDate now = LocalDate.now();

        result = (now.getYear() - year != 0) ?
                (now.getYear() - year) * 200 : 200;
        if (indicator == 'd' || indicator == 'D') result += 1000;
        if (odometer > 200_000) result += 1000;
        else if (odometer > 100_000) result += 500;

        return result;
    }
}
