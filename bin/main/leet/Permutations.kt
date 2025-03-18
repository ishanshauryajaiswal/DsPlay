package leet

class Permutations {

    val list = ArrayList<List<Int>>()
    var curr = ArrayList<Int>()
    fun permute(nums: IntArray): List<List<Int>> {
        rec(nums, HashSet())
        return list
    }

    fun rec(nums: IntArray, visited: HashSet<Int>){
        if(curr.size == nums.size){
            list.add(curr.clone() as List<Int>)
            return
        }
        for(i in nums.indices){
            if(!visited.contains(i)){
                visited.add(i)
                curr.add(nums[i])
                rec(nums, visited)
                curr.removeAt(curr.size-1)
                visited.remove(i)
            }
        }
    }
}
/*
visited = 2
curr =
list = 123,132,
 */