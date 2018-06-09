class RunnerKotlin {

    companion object {

        private val ts = TextStatistics("res/gigabyte.txt")

        @JvmStatic
        fun main(args: Array<String>) {
            testWordCountWithRunTime()
            testLineCountWithRunTime()
            testAverageWithRunTime()
            testCommonWithRunTime()
        }

        private fun testWordCountWithRunTime() {
            val startTime = System.currentTimeMillis()
            println("Word Count: ${ts.getWordCount()}")
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

        private fun testCommonWithRunTime() {
            val startTime = System.currentTimeMillis()
            println("Most Common Letter: ${ts.getMostCommonLetter()}")
            val endTime = System.currentTimeMillis()

            val totalTime = endTime - startTime
            println("Run Time: $totalTime ms\n")
        }
    }

}