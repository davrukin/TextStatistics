
import java.io.File

/**
 * Program to read file and run certain statistics on it.
 *
 * Whitespace-delimited word count
 *
 * Line count
 *
 * Average number of letters per word (to one decimal place)
 *
 * Most common letter
 *
 * @author Daniel Avrukin
 */

class TextStatistics(filepath: String) {

    private var filepath: String ?= null

    private var lineCount: Int = 0
    private var wordCount: Long = 0
    private var charCount: Long = 0
    // instead of the arrays, have two frequency maps
    // 1: Map<Integer, Integer> <-- word_length --> occurrences 
    // 2: Map<Character, Integer> <-- character --> occurrences
    private var wordLengths: MutableMap<Int, Int> ?= null
    private var characters: MutableMap<Char, Int> ?= null

    init {
        //lines = ArrayList()
        //words = ArrayList()
        wordLengths = mutableMapOf()
        characters = mutableMapOf()
        this.filepath = filepath
        readFile()
    }

    /**
     * Reads the file.
     *
     * Checks if it exists and if it does adds all the lines to an ArrayList of Strings, where each String is a line.
     */
    private fun readFile() {
        val startTime = System.currentTimeMillis()
        println("...Reading file \"${this.filepath}\"...")

        val file = File(this.filepath)
        if (file.exists()) {
            file.forEachLine {
                //lines!!.add(it)  // not necessary, perform your statistics here
                // 1. increment line count
                // 2. split line
                // 3. increment word count by number of words
                // 4. for each word - increment word_length --> count map
                // 5. for each word - iterate over characters and update character --> count map, if you wanted to do it faster, you could have a fixed size array of length a-zA-Z (52) but that wouldn't be portable at all, but would be very fast
                val words = it.split(" ")
                lineCount++

                words.forEach {
                    val l = it.length
                    val chars = it.toCharArray()

                    if (wordLengths!!.containsKey(l)) {
                        var wcount = wordLengths!![l]
                        wcount = wcount!! + 1
                        wordLengths!![l] = wcount
                    } else {
                        wordLengths!![l] = 1
                    }

                    chars.forEach {
                        if (characters!!.containsKey(it)) {
                            var ccount = characters!![it]
                            ccount = ccount!! + 1
                            characters!![it] = ccount
                        } else {
                            characters!![it] = 1
                        }

                        charCount++
                    }

                    wordCount++
                }
            }
        } else {
            println("File not found. Please try another file.")
            println("Set \"lipsum\" to something else and try again.")
        }

        val endTime = System.currentTimeMillis()
        val totalTime = endTime - startTime
        println("...Finished reading file...")
        println("\t\t\t-----")
        println("File reading & processing run time: $totalTime ms\n")
    }

    /**
     * Returns the whitespace-delimited word count in the file
     *
     * https://stackoverflow.com/a/13925522/7776826
     * @return Long
     */
    fun getWordCount(): Long {
        return wordCount
    }

    /**
     * Returns the line count in the file
     * @return Int
     */
    fun getLineCount(): Int {
        return lineCount
        //return lines!!.count()
    }

    /**
     * Returns the average number of letters per word in the file
     * @return Float
     */
    fun getAverageNumberOfLettersPerWord(): Float {
        return average(charCount, wordCount, 1)
    }

    /**
     * Computes average to a single decimal point
     *
     * https://discuss.kotlinlang.org/t/print-floats-with-certain-amount-of-decimal-numbers/1812
     * @param total the sum of values
     * @param count the count of values
     * @param [decimals] the number of decimals which to return
     * @return Float
     */
    private fun average(total: Long, count: Long, decimals: Int): Float {
        val result = total.toFloat() / count.toFloat()
        //println(result)
        return "%.${decimals}f".format(result).toFloat()
    }

    /**
     * Returns the most common letter in the file. If there are multiple, will return first one found.
     *
     * https://stackoverflow.com/a/47026192/7776826
     * @return Char
     */
    fun getMostCommonLetter(): Char {
        return characters!!.maxBy { it.value }!!.key // return the key whose value is the greatest
    }
}
