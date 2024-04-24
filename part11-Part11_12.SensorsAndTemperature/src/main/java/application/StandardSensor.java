package application;

public class StandardSensor implements Sensor {

    private int number;

    public StandardSensor(int number) {
        this.number = number;
    }

    @Override
    public boolean isOn() {
        return true;
    }

    @Override
    public void setOn() {
        // Standard Sensor is alway on. Method has no effect
    }

    @Override
    public void setOff() {
        // Standard Sensor is alway on. Method has no effect
    }

    @Override
    public int read() {
        return number;
    }

}
