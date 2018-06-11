/**
 * Runs TestStatistics from Kotlin
 * @author Daniel Avrukin
 */
class RunnerKotlin {

    companion object {

        private lateinit var ts: TextStatistics

        /**
         * The main function
         * @param [args] the command-line arguments
         */
        @JvmStatic
        fun main(args: Array<String>) {
            if (args.isNotEmpty()) {
                runStatistics(args[0])
            } else {
                println("Please add filepath as argument. Program quitting.")
            }
        }

        /**
         * Runs the statistics
         * @param [filepath] the path to the file
         */
        @JvmStatic
        fun runStatistics(filepath: String) {
            ts = TextStatistics(filepath)
            testWordCountWithRunTime()
            testLineCountWithRunTime()
            testAverageWithRunTime()
            testCommonWithRunTime()
        }

        /**
         * Tests the word count and calculates processing time
         */
        private fun testWordCountWithRunTime() {
            val startTime = System.currentTimeMillis()
            println("Word Count: ${ts.getWordCount()}")
            val endTime = System.currentTimeMillis()

            val totalTime = endTime - startTime
            println("Run Time: $totalTime ms\n")
        }

        /**
         * Tests the line count and calculates processing time
         */
        private fun testLineCountWithRunTime() {
            val startTime = System.currentTimeMillis()
            println("Line Count: ${ts.getLineCount()}")
            val endTime = System.currentTimeMillis()

            val totalTime = endTime - startTime
            println("Run Time: $totalTime ms\n")
        }

        /**
         * Tests the average number of letters per word and calculates processing time
         */
        private fun testAverageWithRunTime() {
            val startTime = System.currentTimeMillis()
            println("Average Number of Letters Per Word: ${ts.getAverageNumberOfLettersPerWord()}")
            val endTime = System.currentTimeMillis()

            val totalTime = endTime - startTime
            println("Run Time: $totalTime ms\n")
        }

        /**
         * Tests the most common letter and calculates processing time
         */
        private fun testCommonWithRunTime() {
            val startTime = System.currentTimeMillis()
            println("Most Common Letter: ${ts.getMostCommonLetter()}")
            val endTime = System.currentTimeMillis()

            val totalTime = endTime - startTime
            println("Run Time: $totalTime ms\n")
        }
    }

}
