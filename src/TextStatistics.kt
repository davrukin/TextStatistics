import io.reactivex.rxkotlin.toObservable
import java.io.File
import java.util.regex.Pattern

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

class TextStatistics() {

    private val lipsum: String = "res/gigabyte.txt"   // EVIL!!!  WHY???

    private var lines: ArrayList<String> ?= null  // This is not necessary
    private var lineCount: Int = 0
    private var wordCount: Long = 0
    private var letterCount: Long = 0
    private var words: ArrayList<String> ?= null  // This is not necessary
    // instead of the arrays, have two frequency maps
    // 1: Map<Integer, Integer> <-- word_length --> occurrences 
    // 2: Map<Character, Integer> <-- character --> occurrences

    init {
        lines = ArrayList()
        words = ArrayList()
        readFile()
    }

    /**
     * Reads the file.
     *
     * Checks if it exists and if it does adds all the lines to an ArrayList of Strings, where each String is a line.
     */
    private fun readFile(/* take argument as the file */) {
        val file = File(lipsum)
        if (file.exists()) {
            file.forEachLine {
                lines!!.add(it)  // not necessary, perform your statistics here
                // 1. increment line count
                // 2. split line
                // 3. incremen word count by number of words
                // 4. for each word - increment word_length --> count map
                // 5. for each word - iterate over characters and update character --> count map, if you wanted to do it faster, you could have a fixed size array of length a-zA-Z (52) but that wouldn't be portable at all, but would be very fast
            }
        } else {
            println("File not found. Please try another file.")
            println("Set \"lipsum\" to something else and try again.")
        }
    }

    /**
     * Returns the whitespace-delimited word count in the file
     *
     * https://stackoverflow.com/a/13925522/7776826
     * @return Int
     */
    fun getWordCount(): Int {
        // why?  you should have the counts by now, just return the value
        lines!!.toObservable()
            .map { // convert each line into a list of words
                it -> it.split(' ', '\n', '\t')
            }
            .subscribe { // add each word in each line to the class-level variable
                it.forEach {
                    if (!Pattern.matches("\\p{Punct}", it)) {
                        words!!.add(it) // ignoring punctuation
                    }
                }
            }
        return words!!.count() // if there's nothing in the file, count will return 0
    }

    /**
     * Returns the whitespace-delimited word count in the file
     *
     * https://stackoverflow.com/a/13925522/7776826
     * @return Long
     */
    fun getWordCountNew(): Long {
        // WHY? you already have this information or should have this information already
        val file = File(lipsum)
        file.forEachLine {
            val words = it.split(' ')
            wordCount += words.count()
            lineCount++
        }
        return wordCount // if there's nothing in the file, count will return 0
    }

    // if lipsum is changed, then the arrays need to be cleared. if it can't be changed, then they don't need to be cleared. var vs. val

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
        // this really should just be total characters in file, which you can get by keeping a running count of sum of
        // characters as your getting length of each word, and then, bam!  total characters / num words
        var total = 0
        words!!.toObservable()
            .map { // convert each word into its length
                it -> it.length
            }
            .subscribe { // add the length of that word to a count of total letters
                total += it
            }
        return average(total.toLong(), words!!.count().toLong(), 1) // compute the average: total letters / quantity of words
    }

    /**
     * Returns the average number of letters per word in the file
     * @return Float
     */
    fun getAverageNumberOfLettersPerWordNew(): Float {
        val file = File(lipsum)
        file.forEachLine {
            letterCount += it.length
        }
        return average(letterCount, wordCount, 1) // compute the average: total letters / quantity of words
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
        val map = mutableMapOf<Char, Int>()

        words!!.toObservable()
            .map { // convert each word into a character array
                it -> it.toCharArray()
            }
            .subscribe { // extract each individual character in the array
                it.forEach { // either add the character to the map or increment its value
                    if (map.containsKey(it)) {
                        var value: Int = map[it]!!
                        value++
                        map[it] = value
                    } else {
                        map[it] = 1
                    }
                }
            }

        return map.maxBy { it.value }!!.key // return the key whose value is the greatest
    }

    /**
     * Returns the most common letter in the file. If there are multiple, will return first one found.
     *
     * https://stackoverflow.com/a/47026192/7776826
     * @return Char
     */
    fun getMostCommonLetterNew(): Char {
        val file = File(lipsum)
        val map = mutableMapOf<Char, Int>()

        file.forEachLine {
            val array = it.toCharArray()
            array.forEach {
                if (map.containsKey(it)) {
                    var value: Int = map[it]!!
                    value++
                    map[it] = value
                } else {
                    map[it] = 1
                }
            }
        }

        return map.maxBy { it.value }!!.key // return the key whose value is the greatest
    }

    /**
     * Checks if file is not null
     * @return Boolean
     */
    private fun checkFile(): Boolean {
        return if (File(lipsum).exists()) {
            println("File exists.")
            true
        } else {
            println("File does not exist. Please try with another file.")
            false
        }
    }

    /**
     * Confirms the word count as listed in the file's last line
     * @return Boolean
     */
    fun confirmWordCount(): Boolean {
        return this.getLineCount() == 2072
    }

}
