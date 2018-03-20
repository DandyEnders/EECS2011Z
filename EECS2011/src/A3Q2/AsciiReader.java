package A3Q2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
/**
 *  The AsciiReader can read ascii data files
 *  @author Robert Schuster
 */
public class AsciiReader extends BufferedReader {

    public AsciiReader(String Filename) throws FileNotFoundException {
        super(new FileReader(Filename));
    }

    /**
     * Read a line of Text and parse it to the DataTypes in the Format Array
     * @param Format an array of the types Float, Double, Integer, Long or String 
     * @param delimiter
     * @return              null if the end of the file is reached
     */
    public Object[] ReadLine(Object[] Format, String delimiter) {
        Object[] result = new Object[Format.length];
        try {
            //read a line from the file
            String line = this.readLine();
            if (line == null) return null;
            //Split the String
            String[] words = line.split(delimiter);
            //loop over each element in the result array
            for (int i=0;i<Format.length;i++) {
                if (Format[i] == Float.class) 
                    result[i] = Float.parseFloat(words[i]);
                else if (Format[i] == Double.class) 
                    result[i] = Double.parseDouble(words[i]);
                else if (Format[i] == Integer.class) 
                    result[i] = Integer.parseInt(words[i]);
                else if (Format[i] == Long.class) 
                    result[i] = Long.parseLong(words[i]);
                else if (Format[i] == String.class) 
                    result[i] = words[i];
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
        return result;
    }


}