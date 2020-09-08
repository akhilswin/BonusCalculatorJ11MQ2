package yaksha;

import static yaksha.TestUtils.businessTestFile;
import static yaksha.TestUtils.currentTest;
import static yaksha.TestUtils.yakshaAssert;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;
import org.junit.jupiter.api.Test;

class MainClassTest {

	@Test
	public void testExceptionConditon() throws Exception {

		TestUtils.yakshaAssert(TestUtils.currentTest(), true, TestUtils.boundaryTestFile);
	}

	@Test
	public void testBoundaryCondition() throws Exception {

		TestUtils.yakshaAssert(TestUtils.currentTest(), true, TestUtils.exceptionTestFile);
	}

	@Test
	void testCalculateBonus() throws Exception {
		// Test will pass
		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		HashMap<Integer, Integer> hm1 = new HashMap<Integer, Integer>();
		TreeMap<Integer, Integer> hm2 = new TreeMap<Integer, Integer>();
		hm2.put(1010, 12000);
		hm2.put(2020, 17280);
		hm.put(1010, "20-12-1987");
		hm1.put(2020, 14400);
		String expectedResult[] = { "1010=12000", "2020=17280" };
		List<String> list1 = Arrays.asList(expectedResult);
		TreeMap<Integer, Integer> result3 = BonusCalculator.calculateBonus(hm, hm1);
		var list2 = Arrays.asList(result3);
		yakshaAssert(currentTest(), (list1.containsAll(list2) ? "true" : "false"), businessTestFile);
	}
}
