package application;

import java.util.ArrayList;
import java.util.List;

//An average sensor includes multiple sensors. 
public class AverageSensor implements Sensor {

    private ArrayList<Sensor> sensors;
    private List<Integer> results;

    public AverageSensor() {
        sensors = new ArrayList();
        results = new ArrayList();
    }

    //An AverageSensor is on when all its sensors are on.
    @Override
    public boolean isOn() {
        for (Sensor sensor : sensors) {
            if (!sensor.isOn()) {
                return false;
            }
        }

        return true;
    }

    //When setOn is called, all the sensors must be set on.
    @Override
    public void setOn() {
        sensors.forEach(sensor -> sensor.setOn());

    }

    //When setOff is called, at least one of the sensors must be set off. It's also acceptable to set off all the sensors.
    @Override
    public void setOff() {
        sensors.forEach(sensor -> sensor.setOff());

    }

    // returns the average of the read methods of its sensors
    @Override
    public int read() {
        if (this.sensors.isEmpty() || !this.isOn()) {
            throw new IllegalStateException("no sensors or sensors are off!");
        } else {
            //map to ints from read method. 
            //reduce counts each int from read method. Divide by size of list to get average.
            int avg = this.sensors.stream().map(sensor -> sensor.read()).reduce(0, (prev, curr) -> prev + curr) / this.sensors.size();
            results.add(avg);
            return avg;
        }
    }

    public void addSensor(Sensor toAdd) {
        this.sensors.add(toAdd);
    }

    //returns the results of all the executed readings that the average sensor has done as a list. 
    public List<Integer> readings() {
        return results;
    }

}
