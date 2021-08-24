package hw1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.TreeMap;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class HW1Test {
	// When running in the debugger, you must comment out the two lines below!
	@Rule
    public Timeout globalTimeout = Timeout.seconds(1);
	
	
	@SuppressWarnings("unused")
	private ArrayList<Integer> toArrayList(int[] array) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		for(int i : array)
			result.add(i);
		return result;
	}
	
	
	/**
	 * A toy test function. Tests that symbol table behaves as expected when a
	 * single key/value pair is inserted.
	 */
	@Test
	public void testCountEmpty05() {
		String[] empty = {};
		TreeMap<String, Integer> result = HW1.count(empty);
		assertEquals(0, result.size());
		assertNull(result.get("one"));
	}
	
	@Test
	public void testInvertEmpty05() {
		String[] empty = {};
		TreeMap<String, Integer> result = HW1.invert(empty);
		assertEquals(0, result.size());
		assertNull(result.get("one"));
	}

	@Test
	public void testCountOne05() {
		String[] one = {"one"};
		TreeMap<String, Integer> result = HW1.count(one);
		assertEquals(1, result.size());
		assertEquals(1, result.get("one").intValue());
		assertNull(result.get("two"));		
	}
	
	@Test
	public void testInvertOne05() {
		String[] one = {"one"};
		TreeMap<String, Integer> result = HW1.invert(one);
		assertEquals(1, result.size());
		assertEquals(0, result.get("one").intValue());
		assertNull(result.get("two"));		
	}
	
	@Test
	public void testInvertMultipleSingles05() {
		String[] one = {"one"};
		String[] two = {"two"};
		String[] three = {"three"};
		TreeMap<String, Integer> resultOne = HW1.invert(one);
		TreeMap<String, Integer> resultTwo = HW1.invert(two);
		TreeMap<String, Integer> resultThree = HW1.invert(three);
		assertEquals(1, resultOne.size());
		assertEquals(1, resultTwo.size());
		assertEquals(1, resultThree.size());
		assertEquals(0, resultOne.get("one").intValue());
		assertEquals(0, resultTwo.get("two").intValue());
		assertEquals(0, resultThree.get("three").intValue());	
	}
	
	@Test
	public void testCountMultipleSingles05() {
		String[] one = {"one"};
		String[] two = {"two"};
		String[] three = {"three"};
		TreeMap<String, Integer> resultOne = HW1.count(one);
		TreeMap<String, Integer> resultTwo = HW1.count(two);
		TreeMap<String, Integer> resultThree = HW1.count(three);
		assertEquals(1, resultOne.size());
		assertEquals(1, resultTwo.size());
		assertEquals(1, resultThree.size());
		assertEquals(1, resultOne.get("one").intValue());
		assertEquals(1, resultTwo.get("two").intValue());
		assertEquals(1, resultThree.get("three").intValue());	
	}
	
	@Test
	public void testInvertFive05() {
		String[] fruit = {"apple", "cherry", "kiwi", "peach", "banana"};
		TreeMap<String, Integer> result = HW1.invert(fruit);
		assertEquals(5, result.size());
		assertEquals(0, result.get("apple").intValue());
		assertEquals(4, result.get("banana").intValue());
		assertEquals(1, result.get("cherry").intValue());
		assertEquals(2, result.get("kiwi").intValue());
		assertEquals(3, result.get("peach").intValue());
		assertNull(result.get("two"));		
	}
	
	@Test
	public void testCountFive05() {
		String[] fruit = {"apple", "cherry", "kiwi", "peach", "banana"};
		TreeMap<String, Integer> result = HW1.count(fruit);
		assertEquals(5, result.size());
		assertEquals(1, result.get("apple").intValue());
		assertEquals(1, result.get("banana").intValue());
		assertEquals(1, result.get("cherry").intValue());
		assertEquals(1, result.get("kiwi").intValue());
		assertEquals(1, result.get("peach").intValue());
		assertNull(result.get("two"));		
	}
	
	@Test
	public void testInvertFiveRepeats05() {
		String[] repeats = {"zoo", "zoo", "zoo", "zoo", "zoo"};
		TreeMap<String, Integer> result = HW1.invert(repeats);
		assertEquals(1, result.size());
		assertEquals(0, result.get("zoo").intValue());
		assertNull(result.get("animal"));		
	}
	
	@Test
	public void testCountFiveRepeats05() {
		String[] repeats = {"zoo", "zoo", "zoo", "zoo", "zoo"};
		TreeMap<String, Integer> result = HW1.count(repeats);
		assertEquals(1, result.size());
		assertEquals(5, result.get("zoo").intValue());
		assertNull(result.get("animal"));		
	}
	
	@Test
	public void testInvertTen10() {
		String[] words = {"and", "box", "and", "dog", "box", "cat", "cat", "zoo", "dog", "and"};
		TreeMap<String, Integer> result = HW1.invert(words);
		assertEquals(5, result.size());
		assertEquals(0, result.get("and").intValue());
		assertEquals(1, result.get("box").intValue());
		assertEquals(3, result.get("dog").intValue());
		assertEquals(5, result.get("cat").intValue());
		assertEquals(7, result.get("zoo").intValue());
	}
	
	@Test
	public void testCountTen10() {
		String[] words = {"and", "box", "and", "dog", "box", "cat", "cat", "zoo", "dog", "and"};
		TreeMap<String, Integer> result = HW1.count(words);
		assertEquals(5, result.size());
		assertEquals(3, result.get("and").intValue());
		assertEquals(2, result.get("box").intValue());
		assertEquals(2, result.get("dog").intValue());
		assertEquals(2, result.get("cat").intValue());
		assertEquals(1, result.get("zoo").intValue());
	}

	@Test
	public void testInvertLarge10() {
		String[] largeArray1 = new String[10000];
		String[] largeArray2 = new String[10000];	
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				largeArray1[i*100+j] = ""+j;
				largeArray2[i*100+j] = ""+i;
			}
		}
		TreeMap<String, Integer> result1 = HW1.invert(largeArray1);
		TreeMap<String, Integer> result2 = HW1.invert(largeArray2);
		assertEquals(100, result1.size());
		assertEquals(100, result2.size());
		for(int i = 0; i < 100; i++) {
			assertEquals(i, result1.get(""+i).intValue());
			assertEquals(i*100, result2.get(""+i).intValue());
		}
	}
	
	@Test
	public void testCounttLarge10() {
		String[] largeArray1 = new String[10000];
		String[] largeArray2 = new String[10000];	
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				largeArray1[i*100+j] = ""+j;
				largeArray2[i*100+j] = ""+i;
			}
		}
		TreeMap<String, Integer> result1 = HW1.count(largeArray1);
		TreeMap<String, Integer> result2 = HW1.count(largeArray2);
		assertEquals(100, result1.size());
		assertEquals(100, result2.size());
		for(int i = 0; i < 100; i++) {
			assertEquals(100, result1.get(""+i).intValue());
			assertEquals(100, result2.get(""+i).intValue());
		}
	}
}
