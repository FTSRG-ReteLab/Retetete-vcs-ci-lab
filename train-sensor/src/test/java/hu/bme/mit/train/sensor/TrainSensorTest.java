package hu.bme.mit.train.sensor;

import org.junit.After;
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
import org.mockito.InjectMocks;
import org.mockito.Mock;


public class TrainSensorTest {

	 private TrainController controller ;

	 private TrainUser user;
	 private TrainSensor sensor;

	 @Before
    public void before() {
			controller= mock(TrainController.class);
			 user = mock(TrainUser.class);
			 sensor = new TrainSensorImpl(controller, user);

	 }

	@Test
	public void SpeedLimitMinimum(){
    	sensor.overrideSpeedLimit(-1);
    	verify(user,times(1)).setAlarmState(true);
	}

	@Test
	public void SpeedLimitMaximum(){
    	sensor.overrideSpeedLimit(501);
    	verify(user,times(1)).setAlarmState(true);
	}

	@Test
	public void referencerelation(){
		when(controller.getReferenceSpeed()).thenReturn(31);
		sensor.overrideSpeedLimit(15);
		verify(user,times(1)).setAlarmState(true);
	}

	@Test
	public void notalarm(){
		when(controller.getReferenceSpeed()).thenReturn(29);
		sensor.overrideSpeedLimit(15);
		verify(user,times(1)).setAlarmState(false);
	}

}
