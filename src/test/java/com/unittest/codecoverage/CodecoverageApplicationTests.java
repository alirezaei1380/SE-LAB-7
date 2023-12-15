package test.java.com.unittest.codecoverage;

import com.unittest.codecoverage.CodecoverageApplication;
import com.unittest.codecoverage.repositories.PersonRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import org.mockito.Mockito;

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
