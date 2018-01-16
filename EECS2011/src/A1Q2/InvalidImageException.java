package A1Q2;

/**
 *
 * @author jameselder
 */
public class InvalidImageException extends Exception {

    /**
     * Creates a new instance of <code>InvalidImageException</code> without detail message.
     */
    public InvalidImageException() {
    }


    /**
     * Constructs an instance of <code>InvalidImageException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public InvalidImageException(String msg) {
        super(msg);
    }
}
