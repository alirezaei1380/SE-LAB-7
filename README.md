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
		Person person1 = service.get("TempName");

		assert person1 != null;
		assert person1.getAge() == 24;
		assert person1.getGender() == Gender.F;

	}
```

And here is the result in method and line coverage:


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

### Enhancement 5

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

