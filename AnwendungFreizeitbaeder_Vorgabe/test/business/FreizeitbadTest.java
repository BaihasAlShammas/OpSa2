package business;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FreizeitbadTest {

	private Freizeitbad freizeitbad;

	@BeforeEach
	public void setUp() throws Exception {
		this.freizeitbad = new Freizeitbad("Stadtbad", "7.00", "17.00", "25", "24");
	}

	@AfterEach
	public void tearDown() throws Exception {
		this.freizeitbad = null;
	}

	@Test
	public void test() {
		assertTrue(freizeitbad.getBeckenlaenge() == 25, "Baackenlaenge nicht auf 25 gesezzt");
	}
}
