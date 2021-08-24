package hw1;

import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class JarTest {
	// When running in the debugger, you must comment out the two lines below!
	@Rule
    public Timeout globalTimeout = Timeout.seconds(1);

	@Test
	public void testBag10() {
		edu.princeton.cs.algs4.Bag<String> b = new edu.princeton.cs.algs4.Bag<String>();
		b.add("hello");
		assertEquals(1, b.size());
		for(String s : b) {
			assertEquals("hello", s);
		}
	}
}
