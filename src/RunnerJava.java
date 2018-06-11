/**
 * Runs TextStatistics with Java
 * @author Daniel Avrukin
 */
public class RunnerJava {

    /**
     * The main function
     * @param args the command-line arguments
     */
    public static void main(String[] args) {

        //RunnerKotlin.runStatistics("res/big.txt");
        //RunnerKotlin.main(new String[]{"res/big.txt"});
        if (args.length > 0) {
            if (args[0] != null) {
                run(args[0]);
            } else {
                System.out.println("Please add filepath as argument. Program quitting.");
            }
        } else {
            System.out.println("Please add filepath as argument. Program quitting.");
        }
    }

    /**
     * Runs the statistics
     * @param filepath the path to the file
     */
    public static void run(String filepath) {
        TextStatistics ts = new TextStatistics(filepath);
        ts.getWordCount();
        ts.getLineCount();
        ts.getAverageNumberOfLettersPerWord();
        ts.getMostCommonLetter();
    }

}
