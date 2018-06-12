# TextStatistics
Library to run certain statistics on a text file
* Word count
* Line count
* Average number of letters per word
* Most common letter

## How to use this library
* Make sure you have either the SDK or CLI tools
    * [Java](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
    * [Kotlin](https://kotlinlang.org/docs/tutorials/command-line.html)
* Calling the methods
    * TextStatistics
        * From Java
            * ```java
                public class Run {
                    public void run() {
                        TextStatistics ts = new TextStatistics("res/big.txt");
                        ts.getWordCount();
                        ts.getLineCount();
                        ts.getAverageNumberOfLettersPerWord();
                        ts.getMostCommonLetter();
                    }
                }
               ```
        * From Kotlin
            * ```kotlin
                fun run() {
                  val ts = TextStatistics("res/big")
                  ts.getWordCount()
                  ts.getLineCount()
                  ts.getAverageNumberOfLettersPerWord()
                  ts.getMostCommonLetter() 
                }
                ```
    * RunnerJava
        * `RunnerKotlin.runStatistics("res/big.txt");`
        * `RunnerKotlin.main(new String[]{"res/big.txt"});`
    * RunnerKotlin
        * `RunnerKotlin.runStatistics("res/big.txt")`
        * `RunnerKotlin.main(arrayOf("res/big.txt"))`
    * Replace `res/big.txt` with the relative path to your file.
* From the command line
    * `java -jar TextStatistics.jar "res/big.txt"`
    * Replace `res/big.txt` with the absolute path to your file.

### Compiling TextStatistics
* `kotlinc TextStatistics.kt`

## Expected output
```
...Reading file "res/big.txt"...
...Finished reading file...
			-----
File reading & processing run time: 1010 ms

Word Count: 1164968
Run Time: 0 ms

Line Count: 128457
Run Time: 0 ms

Average Number of Letters Per Word: 4.6
Run Time: 4 ms

Most Common Letter: e
Run Time: 1 ms
```
 
 
