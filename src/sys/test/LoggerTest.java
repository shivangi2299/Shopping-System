package sys.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import sys.Logger;

//Logger class tests
public class LoggerTest {

	private Logger logger;

	@Before
	public void setUp() {
		logger = new Logger();
	}

	@Test
	public void addLogTest() {
		String log = "test";
		logger.addLog(log);
		List<String> entries = logger.getHistory();
		assertEquals(log, entries.get(0));
		assertFalse(entries.isEmpty());
	}
}
