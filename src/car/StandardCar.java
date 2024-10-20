package car;

import java.time.LocalDate;

public final class StandardCar extends Car {
    private final String transmission;

    public StandardCar(int ID, int odometer, int year, char indicator, String transmission) {
        super(ID, odometer, year, indicator);
        this.transmission = transmission;
    }

    @Override
    public String toString() {
        return "Standard Car:\nID: " + ID + "\nOdometer: " + odometer
                + "\nYear: " + year + "\nIndicator: " + indicator +
                "\nTransmission: " + transmission + '\n';
    }

    public double calculateStandardCarInsurance() {
        int result;
        LocalDate now = LocalDate.now();

        result = (now.getYear() - year != 0) ?
                (now.getYear() - year) * 100 : 100;
        if (indicator == 'd' || indicator == 'D') result += 500;
        if (odometer > 200_000) result += 500;

        return result;
    }
}
