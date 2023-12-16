package test.java.com.unittest.codecoverage.service;

import com.unittest.codecoverage.models.StreetDirectionFlow;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.unittest.codecoverage.exceptions.BehaviorException;
import com.unittest.codecoverage.models.Footpassenger;
import com.unittest.codecoverage.models.Traffic;
import com.unittest.codecoverage.models.TrafficLigth;
import com.unittest.codecoverage.services.TrafficBehaviorService;
import com.unittest.codecoverage.services.impl.TrafficBehaviorServiceImpl;

public class TrafficBehaviorServiceTest {
	
	private TrafficBehaviorService trafficBehaviorService = new TrafficBehaviorServiceImpl();
	
	@Test
	public void testFootpassengerCrossTheStreet_shouldThrowBehaviorExceptionWhenFootpassengerCrossesTheRoadDuringHeavyTrafficAndWhileTheTrafficLightIsRed() {
	
		Traffic currentTrafic = new Traffic();
		currentTrafic.setIntenseCarTraffic(true);
		
		Footpassenger currentFootpassengerBehavior = new Footpassenger();
		currentFootpassengerBehavior.setCrossedTheRoad(true);
		currentFootpassengerBehavior.setCrossedTrafficLigth(TrafficLigth.RED);
		
		Assertions.assertThatThrownBy(() -> trafficBehaviorService.footpassengerCrossTheStreet(currentTrafic, currentFootpassengerBehavior))
			.isInstanceOf(BehaviorException.class)
			.hasMessageContaining("You should'nt do that, reckless person");
		
	}
	
	@Test
	@DisplayName("Should throw exception when footpassenger crosses the road during heavy traffic without attention")
	public void testFootpassengerCrossTheStreet_shouldThrowBehaviorExceptionWhenFootpassengerCrossesTheRoadDuringHeavyTrafficWithoutLookSides() {
	
		Traffic currentTrafic = new Traffic();
		currentTrafic.setIntenseCarTraffic(true);
		
		Footpassenger currentFootpassengerBehavior = new Footpassenger();
		currentFootpassengerBehavior.setCrossedTheRoad(true);
		currentFootpassengerBehavior.setCrossedTrafficLigth(TrafficLigth.GREEN);
		currentFootpassengerBehavior.setLookedToTheLeft(false);
		currentFootpassengerBehavior.setLookedToTheRight(false);
		
		Assertions.assertThatThrownBy(() -> trafficBehaviorService.footpassengerCrossTheStreet(currentTrafic, currentFootpassengerBehavior))
			.isInstanceOf(BehaviorException.class)
			.hasMessage("You should be more careful");
		
	}

	@Test
	@DisplayName("Should update cross the cross walk status")
	public void testFootpassengerCrossTheCrossWalk() {

		Traffic currentTrafic = new Traffic();
		currentTrafic.setIntenseCarTraffic(true);

		Footpassenger currentFootpassengerBehavior = new Footpassenger();
		currentFootpassengerBehavior.setCrossedTheCrosswalk(true);
		assertEquals(true, currentFootpassengerBehavior.crossedTheCrosswalk());
	}

	@Test
	@DisplayName("Should update current traffic light status")
	public void testTrafficgetCurrentTrafficLight() {

		Traffic currentTrafic = new Traffic();

		currentTrafic.setCurrentTrafficLight(TrafficLigth.GREEN);
		assertEquals(TrafficLigth.GREEN, currentTrafic.getCurrentTrafficLight());
	}

	@Test
	@DisplayName("Should update max speed allowed status")
	public void testTrafficgetMaxSpeedAllowed() {

		Traffic currentTrafic = new Traffic();

		short maxSpeed = 20;
		currentTrafic.setMaxSpeedAllowed(maxSpeed);
		assertEquals(maxSpeed, currentTrafic.getMaxSpeedAllowed());
	}

	@Test
	@DisplayName("Should update min speed allowed status")
	public void testTrafficgetMinSpeedAllowed() {

		Traffic currentTrafic = new Traffic();

		short minSpeed = 10;
		currentTrafic.setMinSpeedAllowed(minSpeed);
		assertEquals(minSpeed, currentTrafic.getMinSpeedAllowed());
	}

	@Test
	@DisplayName("Should update street direction flow status")
	public void testTrafficgetStreetDirectionFlow() {

		Traffic currentTrafic = new Traffic();

		short maxSpeed = 20;
		currentTrafic.setStreetDirectionFlow(StreetDirectionFlow.ONE_WAY);
		assertEquals(StreetDirectionFlow.ONE_WAY, currentTrafic.getStreetDirectionFlow());
	}
}
