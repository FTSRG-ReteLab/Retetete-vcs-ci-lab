package hu.bme.mit.train.sensor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

import hu.bme.mit.train.controller.TrainControllerImpl;
import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import hu.bme.mit.train.sensor.TrainSensorImpl;
import hu.bme.mit.train.user.TrainUserImpl;



public class TrainSensorTest {
	 private TrainController controller ;
	 private TrainUser user;
	 private TrainSensor sensor;
    @Before
    public void before() {
			controller= new TrainControllerImpl();
			 user = new TrainUserImpl(controller);
			 sensor = new TrainSensorImpl(controller, user);
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
