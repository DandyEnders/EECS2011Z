package A4Q1;

import java.util.*;

/**
 *
 * Provides two static methods for sorting Integer arrays (heapSort and
 * mergeSort)
 * 
 * @author jameselder
 */
public class YorkArrays {

	/*
	 * Sorts the input array of Integers a using HeapSort. Result is returned in a.
	 * Makes use of java.util.PriorityQueue. Sorting is NOT in place - PriorityQueue
	 * allocates a separate heap-based priority queue. Not a stable sort, in
	 * general. Throws a null pointer exception if the input array is null.
	 */
	public static void heapSort(Integer[] a) throws NullPointerException {
		if (a == null) {
			throw new NullPointerException();
		}
		PriorityQueue<Integer> sorted = new PriorityQueue<Integer>(a.length);

		for (Integer number : a) {
			sorted.add(number);
		}

		for (int i = 0; i < a.length; i++) {
			a[i] = sorted.poll();
		}

	}

	/*
	 * Sorts the input array of Integers a using mergeSort and returns result.
	 * Sorting is stable. Throws a null pointer exception if the input array is
	 * null.
	 */
	public static Integer[] mergeSort(Integer[] a) throws NullPointerException {
		if (a == null) {
			throw new NullPointerException();
		}
		
		
		
		return (mergeSort(a, 0, a.length - 1));
	}

	/* 1 2 3 4 5
	 * 1 2
	 * 1
	 *   2
	 * 1 2
	 * Sorts the input subarray of Integers a[p...q] using MergeSort and returns
	 * result. Sorting is stable.
	 */
	private static Integer[] mergeSort(Integer[] a, int p, int q) {
		
		if(a.length > 1) {
			
			int half = a.length/2;
			Integer[] firstHalf = new Integer[half];
			Integer[] secondHalf = new Integer[a.length - half];
			
			for(int i = 0 ,j = 0 ; i < a.length ; i++) {
				if(i < half) {
					firstHalf[i] = a[i];
				}else {
					secondHalf[j] = a[i];
					j++;
				}
			}
			
			firstHalf = mergeSort(firstHalf, p, firstHalf.length);
			secondHalf = mergeSort(secondHalf, p, secondHalf.length);
			
			Integer[] sortedFull = merge(firstHalf, secondHalf);
			
			return sortedFull;
			
		}
		return a;
		

	}

	

	/*
	 * Merges two sorted arrays of Integers into a single sorted array. Given two
	 * equal elements, one in a and one in b, the element in a precedes the element
	 * in b.
	 */
	private static Integer[] merge(Integer[] a, Integer[] b) {

		
		if(a.length == 0){
			return b;
		}
		
		if(b.length == 0){
			return a;
		}
		
		Integer[] returnList = new Integer[a.length + b.length];
		
		{
			int i = 0;
			int j = 0;
			int currentFlag = 0;
	
			while (i < a.length && j < b.length) {
				if (a[i] <= b[j]) {
					returnList[currentFlag] = a[i];
					i++;
				} else {
					returnList[currentFlag] = b[j];
					j++;
				}
				currentFlag++;
			}
	
			while(i < a.length) {
				returnList[currentFlag] = a[i];
				i++;
				currentFlag++;
			}
			while(j < b.length) {
				returnList[currentFlag] = b[j];
				j++;
				currentFlag++;
			}
			
		}

		return returnList;

	}
}