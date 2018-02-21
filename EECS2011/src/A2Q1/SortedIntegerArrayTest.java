package A2Q1;

import static org.junit.Assert.assertEquals;

import org.junit.*;
import org.junit.runners.MethodSorters;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class SortedIntegerArrayTest {
	
	
	
	@Test
	public void test_1_ArrayFilledZero() {
		
		boolean expected = false;
		
		int[] myIntegerArray;
		
		myIntegerArray = new int[2];
		myIntegerArray[0] = 0;
		myIntegerArray[1] = 0;
		
		SortedIntegerArray mySortedIntegerArray = new SortedIntegerArray(myIntegerArray);
		
		boolean actual = mySortedIntegerArray.kPairSum(1);
		assertEquals("How can zeros add up to 1?",expected, actual);
	}
	
	@Test
	public void test_2_ArrayFilledOnes() {
		
		boolean expected = true;
		
		int[] myIntegerArray;
		
		myIntegerArray = new int[2];
		myIntegerArray[0] = 1;
		myIntegerArray[1] = 1;
		
		SortedIntegerArray mySortedIntegerArray = new SortedIntegerArray(myIntegerArray);
		
		boolean actual = mySortedIntegerArray.kPairSum(2);
		
		assertEquals("1 + 1 != 2?",expected, actual);
	}
	
	@Test
	public void test_3_ArrayZeroToThree() {
		
		boolean expected = false;
		
		int[] myIntegerArray;
		
		myIntegerArray = new int[4];
		myIntegerArray[0] = 0;
		myIntegerArray[1] = 1;
		myIntegerArray[2] = 2;
		myIntegerArray[3] = 3;
		
		SortedIntegerArray mySortedIntegerArray = new SortedIntegerArray(myIntegerArray);
		
		boolean actual = mySortedIntegerArray.kPairSum(7);
		
		assertEquals("How can you find a pair from 0-3 to add up 7?",expected, actual);
	}
	
	@Test
	public void test_4_ArrayMAXVALUES() {
		
		boolean expected = false;
		
		int[] myIntegerArray;
		
		myIntegerArray = new int[3];
		myIntegerArray[0] = Integer.MAX_VALUE;
		myIntegerArray[1] = Integer.MAX_VALUE;
		myIntegerArray[2] = Integer.MAX_VALUE;
		
		SortedIntegerArray mySortedIntegerArray = new SortedIntegerArray(myIntegerArray);
		
		boolean actual = mySortedIntegerArray.kPairSum(0);
		
		assertEquals("MAX VALUE HAPPENED?",expected, actual);
	}
	
	@Test
	public void test_5_GivenExampleTest1() {
		
		boolean expected = true;
		
		int[] myIntegerArray;
		
		myIntegerArray = new int[6];
		myIntegerArray[0] = 3;
		myIntegerArray[1] = 4;
		myIntegerArray[2] = 4;
		myIntegerArray[3] = 6;
		myIntegerArray[4] = 8;
		myIntegerArray[5] = 9;
		
		
		SortedIntegerArray mySortedIntegerArray = new SortedIntegerArray(myIntegerArray);
		
		boolean actual = mySortedIntegerArray.kPairSum(10);
		
		assertEquals("4 + 6 should be a pair add up to 10.",expected, actual);
	}
	
	@Test
	public void test_6_GivenExampleTest2() {
		
		int[] myIntegerArray;
		
		myIntegerArray = new int[6];
		myIntegerArray[0] = 3;
		myIntegerArray[1] = 4;
		myIntegerArray[2] = 4;
		myIntegerArray[3] = 6;
		myIntegerArray[4] = 8;
		myIntegerArray[5] = 9;
		
		
		SortedIntegerArray mySortedIntegerArray = new SortedIntegerArray(myIntegerArray);
		
		boolean expected = false;
		boolean actual = mySortedIntegerArray.kPairSum(16);
		
		assertEquals("4 + 6 should be a pair add up to 10.",expected, actual);
	}
	
	@Test
	public void test_7_AllFour() {
		
		int[] myIntegerArray;
		
		myIntegerArray = new int[6];
		myIntegerArray[0] = 4;
		myIntegerArray[1] = 4;
		myIntegerArray[2] = 4;
		myIntegerArray[3] = 4;
		myIntegerArray[4] = 4;
		myIntegerArray[5] = 4;
		
		
		SortedIntegerArray mySortedIntegerArray = new SortedIntegerArray(myIntegerArray);
		
		boolean expected = true;
		boolean actual = mySortedIntegerArray.kPairSum(8);
		
		assertEquals("They should add up to 8.",expected, actual);
	}
	
	@Test
	public void test_8_AllFour1() {
		
		int[] myIntegerArray;
		
		myIntegerArray = new int[6];
		myIntegerArray[0] = 4;
		myIntegerArray[1] = 4;
		myIntegerArray[2] = 4;
		myIntegerArray[3] = 4;
		myIntegerArray[4] = 4;
		myIntegerArray[5] = 4;
		
		
		SortedIntegerArray mySortedIntegerArray = new SortedIntegerArray(myIntegerArray);
		
		boolean expected = true;
		boolean actual = mySortedIntegerArray.kPairSum(8);
		
		assertEquals("They should add up to 8.",expected, actual);
	}
	
	@Test
	public void test_9_AllFour2() {
		
		int[] myIntegerArray;
		
		myIntegerArray = new int[6];
		myIntegerArray[0] = 4;
		myIntegerArray[1] = 4;
		myIntegerArray[2] = 4;
		myIntegerArray[3] = 4;
		myIntegerArray[4] = 4;
		myIntegerArray[5] = 4;
		
		
		SortedIntegerArray mySortedIntegerArray = new SortedIntegerArray(myIntegerArray);
		
		boolean expected = false;
		boolean actual = mySortedIntegerArray.kPairSum(9);
		
		assertEquals("You can make 9 with only 4s? YOU ARE A MAGICIAN.",expected, actual);
	}
	
	@Test
	public void test_10_EVERYTHING_IS_RANDOM_BE_PREPARED() {
		
		int numberOfRandomTest = 20;
		
		for(int i = 0 ; i < numberOfRandomTest; i++ ) {
			
			int arraySize = (int)(Math.random() * 100);
			int[] myIntegerArray = new int[arraySize];
			
			for(int j = 0; j < myIntegerArray.length;j++) {
				myIntegerArray[j] = (int)(Math.random() * 10);
				System.out.print(myIntegerArray[j] + " ");
			}
			
			int firstCandidate = (int)(Math.random()*arraySize);
			int secondCandidate;
			
			do{
				secondCandidate = (int)(Math.random()*arraySize);
			}while(firstCandidate == secondCandidate);
			
			int actualSum = myIntegerArray[firstCandidate] + myIntegerArray[secondCandidate];
			
			
			SortedIntegerArray mySortedIntegerArray = new SortedIntegerArray(myIntegerArray);
			
			boolean expected = true;
			boolean actual = mySortedIntegerArray.kPairSum(actualSum);
			
			assertEquals("I picked " + myIntegerArray[firstCandidate] + " on index " + firstCandidate
					+ " and " + myIntegerArray[secondCandidate] + " " + " on index " + secondCandidate
					+ " and their sum is " +actualSum +" THIS SHOULD BE TRUE MAGGOT!",expected, actual);
		
		}
	}
}
