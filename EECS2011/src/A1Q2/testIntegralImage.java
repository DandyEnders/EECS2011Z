package A1Q2;

/**
 * Tests the IntegralImage class.
 * @author jameselder
 */
public class testIntegralImage {

    public static void main(String[] args) {
        int[][] image1 = {{1,2,5,7,2,8,0,6,4,6},{9,8,0,4,9,5,10,7,10,3},{7,6,10,2,0,10,4,9,10,8},{3,8,1,5,4,8,0,9,5,8},{9,5,0,1,3,4,1,9,6,1},{1,2,5,6,9,9,0,2,4,0},{1,2,4,1,6,6,10,4,2,5},{5,6,2,10,5,3,9,10,10,2}};
        
        int top,bottom,left,right;
        double mean;

        IntegralImage integralImage1;
        top = 0;
        bottom =5;
        left = 0;
        right = 7;
        
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
