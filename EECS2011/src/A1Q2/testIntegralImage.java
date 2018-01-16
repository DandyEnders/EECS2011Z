package A1Q2;

/**
 * Tests the IntegralImage class.
 * @author jameselder
 */
public class testIntegralImage {

    public static void main(String[] args) {
        int[][] image1 = {{1, 2, 3}, 
        				  {4, 5, 6}, 
        				  {7, 8, 9}};
        int top,bottom,left,right;
        double mean;

        IntegralImage integralImage1;
        top = 1;
        bottom = 2;
        left = 1;
        right = 2;
        
        try {
            integralImage1 = new IntegralImage(image1);
        } catch (InvalidImageException iix) {
            System.out.println("Invalid Image Exception");
            return;
        }
       try {
            mean = integralImage1.meanSubImage(top, bottom, left, right); //should be 7.0
            System.out.println("The mean of the subimage from ("
                    + top + "," + left + ") to (" + bottom + "," + right + ") is " + mean);
        } catch (BoundaryViolationException bvx) {
            System.out.println("Index out of range.");
        } catch (NullSubImageException nsix) {
            System.out.println("Null sub-image.");
        }

    }
}
