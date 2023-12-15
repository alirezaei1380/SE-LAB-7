# unittest.with.codecoverage
### _Demo of unit test with code coverage_

## Content
- Unit test exemples with jUnit5 and Mockito
- JaCoCo for code coverage report
- Dificult: Beginner

## Executions
- mvn clean install -DskipTests
- mvn jacoco:report
- mvn test

### JaCoCo report report can be found at _target/site/jacoco/index.html_

Slides with content of the topic (pt-BR):<br> https://docs.google.com/presentation/d/1Dkz-qUYigPFynfNk8KcAeyTIxhUmaVTZ4DM6d5UjcJE/edit?usp=sharing


# Examination Report


Here is the initial coverage of tests:
<img width="587" alt="Screen Shot 1402-09-24 at 18 32 27" src="https://github.com/alirezaei1380/SE-LAB-7/assets/60629485/26ec46a8-1c50-4ff9-8d31-066d6bd48f27">


### Enhancement 1

Objective: Covering update/Get method in PersonService

We added following test to cover update function followed by successful get in the service without raising any errors:

```java

	@Test
	public void testUpdate_successfulUpdateWhenAllTheDataIsFilled() {
		Person person = createSampleUser();

		when(repository.insert(any(Person.class))).thenReturn(person);

		service.insert(person);

		person.setName("TempName");
		person.setAge(24);
		person.setGender(Gender.F);

		service.update(person);
        when(repository.get("TempName")).thenReturn(person);
        Person person1 = service.get("TempName");

		assert person1 != null;
		assert person1.getAge() == 24;
		assert person1.getGender() == Gender.F;

	}
```

And here is the result in method and line coverage:

<img width="575" alt="Screen Shot 1402-09-24 at 18 47 14" src="https://github.com/alirezaei1380/SE-LAB-7/assets/60629485/ec28ada6-5b10-4fea-92d7-3f0b91b4494a">

### Enhancement 2

Objective: Covering failure of get method in PersonService

We added following tests to cover get function in failure case:

```java
	@Test
	public void testGet_shouldFailTryToGetAUserWithNullName() {
		List<String> expectedErrors = Lists.newArrayList("Name is required");
		String expectedMessage = String.join(";", expectedErrors);

		Person person = createSampleUser();

		when(repository.insert(any(Person.class))).thenReturn(person);

		service.insert(person);

		assertThatThrownBy(() -> service.get(null))
				.isInstanceOf(PersonException.class)
				.hasFieldOrPropertyWithValue("errors", expectedErrors)
				.hasMessage(expectedMessage);

	}
```

And here is the result in method and line coverage:

<img width="752" alt="Screen Shot 1402-09-24 at 18 55 01" src="https://github.com/alirezaei1380/SE-LAB-7/assets/60629485/4b30ee9a-da1e-4021-a323-4007e46fe385">


### Enhancement 3

Objective: Covering delete method in PersonService

We added following tests to cover delete function in both successful and failure cases:

```java
	@Test
	public void testDelete_successfulDeleteWhileDeletingSampleUser() {
		Person person = createSampleUser();
		service.delete(person.getName());
	}

	@Test
	public void testDelete_shouldFailWhenTryToDeleteNullUser() {
		List<String> expectedErrors = Lists.newArrayList("Name is required");
		String expectedMessage = String.join(";", expectedErrors);
		assertThatThrownBy(() -> service.delete(null))
				.isInstanceOf(PersonException.class)
				.hasFieldOrPropertyWithValue("errors", expectedErrors)
				.hasMessage(expectedMessage);

	}
```
And here is the result in method and line coverage:

<img width="643" alt="Screen Shot 1402-09-24 at 19 00 41" src="https://github.com/alirezaei1380/SE-LAB-7/assets/60629485/510a32b8-8103-4e24-a5c4-b89dba48e8ad">

### Enhancement 4

Objective: Covering if run method is called in CodeCoverageApplication class or not


We added following tests to check if proper method is called in the class or not:

```java
class CodeCoverageApplicationTests {

	@Mock
	SpringApplication app;

	@Test
	public void testMain_whileLoadingMainFunction() {
		String[] args = {"arg1", "arg2"};
		CodecoverageApplication.main(args);
		Mockito.verify(app).run();
	}

}

```

And here is the result in method and line coverage:

<img width="746" alt="Screen Shot 1402-09-24 at 19 10 15" src="https://github.com/alirezaei1380/SE-LAB-7/assets/60629485/2b9f5953-d499-4679-88bc-30d5bd2f16c9">

### Enhancement 5

Objective: Covering crossedTheCrosswalk method in Footpassenger class


We added following tests to check if data is properly stored:

```java
    @Test
    @DisplayName("Should update cross the cross walk status")
    public void testFootpassengerCrossTheCrossWalk() {

        Traffic currentTrafic = new Traffic();
        currentTrafic.setIntenseCarTraffic(true);

        Footpassenger currentFootpassengerBehavior = new Footpassenger();
        currentFootpassengerBehavior.setCrossedTheCrosswalk(true);
        assertEquals(true, currentFootpassengerBehavior.crossedTheCrosswalk());
    }

```

And here is the result in method and line coverage:

// image

### Enhancement 6

Objective: Covering remained methods in Traffic class


We added following tests to check if data is properly stored:

```java
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

```

And here is the result in method and line coverage:

// image2

### Enhancement 7

Objective: Covering Person Repository class methods


We added following test class

```java
public class PersonRepositoryTest{

    @Test
    @DisplayName("Should throw exception when input is Null")
    public void testPersonRepositoryInsertNullException() {
        PersonRepository personRepository = new PersonRepository();
        Assertions.assertThatThrownBy(() -> personRepository.insert(null))
                .isInstanceOf(NullPointerException.class)
                .hasMessageContaining("person can't be null");
    }

    @Test
    @DisplayName("Should return the same person")
    public void testPersonRepositoryInsert() {
        PersonRepository personRepository = new PersonRepository();
        Person person = new Person();
        assertEquals(person, personRepository.insert(person));
    }

    @Test
    @DisplayName("Should throw exception when input is Null")
    public void testPersonRepositoryUpdate() {
        PersonRepository personRepository = new PersonRepository();
        Assertions.assertThatThrownBy(() -> personRepository.update(null))
                .isInstanceOf(NullPointerException.class)
                .hasMessageContaining("person can't be null");
    }

    @Test
    @DisplayName("Should throw exception when input is Null")
    public void testPersonRepositoryDelete() {
        PersonRepository personRepository = new PersonRepository();
        Assertions.assertThatThrownBy(() -> personRepository.delete(null))
                .isInstanceOf(NullPointerException.class)
                .hasMessageContaining("name can't be null");
    }

    @Test
    @DisplayName("Should throw exception when input is Null")
    public void testPersonRepositoryGetNullException() {
        PersonRepository personRepository = new PersonRepository();
        Assertions.assertThatThrownBy(() -> personRepository.get(null))
                .isInstanceOf(NullPointerException.class)
                .hasMessageContaining("name can't be null");
    }

    @Test
    @DisplayName("Should return null with any input")
    public void testPersonRepositoryGet() {
        PersonRepository personRepository = new PersonRepository();
        assertNull(personRepository.get("test"));
    }

}

```

And here is the result in method and line coverage (we reached 100%):

// image3