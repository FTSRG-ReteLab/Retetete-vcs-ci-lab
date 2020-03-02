package hu.bme.mit.train.sensor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import hu.bme.mit.train.system.TrainSystem;

public class TrainSensorTest {
	TrainSensor sensor;
    @Before
    public void before() {
        TrainSystem system = new TrainSystem();
    	sensor = system.getSensor();
	sensor.overrideSpeedLimit(50);
}

    @Test
    public void ThisIsAnExampleTestStub() {
        // TODO Delete this and add test cases based on the issues
    }
    @Test

	public void GettingSensorSpeedLimit(){
	sensor.overrideSpeedLimit(10);
	Assert.assertEquals(10,sensor.getSpeedLimit());
}
}
