package car;

public abstract class Car {
    protected int ID;
    protected int odometer;
    protected int year;
    protected char indicator;

    public Car(int ID, int odometer, int year, char indicator) {
        this.ID = ID;
        this.odometer = odometer;
        this.year = year;
        this.indicator = indicator;
    }

    public int getID() {
        return ID;
    }
}
