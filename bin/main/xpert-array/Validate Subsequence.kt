package `xpert-array`

import kotlin.math.pow

class `Validate Subsequence` {

    fun isValidSubsequence(array: List<Int>, sequence: List<Int>): Boolean {
        val set = sequence.toHashSet()
        array.forEach {
            if(set.contains(it)){
                set.remove(it)
            }
        }
        return set.isEmpty()
    }

    fun binary(array: Array<Int>, ele: Int): Int{
        var left = 0
        var right = array.size - 1
        while(left < right){
            val mid = (left+right)/2
            val midEle = array[mid]
            if(midEle == ele)
                return mid
            if(midEle < ele){
                left = mid+1
            }
            else{
                right = mid -1
            }
        }
        return -1
    }
/*

    fun findFirstPositiveNumberInSortedArray(array: Array<Int>){
        var left = 0
        var right = array.size - 1
        val output = Array<Int>(array.size)
        while(left < right){
            val mid = (left+right)/2
            val midEle = array[mid]
            if(midEle < 0){
                left = mid+1
            }
            else{
                right = mid-1
            }
        }
        var i =0
        left = right - 1
        while (i < array.size){
            if(array[left].toDouble().pow(2.0) <= array[right].toDouble().pow(2.0)){
                output[i++] = array[left].toDouble().pow(2.0).toInt()
                left--
            }
            else{
                output[i++] = array[right].toDouble().pow(2.0).toInt()
                right++
            }
        }
    }
*/

}