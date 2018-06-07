class RunnerKotlin {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {

            val ts = TextStatistics()
            println("Word Count: ${ts.getWordCount()}")
            println("Confirm Word Count: ${ts.confirmWordCount()}")
            println("Line Count: ${ts.getLineCount()}")
            println("Average Number of Letters Per Word: ${ts.getAverageNumberOfLettersPerWord()}")
            println("Most Common Letter: ${ts.getMostCommonLetter()}")
        }
    }

}