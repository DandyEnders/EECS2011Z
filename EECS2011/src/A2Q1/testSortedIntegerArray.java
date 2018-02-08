package A2Q1;
import java.util.*;

/**
 *
 * @author jameselder
 */
public class testSortedIntegerArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] myIntegerArray = new int[10];

        SortedIntegerArray mySortedIntegerArray;
        int k;

        // Random test input
        // Ron - you might want to use the same random input on each program.
        for (int i = 1; i < 4; i++) {
            for (int j = 0; j < myIntegerArray.length; j++) {
                myIntegerArray[j] = (int) (10.0 * Math.random()) + 1;
            }
            mySortedIntegerArray = new SortedIntegerArray(myIntegerArray);
            k = (int) (20.0 * Math.random()) + 1;
            if (mySortedIntegerArray.kPairSum(k)) {
                System.out.println("The array" + Arrays.toString(myIntegerArray) + " contains two elements that sum to " + k);
            } else {
                System.out.println("The array" + Arrays.toString(myIntegerArray) + " does not contain two elements that sum to " + k);
            }
        }

        // Non-random test input
        int[][] myIntegerArrays = new int[3][];

        myIntegerArrays[0] = new int[0];
        myIntegerArrays[1] = new int[1];
        myIntegerArrays[1][0] = 1;
        myIntegerArrays[2] = new int[2];
        myIntegerArrays[2][0] = Integer.MAX_VALUE;
        myIntegerArrays[2][1] = 0;
        k = Integer.MAX_VALUE;

        for (int i = 0; i < 3; i++) {
            mySortedIntegerArray = new SortedIntegerArray(myIntegerArrays[i]);
            if (mySortedIntegerArray.kPairSum(k)) {
                System.out.println("The array" + Arrays.toString(myIntegerArrays[i]) + " contains two elements that sum to " + k);
            } else {
                System.out.println("The array" + Arrays.toString(myIntegerArrays[i]) + " does not contain two elements that sum to " + k);
            }
        }
    }
}