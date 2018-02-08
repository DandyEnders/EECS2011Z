package A1Q1;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author jameselder
 */
public class testSparseNumericVector {

    /**
     * @param args the command line arguments
     *//*
    public static void main(String[] args) {
        SparseNumericVector X = new SparseNumericVector();
        SparseNumericVector Y = new SparseNumericVector();
        double projection;

        X.add(new SparseNumericElement(150000, 3.1415));
        X.add(new SparseNumericElement(15, 3));
        X.add(new SparseNumericElement(1500, 3.14));
        X.add(new SparseNumericElement(150, 3.1));
        X.add(new SparseNumericElement(15000, 3.141));
        Y.add(new SparseNumericElement(150000, 1));
        Y.add(new SparseNumericElement(15, 1));
        X.remove((long) 150);

        projection = X.dot(Y);

        System.out.println("The inner product of");
        System.out.print(X);
        System.out.println("and");
        System.out.print(Y);
        System.out.println("is ");
        System.out.printf("%.5f\n\n",projection); //answer should be 3*1 + 3.1415*1 = 6.1415
     }*/
    
	@AfterEach
	public void after() {
		System.out.println("-");
	}
	
    @Test
    public void Test1_InitializeVector() {
    	SparseNumericVector X = new SparseNumericVector();
    }
    
    @Test
    public void Test2_AddOneAndCheckSize() {
    	SparseNumericVector X = new SparseNumericVector();
    	X.add(new SparseNumericElement(15, 3));
    	System.out.println(X.toString());
    	assertEquals(1,X.getSize(),"Size must be 1 when you add one element!");
    }
    
    @Test
    public void Test3_AddTwoAndCheckSize() {
    	SparseNumericVector X = new SparseNumericVector();
    	X.add(new SparseNumericElement(15, 3));
    	X.add(new SparseNumericElement(1500, 3.14));
    	System.out.println(X.toString());
    	assertEquals(2,X.getSize(),"Size must be 2 when you add two elements!");
    }
    
    @Test
    public void Test4_AddThreeAndCheckSize() {
    	SparseNumericVector X = new SparseNumericVector();
    	X.add(new SparseNumericElement(15, 3));
    	X.add(new SparseNumericElement(1500, 3.14));
    	X.add(new SparseNumericElement(15000, 3.141));
    	System.out.println(X.toString());
    	assertEquals(3,X.getSize(),"Size must be 3 when you add three elements!");
    }
    
    @Test
    public void Test5_RemovingOneCheckSize() {
    	SparseNumericVector X = new SparseNumericVector();
    	X.add(new SparseNumericElement(15, 3));
    	X.add(new SparseNumericElement(1500, 3.14));
    	X.add(new SparseNumericElement(15000, 3.141));
    	X.remove(15L);
    	System.out.println(X.toString());
    	assertEquals(2,X.getSize(),"Size must be 2!");
    }
    
    @Test
    public void Test6_RemovingTwoCheckSize() {
    	SparseNumericVector X = new SparseNumericVector();
    	X.add(new SparseNumericElement(15, 3));
    	X.add(new SparseNumericElement(1500, 3.14));
    	X.add(new SparseNumericElement(15000, 3.141));
    	X.remove(15L);
    	X.remove(1500L);
    	System.out.println(X.toString());
    	assertEquals(1,X.getSize(),"Size must be 1!");
    }
    
    @Test
    public void Test7_RemovingThreeCheckSize() {
    	SparseNumericVector X = new SparseNumericVector();
    	X.add(new SparseNumericElement(15, 3));
    	X.add(new SparseNumericElement(1500, 3.14));
    	X.add(new SparseNumericElement(15000, 3.141));
    	X.remove(15L);
    	X.remove(1500L);
    	X.remove(15000L);
    	System.out.println(X.toString());
    	assertEquals(0,X.getSize(),"Size must be 0!");
    }
    
}
