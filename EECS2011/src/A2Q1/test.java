package A2Q1;

import java.util.*;

/**
 *
 * @author jameselder
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        int[] a = {9531,
        4573,
        629,
        8694,
        6203,
        6454,
        3749,
        8529,
        3383,
        7639,
        2269,
        9499,
        9329,
        7846,
        4415,
        7582,
        167,
        9158,
        9052,
        3844,
        8037,
        6253,
        1754,
        8083,
        3935,
        7203,
        554};
        int[] myIntegerArray = new int[10];
        SortedIntegerArray mySortedIntegerArray;
        int k;

        // Random test input
        // Ron - you might want to use the same random input on each program.
            mySortedIntegerArray = new SortedIntegerArray(a);
            k=15485;
            if (mySortedIntegerArray.kPairSum(k)) {
                System.out.println("The array" + Arrays.toString(a) + " contains two elements that sum to " + k);
            } else {
                System.out.println("The array" + Arrays.toString(a) + " does not contain two elements that sum to " + k);
            }
    }
}