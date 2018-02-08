package A2Q1;
import java.util.*;
/**
 * Represents a sorted integer array.  Provides a method, kpairSum, that
 * determines whether the array contains two elements that sum to a given
 * integer k.  Runs in O(n) time, where n is the length of the array.
 * @author jameselder
 */
public class SortedIntegerArray {

    protected int[] sortedIntegerArray;
    protected long[] sortedLongArray;

    public SortedIntegerArray(int[] integerArray) {
        sortedIntegerArray = integerArray.clone();
        Arrays.sort(sortedIntegerArray);
        sortedLongArray = new long[sortedIntegerArray.length];
        
        for(int i = 0; i <sortedIntegerArray.length ; i++) {
    		sortedLongArray[i] = (long)sortedIntegerArray[i];
    	}
    }

/**
 * Determines whether the array contains two elements that sum to a given
 * integer k. Runs in O(n) time, where n is the length of the array.
 * @author jameselder
 */
    public boolean kPairSum(Integer k) { // 3 4 4 6 8 9
    	return kPairSumInterval(k,0,sortedIntegerArray.length-1);
    }
    
    private boolean kPairSumInterval(Integer k, int i, int j){
    	int intervalLength = j-i+1;
    	
    	if(intervalLength <= 1) {
    		return false;
    	}
    	
    	if( sortedIntegerArray[i] + sortedIntegerArray[j] == k ) {
			return true;
		}
    	
    	if(intervalLength == 2 && sortedIntegerArray[i] + sortedIntegerArray[j] != k) {
    		return kPairSumInterval(k,i+1,sortedIntegerArray.length-1);
    	}
    	
    	return kPairSumInterval(k,i,j-1);
    }
}