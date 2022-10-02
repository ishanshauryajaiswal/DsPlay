import java.util.concurrent.ConcurrentHashMap

class HashMapGet {

    fun main() {
        val map = ConcurrentHashMap<String, String>()
        print(map["a"])
    }
}