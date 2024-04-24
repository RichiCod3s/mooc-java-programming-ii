package application;

import java.util.Random;

public class TemperatureSensor implements Sensor {

    private boolean isOn;

    public TemperatureSensor() {
        isOn = false;
    }

    @Override
    public boolean isOn() {
        return isOn;
    }

    @Override
    public void setOn() {
        isOn = true;
    }

    @Override
    public void setOff() {
        isOn = false;
    }

    @Override
    public int read() {
        if (isOn) {
            //gets an integer in the range 0-60
            //subtract 30 to get a random integer in the range -30 to 30
            return new Random().nextInt(61) - 30;
        } else {
            throw new IllegalStateException();
        }
    }
}
