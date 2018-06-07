class RunnerKotlin {

    companion object {

        private val ts = TextStatistics()

        @JvmStatic
        fun main(args: Array<String>) {

            /*println("Word Count: ${ts.getWordCount()}")
            println("Confirm Word Count: ${ts.confirmWordCount()}")
            println("Line Count: ${ts.getLineCount()}")
            println("Average Number of Letters Per Word: ${ts.getAverageNumberOfLettersPerWord()}")
            println("Most Common Letter: ${ts.getMostCommonLetter()}")*/

            testWordCountWithRunTime()
            testWordCountNewWithRunTime()
            testLineCountWithRunTime()
            testAverageWithRunTime()
            testAverageNewWithRunTime()
            testCommonWithRunTime()
            testCommonNewWithRunTime()
        }

        private fun testWordCountWithRunTime() {
            val startTime = System.currentTimeMillis()
            println("Word Count: ${ts.getWordCount()}")
            val endTime = System.currentTimeMillis()

            val totalTime = endTime - startTime
            println("Run Time: $totalTime ms\n")
        }

        private fun testWordCountNewWithRunTime() {
            val startTime = System.currentTimeMillis()
            println("Word Count New: ${ts.getWordCountNew()}")
            val endTime = System.currentTimeMillis()

            val totalTime = endTime - startTime
            println("Run Time: $totalTime ms\n")
        }

        private fun testLineCountWithRunTime() {
            val startTime = System.currentTimeMillis()
            println("Line Count: ${ts.getLineCount()}")
            val endTime = System.currentTimeMillis()

            val totalTime = endTime - startTime
            println("Run Time: $totalTime ms\n")
        }

        private fun testAverageWithRunTime() {
            val startTime = System.currentTimeMillis()
            println("Average Number of Letters Per Word: ${ts.getAverageNumberOfLettersPerWord()}")
            val endTime = System.currentTimeMillis()

            val totalTime = endTime - startTime
            println("Run Time: $totalTime ms\n")
        }

        private fun testAverageNewWithRunTime() {
            val startTime = System.currentTimeMillis()
            println("Average Number of Letters Per Word New: ${ts.getAverageNumberOfLettersPerWordNew()}")
            val endTime = System.currentTimeMillis()

            val totalTime = endTime - startTime
            println("Run Time: $totalTime ms\n")
        }

        private fun testCommonWithRunTime() {
            val startTime = System.currentTimeMillis()
            println("Most Common Letter: ${ts.getMostCommonLetter()}")
            val endTime = System.currentTimeMillis()

            val totalTime = endTime - startTime
            println("Run Time: $totalTime ms\n")
        }

        private fun testCommonNewWithRunTime() {
            val startTime = System.currentTimeMillis()
            println("Most Common Letter New: ${ts.getMostCommonLetterNew()}")
            val endTime = System.currentTimeMillis()

            val totalTime = endTime - startTime
            println("Run Time: $totalTime ms\n")
        }
    }

}