package leet

import kotlin.math.max


class MergeIntervals {

    fun merge(intervals: Array<IntArray>): Array<IntArray> {

        val ans = ArrayList<IntArray>()
        /*
        intervals.sortWith(object : Comparator<IntArray>{
            override fun compare(o1: IntArray, o2: IntArray): Int {
                if(o1[0] == o2[0])
                    return o1[1] - o2[1]
                return o1[0] - o2[0]
            }

        })

         */

        intervals.sortWith{
            o1, o2 ->
                if (o1[0] == o2[0])
                     o1[1] - o2[1]
                else o1[0] - o2[0]
        }
        for(i in 1 until intervals.size){
            val newStartTime = intervals[i][0]
            val newEndTime = intervals[i][1]
            val prevEndTime = intervals[i-1][1]
            val prevStartTime = intervals[i-1][0]
            if(newStartTime <= prevEndTime){
                intervals[i][0] = prevStartTime
                intervals[i][1] = max(prevEndTime, newEndTime)
            }
            else
                ans.add(intervals[i-1])
        }
        if(intervals.size > 0)
            ans.add(intervals[intervals.size-1])
        return ans.toTypedArray()
    }

}