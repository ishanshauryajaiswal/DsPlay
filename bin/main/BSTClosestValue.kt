class BSTClosestValue {


    /*

      tree ->       10

              5           15

           2    6      13      22

        1                14

        target = 12

     */

    open class BST(value: Int) {
        var value = value
        var left: BST? = null
        var right: BST? = null
    }

    fun findClosestValueInBst(tree: BST, target: Int): Int {
        return -1
    }


    fun createBST(): BST{
        val root = BST(10)
        root.left = BST(5); root.right = BST(15)
        root.left!!.left = BST(2); root.left!!.right = BST(6)
        root.left!!.left!!.left = BST(1)
        root.right!!.left = BST(13); root.right!!.right = BST(22)
        root.right!!.left!!.right =  BST(14)
        return root
    }

}