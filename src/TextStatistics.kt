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

    // two frequency maps
    // 1: Map<Integer, Integer> <-- word_length --> occurrences
    // 2: Map<Character, Integer> <-- character --> occurrences
    private var wordLengths: MutableMap<Any, Int> ?= null // Any is Int
    private var characters: MutableMap<Any, Int> ?= null // Any is Char

    /**
     * The init method runs these functions to initialize the class-level variables
     */
    init {
        this.wordLengths = mutableMapOf()
        this.characters = mutableMapOf()
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
                val words = it.split(" ")
                lineCount++

                words.forEach {
                    val l = it.length
                    val chars = it.toCharArray()

                    incrementKeyOfMap(wordLengths!!, l)

                    chars.forEach {
                        incrementKeyOfMap(characters!!, it)

                        charCount++
                    }
                    wordCount++
                }
            }
        } else {
            println("File not found. Please try another file.")
            System.exit(1)
        }

        val endTime = System.currentTimeMillis()
        val totalTime = endTime - startTime
        println("...Finished reading file...")
        println("\t\t\t-----")
        println("File reading & processing run time: $totalTime ms\n")
    }

    /**
     * Increments the key of a map by one if the key exists in the map. If the key
     * does not exist in the map, the key is put and its value is set to one.
     * @param [map] the MutableMap where key type is Any and value type is int
     * @param [key] the key for which to look
     */
    private fun incrementKeyOfMap(map: MutableMap<Any, Int>, key: Any) {
        if (map.containsKey(key)) {
            var count = map[key]
            count = count!! + 1
            map[key] = count
        } else {
            map[key] = 1
        }
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
    }

    /**
     * Returns the average number of letters per word in the file
     * @return Float
     */
    fun getAverageNumberOfLettersPerWord(): Float {
        return average(charCount, wordCount, 1)
    }

    /**
     * Computes average to a set decimal point
     *
     * [https://discuss.kotlinlang.org/t/print-floats-with-certain-amount-of-decimal-numbers/1812/3](https://discuss.kotlinlang.org/t/print-floats-with-certain-amount-of-decimal-numbers/1812/3)
     * @param [total] the sum of values
     * @param [count] the count of values
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
     * Returns null if there are no entries.
     *
     * [https://stackoverflow.com/a/47026192/7776826](https://stackoverflow.com/a/47026192/7776826)
     * @return Char
     */
    fun getMostCommonLetter(): Char {
        return characters!!.maxBy { it.value }!!.key as Char// return the key whose value is the greatest
    }
}
