package `xpert-array`

import kotlin.math.abs

class SortedSquaredArray {
/*
1,2,3,4
16, 9, 4, 1

-6, -4, 0, 1 ,4, 5, 7
 */
    fun sortedSquaredArray(array: List<Int>): List<Int> {
        var size = array.size
        var i = 0
        var j = size-1
        val list = mutableListOf<Int>()
        while (i<=j){
            if(abs(array[i]) >= abs(array[j])){
                list.add(array[i]*array[i])
                i++
            }
            else{
                list.add(array[j]*array[j])
                j--
            }
        }
        return list.reversed()
    }

}