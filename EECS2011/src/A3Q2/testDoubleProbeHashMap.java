package A3Q2;

/**
 * Tests DoubleProbeHashMap
 *
 * @author jameselder
 */
public class testDoubleProbeHashMap {

    public static void main(String[] args) throws Exception {
        AsciiReader marathonReader;
        Object[] Format = {Integer.class, String.class,
            String.class, String.class, String.class, String.class};
        Object[] result;
        //ProbeHashMap<String, MarathonRunner> marathonMap = new ProbeHashMap<>(7500);
        DoubleProbeHashMap<String, MarathonRunner> marathonMap = new DoubleProbeHashMap<>(7500);
        MarathonRunner marathonRunner;

        try {
            //marathonReader = new AsciiReader("marathon.csv");
            marathonReader = new AsciiReader("marathon2017.csv");
            do {
                result = marathonReader.ReadLine(Format, ",");
                if (result != null) {
                    marathonRunner = new MarathonRunner((Integer) result[0],
                            (String) result[1], (String) result[2], 
                            (String) result[3], (String) result[4], 
                            (String) result[5]
                    );
                    //System.out.println(marathonRunner.toString());
                    try { //use name and category as key
                        marathonRunner = marathonMap.put((String) result[3] + " " 
                                + (String) result[4] + " " + (String) result[5], marathonRunner);
                        if (marathonRunner != null) {
                            System.out.println(marathonRunner.toString()); //print duplicates
                        }
                    } catch (Exception ex) {
                        System.out.println("Incorrect: ProbeHashMap.put threw an exception.");
                    }
                }
            } while (result != null);
        } catch (Exception x) {
            System.out.println("File not found");
        }

        try {
            marathonRunner = marathonMap.get("Cartmell Greg M25-29");
            System.out.println(marathonRunner.toString());
        } catch (Exception ex) {
            System.out.println("Incorrect: DoubleProbeHashMap.get threw an exception.");
        }
        System.out.println("Total Probes: " + marathonMap.getTotalProbes());

    }
}
