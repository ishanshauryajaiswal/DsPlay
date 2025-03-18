package lint.string

/*
https://www.lintcode.com/problem/834/?fromId=18&_from=collection
 */

class RemoveDuplicateLetters {

    fun removeDuplicateLetters(s: String): String {
        val lettersInLexOrder = ArrayList<Char>()
        s.forEach {
            if (!lettersInLexOrder.contains(it))
                lettersInLexOrder.add(it)
        }
        return lettersInLexOrder.toString()
    }
}