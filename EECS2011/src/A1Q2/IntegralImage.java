package A1Q2;

/**
 * Represents an integer integral image, which allows the user to query the mean
 * value of an arbitrary rectangular subimage in O(1) time. Uses O(n) memory,
 * where n is the number of pixels in the image.
 *
 * @author jameselder
 */
public class IntegralImage {

	private final int[][] integralImage;
	private final int[][] rectangularTotal;
	private final int imageHeight; 			// height of image (first index)
	private final int imageWidth; 			// width of image (second index)

	/**
	 * Constructs an integral image from the given input image.
	 *
	 * @author jameselder
	 * @param image
	 *            The image represented
	 * @throws InvalidImageException
	 *             Thrown if input array is not rectangular
	 */
	public IntegralImage(int[][] image) throws InvalidImageException {
		// implement this method.

		// case 1 the image is not empty
		if (image.length != 0) {

			// get the length of the first row
			int firstRowLength = image[0].length;

			// case 1.1 if rows are disuniform -> InvalidImageException
			for (int[] testRow : image) {
				if (testRow.length != firstRowLength) {
					throw new InvalidImageException();
				}
			}

		}

		// initiallize image / Height / Width
		this.integralImage = image;

		this.imageHeight = integralImage.length;
		this.imageWidth = integralImage[0].length;

		// create a new 2D array containing rectangular sums

		rectangularTotal = new int[imageHeight][imageWidth];
		
		for (int i = 0; i < rectangularTotal.length; i++) {
			for (int j = 0; j < rectangularTotal[0].length; j++) {
				
				if(i == 0 && j == 0) { // 0 0
					rectangularTotal[0][0] = integralImage[0][0];
				}else if (i == 0) { // first row
					rectangularTotal[i][j] = rectangularTotal[i][j-1] + integralImage[i][j];
				}else if (j == 0) { // first column
					rectangularTotal[i][j] = rectangularTotal[i-1][j] + integralImage[i-1][j];
				}else {
					rectangularTotal[i][j] = 0 - rectangularTotal[i-1][j-1] + rectangularTotal[i-1][j]
											+rectangularTotal[i][j-1] + integralImage[i][j];
				}
				
				
			}
		}

	}

	/**
	 * Returns the mean value of the rectangular sub-image specified by the top,
	 * bottom, left and right parameters. The sub-image should include pixels in
	 * rows top and bottom and columns left and right. For example, top = 1, bottom
	 * = 2, left = 1, right = 2 specifies a 2 x 2 sub-image starting at (top, left)
	 * coordinate (1, 1).
	 *
	 * @author jameselder
	 * @param top
	 *            top row of sub-image
	 * @param bottom
	 *            bottom row of sub-image
	 * @param left
	 *            left column of sub-image
	 * @param right
	 *            right column of sub-image
	 * @return
	 * @throws BoundaryViolationException
	 *             if image indices are out of range
	 * @throws NullSubImageException
	 *             if top > bottom or left > right
	 */
	public double meanSubImage(int top, int bottom, int left, int right)
			throws BoundaryViolationException, NullSubImageException {

		if (top < 0 || 								// if top is smaller then array height 0
				bottom > integralImage.length ||	// if bottom is bigger then array height
				left < 0 || 						// if left is smaller then array width 0
				right > integralImage[0].length) 	// if right is bigger then array width
		{
			throw new BoundaryViolationException(); // throw exception
		}

		if (top > bottom || // ---------------------//if top is bigger then bottom
				left > right // --------------------//if left is bigger than right
		) {
			throw new NullSubImageException(); 		// throw exception
		}

		double totalImageSum = 0;
		int topRectangleSum = 0;
		int leftRectangleSum = 0;
		int rightBottomTotalSum = 0;
		int overlapSum = 0;
		
		if(top > 0){topRectangleSum = rectangularTotal[top-1][right];}
		if(left > 0) {leftRectangleSum = rectangularTotal[bottom][left-1];}
		rightBottomTotalSum = rectangularTotal[bottom][right];
		
		if(top > 0 && left > 0){overlapSum = rectangularTotal[top-1][left-1];}
		
		totalImageSum = rightBottomTotalSum - topRectangleSum - leftRectangleSum + overlapSum;

		double n = (bottom - top) + (right - left) + 2;

		double mean = (double) (totalImageSum / n);

		return mean;
	}

}
