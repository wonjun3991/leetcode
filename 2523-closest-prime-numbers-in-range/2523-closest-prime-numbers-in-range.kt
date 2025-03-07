
import java.util.*

class Solution {
    fun closestPrimes(left: Int, right: Int): IntArray {
        // Step 1: Get all prime numbers up to 'right' using sieve
        val sieveArray = sieve(right)

        val primeNumbers: MutableList<Int> = ArrayList() // Store all primes in the range [left, right]
        for (num in left..right) {
            // If number is prime add to the primeNumbers list
            if (sieveArray[num] == 1) {
                primeNumbers.add(num)
            }
        }

        // Step 2: Find the closest prime pair
        if (primeNumbers.size < 2) return intArrayOf(-1, -1) // Less than two primes available


        var minDifference = Int.MAX_VALUE
        val closestPair = IntArray(2)
        // setting initial values
        Arrays.fill(closestPair, -1)

        for (index in 1 until primeNumbers.size) {
            val difference =
                primeNumbers[index] - primeNumbers[index - 1]
            if (difference < minDifference) {
                minDifference = difference
                closestPair[0] = primeNumbers[index - 1]
                closestPair[1] = primeNumbers[index]
            }
        }

        return closestPair
    }

    private fun sieve(upperLimit: Int): IntArray {
        // Initiate an int array to mark prime numbers (1 = prime, else it's not)
        val sieve = IntArray(upperLimit + 1)
        // Assuming all numbers as prime initially
        Arrays.fill(sieve, 1)

        // 0 and 1 are not prime
        sieve[0] = 0
        sieve[1] = 0

        var number = 2
        while (number * number <= upperLimit) {
            if (sieve[number] == 1) {
                // Mark all multiples of 'number' as non-prime
                var multiple = number * number
                while (multiple <= upperLimit
                ) {
                    sieve[multiple] = 0
                    multiple += number
                }
            }
            number++
        }
        return sieve
    }
}