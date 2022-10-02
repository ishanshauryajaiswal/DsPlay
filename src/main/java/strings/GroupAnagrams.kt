package strings

import java.math.BigInteger


/*
https://www.algoexpert.io/questions/group-anagrams
 */
class GroupAnagrams {

    fun groupAnagrams(words: List<String>): List<List<String>> {
        val ans = ArrayList<ArrayList<String>>()
        var map = HashMap<BigInteger, ArrayList<String>>()
        val primeArray = generatePrimes()
        words.forEach {
            var product = BigInteger.valueOf(1L)
            for(i in 0..it.length-1){
                val char = it[i]
                val numChar = char.toLong()-97L
                product = product.multiply(BigInteger.valueOf(primeArray[numChar.toInt()].toLong()))
            }
            map.getOrPut(product ){ ArrayList()}.add(it)
        }

        words.forEach {
            var product = BigInteger.valueOf(1L)
            for(i in 0..it.length-1){
                val char = it[i]
                val numChar = char.toLong()-97L
                product = product.multiply(BigInteger.valueOf(primeArray[numChar.toInt()].toLong()))
            }
            if(map.containsKey(product))
                ans.add(map.get(product)!!)
            map.remove(product)
        }
        return ans
    }

    fun generatePrimes(): IntArray {
        val c = IntArray(26)
        var i = 0
        var num = 2
        while (i < 26){
            var isPrime = true
            for(j in 2..num-1){
                if(num % j == 0){
                    isPrime = false
                    break
                }
            }
            if(isPrime){
                c[i] = num
                i++
            }
            num++
        }
        return c
    }

}