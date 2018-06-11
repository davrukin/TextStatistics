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
        run();
    }

    /**
     * Runs the statistics
     */
    public static void run() {
        TextStatistics ts = new TextStatistics("res/big.txt");
        ts.getWordCount();
        ts.getLineCount();
        ts.getAverageNumberOfLettersPerWord();
        ts.getMostCommonLetter();
    }

}
