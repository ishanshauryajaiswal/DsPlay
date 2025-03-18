package lint.dp

import org.junit.jupiter.api.Test
import java.util.*
import kotlin.Comparator

internal class KnapsackTest {

    @Test
    fun a() {
        println(Knapsack().backPackII(10, intArrayOf(2, 3, 5, 7), intArrayOf(1, 5, 2, 4)))
    }

    @Test
    fun minMeetingRooms() {
        val intervals: Array<IntArray> = arrayOf(intArrayOf(3,4), intArrayOf(2, 3))
        intervals.sortBy { it[0] }
    }
    @Test
    fun minMeetingRooms2() {
        val intervals: Array<IntArray> = arrayOf(intArrayOf(3,4), intArrayOf(2, 3))
        intervals.sortWith(object : Comparator<IntArray>{
            override fun compare(o1: IntArray, o2: IntArray): Int {
                return o1[0] - o2[0]
            }
        })
    }

    fun queueToArray(): Array<IntArray>{
        val queue = PriorityQueue<IntArray>()
        return queue.map { it }.toTypedArray()
    }
}
